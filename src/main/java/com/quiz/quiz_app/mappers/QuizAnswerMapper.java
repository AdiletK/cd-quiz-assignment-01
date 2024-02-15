package com.quiz.quiz_app.mappers;

import com.quiz.quiz_app.dto.QuizAnswerDto;
import com.quiz.quiz_app.entity.QuizAnswer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizAnswerMapper {

    QuizAnswer toEntity(QuizAnswerDto dto);

    QuizAnswerDto toDto(QuizAnswer entity);
}
