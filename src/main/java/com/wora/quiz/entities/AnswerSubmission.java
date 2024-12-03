//package com.wora.quiz.entities;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//public class AnswerSubmission {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    private PassageTest passageTest;
//
//    @ManyToOne
//    private Question question;
//
//    @ManyToOne
//    private Answer answer;
//
//    private LocalDateTime submissionTime;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "response", cascade = CascadeType.ALL)
//    private List<AnswerValidation> answerValidation;
//}
//
