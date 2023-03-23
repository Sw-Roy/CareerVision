package com.careerVision.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.careerVision.career.entity.AuthRequest;
import com.careerVision.career.entity.User;
import com.careerVision.career.repository.LogInDAOImpl;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private LogInDAOImpl logInDAOImpl;

	@Override
	public UserDetails loadUserByUsername(String contactNo) throws UsernameNotFoundException {
		AuthRequest authRequest = logInDAOImpl.getUserLogin(Integer.parseInt(contactNo));
		return new org.springframework.security.core.userdetails.User(contactNo, authRequest.getPassword(),
				new ArrayList<>());
	}


}
