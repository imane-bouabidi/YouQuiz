package com.wora.quiz.mappers;

import com.wora.quiz.dtos.QuestionTimerDTO.CreateQuestionTimerDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.QuestionTimerDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.UpdateQuestionTimerDTO;
import com.wora.quiz.entities.QuestionTimer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionTimerMapper {
    QuestionTimer toEntity(QuestionTimerDTO questionTimerDTO);
    QuestionTimer toEntity(CreateQuestionTimerDTO createDTO);
    QuestionTimer toEntity(UpdateQuestionTimerDTO updateDTO);
    QuestionTimerDTO toDTO(QuestionTimer questionTimer);
}

