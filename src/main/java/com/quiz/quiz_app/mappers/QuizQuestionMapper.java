package com.quiz.quiz_app.mappers;

import com.quiz.quiz_app.dto.QuizQuestionDto;
import com.quiz.quiz_app.entity.QuizQuestion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuizQuestionMapper {

    QuizQuestion toEntity(QuizQuestionDto dto);

    QuizQuestionDto toDto(QuizQuestion entity);
    List<QuizQuestionDto> toDtos(List<QuizQuestion> entity);
}
