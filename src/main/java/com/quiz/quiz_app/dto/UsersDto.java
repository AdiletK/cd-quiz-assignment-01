package com.quiz.quiz_app.dto;

import com.quiz.quiz_app.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto extends BaseDto {
    private String firstName;
    private String lastName;
}
