package com.cinema.abyss.events.kafka.consumers;

import com.cinema.abyss.events.events.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventConsumer {

    @KafkaListener(topics = "user", groupId = "user-consumers")
    public void listen(UserEvent event) {
        log.info("Received user event: " + event);
    }
}
