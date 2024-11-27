package com.wora.quiz.entities;

import jakarta.persistence.*;

@Entity
public class AnswerValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int point;

    @ManyToOne
    @JoinColumn(name = "reponse_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Student student;
}

