package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.StudentDTO.StudentCreateDTO;
import com.wora.quiz.dtos.StudentDTO.StudentDTO;
import com.wora.quiz.dtos.StudentDTO.StudentUpdateDTO;
import com.wora.quiz.service.GenericService;

public interface StudentService extends GenericService<StudentCreateDTO, StudentUpdateDTO, StudentDTO,Long> {
}
