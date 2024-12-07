package com.rio.Exam_Portal_Application.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ExamHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int examId;
	private String examName;
	private Long examSubmittedBy; //roll_no
	private LocalDateTime examSubmittedAt;
	private int score;
	private float percentage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Users users;

}
