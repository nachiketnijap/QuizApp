package com.nachiket.quiz.Repository;

import com.nachiket.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository  extends JpaRepository<Quiz,Integer> {
}
