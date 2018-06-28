package com.arundudani.kata.hazelcastjet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Events implements Serializable {
    String lei;
    String activityId;
    String eventType;
    String isin;
    LocalDateTime eventTime;

    public String getLeiActivityIdCombo() {
        return lei + "-" + activityId;
    }
}
