package com.rio.Exam_Portal_Application.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Column(name="username")
	private String email;
	private String username;
	private String password;
	private Long rollNumber;
	private Long contactNumber;
	
	@OneToMany(mappedBy = "users")
	//@JoinColumn(name="user_id", referencedColumnName = "id")
	@JsonIgnore
	private List<ExamHistory> examHistory;
	
}
	