package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Descripton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToOne
    private Movie movie;
}
