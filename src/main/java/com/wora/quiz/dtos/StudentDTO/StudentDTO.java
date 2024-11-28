package com.wora.quiz.dtos.StudentDTO;

import com.wora.quiz.dtos.UserDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends UserDTO {
    private int id;
    @NotBlank
    private LocalDate dateInscription;
}
