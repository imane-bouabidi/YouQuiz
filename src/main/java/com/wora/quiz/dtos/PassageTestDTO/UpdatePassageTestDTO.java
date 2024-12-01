package com.wora.quiz.dtos.PassageTestDTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdatePassageTestDTO {
    private Long studentId;
    private Long quizId;
    private Integer scoreObtenu;
    private Integer numTentative;
    private String raisonRepassage;
    private Boolean resultatFinal;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
}

