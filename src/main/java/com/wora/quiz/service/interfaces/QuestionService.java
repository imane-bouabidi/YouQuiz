package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.QuestionDTO.CreateQuestionDTO;
import com.wora.quiz.dtos.QuestionDTO.QuestionDTO;
import com.wora.quiz.dtos.QuestionDTO.UpdateQuestionDTO;
import com.wora.quiz.service.GenericService;

public interface QuestionService extends GenericService<CreateQuestionDTO, UpdateQuestionDTO,QuestionDTO,Long> {
}
