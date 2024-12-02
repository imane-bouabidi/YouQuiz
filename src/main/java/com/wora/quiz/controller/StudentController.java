package com.wora.quiz.controller;

import com.wora.quiz.dtos.StudentDTO.StudentCreateDTO;
import com.wora.quiz.dtos.StudentDTO.StudentDTO;
import com.wora.quiz.dtos.StudentDTO.StudentUpdateDTO;
import com.wora.quiz.service.interfaces.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> saveTrainer(@RequestBody @Valid StudentCreateDTO createDTO) {
        StudentDTO student = studentService.save(createDTO);
        return ResponseEntity.status(201).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateTrainer(@RequestBody @Valid StudentUpdateDTO updateDTO, @PathVariable Long id) {
        StudentDTO student = studentService.update(updateDTO,id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }
}
