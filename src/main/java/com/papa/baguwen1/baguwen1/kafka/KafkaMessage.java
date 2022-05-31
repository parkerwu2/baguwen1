package com.papa.baguwen1.baguwen1.kafka;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class KafkaMessage {
    private Long id;
    private String username;
    private String password;
    private ZonedDateTime zonedDateTime;
}
