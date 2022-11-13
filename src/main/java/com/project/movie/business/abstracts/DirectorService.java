package com.project.movie.business.abstracts;

import com.project.movie.entities.Director;

import java.util.Optional;

public interface DirectorService {
    Director getById(Long id);
}
