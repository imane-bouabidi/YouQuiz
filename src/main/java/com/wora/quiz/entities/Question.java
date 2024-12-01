package com.wora.quiz.entities;

import com.wora.quiz.entities.enums.TypeQuestion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String texte;
    private Integer points;
    private Integer nombreReponses;
    private Integer nombreReponsesCorrectes;

    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;

    @ManyToOne
    private Sujet sujet;

    @ManyToOne
    private Level level;

    @OneToMany(mappedBy = "question")
    private List<QuestionTimer> questionTimers;

    @OneToMany(mappedBy = "question")
    private List<AnswerValidation> validations;
}
