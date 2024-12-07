package com.rio.Exam_Portal_Application.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseQuiz {
	private Integer id;
	private String response;
}
