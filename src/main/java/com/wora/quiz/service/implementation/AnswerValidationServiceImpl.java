package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.AnswerValidationDTO.CreateAnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.UpdateAnswerValidationDTO;
import com.wora.quiz.dtos.AnswerValidationDTO.AnswerValidationDTO;
import com.wora.quiz.entities.*;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.exceptions.ExistQuestionQuizException;
import com.wora.quiz.mappers.AnswerValidationMapper;
import com.wora.quiz.repositories.*;
import com.wora.quiz.service.interfaces.AnswerQuestionService;
import com.wora.quiz.service.interfaces.AnswerValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerValidationServiceImpl implements AnswerValidationService {

    private final AnswerValidationMapper answerValidationMapper;
    private final AnswerValidationRepository answerValidationRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final PassageTestRepository passageTestRepository;
    private final AnswerQuestionRepository answerQuestionRepository;

    @Override
    public AnswerValidationDTO save(CreateAnswerValidationDTO createDTO) {
        Answer answer = answerRepository.findById(createDTO.getAnswerId()).orElseThrow(()-> new EntityNotFoundException("Answer not found"));
        Question question = questionRepository.findById(createDTO.getQuestionId()).orElseThrow(()-> new EntityNotFoundException("Question not found"));
        PassageTest passageTest = passageTestRepository.findById(createDTO.getPassageTestId()).orElseThrow(()-> new EntityNotFoundException("Passage Test not found"));

        boolean questionDansQuiz = passageTest.getQuiz().getQuestionTimers()
                .stream()
                .anyMatch(quiz -> Objects.equals(quiz.getQuestion().getId(), question.getId()));

        if (!questionDansQuiz) {
            throw new ExistQuestionQuizException("existe deja !");
        }

        AnswerQuestion reponseAssociee = answerQuestionRepository.findByAnswerIdAndQuestionId(
                        answer.getId(), question.getId())
                .orElseThrow(() -> new EntityNotFoundException("Réponse question non trouvée"));

        AnswerValidation validationReponse = answerValidationMapper.toEntity(createDTO);
        validationReponse.setPointsObtenus(reponseAssociee.getPoint());
        validationReponse.setQuestion(question);
        validationReponse.setAnswer(answer);
        validationReponse.setPassageTest(passageTest);

        AnswerValidation validationSauvegardee = answerValidationRepository.save(validationReponse);

        double scoreTotal = answerValidationRepository.findByPassageTestId(passageTest.getId())
                .stream()
                .mapToDouble(AnswerValidation::getPointsObtenus)
                .sum();

        passageTest.setScoreObtenu(scoreTotal);
        passageTest.setResultatFinal((scoreTotal / passageTest.getQuiz().getScoreReussite()) * 100);
        passageTestRepository.save(passageTest);

        return answerValidationMapper.toDTO(validationSauvegardee);
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
