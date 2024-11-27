package com.wora.quiz.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("Formateur")
public class Formateur extends User {
    private String specialite;

    @OneToMany(mappedBy = "formateur")
    private List<Test> tests;

    public Formateur() {}

}

