package com.wora.quiz.dtos.quizDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateQuizDTO {
    private String title;
    private Date dateDebut;
    private Date dateFin;
    private int score;
    private int formateurId;
}
