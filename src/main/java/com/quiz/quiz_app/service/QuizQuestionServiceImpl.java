package com.quiz.quiz_app.service;

import com.quiz.quiz_app.dto.QuizQuestionDto;
import com.quiz.quiz_app.entity.QuizQuestion;
import com.quiz.quiz_app.exception.NotFoundException;
import com.quiz.quiz_app.mappers.QuizQuestionMapper;
import com.quiz.quiz_app.repo.QuizQuestionRepo;
import com.quiz.quiz_app.repo.QuizRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizQuestionServiceImpl implements QuizQuestionService {
    private final QuizQuestionRepo repository;
    private final QuizQuestionMapper mapper;
    private final QuizRepo quizRepo;
    private final QuizAnswerService quizAnswerService;


    @Override
    public QuizQuestionDto create(Long quizId, QuizQuestionDto quizQuestionDto) {
        QuizQuestion quizQuestion = mapper.toEntity(quizQuestionDto);
        quizQuestion.setQuiz(quizRepo.getReferenceById(quizId));
        return mapper.toDto(repository.save(quizQuestion));
    }

    @Override
    public List<QuizQuestionDto> getAllByQuizId(Long quizId) {
        List<QuizQuestion> questions = repository.findAllByQuizId(quizId);
        return mapper.toDtos(questions).stream()
                .peek(el -> el.setAnswers(quizAnswerService.getAllByQuestionId(el.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public QuizQuestionDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("Quiz question with id " + id + " not found"));
    }

    @Override
    public QuizQuestionDto update(Long id, QuizQuestionDto quizQuestionDto) {
        QuizQuestion quizQuestion = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quiz question with id " + id + " not found"));
        quizQuestion.setId(id);
        return mapper.toDto(repository.save(quizQuestion));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
