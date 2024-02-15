package com.quiz.quiz_app.dto;

import com.quiz.quiz_app.dto.base.BaseDto;
import com.quiz.quiz_app.enums.QuizStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizDto extends BaseDto {
    private String title;
    private String description;
    private QuizStatus status;
}
