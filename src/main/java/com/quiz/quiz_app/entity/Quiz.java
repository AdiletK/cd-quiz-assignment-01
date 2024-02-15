package com.quiz.quiz_app.entity;

import com.quiz.quiz_app.enums.QuizStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "quiz")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quiz extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private QuizStatus status;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizQuestion> questions;

}
