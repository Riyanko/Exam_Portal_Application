package com.rio.Exam_Portal_Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rio.Exam_Portal_Application.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	List<Question> findByCategory(String category);
	
	@Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :nQues",nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category, int nQues);
}