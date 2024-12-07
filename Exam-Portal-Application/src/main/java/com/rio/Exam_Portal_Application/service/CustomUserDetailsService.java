package com.rio.Exam_Portal_Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rio.Exam_Portal_Application.exception.UsersNotFoundException;
import com.rio.Exam_Portal_Application.model.Users;
import com.rio.Exam_Portal_Application.repository.UserRepository;
import com.rio.Exam_Portal_Application.securityConfig.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=userRepo.findByEmail(username);
		if(user==null) {
			throw new UsersNotFoundException("User does not exixts!!");
		}
		return new UserPrincipal(user);
	}

}
