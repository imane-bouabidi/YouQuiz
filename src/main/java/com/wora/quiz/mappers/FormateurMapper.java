package com.wora.quiz.mappers;

import com.wora.quiz.dtos.FormateurDTO.FormateurCreateDTO;
import com.wora.quiz.dtos.FormateurDTO.FormateurDTO;
import com.wora.quiz.dtos.FormateurDTO.FormateurUpdateDTO;
import com.wora.quiz.entities.Formateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormateurMapper {
    Formateur toEntity(FormateurDTO formateurDTO);
    Formateur toEntity(FormateurCreateDTO createDTO);
    Formateur toEntity(FormateurUpdateDTO updateDTO);
    FormateurDTO toDTO(Formateur formateur);
}
