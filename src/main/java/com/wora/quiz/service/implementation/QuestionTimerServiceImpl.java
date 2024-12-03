package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.QuestionTimerDTO.CreateQuestionTimerDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.UpdateQuestionTimerDTO;
import com.wora.quiz.dtos.QuestionTimerDTO.QuestionTimerDTO;
import com.wora.quiz.entities.Question;
import com.wora.quiz.entities.QuestionTimer;
import com.wora.quiz.entities.Quiz;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.QuestionTimerMapper;
import com.wora.quiz.repositories.QuestionRepository;
import com.wora.quiz.repositories.QuestionTimerRepository;
import com.wora.quiz.repositories.QuizRepository;
import com.wora.quiz.service.interfaces.QuestionTimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionTimerServiceImpl implements QuestionTimerService {

    private final QuestionTimerMapper questionTimerMapper;
    private final QuestionTimerRepository questionTimerRepository;
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    @Override
    public QuestionTimerDTO save(CreateQuestionTimerDTO createDTO) {
        Question question = questionRepository.findById(createDTO.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        Quiz quiz = quizRepository.findById(createDTO.getQuizId())
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));

        QuestionTimer questionTimer = questionTimerMapper.toEntity(createDTO);

        questionTimer.setQuestion(question);
        questionTimer.setQuiz(quiz);
        QuestionTimer savedQuestionTimer = questionTimerRepository.save(questionTimer);
        return questionTimerMapper.toDTO(savedQuestionTimer);
    }

    @Override
    public QuestionTimerDTO update(UpdateQuestionTimerDTO updateDTO,Long id) {
        QuestionTimer questionTimer = questionTimerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("QuestionTimer not found"));

        Question question = questionRepository.findById(updateDTO.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        Quiz quiz = quizRepository.findById(updateDTO.getQuizId())
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));

        questionTimer.setTemps(updateDTO.getTemps());
        questionTimer.setQuestion(question);
        questionTimer.setQuiz(quiz);

        QuestionTimer updatedQuestionTimer = questionTimerRepository.save(questionTimer);
        return questionTimerMapper.toDTO(updatedQuestionTimer);
    }

//    @Override
    public void delete(Long id) {
        if (!questionTimerRepository.existsById(id)) {
            throw new EntityNotFoundException("QuestionTimer not found");
        }
        questionTimerRepository.deleteById(id);
    }

//    @Override
    public QuestionTimerDTO getById(Long id) {
        QuestionTimer questionTimer = questionTimerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("QuestionTimer not found"));
        return questionTimerMapper.toDTO(questionTimer);
    }

//    @Override
    public List<QuestionTimerDTO> getAll() {
        return questionTimerRepository.findAll().stream()
                .map(questionTimerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
