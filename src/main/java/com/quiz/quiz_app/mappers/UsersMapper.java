package com.quiz.quiz_app.mappers;

import com.quiz.quiz_app.dto.UsersDto;
import com.quiz.quiz_app.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    Users toEntity(UsersDto dto);

    UsersDto toDto(Users entity);
}
