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
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDTO extends UserDTO {
    @NotBlank
    private LocalDate dateInscription;
}
