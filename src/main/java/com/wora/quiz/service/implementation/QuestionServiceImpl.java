package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.QuestionDTO.CreateQuestionDTO;
import com.wora.quiz.dtos.QuestionDTO.UpdateQuestionDTO;
import com.wora.quiz.dtos.QuestionDTO.QuestionDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.CreateQuestionTimerDTO;
import com.wora.quiz.entities.*;
import com.wora.quiz.entities.enums.TypeQuestion;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.exceptions.NbrReponsesCorrectes;
import com.wora.quiz.mappers.QuestionMapper;
import com.wora.quiz.repositories.*;
import com.wora.quiz.service.interfaces.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final SujetRepository sujetRepository;
    private final LevelRepository levelRepository;
    private final QuestionTimerRepository questionTimerRepository;
    private final QuizRepository quizRepository;

    @Override
    public QuestionDTO save(CreateQuestionDTO createDTO) {
        Sujet sujet = sujetRepository.findById(createDTO.getSujetId())
                .orElseThrow(() -> new EntityNotFoundException("Sujet not found"));

        Level level = levelRepository.findById(createDTO.getLevelId())
                .orElseThrow(() -> new EntityNotFoundException("Level not found"));
        if (TypeQuestion.UNIQUE.equals(createDTO.getTypeQuestion()) && createDTO.getNombreReponsesCorrectes() > 1) {
            throw new NbrReponsesCorrectes("Nombre de reponses correctes ne match pas le type de question");
        }
        Question question = questionMapper.toEntity(createDTO);
        question.setLevel(level);
        question.setSujet(sujet);
        Question savedQuestion = questionRepository.save(question);

//        Quiz quiz = quizRepository.findById(createDTO.getQuizId())
//                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
//
//        QuestionTimer questionTimer = questionTimerRepository.save(new CreateQuestionTimerDTO());
        return questionMapper.toDTO(savedQuestion);
    }

    @Override
    public QuestionDTO update(UpdateQuestionDTO updateDTO, Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        Sujet sujet = sujetRepository.findById(updateDTO.getSujetId())
                .orElseThrow(() -> new EntityNotFoundException("Sujet not found"));

        Level level = levelRepository.findById(updateDTO.getLevelId())
                .orElseThrow(() -> new EntityNotFoundException("Level not found"));


        question.setTexte(updateDTO.getTexte());
        question.setNombreReponses(updateDTO.getNombreReponses());
        question.setNombreReponsesCorrectes(updateDTO.getNombreReponsesCorrectes());
        question.setTypeQuestion(updateDTO.getTypeQuestion());

        question.setSujet(sujet);
        question.setLevel(level);
        Question updatedQuestion = questionRepository.save(question);
        return questionMapper.toDTO(updatedQuestion);
    }

//    @Override
    public void delete(Long id) {
        if (!questionRepository.existsById(id)) {
            throw new EntityNotFoundException("Question not found");
        }
        questionRepository.deleteById(id);
    }

//    @Override
    public QuestionDTO getById(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
        return questionMapper.toDTO(question);
    }

//    @Override
    public List<QuestionDTO> getAll() {
        return questionRepository.findAll().stream()
                .map(questionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
