package com.wora.quiz.repositories;

import com.wora.quiz.entities.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
}
