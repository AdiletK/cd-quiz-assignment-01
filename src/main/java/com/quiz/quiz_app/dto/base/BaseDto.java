package com.quiz.quiz_app.dto.base;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
