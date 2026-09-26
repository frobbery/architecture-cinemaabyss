package com.cinema.abyss.proxy.client;

import com.cinema.abyss.proxy.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "movieServiceClient", url = "${movie.service.url}")
public interface MovieServiceClient {

    @GetMapping(value = "/api/movies")
    List<MovieDto> getMovies();
}
