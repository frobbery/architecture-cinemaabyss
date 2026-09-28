package com.cinema.abyss.proxy.controller;

import com.cinema.abyss.proxy.client.MovieMonolithClient;
import com.cinema.abyss.proxy.client.MovieServiceClient;
import com.cinema.abyss.proxy.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequiredArgsConstructor
public class MovieController {

    @Value("${gradualMigration}")
    private Boolean gradualMigration;

    @Value("${movieMigrationPercent}")
    private Integer moviesMigrationPercent;

    private final MovieMonolithClient monolithClient;

    private final MovieServiceClient movieServiceClient;

    @GetMapping("api/movies")
    public List<MovieDto> getMovies() {
        if (gradualMigration) {
            if (ThreadLocalRandom.current().nextInt(100) < moviesMigrationPercent) {
                return movieServiceClient.getMovies();
            } else {
                return monolithClient.getMovies();
            }
        } else {
            return movieServiceClient.getMovies();
        }
    }
}
