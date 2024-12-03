package com.wora.quiz.dtos.AnswerValidationDTO;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateAnswerValidationDTO {
    private Long answerId;
    private Long questionId;
    private Integer pointsObtenus;
}
