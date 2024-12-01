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
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String description;
    private Integer pointsMin;
    private Integer pointsMax;

    @OneToMany(mappedBy = "level")
    private List<Question> questions;
}

