package com.wora.quiz.dtos.FormateurDTO;

import com.wora.quiz.dtos.UserDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormateurDTO extends UserDTO {
    private int id;
    @NotBlank
    private String specialite;
}
