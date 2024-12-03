package com.wora.quiz.mappers;

import com.wora.quiz.dtos.PassageTestDTO.CreatePassageTestDTO;
import com.wora.quiz.dtos.PassageTestDTO.PassageTestDTO;
import com.wora.quiz.dtos.PassageTestDTO.UpdatePassageTestDTO;
import com.wora.quiz.entities.PassageTest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassageTestMapper {
    PassageTest toEntity(PassageTestDTO passageTestDTO);
    PassageTest toEntity(CreatePassageTestDTO createDTO);
    PassageTest toEntity(UpdatePassageTestDTO updateDTO);
    PassageTestDTO toDTO(PassageTest passageTest);
}

