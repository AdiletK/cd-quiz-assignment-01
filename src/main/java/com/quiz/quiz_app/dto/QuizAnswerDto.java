package com.quiz.quiz_app.dto;

import com.quiz.quiz_app.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizAnswerDto extends BaseDto {
    private Long questionId;
    private String answer;
    private Boolean isCorrect;
}
