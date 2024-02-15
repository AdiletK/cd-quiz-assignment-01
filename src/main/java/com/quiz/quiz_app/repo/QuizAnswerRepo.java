package com.quiz.quiz_app.repo;

import com.quiz.quiz_app.entity.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAnswerRepo extends JpaRepository<QuizAnswer, Long> {
    List<QuizAnswer> findAllByQuestionId(Long questionId);
}
