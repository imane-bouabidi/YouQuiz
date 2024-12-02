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

import java.util.List;
import java.util.stream.Collectors;

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
    public StudentDTO update(StudentUpdateDTO updateDTO, Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        if (updateDTO.getNom() != null) {
        student.setNom(updateDTO.getNom());
        }
        if (updateDTO.getPrenom() != null) {
        student.setPrenom(updateDTO.getPrenom());
        }
        if (updateDTO.getDateInscription() != null) {
        student.setDateInscription(updateDTO.getDateInscription());
        }
        if (updateDTO.getAdresse() != null) {
        student.setAdresse(updateDTO.getAdresse());
        }
        if (updateDTO.getBirthDate() != null) {
        student.setBirthDate(updateDTO.getBirthDate());
        }
        Student updated = studentRepository.save(student);
        return studentMapper.toDTO(updated);
    }

    @Override
    public StudentDTO getById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        return studentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
    }
}
