package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.AnswerDTO.CreateAnswerDTO;
import com.wora.quiz.dtos.AnswerDTO.UpdateAnswerDTO;
import com.wora.quiz.dtos.AnswerDTO.AnswerDTO;
import com.wora.quiz.entities.Answer;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.AnswerMapper;
import com.wora.quiz.repositories.AnswerRepository;
import com.wora.quiz.service.interfaces.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;
    private final AnswerRepository answerRepository;

    @Override
    public AnswerDTO save(CreateAnswerDTO createDTO) {
        Answer answer = answerMapper.toEntity(createDTO);
        Answer savedAnswer = answerRepository.save(answer);
        return answerMapper.toDTO(savedAnswer);
    }

    @Override
    public AnswerDTO update(UpdateAnswerDTO updateDTO,Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found"));
        answer.setTexte(updateDTO.getTexte());
        Answer updatedAnswer = answerRepository.save(answer);
        return answerMapper.toDTO(updatedAnswer);
    }

//    @Override
    public void delete(Long id) {
        if (!answerRepository.existsById(id)) {
            throw new EntityNotFoundException("Answer not found");
        }
        answerRepository.deleteById(id);
    }

//    @Override
    public AnswerDTO getById(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found"));
        return answerMapper.toDTO(answer);
    }

//    @Override
    public List<AnswerDTO> getAll() {
        return answerRepository.findAll().stream()
                .map(answerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
