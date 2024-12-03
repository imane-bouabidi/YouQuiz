package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.AnswerValidationDTO.CreateAnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.UpdateAnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.AnswerValidationDTO;
import com.wora.quiz.entities.AnswerValidation;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.AnswerValidationMapper;
import com.wora.quiz.repositories.AnswerValidationRepository;
import com.wora.quiz.service.interfaces.AnswerValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerValidationServiceImpl implements AnswerValidationService {

    private final AnswerValidationMapper answerValidationMapper;
    private final AnswerValidationRepository answerValidationRepository;

    @Override
    public AnswerValidationDTO save(CreateAnswerValidationDTO createDTO) {
        AnswerValidation answerValidation = answerValidationMapper.toEntity(createDTO);
        AnswerValidation savedAnswerValidation = answerValidationRepository.save(answerValidation);
        return answerValidationMapper.toDTO(savedAnswerValidation);
    }

    @Override
    public AnswerValidationDTO update(UpdateAnswerValidationDTO updateDTO, Long id) {
        AnswerValidation answerValidation = answerValidationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AnswerValidation not found"));
        answerValidation.setAnswer(answerValidation.getAnswer());
        AnswerValidation updatedAnswerValidation = answerValidationRepository.save(answerValidation);
        return answerValidationMapper.toDTO(updatedAnswerValidation);
    }

//    @Override
    public void delete(Long id) {
        if (!answerValidationRepository.existsById(id)) {
            throw new EntityNotFoundException("AnswerValidation not found");
        }
        answerValidationRepository.deleteById(id);
    }

//    @Override
    public AnswerValidationDTO getById(Long id) {
        AnswerValidation answerValidation = answerValidationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AnswerValidation not found"));
        return answerValidationMapper.toDTO(answerValidation);
    }

//    @Override
    public List<AnswerValidationDTO> getAll() {
        return answerValidationRepository.findAll().stream()
                .map(answerValidationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
