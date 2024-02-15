package com.quiz.quiz_app.service;

import com.quiz.quiz_app.dto.UserAnswerDto;
import com.quiz.quiz_app.dto.request.UserAnswerRequestDto;
import com.quiz.quiz_app.entity.UserAnswer;
import com.quiz.quiz_app.entity.Users;
import com.quiz.quiz_app.exception.NotFoundException;
import com.quiz.quiz_app.mappers.UserAnswerMapper;
import com.quiz.quiz_app.repo.QuizAnswerRepo;
import com.quiz.quiz_app.repo.QuizQuestionRepo;
import com.quiz.quiz_app.repo.UserAnswerRepo;
import com.quiz.quiz_app.repo.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {
    private final UserAnswerRepo repository;
    private final UserAnswerMapper mapper;

    private final UsersRepo usersRepo;
    private final QuizQuestionRepo questionRepo;
    private final QuizAnswerRepo answerRepo;


    @Override
    public List<UserAnswerDto> create(Long userId, List<UserAnswerRequestDto> userAnswerRequestDto) {
        Users user = usersRepo.getReferenceById(userId);
        List<UserAnswer> userAnswers = userAnswerRequestDto.stream().map(el -> UserAnswer.builder()
                .users(user)
                .answer(answerRepo.getReferenceById(el.getAnswerId()))
                .question(questionRepo.getReferenceById(el.getQuestionId()))
                .build()).collect(Collectors.toList());
        return mapper.toDtos(repository.saveAll(userAnswers));
    }

    @Override
    public List<UserAnswerDto> getAllByUser(Long userId) {
        return mapper.toDtos(repository.findAllByUsersId(userId));
    }

    @Override
    public UserAnswerDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("User answer with id " + id + " not found"));
    }

    @Override
    public UserAnswerDto update(Long id, UserAnswerRequestDto userAnswerRequestDto) {
        UserAnswer userAnswer = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User answer with id " + id + " not found"));
        userAnswer.setId(id);
        return mapper.toDto(repository.save(userAnswer));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
