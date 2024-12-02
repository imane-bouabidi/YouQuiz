package com.wora.quiz.controller;

import com.wora.quiz.dtos.QuestionTimerDTO.CreateQuestionTimerDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.QuestionTimerDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.UpdateQuestionTimerDTO;
import com.wora.quiz.service.interfaces.QuestionTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question-timers")
@RequiredArgsConstructor
public class QuestionTimerController {

    private final QuestionTimerService questionTimerService;

    @PostMapping
    public ResponseEntity<QuestionTimerDTO> create(@RequestBody CreateQuestionTimerDTO createDTO) {
        return ResponseEntity.ok(questionTimerService.save(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionTimerDTO> update(@PathVariable Long id, @RequestBody UpdateQuestionTimerDTO updateDTO) {
        return ResponseEntity.ok(questionTimerService.update(updateDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionTimerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(questionTimerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        questionTimerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<QuestionTimerDTO>> getAll() {
        return ResponseEntity.ok(questionTimerService.getAll());
    }
}

