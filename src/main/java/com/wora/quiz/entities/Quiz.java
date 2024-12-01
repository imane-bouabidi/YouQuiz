package com.wora.quiz.entities;

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
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String titre;
    private Integer scoreReussite;
    private boolean droitVisualiserReponses;
    private boolean droitVoirResultats;
    private Integer nombreChances;
    private String remarques;
    private Integer duration;

    @ManyToOne
    private Formateur formateur;

    @OneToMany(mappedBy = "quiz")
    private List<QuestionTimer> questionTimers;

    @OneToMany(mappedBy = "quiz")
    private List<PassageTest> passageTests;
}

