package com.wora.quiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;

    @ManyToMany(mappedBy = "sujets")
    private List<Quiz> tests;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "parent_sujet_id")
    private Sujet parentSujet;

    @OneToMany(mappedBy = "parentSujet")
    private List<Sujet> subSubjects;
}

