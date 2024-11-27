package com.wora.quiz.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private int maxPoints;
    private int minPoints;

    @OneToMany(mappedBy = "niveau")
    private List<Sujet> sujets;
}

