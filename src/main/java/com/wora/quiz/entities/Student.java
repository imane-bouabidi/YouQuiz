package com.wora.quiz.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("Etudiant")
public class Student extends User {
    private java.util.Date dateInscription;

    @OneToMany(mappedBy = "etudiant")
    private List<PassageTest> passageTests;


}

