package com.quiz.quiz_app.service;

import com.quiz.quiz_app.dto.QuizQuestionDto;
import com.quiz.quiz_app.entity.Quiz;
import com.quiz.quiz_app.entity.QuizQuestion;
import com.quiz.quiz_app.exception.NotFoundException;
import com.quiz.quiz_app.mappers.QuizQuestionMapper;
import com.quiz.quiz_app.repo.QuizQuestionRepo;
import com.quiz.quiz_app.repo.QuizRepo;
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

public class QuizQuestionServiceImplTest {
    @Mock
    private QuizQuestionRepo repository;
    @Mock
    private QuizRepo quizRepo;
    @Mock
    private QuizAnswerService quizAnswerService;
    @Mock
    private QuizQuestionMapper mapper;
    @InjectMocks
    private QuizQuestionServiceImpl service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        QuizQuestionDto quizQuestionDto = getQuestionDto(1L, "Test question");

        QuizQuestion quizQuestion = getQuizQuestion(1L, "Test question");

        when(mapper.toEntity(quizQuestionDto)).thenReturn(quizQuestion);
        when(mapper.toDto(quizQuestion)).thenReturn(quizQuestionDto);
        when(quizRepo.getReferenceById(1L)).thenReturn(new Quiz());
        when(repository.save(quizQuestion)).thenReturn(quizQuestion);

        QuizQuestionDto result = service.create(1L, quizQuestionDto);

        assertEquals(quizQuestionDto.getId(), result.getId());
        assertEquals(quizQuestionDto.getQuestion(), result.getQuestion());
    }


    @Test
    public void testGetAllByQuizId() {
        Long quizId = 1L;

        List<QuizQuestion> quizQuestions = getQuizQuestions();

        List<QuizQuestionDto> quizQuestionsDto = getQuizQuestionDtos();

        when(repository.findAllByQuizId(quizId)).thenReturn(quizQuestions);
        when(quizAnswerService.getAllByQuestionId(anyLong())).thenReturn(new ArrayList<>());
        when(mapper.toDtos(quizQuestions)).thenReturn(quizQuestionsDto);


        List<QuizQuestionDto> result = service.getAllByQuizId(quizId);

        assertEquals(quizQuestions.size(), result.size());
        assertEquals(quizQuestions.get(0).getQuestion(), result.get(0).getQuestion());
        assertEquals(quizQuestions.get(1).getQuestion(), result.get(1).getQuestion());
    }


    @Test
    public void testGetById() {
        Long id = 1L;
        QuizQuestionDto quizQuestionDto = getQuestionDto(1L, "Test question");

        QuizQuestion quizQuestion = getQuizQuestion(id, "Test question");

        when(repository.findById(id)).thenReturn(Optional.of(quizQuestion));
        when(mapper.toDto(quizQuestion)).thenReturn(quizQuestionDto);

        QuizQuestionDto result = service.getById(id);

        assertEquals(id, result.getId());
        assertEquals(quizQuestion.getQuestion(), result.getQuestion());
    }


    @Test
    public void testGetByIdNotFound() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.getById(id));
    }

    @Test
    public void testUpdate() {
        Long id = 1L;

        QuizQuestionDto quizQuestionDto = getQuestionDto(id, "Updated question");

        QuizQuestion quizQuestion = getQuizQuestion(id, "Test question");

        when(repository.findById(id)).thenReturn(Optional.of(quizQuestion));
        when(repository.save(quizQuestion)).thenReturn(quizQuestion);
        when(mapper.toDto(quizQuestion)).thenReturn(quizQuestionDto);


        QuizQuestionDto result = service.update(id, quizQuestionDto);

        assertEquals(id, result.getId());
        assertEquals(quizQuestionDto.getQuestion(), result.getQuestion());
    }

    @Test
    public void testUpdateNotFound() {
        Long id = 1L;

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.update(id, new QuizQuestionDto()));
    }

    @Test
    public void testDelete() {
        Long id = 1L;

        service.delete(id);

        verify(repository, times(1)).deleteById(id);
    }

    private QuizQuestion getQuizQuestion(long id, String Test_question) {
        QuizQuestion quizQuestion = new QuizQuestion();
        quizQuestion.setId(id);
        quizQuestion.setQuestion(Test_question);
        return quizQuestion;
    }

    private QuizQuestionDto getQuestionDto(long id, String Test_question) {
        QuizQuestionDto quizQuestionDto = new QuizQuestionDto();
        quizQuestionDto.setId(id);
        quizQuestionDto.setQuestion(Test_question);
        return quizQuestionDto;
    }

    private List<QuizQuestionDto> getQuizQuestionDtos() {
        QuizQuestionDto quizQuestionDto = getQuestionDto(1L, "Test question 1");

        QuizQuestionDto quizQuestionDto2 = getQuestionDto(2L, "Test question 2");

        List<QuizQuestionDto> quizQuestionsDto = new ArrayList<>();
        quizQuestionsDto.add(quizQuestionDto);
        quizQuestionsDto.add(quizQuestionDto2);
        return quizQuestionsDto;
    }

    private List<QuizQuestion> getQuizQuestions() {
        QuizQuestion quizQuestion1 = getQuizQuestion(1L, "Test question 1");

        QuizQuestion quizQuestion2 = getQuizQuestion(2L, "Test question 2");

        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(quizQuestion1);
        quizQuestions.add(quizQuestion2);
        return quizQuestions;
    }
}
