package com.rio.Exam_Portal_Application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class QuestionNotFoundException extends RuntimeException{
	public QuestionNotFoundException(String message){
		super(message);
	}
}
