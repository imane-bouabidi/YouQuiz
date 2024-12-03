package com.wora.quiz.controller;

import com.wora.quiz.dtos.QuizDTO.CreateQuizDTO;
import com.wora.quiz.dtos.QuizDTO.QuizDTO;
import com.wora.quiz.dtos.QuizDTO.UpdateQuizDTO;
import com.wora.quiz.service.interfaces.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    public ResponseEntity<QuizDTO> create(@RequestBody CreateQuizDTO createDTO) {
        return ResponseEntity.ok(quizService.save(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuizDTO> update(@PathVariable Long id, @RequestBody UpdateQuizDTO updateDTO) {
        return ResponseEntity.ok(quizService.update(updateDTO, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        quizService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<QuizDTO>> getAll() {
        return ResponseEntity.ok(quizService.getAll());
    }
}

