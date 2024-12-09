package com.wora.quiz.repositories;

import com.wora.quiz.entities.AnswerValidation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerValidationRepository extends JpaRepository<AnswerValidation, Long> {
    List<AnswerValidation> findByPassageTestId(Long passageTestId);
}
