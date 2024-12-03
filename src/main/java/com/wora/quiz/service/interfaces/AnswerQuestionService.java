package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.AnswerQuestionDTO.AnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.CreateAnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.UpdateAnswerQuestionDTO;
import com.wora.quiz.service.GenericService;

public interface AnswerQuestionService extends GenericService<CreateAnswerQuestionDTO, UpdateAnswerQuestionDTO,AnswerQuestionDTO,Long> {
}
