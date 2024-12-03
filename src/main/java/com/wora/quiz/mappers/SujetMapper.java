package com.wora.quiz.mappers;

import com.wora.quiz.dtos.SujetDTO.CreateSujetDTO;
import com.wora.quiz.dtos.SujetDTO.SujetDTO;
import com.wora.quiz.dtos.SujetDTO.UpdateSujetDTO;
import com.wora.quiz.entities.Sujet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SujetMapper {
    Sujet toEntity(SujetDTO sujetDTO);
    Sujet toEntity(CreateSujetDTO createDTO);
    Sujet toEntity(UpdateSujetDTO updateDTO);
    SujetDTO toDTO(Sujet sujet);
}

