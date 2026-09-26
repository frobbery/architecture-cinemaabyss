package com.cinema.abyss.proxy.controller;

import com.cinema.abyss.proxy.client.MovieMonolithClient;
import com.cinema.abyss.proxy.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final MovieMonolithClient monolithClient;

    @GetMapping("api/users")
    public List<UserDto> getUsers() {
        return monolithClient.getUsers();
    }
}
