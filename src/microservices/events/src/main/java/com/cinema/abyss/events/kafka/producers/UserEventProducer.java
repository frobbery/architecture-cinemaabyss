package com.cinema.abyss.events.kafka.producers;

import com.cinema.abyss.events.events.UserEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserEventProducer {

    private final KafkaTemplate<String, UserEvent> kafkaTemplate;

    private final String userTopic = "user";

    public UserEventProducer(KafkaTemplate<String, UserEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserEvent(UserEvent event) {
        kafkaTemplate.send(userTopic, event);
    }
}
