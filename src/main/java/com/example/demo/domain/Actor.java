package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "required field")
    private String surname;
    @NotBlank(message = "required field")
    private String name;

    @ManyToMany
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<Movie> movies;
}
