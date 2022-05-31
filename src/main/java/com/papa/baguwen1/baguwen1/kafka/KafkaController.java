package com.papa.baguwen1.baguwen1.kafka;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/kafka", produces = APPLICATION_JSON_VALUE)
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public KafkaMessage getMessageWithPost(@RequestBody KafkaMessage kafkaMessage) {
        kafkaMessage.setZonedDateTime(ZonedDateTime.now());
        kafkaProducer.sendMessage(kafkaMessage);
        return kafkaMessage;
    }

}

