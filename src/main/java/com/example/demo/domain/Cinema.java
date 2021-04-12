package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String address;
    private int constructionyear;

    @OneToMany(mappedBy = "cinema")
    private List<Hall> halls;
}
