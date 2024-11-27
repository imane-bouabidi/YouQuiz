package com.wora.quiz.entities;

import com.wora.quiz.entities.enums.TypeQuestion;
import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;
    private boolean temporisee;
    private int minPoints;
    private int maxPoints;

    @ManyToOne
    @JoinColumn(name = "sujet_id")
    private Sujet sujet;

    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;
}

