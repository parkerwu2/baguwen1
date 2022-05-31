package com.papa.baguwen1.baguwen1.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "firstTopic", groupId = "myGroup")
    public void obtainMessage(ConsumerRecord<String, String> consumerRecord) {

        String key = consumerRecord.key();
        String value = consumerRecord.value();
        int partition = consumerRecord.partition();
        long timestamp = consumerRecord.timestamp();
        String topic = consumerRecord.topic();
        log.info("key: " + key + "\n" + "value: " + value + "\n" + "partition: " + partition + "\n" + "timestamp: " + timestamp + "\n" + "topic: " + topic);
    }
}

