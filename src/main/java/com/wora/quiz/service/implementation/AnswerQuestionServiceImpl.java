package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.AnswerQuestionDTO.AnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.CreateAnswerQuestionDTO;
import com.wora.quiz.dtos.AnswerQuestionDTO.UpdateAnswerQuestionDTO;
import com.wora.quiz.entities.Answer;
import com.wora.quiz.entities.AnswerQuestion;
import com.wora.quiz.entities.Question;
import com.wora.quiz.exceptions.NbrReponsesCorrectes;
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
                .orElseThrow(() -> new EntityNotFoundException("Question not found with id " + createDTO.getQuestionId()));

        Answer answer = answerRepository.findById(createDTO.getAnswerId())
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id " + createDTO.getAnswerId()));

        double minPoint = question.getLevel().getPointsMin();
        double maxPoint = question.getLevel().getPointsMax();

        int maxWrongAnswers = question.getNombreReponses() - question.getNombreReponsesCorrectes();

        int countWrongAnswers = (int) question.getAnswerQuestions().stream()
                .filter(answerQuestion -> answerQuestion.getPoint() == 0)
                .count();

        if (createDTO.getPoint() == 0) {
            if (countWrongAnswers >= maxWrongAnswers) {
                throw new NbrReponsesCorrectes("le max des reponses incorrectes !");
            }
            AnswerQuestion savedAnswerQuestion = answerQuestionMapper.toEntity(createDTO);
            savedAnswerQuestion.setQuestion(question);
            savedAnswerQuestion.setAnswer(answer);
            AnswerQuestion created = answerQuestionRepository.save(savedAnswerQuestion);
            return answerQuestionMapper.toDTO(created);
        }

        if (createDTO.getPoint() <= minPoint || createDTO.getPoint() >= maxPoint) {
            throw new NbrReponsesCorrectes("il faut respecter le min et max des points!");
        }

        int totalAnswers = question.getAnswerQuestions().size();
        if (totalAnswers >= question.getNombreReponses()) {
            throw new NbrReponsesCorrectes("Vous avez depassé le nombre des reponses");
        }

        int countCorrectAnswers = (int) question.getAnswerQuestions().stream()
                .filter(answerQuestion -> answerQuestion.getPoint() > 0)
                .count();

        if (countCorrectAnswers >= question.getNombreReponsesCorrectes()) {
            throw new NbrReponsesCorrectes("Nombre de reponses correcte est depassé !");
        }

        AnswerQuestion savedAnswerQuestion = answerQuestionMapper.toEntity(createDTO);
        savedAnswerQuestion.setQuestion(question);
        savedAnswerQuestion.setAnswer(answer);

        return answerQuestionMapper.toDTO(answerQuestionRepository.save(savedAnswerQuestion));
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

}
