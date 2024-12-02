package com.wora.quiz.controller;

import com.wora.quiz.dtos.PassageTestDTO.CreatePassageTestDTO;
import com.wora.quiz.dtos.PassageTestDTO.PassageTestDTO;
import com.wora.quiz.dtos.PassageTestDTO.UpdatePassageTestDTO;
import com.wora.quiz.service.interfaces.PassageTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passage-tests")
@RequiredArgsConstructor
public class PassageTestController {

    private final PassageTestService passageTestService;

    @PostMapping
    public ResponseEntity<PassageTestDTO> create(@RequestBody CreatePassageTestDTO createDTO) {
        return ResponseEntity.ok(passageTestService.save(createDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassageTestDTO> update(@PathVariable Long id, @RequestBody UpdatePassageTestDTO updateDTO) {
        return ResponseEntity.ok(passageTestService.update(updateDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassageTestDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(passageTestService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        passageTestService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PassageTestDTO>> getAll() {
        return ResponseEntity.ok(passageTestService.getAll());
    }
}

