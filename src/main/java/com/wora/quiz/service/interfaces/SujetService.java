package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.SujetDTO.CreateSujetDTO;
import com.wora.quiz.dtos.SujetDTO.SujetDTO;
import com.wora.quiz.dtos.SujetDTO.UpdateSujetDTO;
import com.wora.quiz.service.GenericService;

public interface SujetService extends GenericService<CreateSujetDTO, UpdateSujetDTO, SujetDTO,Long> {
}
