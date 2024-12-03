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
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;

    @ManyToOne
    private Sujet parent;

    @OneToMany(mappedBy = "parent")
    private List<Sujet> subSubjects;

    @OneToMany(mappedBy = "sujet")
    private List<Question> questions;
}

