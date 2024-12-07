package com.rio.Exam_Portal_Application.service;

import java.util.List;

import com.rio.Exam_Portal_Application.model.ExamHistory;

public interface ExamHistroyService {

	List<ExamHistory> getResultsOfSpecificExam(String examname);

	List<ExamHistory> getRecordsOfUser(Long id);

}
