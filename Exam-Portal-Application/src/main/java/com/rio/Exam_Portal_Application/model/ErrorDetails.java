package com.rio.Exam_Portal_Application.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorDetails {
	private LocalDateTime dateTime;
	private String details;
	private String message;
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public String getDetails() {
		return details;
	}
	public String getMessage() {
		return message;
	}
}
