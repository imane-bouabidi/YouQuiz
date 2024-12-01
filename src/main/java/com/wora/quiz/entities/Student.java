package com.wora.quiz.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Etudiant")
public class Student extends User {
    @NotBlank
    private LocalDate dateInscription;

    @OneToMany(mappedBy = "student")
    private List<PassageTest> passageTests;


}

