package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.StudentDTO.StudentCreateDTO;
import com.wora.quiz.dtos.StudentDTO.StudentDTO;
import com.wora.quiz.dtos.StudentDTO.StudentUpdateDTO;
import com.wora.quiz.entities.Student;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.StudentMapper;
import com.wora.quiz.repositories.StudentRepository;
import com.wora.quiz.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Override
    public StudentDTO save(StudentCreateDTO createDTO) {
        Student student = studentMapper.toEntity(createDTO);
        Student studentSaved = studentRepository.save(student);
        return studentMapper.toDTO(studentSaved);
    }

    @Override
    public StudentDTO update(StudentUpdateDTO updateDTO) {
        Student student = studentRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        student.setNom(updateDTO.getNom());
        student.setAdresse(updateDTO.getAdresse());
        student.setPrenom(updateDTO.getPrenom());
        student.setBirthDate(updateDTO.getBirthDate());
        student.setDateInscription(updateDTO.getDateInscription());
        Student updated = studentRepository.save(student);
        return studentMapper.toDTO(updated);
    }
}
