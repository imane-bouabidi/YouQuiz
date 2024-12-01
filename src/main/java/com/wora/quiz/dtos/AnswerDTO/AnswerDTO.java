package com.wora.quiz.dtos.AnswerDTO;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AnswerDTO {
    private Long id;
    private String texte;
}

