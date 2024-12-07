package com.rio.Exam_Portal_Application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class QuestionDto {
	private int id;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String category;

	
}
