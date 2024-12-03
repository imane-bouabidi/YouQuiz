package com.wora.quiz.mappers;

import com.wora.quiz.dtos.AnswerQuestionDTO.AnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.CreateAnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.UpdateAnswerQuestionDTO;
import com.wora.quiz.entities.AnswerQuestion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AnswerQuestionMapper {
    AnswerQuestion toEntity(AnswerQuestionDTO answerQuestionDTO);
    AnswerQuestion toEntity(CreateAnswerQuestionDTO createDTO);
    AnswerQuestion toEntity(UpdateAnswerQuestionDTO updateDTO);
    AnswerQuestionDTO toDTO(AnswerQuestion answerQuestion);
}
