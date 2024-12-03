package com.wora.quiz.controller;

import com.wora.quiz.dtos.SujetDTO.CreateSujetDTO;
import com.wora.quiz.dtos.SujetDTO.SujetDTO;
import com.wora.quiz.dtos.SujetDTO.UpdateSujetDTO;
import com.wora.quiz.service.interfaces.SujetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sujets")
@RequiredArgsConstructor
public class SujetController {

    private final SujetService sujetService;

    @PostMapping
    public ResponseEntity<SujetDTO> create(@RequestBody CreateSujetDTO createDTO) {
        return ResponseEntity.ok(sujetService.save(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SujetDTO> update(@PathVariable Long id, @RequestBody UpdateSujetDTO updateDTO) {
        return ResponseEntity.ok(sujetService.update(updateDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SujetDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sujetService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sujetService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SujetDTO>> getAll() {
        return ResponseEntity.ok(sujetService.getAll());
    }
}

