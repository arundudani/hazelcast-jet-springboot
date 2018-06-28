package com.arundudani.kata.hazelcastjet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class InputEventsCreator {
    public static void create(List<Events> input) {
        input.add(Events.builder().lei("LEI001").activityId("1").isin("ISIN001").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                    10, 0, 0)).build());
        input.add(Events.builder().lei("LEI001").activityId("1").isin("ISIN001").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 5)).build());

        input.add(Events.builder().lei("LEI001").activityId("2").isin("ISIN001").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 0)).build());
        input.add(Events.builder().lei("LEI001").activityId("2").isin("ISIN001").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 3)).build());

        input.add(Events.builder().lei("LEI001").activityId("3").isin("ISIN001").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 0)).build());
        input.add(Events.builder().lei("LEI001").activityId("3").isin("ISIN001").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 7)).build());

        input.add(Events.builder().lei("LEI001").activityId("10").isin("ISIN002").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 0)).build());
        input.add(Events.builder().lei("LEI001").activityId("10").isin("ISIN002").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 5)).build());

        input.add(Events.builder().lei("LEI001").activityId("20").isin("ISIN002").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 0)).build());
        input.add(Events.builder().lei("LEI001").activityId("20").isin("ISIN002").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 3)).build());

        input.add(Events.builder().lei("LEI001").activityId("30").isin("ISIN002").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 0)).build());
        input.add(Events.builder().lei("LEI001").activityId("30").isin("ISIN002").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 7)).build());


        input.add(Events.builder().lei("LEI002").activityId("4").isin("ISIN001").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 0)).build());
        input.add(Events.builder().lei("LEI002").activityId("4").isin("ISIN001").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 5)).build());

        input.add(Events.builder().lei("LEI002").activityId("5").isin("ISIN001").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 0)).build());
        input.add(Events.builder().lei("LEI002").activityId("5").isin("ISIN001").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 3)).build());

        input.add(Events.builder().lei("LEI002").activityId("6").isin("ISIN001").
                eventType("CREATED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 0)).build());
        input.add(Events.builder().lei("LEI002").activityId("6").isin("ISIN001").
                eventType("QUOTED").eventTime(LocalDateTime.of(2018, Month.APRIL, 12,
                10, 0, 7)).build());
    }
}
