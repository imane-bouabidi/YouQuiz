package com.wora.quiz.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;

    @ManyToMany(mappedBy = "sujets")
    private List<Quiz> tests;

    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "parent_sujet_id")
    private Sujet parentSujet;

    @OneToMany(mappedBy = "parentSujet")
    private List<Sujet> subSubjects;
}

