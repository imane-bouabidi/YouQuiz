package com.wora.quiz.repositories;

import com.wora.quiz.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
}
