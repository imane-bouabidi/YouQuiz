package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.AnswerValidationDTO.AnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.CreateAnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.UpdateAnswerValidationDTO;
import com.wora.quiz.entities.AnswerValidation;
import com.wora.quiz.service.GenericService;

public interface AnswerValidationService extends GenericService<CreateAnswerValidationDTO, UpdateAnswerValidationDTO,AnswerValidationDTO,Long> {
}
