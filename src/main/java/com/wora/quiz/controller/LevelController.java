package com.wora.quiz.controller;

import com.wora.quiz.dtos.LevelDTO.CreateLevelDTO;
import com.wora.quiz.dtos.LevelDTO.LevelDTO;
import com.wora.quiz.dtos.LevelDTO.UpdateLevelDTO;
import com.wora.quiz.service.interfaces.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @PostMapping
    public ResponseEntity<LevelDTO> create(@RequestBody CreateLevelDTO createDTO) {
        return ResponseEntity.ok(levelService.save(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LevelDTO> update(@PathVariable Long id, @RequestBody UpdateLevelDTO updateDTO) {
        return ResponseEntity.ok(levelService.update(updateDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(levelService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        levelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LevelDTO>> getAll() {
        return ResponseEntity.ok(levelService.getAll());
    }
}
