package com.quiz.quiz_app.controller;

import com.quiz.quiz_app.dto.UserAnswerDto;
import com.quiz.quiz_app.dto.request.UserAnswerRequestDto;
import com.quiz.quiz_app.service.UserAnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-answers")
public class UserAnswerController {

    private final UserAnswerService userAnswerService;

    public UserAnswerController(UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }

    @PostMapping("/user/{user_id}")
    public List<UserAnswerDto> create(@PathVariable("user_id")Long userId, @RequestBody List<UserAnswerRequestDto> userAnswerRequestDto) {
        return userAnswerService.create(userId, userAnswerRequestDto);
    }

    @GetMapping("/user/{user_id}")
    public List<UserAnswerDto> getAll(@PathVariable(name = "user_id") Long userId) {
        return userAnswerService.getAllByUser(userId);
    }

    @GetMapping("/{id}")
    public UserAnswerDto getById(@PathVariable Long id) {
        return userAnswerService.getById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userAnswerService.delete(id);
    }
}

