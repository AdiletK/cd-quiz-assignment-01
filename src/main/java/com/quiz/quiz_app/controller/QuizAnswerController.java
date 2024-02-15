package com.quiz.quiz_app.controller;

import com.quiz.quiz_app.dto.QuizAnswerDto;
import com.quiz.quiz_app.service.QuizAnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz-answers")
public class QuizAnswerController {

    private final QuizAnswerService quizAnswerService;

    public QuizAnswerController(QuizAnswerService quizAnswerService) {
        this.quizAnswerService = quizAnswerService;
    }

    @PostMapping("/question/{question_id}")
    public List<QuizAnswerDto> createQuizAnswer(@PathVariable(name = "question_id") Long questionId,
                                                @RequestBody List<QuizAnswerDto> quizAnswerDtos) {
        return quizAnswerService.create(questionId, quizAnswerDtos);
    }

    @GetMapping
    public List<QuizAnswerDto> getAllQuizAnswers() {
        return quizAnswerService.getAll();
    }

    @GetMapping("/{id}")
    public QuizAnswerDto getQuizAnswerById(@PathVariable Long id) {
        return quizAnswerService.getById(id);
    }

    @PutMapping("/{id}")
    public QuizAnswerDto updateQuizAnswer(@PathVariable Long id, @RequestBody QuizAnswerDto quizAnswerDto) {
        return quizAnswerService.update(id, quizAnswerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteQuizAnswer(@PathVariable Long id) {
        quizAnswerService.delete(id);
    }
}

