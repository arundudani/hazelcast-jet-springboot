package com.arundudani.kata.hazelcastjet.domain;

import com.hazelcast.jet.Jet;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.jet.accumulator.LongAccumulator;
import com.hazelcast.jet.aggregate.AggregateOperation;
import com.hazelcast.jet.aggregate.AggregateOperation1;
import com.hazelcast.jet.aggregate.AggregateOperation2;
import com.hazelcast.jet.pipeline.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneOffset;
import java.util.Map;

import static com.hazelcast.jet.aggregate.AggregateOperations.counting;

@RestController
@RequestMapping("/hzjet")
public class HazelcastJetController {
    private static final String INPUT_EVENTS_LIST = "inputEvents";
    private static final String OUTPUT_RECORDS_LIST = "outputRecords";

    @GetMapping("/table9example")
    public String triggerTable9() {
        JetInstance instance = Jet.newJetInstance();

        try {
            InputEventsCreator.create(instance.getList(INPUT_EVENTS_LIST));

            Pipeline p = Pipeline.create();
            BatchSource<Events> inputEvents = Sources.list(INPUT_EVENTS_LIST);

            BatchStage<Events> eventsBatchStage = p.drawFrom(inputEvents);

            StageWithGrouping<Events, String> createdEventsByLeiActivityId = eventsBatchStage
                    .filter(event -> event.getEventType().equals("CREATED")).groupingKey(event -> event.getLeiActivityIdCombo());
            StageWithGrouping<Events, String> quotedEventsByLeiActivityId = eventsBatchStage
                    .filter(event -> event.getEventType().equals("QUOTED")).groupingKey(event -> event.getLeiActivityIdCombo());

            BatchStage<Map.Entry<String, Long>> createdMinusQuotedByLeiAndActivityId = createdEventsByLeiActivityId.aggregate2(quotedEventsByLeiActivityId, quotedMinusCreated());

            StageWithGrouping<Events, String> eventsByActivityIdAndIsin = eventsBatchStage.groupingKey(event -> event.getLei() + "-" + event.getIsin());

            createdMinusQuotedByLeiAndActivityId.drainTo(Sinks.logger());

            instance.newJob(p).join();

        } finally {
            Jet.shutdownAll();
        }
        return "Done";
    }

    private AggregateOperation2<Events, Events, LongAccumulator, Long> quotedMinusCreated() {
        return AggregateOperation
                .withCreate(LongAccumulator::new)
                .<Events>andAccumulate0((acc, s) -> acc.add(-1 * s.getEventTime().toInstant(ZoneOffset.UTC).toEpochMilli()))
                .<Events>andAccumulate1((acc, s) -> acc.add(s.getEventTime().toInstant(ZoneOffset.UTC).toEpochMilli()))
                .andCombine(LongAccumulator::add)
                .andFinish(LongAccumulator::get);
    }
}
