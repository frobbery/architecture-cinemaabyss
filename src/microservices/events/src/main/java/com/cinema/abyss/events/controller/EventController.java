package com.cinema.abyss.events.controller;

import com.cinema.abyss.events.events.MovieEvent;
import com.cinema.abyss.events.events.PaymentEvent;
import com.cinema.abyss.events.events.UserEvent;
import com.cinema.abyss.events.kafka.producers.MovieEventProducer;
import com.cinema.abyss.events.kafka.producers.PaymentEventProducer;
import com.cinema.abyss.events.kafka.producers.UserEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequiredArgsConstructor
public class EventController {

    private final PaymentEventProducer paymentEventProducer;

    private final MovieEventProducer movieEventProducer;

    private final UserEventProducer userEventProducer;

    @PostMapping("api/events/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> createPaymentEvent(@RequestBody PaymentEvent paymentEvent) {
        paymentEventProducer.sendPaymentEvent(paymentEvent);
        return Map.of("status", "success");
    }

    @PostMapping("api/events/user")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> createUserEvent(@RequestBody UserEvent userEvent) {
        userEventProducer.sendUserEvent(userEvent);
        return Map.of("status", "success");
    }

    @PostMapping("api/events/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> createMovieEvent(@RequestBody MovieEvent movieEvent) {
        movieEventProducer.sendMovieEvent(movieEvent);
        return Map.of("status", "success");
    }
}
