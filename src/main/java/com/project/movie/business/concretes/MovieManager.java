package com.project.movie.business.concretes;

import com.project.movie.business.abstracts.ActorService;
import com.project.movie.business.abstracts.DirectorService;
import com.project.movie.business.abstracts.MovieService;
import com.project.movie.business.requests.MovieCreateRequest;
import com.project.movie.dataAccess.MovieRepository;
import com.project.movie.entities.Actor;
import com.project.movie.entities.Director;
import com.project.movie.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieManager implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorService directorService;
    private final ActorService actorService;

    public MovieManager(MovieRepository movieRepository, DirectorService directorService, ActorService actorService) {
        this.movieRepository = movieRepository;
        this.directorService = directorService;
        this.actorService = actorService;
    }

    @Override
    public void add(MovieCreateRequest movieCreateRequest) {
        Director director = directorService.getById(movieCreateRequest.getDirectorId());
        List<Actor> actors = actorService.findAllByIdIn(movieCreateRequest.getActorIds());
        Movie movie = new Movie();
        movie.setName(movieCreateRequest.getName());
        movie.setDescription(movieCreateRequest.getDescription());
        movie.setImdbUrl(movieCreateRequest.getImdbUrl());
        movie.setDuration(movieCreateRequest.getDuration());
        movie.setReleaseYear(movieCreateRequest.getReleaseYear());
        movie.setCategories(movieCreateRequest.getCategories());
        movie.setDirector(director);
        movie.setActors(actors);
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
