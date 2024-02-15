package com.quiz.quiz_app.service;


import com.quiz.quiz_app.dto.QuizQuestionDto;

import java.util.List;

public interface QuizQuestionService {
    QuizQuestionDto create(Long quizId, QuizQuestionDto quizQuestionDto);
    List<QuizQuestionDto> getAllByQuizId(Long quizId);
    QuizQuestionDto getById(Long id);
    QuizQuestionDto update(Long id, QuizQuestionDto quizQuestionDto);
    void delete(Long id);
}
