package com.quiz.quiz_app.service;


import com.quiz.quiz_app.dto.UserAnswerDto;
import com.quiz.quiz_app.dto.request.UserAnswerRequestDto;

import java.util.List;

public interface UserAnswerService {
    List<UserAnswerDto> create(Long userId, List<UserAnswerRequestDto> userAnswerRequestDto);
    List<UserAnswerDto> getAllByUser(Long userId);
    UserAnswerDto getById(Long id);
    UserAnswerDto update(Long id, UserAnswerRequestDto userAnswerRequestDto);
    void delete(Long id);
}

