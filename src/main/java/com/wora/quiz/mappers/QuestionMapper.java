package com.wora.quiz.mappers;

import com.wora.quiz.dtos.QuestionDTO.CreateQuestionDTO;
import com.wora.quiz.dtos.QuestionDTO.QuestionDTO;
import com.wora.quiz.dtos.QuestionDTO.UpdateQuestionDTO;
import com.wora.quiz.entities.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question toEntity(QuestionDTO questionDTO);
    Question toEntity(CreateQuestionDTO createDTO);
    Question toEntity(UpdateQuestionDTO updateDTO);
    QuestionDTO toDTO(Question question);
}

