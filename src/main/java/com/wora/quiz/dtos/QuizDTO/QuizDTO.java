package com.wora.quiz.dtos.QuizDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class QuizDTO {
    private Long id;
    private String titre;
    private Integer scoreReussite;
    private boolean droitVisualiserReponses;
    private boolean droitVoirResultats;
    private Integer nombreChances;
    private String remarques;
    private Integer duration;
    private Long formateurId;
}

