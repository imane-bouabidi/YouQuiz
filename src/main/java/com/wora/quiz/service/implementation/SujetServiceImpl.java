package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.SujetDTO.CreateSujetDTO;
import com.wora.quiz.dtos.SujetDTO.UpdateSujetDTO;
import com.wora.quiz.dtos.SujetDTO.SujetDTO;
import com.wora.quiz.entities.Sujet;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.SujetMapper;
import com.wora.quiz.repositories.SujetRepository;
import com.wora.quiz.service.interfaces.SujetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SujetServiceImpl implements SujetService {

    private final SujetMapper sujetMapper;
    private final SujetRepository sujetRepository;

    @Override
    public SujetDTO save(CreateSujetDTO createDTO) {
        Sujet sujet = sujetMapper.toEntity(createDTO);
        Sujet savedSujet = sujetRepository.save(sujet);
        return sujetMapper.toDTO(savedSujet);
    }

    @Override
    public SujetDTO update(UpdateSujetDTO updateDTO,Long id) {
        Sujet sujet = sujetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sujet not found"));
        sujet.setIntitule(updateDTO.getIntitule());
        if (updateDTO.getParentId() != null) {
            sujet.setParent(sujetRepository.findById(updateDTO.getParentId())
                    .orElseThrow(() -> new EntityNotFoundException("Parent Sujet not found")));
        }
        Sujet updatedSujet = sujetRepository.save(sujet);
        return sujetMapper.toDTO(updatedSujet);
    }

    @Override
    public void delete(Long id) {
        if (!sujetRepository.existsById(id)) {
            throw new EntityNotFoundException("Sujet not found");
        }
        sujetRepository.deleteById(id);
    }

    @Override
    public SujetDTO getById(Long id) {
        Sujet sujet = sujetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sujet not found"));
        return sujetMapper.toDTO(sujet);
    }

    @Override
    public List<SujetDTO> getAll() {
        return sujetRepository.findAll().stream()
                .map(sujetMapper::toDTO)
                .collect(Collectors.toList());
    }
}
