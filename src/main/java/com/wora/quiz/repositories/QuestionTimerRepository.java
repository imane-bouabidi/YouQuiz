package com.wora.quiz.repositories;

import com.wora.quiz.entities.QuestionTimer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTimerRepository extends JpaRepository<QuestionTimer, Long> {
}