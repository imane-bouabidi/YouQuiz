package com.wora.quiz.controller;

import com.wora.quiz.dtos.FormateurDTO.FormateurCreateDTO;
import com.wora.quiz.dtos.FormateurDTO.FormateurDTO;
import com.wora.quiz.dtos.FormateurDTO.FormateurUpdateDTO;
import com.wora.quiz.service.implementation.FormateurServiceImpl;
import com.wora.quiz.service.interfaces.FormateurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/formateurs")
@RequiredArgsConstructor
public class FormateurController {

    private final FormateurService formateurService;

    @PostMapping
    public ResponseEntity<FormateurDTO> saveTrainer(@RequestBody @Valid FormateurCreateDTO createDTO) {
        FormateurDTO formateur = formateurService.save(createDTO);
        return ResponseEntity.status(201).body(formateur);
    }

    @PutMapping
    public ResponseEntity<FormateurDTO> saveTrainer(@RequestBody @Valid FormateurUpdateDTO updateDTO) {
        FormateurDTO formateur = formateurService.update(updateDTO);
        return ResponseEntity.ok(formateur);
    }
}
