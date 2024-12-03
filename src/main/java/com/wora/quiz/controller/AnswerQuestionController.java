package com.wora.quiz.controller;

import com.wora.quiz.dtos.AnswerQuestionDTO.AnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.CreateAnswerQuestionDTO;
import com.wora.quiz.service.interfaces.AnswerQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer-question")
@RequiredArgsConstructor
public class AnswerQuestionController {
    private final AnswerQuestionService answerQuestionService;

    @PostMapping
    public ResponseEntity<AnswerQuestionDTO> create(@RequestBody CreateAnswerQuestionDTO createDTO) {
        return ResponseEntity.ok(answerQuestionService.save(createDTO));
    }
}
