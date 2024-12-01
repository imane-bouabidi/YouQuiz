package com.wora.quiz.dtos.QuizDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuizDTO {
    private String titre;
    private Integer scoreReussite;
    private Boolean droitVisualiserReponses;
    private Boolean droitVoirResultats;
    private Integer nombreChances;
    private String remarques;
    private Integer duration;
    private Long formateurId;
}
