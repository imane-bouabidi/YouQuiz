package com.wora.quiz.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotBlank
    private LocalDate birthDate;
    @NotBlank
    private String adresse;
}
