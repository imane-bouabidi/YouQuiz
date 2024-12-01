package com.wora.quiz.service.implementation;

import com.wora.quiz.dtos.PassageTestDTO.CreatePassageTestDTO;
import com.wora.quiz.dtos.PassageTestDTO.UpdatePassageTestDTO;
import com.wora.quiz.dtos.PassageTestDTO.PassageTestDTO;
import com.wora.quiz.entities.PassageTest;
import com.wora.quiz.entities.Quiz;
import com.wora.quiz.entities.Student;
import com.wora.quiz.exceptions.EntityNotFoundException;
import com.wora.quiz.mappers.PassageTestMapper;
import com.wora.quiz.repositories.PassageTestRepository;
import com.wora.quiz.repositories.QuizRepository;
import com.wora.quiz.repositories.StudentRepository;
import com.wora.quiz.service.interfaces.PassageTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassageTestServiceImpl implements PassageTestService {

    private final PassageTestMapper passageTestMapper;
    private final PassageTestRepository passageTestRepository;
    private final StudentRepository studentRepository;
    private final QuizRepository quizRepository;

    @Override
    public PassageTestDTO save(CreatePassageTestDTO createDTO) {
        PassageTest passageTest = passageTestMapper.toEntity(createDTO);
        PassageTest savedPassageTest = passageTestRepository.save(passageTest);
        return passageTestMapper.toDTO(savedPassageTest);
    }

    @Override
    public PassageTestDTO update(UpdatePassageTestDTO updateDTO, Long id) {
        PassageTest passageTest = passageTestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PassageTest not found"));

        Student student = studentRepository.findById(updateDTO.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        Quiz quiz = quizRepository.findById(updateDTO.getQuizId())
                .orElseThrow(() -> new EntityNotFoundException("Quiz not found"));

        passageTest.setStudent(student);
        passageTest.setQuiz(quiz);
        passageTest.setScoreObtenu(updateDTO.getScoreObtenu());
        passageTest.setNumTentative(updateDTO.getNumTentative());
        passageTest.setRaisonRepassage(updateDTO.getRaisonRepassage());
        passageTest.setResultatFinal(updateDTO.getResultatFinal());
        passageTest.setDateDebut(updateDTO.getDateDebut());
        passageTest.setDateFin(updateDTO.getDateFin());

        PassageTest updatedPassageTest = passageTestRepository.save(passageTest);
        return passageTestMapper.toDTO(updatedPassageTest);
    }

//    @Override
    public void delete(Long id) {
        if (!passageTestRepository.existsById(id)) {
            throw new EntityNotFoundException("PassageTest not found");
        }
        passageTestRepository.deleteById(id);
    }

//    @Override
    public PassageTestDTO getById(Long id) {
        PassageTest passageTest = passageTestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PassageTest not found"));
        return passageTestMapper.toDTO(passageTest);
    }

//    @Override
    public List<PassageTestDTO> getAll() {
        return passageTestRepository.findAll().stream()
                .map(passageTestMapper::toDTO)
                .collect(Collectors.toList());
    }
}