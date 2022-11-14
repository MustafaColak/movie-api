package com.project.movie.business.requests;

import com.project.movie.entities.Category;
import lombok.Data;

import java.util.List;

@Data
public class MovieCreateRequest {
    private String name;
    private String description;
    private String imdbUrl;
    private int duration;
    private int releaseYear;
    private List<Category> categories;
    private Long directorId;
    private List<Long> actorIds;
}
