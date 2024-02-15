package com.quiz.quiz_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_answer")
public class UserAnswer extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuizQuestion question;

    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    private QuizAnswer answer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

}
