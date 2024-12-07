package com.rio.Exam_Portal_Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rio.Exam_Portal_Application.exception.NoRecordsFoundException;
import com.rio.Exam_Portal_Application.model.ExamHistory;
import com.rio.Exam_Portal_Application.model.Users;
import com.rio.Exam_Portal_Application.repository.UserRepository;
import com.rio.Exam_Portal_Application.service.ExamHistroyService;

@RestController
public class ExamHistoryController {
	@Autowired
	private ExamHistroyService examservice;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/results/{examname}")
	public ResponseEntity<List<ExamHistory>> GetResultsByExamName(@PathVariable String examname){
		List<ExamHistory> result=examservice.getResultsOfSpecificExam(examname);
		if(result==null) {
			throw new NoRecordsFoundException("No Records found of "+examname);
		}
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/examrecords")
	public ResponseEntity<List<ExamHistory>> GetRecordsOfUser(Authentication authentication){
		
		Users user=userRepository.findByEmail(authentication.getName());
		
		List<ExamHistory> records=examservice.getRecordsOfUser(user.getRollNumber());
		if(records==null) {
			throw new NoRecordsFoundException("No Exam Records found");
		}
		return ResponseEntity.ok(records);
	}
	
	
	
	

}
