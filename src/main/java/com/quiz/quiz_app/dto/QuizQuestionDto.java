package com.quiz.quiz_app.dto;

import com.quiz.quiz_app.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuizQuestionDto extends BaseDto {
    private String question;
    private String clarification;
    private List<QuizAnswerDto> answers = new ArrayList<>();
}
