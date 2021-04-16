package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int duration;
    private int year;

    @OneToOne(mappedBy = "movie",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Descripton descripton;

    @ManyToOne
    private Hall hall;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<Genre> genres;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    @ManyToMany(mappedBy = "movies")
    private List<Spectator> spectators;

}
