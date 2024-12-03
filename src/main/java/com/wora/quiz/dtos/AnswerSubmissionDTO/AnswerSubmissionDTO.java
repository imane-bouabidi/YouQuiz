package com.wora.quiz.dtos.AnswerSubmissionDTO;

import java.time.LocalDateTime;

public class AnswerSubmissionDTO {
    private Long id;
    private Long passageTestId;
    private Long questionId;
    private Long answerId;
    private LocalDateTime submissionTime;
}

