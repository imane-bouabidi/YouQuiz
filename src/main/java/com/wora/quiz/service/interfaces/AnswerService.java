package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.AnswerDTO.AnswerDTO;
import com.wora.quiz.dtos.AnswerDTO.CreateAnswerDTO;
import com.wora.quiz.dtos.AnswerDTO.UpdateAnswerDTO;
import com.wora.quiz.service.GenericService;

public interface AnswerService extends GenericService<CreateAnswerDTO, UpdateAnswerDTO,AnswerDTO,Long> {
}
