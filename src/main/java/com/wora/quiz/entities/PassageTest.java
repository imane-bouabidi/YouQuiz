package com.wora.quiz.entities;

import jakarta.persistence.*;

@Entity
public class PassageTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int score;
    private int numTentative;
    private String raisonRepassage;
    private int result;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Quiz quiz;
}

