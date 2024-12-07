package com.rio.Exam_Portal_Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rio.Exam_Portal_Application.dto.QuestionDto;
import com.rio.Exam_Portal_Application.model.Question;
import com.rio.Exam_Portal_Application.model.ResponseQuiz;
import com.rio.Exam_Portal_Application.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	
	@PostMapping("/create")
	public ResponseEntity<String> CreateQuiz(@RequestParam String category,@RequestParam int nQues,@RequestParam String title){
		return quizService.createQuiz(category,nQues,title);
	}
	
	@GetMapping("/getQuiz/{id}")
	public List<QuestionDto> getQuizQuestions(@PathVariable int id){
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public String SubmitQuiz(@PathVariable Integer id,@RequestBody List<ResponseQuiz> responsequiz ) {
		float result=quizService.calculateResult(id,responsequiz);
		return result+"% Scored";
	}
}
