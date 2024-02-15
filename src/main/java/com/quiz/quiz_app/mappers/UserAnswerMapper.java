package com.quiz.quiz_app.mappers;

import com.quiz.quiz_app.dto.UserAnswerDto;
import com.quiz.quiz_app.dto.request.UserAnswerRequestDto;
import com.quiz.quiz_app.entity.UserAnswer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAnswerMapper {

    UserAnswer toEntity(UserAnswerRequestDto dto);

    UserAnswerDto toDto(UserAnswer entity);

    List<UserAnswerDto> toDtos(List<UserAnswer> entity);
}
