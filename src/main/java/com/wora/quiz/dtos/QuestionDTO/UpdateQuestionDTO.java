package com.wora.quiz.dtos.QuestionDTO;

import com.wora.quiz.entities.enums.TypeQuestion;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateQuestionDTO {
    private String texte;
    private Integer points;
    private Integer nombreReponses;
    private Integer nombreReponsesCorrectes;
    private TypeQuestion typeQuestion;
    private Long sujetId;
    private Long levelId;
}

