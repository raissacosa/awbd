package com.example.demo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
    //@ToString.Exclude
    private List<Hall> halls;
}
