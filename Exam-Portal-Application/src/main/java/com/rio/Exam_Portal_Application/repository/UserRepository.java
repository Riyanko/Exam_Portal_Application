package com.rio.Exam_Portal_Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rio.Exam_Portal_Application.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String username);
	
}
