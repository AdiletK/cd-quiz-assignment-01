package com.quiz.quiz_app.dto;

import com.quiz.quiz_app.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAnswerDto extends BaseDto {
    private QuizQuestionDto question;

    private QuizAnswerDto answer;
}
