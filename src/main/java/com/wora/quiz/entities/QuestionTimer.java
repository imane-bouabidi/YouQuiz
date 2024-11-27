package com.wora.quiz.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class QuestionTimer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean temporisee;

    @Temporal(TemporalType.DATE)
    private Date duree;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
