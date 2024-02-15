package com.quiz.quiz_app.service;

import com.quiz.quiz_app.dto.UserAnswerDto;
import com.quiz.quiz_app.dto.request.UserAnswerRequestDto;
import com.quiz.quiz_app.entity.QuizAnswer;
import com.quiz.quiz_app.entity.QuizQuestion;
import com.quiz.quiz_app.entity.UserAnswer;
import com.quiz.quiz_app.entity.Users;
import com.quiz.quiz_app.exception.NotFoundException;
import com.quiz.quiz_app.mappers.UserAnswerMapper;
import com.quiz.quiz_app.repo.QuizAnswerRepo;
import com.quiz.quiz_app.repo.QuizQuestionRepo;
import com.quiz.quiz_app.repo.UserAnswerRepo;
import com.quiz.quiz_app.repo.UsersRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserAnswerServiceImplTest {

    @Mock
    private UserAnswerRepo repository;

    @Mock
    private UsersRepo usersRepo;

    @Mock
    private QuizQuestionRepo questionRepo;

    @Mock
    private QuizAnswerRepo answerRepo;

    @Mock
    private UserAnswerMapper mapper;

    @InjectMocks
    private UserAnswerServiceImpl service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        Long userId = 1L;
        List<UserAnswerRequestDto> userAnswerRequestDtoList = new ArrayList<>();

        Users user = new Users();
        user.setId(userId);

        when(usersRepo.getReferenceById(userId)).thenReturn(user);
        when(answerRepo.getReferenceById(anyLong())).thenReturn(new QuizAnswer());
        when(questionRepo.getReferenceById(anyLong())).thenReturn(new QuizQuestion());

        UserAnswerDto userAnswerDto = new UserAnswerDto();
        userAnswerDto.setId(1L);

        when(mapper.toDtos(any())).thenReturn(new ArrayList<>());

        List<UserAnswerDto> result = service.create(userId, userAnswerRequestDtoList);

        assertEquals(0, result.size());
    }

    @Test
    public void testGetAllByUser() {
        Long userId = 1L;

        when(repository.findAllByUsersId(userId)).thenReturn(new ArrayList<>());
        when(mapper.toDtos(any())).thenReturn(new ArrayList<>());

        List<UserAnswerDto> result = service.getAllByUser(userId);

        assertEquals(0, result.size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;

        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setId(id);
        UserAnswerDto userAnswerDto = new UserAnswerDto();
        userAnswerDto.setId(id);

        when(repository.findById(id)).thenReturn(Optional.of(userAnswer));
        when(mapper.toDto(userAnswer)).thenReturn(userAnswerDto);

        UserAnswerDto result = service.getById(id);

        assertEquals(id, result.getId());
    }

    @Test
    public void testGetByIdNotFound() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.getById(id));
    }

    @Test
    public void testDelete() {
        Long id = 1L;

        service.delete(id);

        verify(repository, times(1)).deleteById(id);
    }
}
