package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.QuizDTO.CreateQuizDTO;
import com.wora.quiz.dtos.QuizDTO.QuizDTO;
import com.wora.quiz.dtos.QuizDTO.UpdateQuizDTO;
import com.wora.quiz.service.GenericService;

public interface QuizService extends GenericService<CreateQuizDTO, UpdateQuizDTO,QuizDTO,Long> {
}
