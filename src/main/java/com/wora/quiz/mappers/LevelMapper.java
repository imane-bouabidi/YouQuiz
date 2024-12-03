package com.wora.quiz.mappers;

import com.wora.quiz.dtos.LevelDTO.CreateLevelDTO;
import com.wora.quiz.dtos.LevelDTO.LevelDTO;
import com.wora.quiz.dtos.LevelDTO.UpdateLevelDTO;
import com.wora.quiz.entities.Level;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LevelMapper {
    Level toEntity(LevelDTO levelDTO);
    Level toEntity(CreateLevelDTO createDTO);
    Level toEntity(UpdateLevelDTO updateDTO);
    LevelDTO toDTO(Level level);
}
