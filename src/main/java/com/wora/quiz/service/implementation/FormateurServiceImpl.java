package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.FormateurDTO.FormateurCreateDTO;
import com.wora.quiz.dtos.FormateurDTO.FormateurDTO;
import com.wora.quiz.dtos.FormateurDTO.FormateurUpdateDTO;
import com.wora.quiz.entities.Formateur;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.FormateurMapper;
import com.wora.quiz.repositories.FormateurRepository;
import com.wora.quiz.service.interfaces.FormateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormateurServiceImpl implements FormateurService {

    private final FormateurMapper formateurMapper;
    private final FormateurRepository formateurRepository;

    @Override
    public FormateurDTO save(FormateurCreateDTO createDTO) {
        Formateur formateur = formateurMapper.toEntity(createDTO);
        Formateur formateurSaved = formateurRepository.save(formateur);
        return formateurMapper.toDTO(formateurSaved);
    }

    @Override
    public FormateurDTO update(FormateurUpdateDTO updateDTO) {
        Formateur formateur = formateurRepository.findById(updateDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Formateur not found"));
        formateur.setNom(updateDTO.getNom());
        formateur.setAdresse(updateDTO.getAdresse());
        formateur.setPrenom(updateDTO.getPrenom());
        formateur.setBirthDate(updateDTO.getBirthDate());
        formateur.setSpecialite(updateDTO.getSpecialite());
        Formateur updated = formateurRepository.save(formateur);
        return formateurMapper.toDTO(updated);
    }
}
