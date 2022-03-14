package com.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "KafkaExampleTopic",
                    groupId = "groupId")
    void listener(String data) {
        System.out.println("Listener received: " + data + " \uD83D\uDC69\uD83C\uDFFB\u200D\uD83D\uDCBB ");
    }
}
