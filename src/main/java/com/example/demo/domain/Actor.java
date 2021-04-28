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

    @ManyToMany(mappedBy = "actors",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Movie> movies;

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
}
