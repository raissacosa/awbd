package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Setter
@Getter
@Data
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 1, message = "Number mast be at least 1")
    private int number;
    @Min(value = 50, message = "Capacity must be greater then 50")
    @Max(value = 300,message = "Capacity must be less then 50")
    private int capacity;

    @ManyToOne
    @ToString.Exclude
    private Cinema cinema;

    @OneToMany(mappedBy = "hall")
    private List<Movie> movies;
}
