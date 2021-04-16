package com.example.demo.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "required field")
    private String name;

    @ManyToMany(mappedBy = "genres",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Movie> movies;
}
