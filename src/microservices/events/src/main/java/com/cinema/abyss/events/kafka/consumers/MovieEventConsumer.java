package com.cinema.abyss.events.kafka.consumers;

import com.cinema.abyss.events.events.MovieEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MovieEventConsumer {

    @KafkaListener(topics = "movie", groupId = "movie-consumers")
    public void listen(MovieEvent event) {
        log.info("Received movie event: " + event);
    }
}
