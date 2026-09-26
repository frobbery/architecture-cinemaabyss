package com.cinema.abyss.events.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentEvent {

    private final Long paymentId;
    private final Long userId;
    private final BigDecimal amount;
    private final String status;
    private final LocalDate timestamp;
    private final String methodType;

    @JsonCreator
    public PaymentEvent(
            @JsonProperty("payment_id") Long paymentId,
            @JsonProperty("user_id") Long userId,
            @JsonProperty("amount") BigDecimal amount,
            @JsonProperty("status") String status,
            @JsonProperty("timestamp") LocalDate timestamp,
            @JsonProperty("method_type") String methodType) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
        this.timestamp = timestamp;
        this.methodType = methodType;
    }
}
