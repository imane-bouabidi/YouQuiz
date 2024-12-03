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

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<FormateurDTO> updateTrainer(@RequestBody @Valid FormateurUpdateDTO updateDTO, @PathVariable Long id) {
        FormateurDTO formateur = formateurService.update(updateDTO,id);
        return ResponseEntity.ok(formateur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormateurDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(formateurService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        formateurService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FormateurDTO>> getAll() {
        return ResponseEntity.ok(formateurService.getAll());
    }
}
