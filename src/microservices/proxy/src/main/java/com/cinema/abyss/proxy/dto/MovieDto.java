package com.cinema.abyss.proxy.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieDto {

    private Integer id;

    private String title;

    private String description;

    private List<String> genres;

    private Double rating;
}
