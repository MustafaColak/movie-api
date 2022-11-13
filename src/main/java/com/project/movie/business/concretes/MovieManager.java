package com.project.movie.business.concretes;

import com.project.movie.business.abstracts.DirectorService;
import com.project.movie.business.abstracts.MovieService;
import com.project.movie.business.requests.MovieCreateRequest;
import com.project.movie.dataAccess.MovieRepository;
import com.project.movie.entities.Director;
import com.project.movie.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieManager implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    public MovieManager(MovieRepository movieRepository, DirectorService directorService) {
        this.movieRepository = movieRepository;
        this.directorService = directorService;
    }

    @Override
    public void add(MovieCreateRequest movieCreateRequest) {
        Director director = directorService.getById(movieCreateRequest.getDirectorId());
        Movie movie = new Movie();
        movie.setName(movieCreateRequest.getName());
        movie.setDescription(movieCreateRequest.getDescription());
        movie.setImdbUrl(movieCreateRequest.getImdbUrl());
        movie.setDuration(movieCreateRequest.getDuration());
        movie.setReleaseYear(movieCreateRequest.getReleaseYear());
        movie.setCategories(movieCreateRequest.getCategories());
        movie.setDirector(director);
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
