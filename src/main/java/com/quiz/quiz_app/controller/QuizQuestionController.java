package com.quiz.quiz_app.controller;

import com.quiz.quiz_app.dto.QuizQuestionDto;
import com.quiz.quiz_app.service.QuizQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz-questions")
public class QuizQuestionController {

    private final QuizQuestionService quizQuestionService;

    public QuizQuestionController(QuizQuestionService quizQuestionService) {
        this.quizQuestionService = quizQuestionService;
    }

    @PostMapping("/quiz/{quiz_id}")
    public QuizQuestionDto create(@PathVariable(name = "quiz_id") Long quizId, @RequestBody QuizQuestionDto quizQuestionDto) {
        return quizQuestionService.create(quizId,quizQuestionDto);
    }

    @GetMapping("quiz/{quiz_id}")
    public List<QuizQuestionDto> getAll(@PathVariable(name = "quiz_id") Long quizId) {
        return quizQuestionService.getAllByQuizId(quizId);
    }

    @GetMapping("/{id}")
    public QuizQuestionDto getById(@PathVariable Long id) {
        return quizQuestionService.getById(id);
    }

    @PutMapping("/{id}")
    public QuizQuestionDto update(@PathVariable Long id, @RequestBody QuizQuestionDto quizQuestionDto) {
        return quizQuestionService.update(id, quizQuestionDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        quizQuestionService.delete(id);
    }
}

