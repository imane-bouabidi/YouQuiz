package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.FormateurDTO.FormateurCreateDTO;
import com.wora.quiz.dtos.FormateurDTO.FormateurDTO;
import com.wora.quiz.dtos.FormateurDTO.FormateurUpdateDTO;
import com.wora.quiz.service.GenericService;

public interface FormateurService extends GenericService<FormateurCreateDTO, FormateurUpdateDTO, FormateurDTO,Long> {
}
