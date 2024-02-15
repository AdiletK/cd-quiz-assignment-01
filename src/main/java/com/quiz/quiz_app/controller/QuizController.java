package com.quiz.quiz_app.controller;

import com.quiz.quiz_app.dto.QuizDto;
import com.quiz.quiz_app.dto.request.QuizRequestDto;
import com.quiz.quiz_app.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @PostMapping
    public QuizDto createQuiz(@RequestBody QuizRequestDto quizDto) {
        return quizService.create(quizDto);
    }

    @GetMapping
    public List<QuizDto> getAllQuizzes() {
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public QuizDto getQuizById(@PathVariable Long id) {
        return quizService.getById(id);
    }

    @PutMapping("/{id}")
    public QuizDto updateQuiz(@PathVariable Long id, @RequestBody QuizDto quizDto) {
        return quizService.update(id, quizDto);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.delete(id);
    }
}
