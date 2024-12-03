package com.wora.quiz.service.interfaces;

import com.wora.quiz.dtos.LevelDTO.CreateLevelDTO;
import com.wora.quiz.dtos.LevelDTO.LevelDTO;
import com.wora.quiz.dtos.LevelDTO.UpdateLevelDTO;
import com.wora.quiz.service.GenericService;

public interface LevelService extends GenericService<CreateLevelDTO, UpdateLevelDTO, LevelDTO,Long> {
}
