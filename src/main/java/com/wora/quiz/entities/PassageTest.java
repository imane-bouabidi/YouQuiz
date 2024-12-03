package com.wora.quiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PassageTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer scoreObtenu;
    private Integer numTentative;
    private String raisonRepassage;
    private boolean resultatFinal;

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Quiz quiz;

    @OneToMany
    private List<Answer> answers;
}

