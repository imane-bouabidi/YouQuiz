package com.wora.quiz.mappers;

import com.wora.quiz.dtos.AnswerValidationDTO.CreateAnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.AnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.UpdateAnswerValidationDTO;
import com.wora.quiz.entities.AnswerValidation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerValidationMapper {
    AnswerValidation toEntity(AnswerValidationDTO answerValidationDTO);
    AnswerValidation toEntity(CreateAnswerValidationDTO createDTO);
    AnswerValidation toEntity(UpdateAnswerValidationDTO updateDTO);
    AnswerValidationDTO toDTO(AnswerValidation answerValidation);
}