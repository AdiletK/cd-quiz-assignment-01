package com.quiz.quiz_app.service;

import com.quiz.quiz_app.dto.UsersDto;
import com.quiz.quiz_app.entity.Users;
import com.quiz.quiz_app.exception.NotFoundException;
import com.quiz.quiz_app.mappers.UsersMapper;
import com.quiz.quiz_app.repo.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepo repository;
    private final UsersMapper mapper;

    public UsersServiceImpl(UsersRepo repository, UsersMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public UsersDto create(UsersDto usersDto) {
        Users users = mapper.toEntity(usersDto);
        return mapper.toDto(repository.save(users));
    }

    @Override
    public List<UsersDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
    }

    @Override
    public UsersDto update(Long id, UsersDto usersDto) {
        Users users = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
        users.setId(id);
        return mapper.toDto(repository.save(users));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
