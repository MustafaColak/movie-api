package com.project.movie.business.abstracts;

import com.project.movie.entities.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAllByIdIn(List<Long> ids);
}
