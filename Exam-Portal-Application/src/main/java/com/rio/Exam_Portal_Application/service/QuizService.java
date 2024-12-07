package com.rio.Exam_Portal_Application.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rio.Exam_Portal_Application.dto.QuestionDto;
import com.rio.Exam_Portal_Application.model.Question;
import com.rio.Exam_Portal_Application.model.ResponseQuiz;

public interface QuizService {
	ResponseEntity<String> createQuiz(String category, int nQues, String title);
	List<QuestionDto> getQuizQuestions(int id);
	float calculateResult(Integer id, List<ResponseQuiz> responsequiz);
}
