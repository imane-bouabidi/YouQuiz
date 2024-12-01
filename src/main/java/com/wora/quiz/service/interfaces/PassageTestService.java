package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.PassageTestDTO.CreatePassageTestDTO;
import com.wora.quiz.dtos.PassageTestDTO.PassageTestDTO;
import com.wora.quiz.dtos.PassageTestDTO.UpdatePassageTestDTO;
import com.wora.quiz.service.GenericService;

public interface PassageTestService extends GenericService<CreatePassageTestDTO, UpdatePassageTestDTO, PassageTestDTO,Long> {
}
