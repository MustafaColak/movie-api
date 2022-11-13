package com.project.movie.business.concretes;

import com.project.movie.business.abstracts.DirectorService;
import com.project.movie.dataAccess.DirectorRepository;
import com.project.movie.entities.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectorManager implements DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorManager(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director getById(Long id) {
        return directorRepository.findById(id).orElse(null);
    }
}
