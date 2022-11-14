package com.project.movie.business.concretes;

import com.project.movie.business.abstracts.ActorService;
import com.project.movie.dataAccess.ActorRepository;
import com.project.movie.entities.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorManager implements ActorService {
    private final ActorRepository actorRepository;

    public ActorManager(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAllByIdIn(List<Long> ids) {
        return actorRepository.findAllByIdIn(ids);
    }
}
