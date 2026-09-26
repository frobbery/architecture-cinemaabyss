package com.cinema.abyss.events.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserEvent {

    private final Long userId;
    private final String username;
    private final String action;
    private final LocalDate timestamp;

    @JsonCreator
    public UserEvent(
            @JsonProperty("user_id") Long userId,
            @JsonProperty("username") String username,
            @JsonProperty("action") String action,
            @JsonProperty("timestamp") LocalDate timestamp) {
        this.userId = userId;
        this.username = username;
        this.action = action;
        this.timestamp = timestamp;
    }
}
