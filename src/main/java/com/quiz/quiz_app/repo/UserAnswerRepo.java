package com.quiz.quiz_app.repo;

import com.quiz.quiz_app.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepo extends JpaRepository<UserAnswer, Long> {
    List<UserAnswer> findAllByUsersId(Long userId);
}
