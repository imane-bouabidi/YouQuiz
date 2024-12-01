package com.wora.quiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private Integer pointsObtenus;

    @ManyToOne
    private Answer answer;

    @ManyToOne
    private Question question;
}

