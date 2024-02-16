package com.quiz.quiz_app.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
