package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Spectator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "required field")
    private String surname;
    @NotBlank(message = "required field")
    private String name;
    @Size(min = 10, max = 10, message = "The phone number must have 10 digits")
    private String phone;

    @ManyToMany
    @JoinTable(name = "movie_spectator",
            joinColumns = @JoinColumn(name = "spectator_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<Movie> movies;


    public String getSurname() {
        return surname;
    }
}
