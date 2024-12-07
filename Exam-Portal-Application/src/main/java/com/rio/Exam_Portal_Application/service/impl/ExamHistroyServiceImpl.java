package com.rio.Exam_Portal_Application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rio.Exam_Portal_Application.model.ExamHistory;
import com.rio.Exam_Portal_Application.repository.ExamHistroyRepository;
import com.rio.Exam_Portal_Application.service.ExamHistroyService;

@Service
public class ExamHistroyServiceImpl implements ExamHistroyService{
	@Autowired
	private ExamHistroyRepository examHistory;
	
	@Override
	public List<ExamHistory> getResultsOfSpecificExam(String examname) {
		List<ExamHistory> examRecords=examHistory.findByExamName(examname);
		return examRecords;
	}

	@Override
	public List<ExamHistory> getRecordsOfUser(Long roll) {
		List<ExamHistory> userExamRecords=examHistory.findByExamSubmittedBy(roll);

		return userExamRecords;
	}

}
