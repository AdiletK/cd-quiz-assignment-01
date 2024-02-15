package com.quiz.quiz_app.controller;

import com.quiz.quiz_app.dto.UsersDto;
import com.quiz.quiz_app.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public UsersDto create(@RequestBody UsersDto usersDto) {
        return usersService.create(usersDto);
    }

    @GetMapping
    public List<UsersDto> getAll() {
        return usersService.getAll();
    }

    @GetMapping("/{id}")
    public UsersDto getById(@PathVariable Long id) {
        return usersService.getById(id);
    }

    @PutMapping("/{id}")
    public UsersDto update(@PathVariable Long id, @RequestBody UsersDto usersDto) {
        return usersService.update(id, usersDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usersService.delete(id);
    }
}
