package com.quiz.quiz_app.service;


import com.quiz.quiz_app.dto.QuizAnswerDto;

import java.util.List;

public interface QuizAnswerService {
    QuizAnswerDto create(QuizAnswerDto quizAnswerDto);
    List<QuizAnswerDto> getAll();
    QuizAnswerDto getById(Long id);
    QuizAnswerDto update(Long id, QuizAnswerDto quizAnswerDto);
    void delete(Long id);

    List<QuizAnswerDto> getAllByQuestionId(Long questionId);

    List<QuizAnswerDto> create(Long questionId, List<QuizAnswerDto> quizAnswerDtos);
}
