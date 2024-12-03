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

import java.util.List;
import java.util.stream.Collectors;

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
    public FormateurDTO update(FormateurUpdateDTO updateDTO, Long id) {
        Formateur formateur = formateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formateur not found"));
        formateur.setNom(updateDTO.getNom());
        formateur.setAdresse(updateDTO.getAdresse());
        formateur.setPrenom(updateDTO.getPrenom());
        formateur.setBirthDate(updateDTO.getBirthDate());
        formateur.setSpecialite(updateDTO.getSpecialite());
        Formateur updated = formateurRepository.save(formateur);
        return formateurMapper.toDTO(updated);
    }
    @Override
    public FormateurDTO getById(Long id) {
        Formateur formateur = formateurRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Formateur not found"));
        return formateurMapper.toDTO(formateur);
    }

    @Override
    public List<FormateurDTO> getAll() {
        return formateurRepository.findAll()
                .stream()
                .map(formateurMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!formateurRepository.existsById(id)) {
            throw new EntityNotFoundException("Formateur not found");
        }
        formateurRepository.deleteById(id);
    }
}
