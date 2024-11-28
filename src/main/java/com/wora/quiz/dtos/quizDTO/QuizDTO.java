package com.wora.quiz.dtos.quizDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class QuizDTO {
    private int id;
    private String title;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int score;
    private int formateurId;
}

