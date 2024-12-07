package com.rio.Exam_Portal_Application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rio.Exam_Portal_Application.model.Users;
import com.rio.Exam_Portal_Application.repository.UserRepository;
import com.rio.Exam_Portal_Application.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;
	
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Override
	public void registerUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
	}

}
