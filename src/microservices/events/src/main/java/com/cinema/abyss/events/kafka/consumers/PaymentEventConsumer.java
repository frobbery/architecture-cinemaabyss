package com.cinema.abyss.events.kafka.consumers;

import com.cinema.abyss.events.events.PaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentEventConsumer {

    @KafkaListener(topics = "payment", groupId = "payment-consumers")
    public void listen(PaymentEvent event) {
        log.info("Received payment event: " + event);
    }
}
