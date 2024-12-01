package com.wora.quiz.mappers;
import com.wora.quiz.dtos.AnswerDTO.CreateAnswerDTO;
import com.wora.quiz.dtos.AnswerDTO.AnswerDTO;
import com.wora.quiz.dtos.AnswerDTO.UpdateAnswerDTO;
import com.wora.quiz.entities.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer toEntity(AnswerDTO answerDTO);
    Answer toEntity(CreateAnswerDTO createDTO);
    Answer toEntity(UpdateAnswerDTO updateDTO);
    AnswerDTO toDTO(Answer answer);
}