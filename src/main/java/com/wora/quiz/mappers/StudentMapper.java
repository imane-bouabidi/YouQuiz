package com.wora.quiz.mappers;

import com.wora.quiz.dtos.StudentDTO.StudentCreateDTO;
import com.wora.quiz.dtos.StudentDTO.StudentDTO;
import com.wora.quiz.dtos.StudentDTO.StudentUpdateDTO;
import com.wora.quiz.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentDTO studentDTO);
    Student toEntity(StudentCreateDTO createDTO);
    Student toEntity(StudentUpdateDTO updateDTO);
    StudentDTO toDTO(Student student);
}
