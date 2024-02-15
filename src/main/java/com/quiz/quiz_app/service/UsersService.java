package com.quiz.quiz_app.service;


import com.quiz.quiz_app.dto.UsersDto;

import java.util.List;

public interface UsersService {
    UsersDto create(UsersDto usersDto);
    List<UsersDto> getAll();
    UsersDto getById(Long id);
    UsersDto update(Long id, UsersDto usersDto);
    void delete(Long id);
}
