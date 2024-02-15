package com.quiz.quiz_app.service;


import com.quiz.quiz_app.dto.QuizDto;
import com.quiz.quiz_app.dto.request.QuizRequestDto;

import java.util.List;

public interface QuizService {
    QuizDto create(QuizRequestDto quizDto);

    List<QuizDto> getAll();

    QuizDto getById(Long id);

    QuizDto update(Long id, QuizDto quizDto);

    void delete(Long id);
}
