package com.cinema.abyss.events.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MovieEvent {

    private final Long movieId;
    private final String title;
    private final String action;
    private final Long userId;

    @JsonCreator
    public MovieEvent(
            @JsonProperty("movie_id") Long movieId,
            @JsonProperty("title") String title,
            @JsonProperty("action") String action,
            @JsonProperty("user_id") Long userId) {
        this.movieId = movieId;
        this.title = title;
        this.action = action;
        this.userId = userId;
    }
}
