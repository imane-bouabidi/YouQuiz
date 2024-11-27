package com.wora.quiz.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("Formateur")
public class Formateur extends User {
    private String specialite;

    @OneToMany(mappedBy = "formateur")
    private List<Quiz> quizzes;

    public Formateur() {}

}

