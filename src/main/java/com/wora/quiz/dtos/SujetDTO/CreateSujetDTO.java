package com.wora.quiz.dtos.SujetDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateSujetDTO {
    private String intitule;
    private Long parentId;
}

