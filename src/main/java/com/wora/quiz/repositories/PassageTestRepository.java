package com.wora.quiz.repositories;

import com.wora.quiz.entities.PassageTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageTestRepository extends JpaRepository<PassageTest, Long> {
}
