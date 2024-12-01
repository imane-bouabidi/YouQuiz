package com.wora.quiz.dtos.LevelDTO;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateLevelDTO {
    private String description;
    private Integer pointsMin;
    private Integer pointsMax;
}

