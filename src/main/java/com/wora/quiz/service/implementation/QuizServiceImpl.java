package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.QuizDTO.CreateQuizDTO;
import com.wora.quiz.dtos.QuizDTO.QuizDTO;
import com.wora.quiz.dtos.QuizDTO.UpdateQuizDTO;
import com.wora.quiz.entities.Formateur;
import com.wora.quiz.entities.Quiz;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.QuizMapper;
import com.wora.quiz.repositories.FormateurRepository;
import com.wora.quiz.repositories.QuizRepository;
import com.wora.quiz.service.interfaces.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;
    private final FormateurRepository formateurRepository;

    @Override
    public QuizDTO save(CreateQuizDTO createDTO) {
        Quiz quiz = quizMapper.toEntity(createDTO);
        quiz = quizRepository.save(quiz);
        return quizMapper.toDTO(quiz);
    }

    @Override
    public QuizDTO update(UpdateQuizDTO updateDTO, Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));

        Formateur formateur = formateurRepository.findById(updateDTO.getFormateurId())
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));

        if (updateDTO.getTitre() != null) {
            quiz.setTitre(updateDTO.getTitre());
        }
        if (updateDTO.getScoreReussite() != null) {
            quiz.setScoreReussite(updateDTO.getScoreReussite());
        }
        if (updateDTO.getNombreChances() != null) {
            quiz.setNombreChances(updateDTO.getNombreChances());
        }
        if (updateDTO.getDuration() != null) {
            quiz.setDuration(updateDTO.getDuration());
        }
        if (updateDTO.getRemarques() != null) {
            quiz.setRemarques(updateDTO.getRemarques());
        }
        if (updateDTO.getDroitVisualiserReponses() != null) {
            quiz.setDroitVisualiserReponses(updateDTO.getDroitVisualiserReponses());
        }
        if (updateDTO.getDroitVoirResultats() != null) {
            quiz.setDroitVoirResultats(updateDTO.getDroitVoirResultats());
        }
        quiz.setFormateur(formateur);

        quiz = quizRepository.save(quiz);
        return quizMapper.toDTO(quiz);
    }

    public QuizDTO getById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
        return quizMapper.toDTO(quiz);
    }

    public List<QuizDTO> getAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizMapper.toDTOList(quizzes);
    }

    public void delete(Long id) {
        quizRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));
        quizRepository.deleteById(id);
    }
}
