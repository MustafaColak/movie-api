package com.project.movie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "imdb_url")
    private String imdbUrl;

    @Column(name = "duration")
    private int duration;

    @Column(name = "release_year")
    private int releaseYear;

    @ElementCollection(targetClass = Category.class)
    @CollectionTable(name="movie_categories")
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    List<Category> categories;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
}
