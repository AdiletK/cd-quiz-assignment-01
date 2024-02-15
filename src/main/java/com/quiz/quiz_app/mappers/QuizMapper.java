package com.quiz.quiz_app.mappers;

import com.quiz.quiz_app.dto.QuizDto;
import com.quiz.quiz_app.dto.request.QuizRequestDto;
import com.quiz.quiz_app.entity.Quiz;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapper {

    Quiz toEntity(QuizRequestDto dto);

    Quiz toEntity(QuizDto dto);

    QuizDto toDto(Quiz entity);
}
