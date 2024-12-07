package com.rio.Exam_Portal_Application.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rio.Exam_Portal_Application.model.ErrorDetails;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails errorDetails=new ErrorDetails(
			LocalDateTime.now(),ex.getMessage(),request.getDescription(false)
		);
		return ResponseEntity.internalServerError().body(errorDetails);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleCategoryNotFoundException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails errorDetails=new ErrorDetails(	
				LocalDateTime.now(),
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(QuestionNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleQuestionNotFoundException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails error=new ErrorDetails(
				LocalDateTime.now(),
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UsersNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails error=new ErrorDetails(
				LocalDateTime.now(),
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoRecordsFoundException.class)
	public final ResponseEntity<ErrorDetails> handleNoRecordsNotFoundException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails error=new ErrorDetails(
				LocalDateTime.now(),
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
