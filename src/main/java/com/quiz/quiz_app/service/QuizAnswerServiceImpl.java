package com.quiz.quiz_app.service;

import com.quiz.quiz_app.dto.QuizAnswerDto;
import com.quiz.quiz_app.entity.QuizAnswer;
import com.quiz.quiz_app.entity.QuizQuestion;
import com.quiz.quiz_app.exception.NotFoundException;
import com.quiz.quiz_app.mappers.QuizAnswerMapper;
import com.quiz.quiz_app.repo.QuizAnswerRepo;
import com.quiz.quiz_app.repo.QuizQuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizAnswerServiceImpl implements QuizAnswerService {
    private final QuizAnswerRepo repository;
    private final QuizAnswerMapper mapper;
    private final QuizQuestionRepo quizQuestionRepo;

    @Override
    public QuizAnswerDto create(QuizAnswerDto quizAnswerDto) {
        QuizAnswer quizAnswer = mapper.toEntity(quizAnswerDto);
        return mapper.toDto(repository.save(quizAnswer));

    }

    @Override
    public List<QuizAnswerDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public QuizAnswerDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("Quiz answer with id " + id + " not found"));
    }

    @Override
    public QuizAnswerDto update(Long id, QuizAnswerDto quizAnswerDto) {
        QuizAnswer answer = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Quiz answer with id " + id + " not found"));
        answer.setId(id);
        return mapper.toDto(repository.save(answer));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<QuizAnswerDto> getAllByQuestionId(Long questionId) {
        return repository.findAllByQuestionId(questionId)
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuizAnswerDto> create(Long questionId, List<QuizAnswerDto> quizAnswerDtos) {
        QuizQuestion question = quizQuestionRepo.getReferenceById(questionId);

        List<QuizAnswer> answers = quizAnswerDtos.stream()
                .map(mapper::toEntity)
                .peek(el -> el.setQuestion(question))
                .collect(Collectors.toList());
        return repository.saveAll(answers)
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
