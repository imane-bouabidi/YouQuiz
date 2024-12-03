package com.wora.quiz.dtos.QuestionTimerDTO;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuestionTimerDTO {
    private Integer temps;
    private Long questionId;
    private Long quizId;
}
