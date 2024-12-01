package com.wora.quiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionTimer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private Integer temps;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Quiz quiz;
}
