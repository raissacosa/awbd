package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int capacity;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "hall")
    private List<Movie> movies;
}
