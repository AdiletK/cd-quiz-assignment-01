package com.quiz.quiz_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "quiz_question")
public class QuizQuestion extends BaseEntity {

    @Column(nullable = false)
    private String question;

    @Column
    private String clarification;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

}
