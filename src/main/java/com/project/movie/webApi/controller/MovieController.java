package com.project.movie.webApi.controller;

import com.project.movie.business.abstracts.MovieService;
import com.project.movie.business.requests.MovieCreateRequest;
import com.project.movie.entities.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    public final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public void add(@RequestBody MovieCreateRequest movieCreateRequest){
        movieService.add(movieCreateRequest);
    }

    @GetMapping("/getall")
    public List<Movie> getAll(){
        return movieService.getAll();
    }
}
