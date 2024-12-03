package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.AnswerQuestionDTO.AnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.CreateAnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.UpdateAnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.AnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.UpdateAnswerValidationDTO;
import com.wora.quiz.entities.Answer;
import com.wora.quiz.entities.AnswerQuestion;
import com.wora.quiz.entities.Question;
import com.wora.quiz.mappers.AnswerQuestionMapper;
import com.wora.quiz.repositories.AnswerQuestionRepository;
import com.wora.quiz.repositories.AnswerRepository;
import com.wora.quiz.repositories.QuestionRepository;
import com.wora.quiz.service.interfaces.AnswerQuestionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerQuestionServiceImpl implements AnswerQuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final AnswerQuestionRepository answerQuestionRepository;
    private final AnswerQuestionMapper answerQuestionMapper;

    @Override
    public AnswerQuestionDTO save(CreateAnswerQuestionDTO createDTO) {
        Question question = questionRepository.findById(createDTO.getQuestionId())
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));

        Answer answer = answerRepository.findById(createDTO.getAnswerId())
                .orElseThrow(() -> new EntityNotFoundException("Answer not found"));

        AnswerQuestion answerQuestion = new AnswerQuestion();
        answerQuestion.setQuestion(question);
        answerQuestion.setAnswer(answer);
        answerQuestion.setCorrect(createDTO.getCorrect());
        answerQuestion.setPoint(createDTO.getPoint());

        AnswerQuestion saved = answerQuestionRepository.save(answerQuestion);
        return answerQuestionMapper.toDTO(saved);
    }

    @Override
    public AnswerQuestionDTO update(UpdateAnswerQuestionDTO updateDTO, Long id) {
        return null;
    }
    @Override

    public  AnswerQuestionDTO getById(Long id) {
        return null;
    }
    @Override
    public  List<AnswerQuestionDTO> getAll() {
        return null;
    }
    @Override
    public  void delete(Long id) {
    }

        public List<AnswerQuestionDTO> getAnswersForQuestion(Long questionId) {
        List<AnswerQuestion> answers = answerQuestionRepository.findByQuestionId(questionId);
        return answers.stream()
                .map(answerQuestionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AnswerQuestionDTO> getQuestionsForAnswer(Long answerId) {
        List<AnswerQuestion> questions = answerQuestionRepository.findByAnswerId(answerId);
        return questions.stream()
                .map(answerQuestionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteAnswerFromQuestion(Long questionId, Long answerId) {
        if (!answerQuestionRepository.existsByAnswerIdAndQuestionId(questionId,answerId)) {
            throw new EntityNotFoundException("AnswerQuestion not found");
        }
        answerQuestionRepository.deleteByAnswerIdAndQuestionId(questionId,answerId);
    }

//    public List<AnswerQuestionDTO> findCorrectAnswersForQuestion(Long questionId) {
//        List<AnswerQuestion> correctAnswers = answerQuestionRepository.findByQuestionId(questionId).stream()
//                .filter(AnswerQuestion::Correct)
//                .collect(Collectors.toList());
//        return correctAnswers.stream()
//                .map(answerQuestionMapper::toDTO)
//                .collect(Collectors.toList());
//    }
}
