package com.quiz.quiz_app.service;

import com.quiz.quiz_app.dto.QuizDto;
import com.quiz.quiz_app.dto.request.QuizRequestDto;
import com.quiz.quiz_app.entity.Quiz;
import com.quiz.quiz_app.enums.QuizStatus;
import com.quiz.quiz_app.exception.NotFoundException;
import com.quiz.quiz_app.mappers.QuizMapper;
import com.quiz.quiz_app.repo.QuizRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepo repository;
    private final QuizMapper mapper;

    public QuizServiceImpl(QuizRepo repository, QuizMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public QuizDto create(QuizRequestDto quizDto) {
        Quiz quiz = mapper.toEntity(quizDto);
        quiz.setStatus(QuizStatus.ACTIVE);
        Quiz saved = repository.save(quiz);
        return mapper.toDto(saved);
    }

    public List<QuizDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public QuizDto getById(Long id) {
        Quiz quiz = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quiz with id " + id + " not found"));
        return mapper.toDto(quiz);
    }

    public QuizDto update(Long id, QuizDto quizDto) {
        Quiz existingQuiz = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quiz with id " + id + " not found"));

        Quiz updatedQuiz = mapper.toEntity(quizDto);
        updatedQuiz.setId(existingQuiz.getId());
        return mapper.toDto(repository.save(updatedQuiz));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}
