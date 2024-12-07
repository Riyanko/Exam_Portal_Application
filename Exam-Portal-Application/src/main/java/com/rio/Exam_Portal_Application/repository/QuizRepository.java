package com.rio.Exam_Portal_Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rio.Exam_Portal_Application.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{
	
}
