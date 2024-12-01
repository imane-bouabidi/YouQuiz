package com.wora.quiz.dtos.QuestionTimerDTO;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuestionTimerDTO {
    private Long id;
    private Integer temps;
    private Long questionId;
    private Long quizId;
}

