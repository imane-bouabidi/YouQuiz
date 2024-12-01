package com.wora.quiz.mappers;

import com.wora.quiz.dtos.QuizDTO.CreateQuizDTO;
import com.wora.quiz.dtos.QuizDTO.QuizDTO;
import com.wora.quiz.dtos.QuizDTO.UpdateQuizDTO;
import com.wora.quiz.entities.Quiz;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuizMapper {
    Quiz toEntity(QuizDTO quizDTO);
    Quiz toEntity(CreateQuizDTO createDTO);
    Quiz toEntity(UpdateQuizDTO updateDTO);
    QuizDTO toDTO(Quiz quiz);
    List<QuizDTO> toDTOList(List<Quiz> quizzes);
}
