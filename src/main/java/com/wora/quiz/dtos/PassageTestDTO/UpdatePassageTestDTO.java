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
    private Double scoreObtenu;
    private Double numTentative;
    private String raisonRepassage;
    private Double resultatFinal;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
}

