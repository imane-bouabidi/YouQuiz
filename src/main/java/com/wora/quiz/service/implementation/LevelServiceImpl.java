package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.LevelDTO.CreateLevelDTO;
import com.wora.quiz.dtos.LevelDTO.UpdateLevelDTO;
import com.wora.quiz.dtos.LevelDTO.LevelDTO;
import com.wora.quiz.entities.Level;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.LevelMapper;
import com.wora.quiz.repositories.LevelRepository;
import com.wora.quiz.service.interfaces.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelMapper levelMapper;
    private final LevelRepository levelRepository;

    @Override
    public LevelDTO save(CreateLevelDTO createDTO) {
        Level level = levelMapper.toEntity(createDTO);
        Level savedLevel = levelRepository.save(level);
        return levelMapper.toDTO(savedLevel);
    }

    @Override
    public LevelDTO update(UpdateLevelDTO updateDTO, Long id) {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Level not found"));
        level.setDescription(updateDTO.getDescription());
        level.setPointsMax(updateDTO.getPointsMax());
        level.setPointsMin(updateDTO.getPointsMin());
        Level updatedLevel = levelRepository.save(level);
        return levelMapper.toDTO(updatedLevel);
    }

//    @Override
    public void delete(Long id) {
        if (!levelRepository.existsById(id)) {
            throw new EntityNotFoundException("Level not found");
        }
        levelRepository.deleteById(id);
    }

//    @Override
    public LevelDTO getById(Long id) {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Level not found"));
        return levelMapper.toDTO(level);
    }

//    @Override
    public List<LevelDTO> getAll() {
        return levelRepository.findAll().stream()
                .map(levelMapper::toDTO)
                .collect(Collectors.toList());
    }
}

