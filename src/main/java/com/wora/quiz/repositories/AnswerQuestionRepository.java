package com.wora.quiz.repositories;

import com.wora.quiz.entities.AnswerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestion, Long> {
    List<AnswerQuestion> findByQuestionId(Long questionId);
    List<AnswerQuestion> findByAnswerId(Long answerId);
    Boolean existsByAnswerIdAndQuestionId(Long questionId, Long answerId);
    void deleteByAnswerIdAndQuestionId(Long questionId, Long answerId);

}
