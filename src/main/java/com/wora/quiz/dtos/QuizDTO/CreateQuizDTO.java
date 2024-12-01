package com.wora.quiz.dtos.QuizDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateQuizDTO {
    private String titre;
    private Integer scoreReussite;
    private boolean droitVisualiserReponses;
    private boolean droitVoirResultats;
    private Integer nombreChances;
    private String remarques;
    private Integer duration;
    private Long formateurId;
}
