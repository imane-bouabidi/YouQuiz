package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.QuestionTimerDTO.CreateQuestionTimerDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.QuestionTimerDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.UpdateQuestionTimerDTO;
import com.wora.quiz.service.GenericService;

public interface QuestionTimerService extends GenericService<CreateQuestionTimerDTO, UpdateQuestionTimerDTO,QuestionTimerDTO,Long> {
}
