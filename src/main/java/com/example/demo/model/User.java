package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data // Getters, Setters, Constructrors and toString
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "surname")
    private String lastName;
}
