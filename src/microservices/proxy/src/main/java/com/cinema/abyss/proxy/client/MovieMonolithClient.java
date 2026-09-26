package com.cinema.abyss.proxy.client;

import com.cinema.abyss.proxy.dto.MovieDto;
import com.cinema.abyss.proxy.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "movieMonolithClient", url = "${movie.monolith.url}")
public interface MovieMonolithClient {

    @GetMapping(value = "/api/movies")
    List<MovieDto> getMovies();

    @GetMapping(value = "/api/users")
    List<UserDto> getUsers();
}
