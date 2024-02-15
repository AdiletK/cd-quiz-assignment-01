package com.quiz.quiz_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "quiz_answer")
public class QuizAnswer extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuizQuestion question;

    @Column
    private String answer;

    @Column
    private Boolean isCorrect;
}
