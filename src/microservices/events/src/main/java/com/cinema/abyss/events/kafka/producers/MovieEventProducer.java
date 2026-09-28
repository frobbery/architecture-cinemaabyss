package com.cinema.abyss.events.kafka.producers;

import com.cinema.abyss.events.events.MovieEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MovieEventProducer {

    private final KafkaTemplate<String, MovieEvent> kafkaTemplate;

    private final String movieTopic = "movie";

    public MovieEventProducer(KafkaTemplate<String, MovieEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMovieEvent(MovieEvent event) {
        kafkaTemplate.send(movieTopic, event);
    }
}
