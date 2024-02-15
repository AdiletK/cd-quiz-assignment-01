package com.quiz.quiz_app.dto.request;

import lombok.Data;

@Data
public class UserAnswerRequestDto {
    private Long questionId;
    private Long answerId;
    private Long userId;
}
