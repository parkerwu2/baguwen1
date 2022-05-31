package com.papa.baguwen1.baguwen1.kafka;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(KafkaMessage kafkaMessage) {
        this.kafkaTemplate.send("firstTopic", new Gson().toJson(kafkaMessage));
    }
}
