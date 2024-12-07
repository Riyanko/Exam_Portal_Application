package com.rio.Exam_Portal_Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rio.Exam_Portal_Application.model.Users;
import com.rio.Exam_Portal_Application.service.UserService;

@RestController
public class UsersController {
	@Autowired
	UserService userService;
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Users user) {
		userService.registerUser(user);
		return ResponseEntity.ok("Registration Successful!!");
	}
	

}
