package com.wora.quiz.controller;

import com.wora.quiz.dtos.AnswerDTO.AnswerDTO;
import com.wora.quiz.dtos.AnswerDTO.CreateAnswerDTO;
import com.wora.quiz.dtos.AnswerDTO.UpdateAnswerDTO;
import com.wora.quiz.service.interfaces.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<AnswerDTO> create(@RequestBody CreateAnswerDTO createDTO) {
        return ResponseEntity.ok(answerService.save(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerDTO> update(@PathVariable Long id, @RequestBody UpdateAnswerDTO updateDTO) {
        return ResponseEntity.ok(answerService.update(updateDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        answerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AnswerDTO>> getAll() {
        return ResponseEntity.ok(answerService.getAll());
    }
}

