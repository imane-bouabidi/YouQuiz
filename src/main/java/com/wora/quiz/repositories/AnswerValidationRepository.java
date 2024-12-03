package com.wora.quiz.repositories;

import com.wora.quiz.entities.AnswerValidation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerValidationRepository extends JpaRepository<AnswerValidation, Long> {
}
