package com.rio.Exam_Portal_Application.service;

import java.util.List;

import com.rio.Exam_Portal_Application.model.Question;

public interface QuestionService {
	List<Question> getAllQuestions();
	List<Question> getByCategory(String category);
	void addNewQuestion(Question question);
	void deleteQuestion(int id);
	Question updateQuestion(Question question);
}
