package com.project.movie.business.abstracts;

import com.project.movie.business.requests.MovieCreateRequest;
import com.project.movie.entities.Movie;

import java.util.List;

public interface MovieService {
    void add(MovieCreateRequest movieCreateRequest);
    List<Movie> getAll();
}
