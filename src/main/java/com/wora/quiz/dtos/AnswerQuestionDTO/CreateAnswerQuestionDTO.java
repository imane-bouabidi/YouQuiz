package com.wora.quiz.dtos.AnswerQuestionDTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAnswerQuestionDTO {
    @NotNull
    private Boolean correct;

    @NotNull
    private Double point;

    @NotNull
    private Long questionId;

    @NotNull
    private Long answerId;
}
