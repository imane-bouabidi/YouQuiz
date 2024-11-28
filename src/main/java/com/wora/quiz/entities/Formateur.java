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
@DiscriminatorValue("Formateur")
public class Formateur extends User {
    private String specialite;

    @OneToMany(mappedBy = "formateur")
    private List<Quiz> quizzes;


}

