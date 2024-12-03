package com.wora.quiz.controller;

import com.wora.quiz.dtos.AnswerValidationDTO.AnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.CreateAnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.UpdateAnswerValidationDTO;
import com.wora.quiz.service.interfaces.AnswerValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer-validations")
@RequiredArgsConstructor
public class AnswerValidationController {

    private final AnswerValidationService answerValidationService;

    @PostMapping
    public ResponseEntity<AnswerValidationDTO> create(@RequestBody CreateAnswerValidationDTO createDTO) {
        return ResponseEntity.ok(answerValidationService.save(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerValidationDTO> update(@PathVariable Long id, @RequestBody UpdateAnswerValidationDTO updateDTO) {
        return ResponseEntity.ok(answerValidationService.update(updateDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerValidationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(answerValidationService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        answerValidationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AnswerValidationDTO>> getAll() {
        return ResponseEntity.ok(answerValidationService.getAll());
    }
}

