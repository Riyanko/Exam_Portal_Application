package com.rio.Exam_Portal_Application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rio.Exam_Portal_Application.model.ExamHistory;

@Repository
public interface ExamHistroyRepository extends JpaRepository<ExamHistory, Long> {
	public List<ExamHistory> findByExamName(String examname);
	
	public List<ExamHistory> findByExamSubmittedBy(Long rollnumber);
}
