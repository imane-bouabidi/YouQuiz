package com.wora.quiz.controller;

import com.wora.quiz.dtos.QuestionDTO.CreateQuestionDTO;
import com.wora.quiz.dtos.QuestionDTO.QuestionDTO;
import com.wora.quiz.dtos.QuestionDTO.UpdateQuestionDTO;
import com.wora.quiz.service.interfaces.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionDTO> create(@RequestBody CreateQuestionDTO createDTO) {
        return ResponseEntity.ok(questionService.save(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionDTO> update(@PathVariable Long id, @RequestBody UpdateQuestionDTO updateDTO) {
        return ResponseEntity.ok(questionService.update(updateDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        questionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAll() {
        return ResponseEntity.ok(questionService.getAll());
    }
}

