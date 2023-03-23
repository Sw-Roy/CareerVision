package com.careerVision.career.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.careerVision.career.model.User;
import com.careerVision.career.repository.LogInDAOImpl;
import com.careerVision.career.util.JwtUtil;

@RestController
public class LogInController 
{
	@Autowired
	LogInDAOImpl daoImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/user")
	public ResponseEntity<Void> login(@RequestBody User user,HttpServletResponse response)throws Exception{
		
		System.out.println("getting the login"+user);
	    
		if(0 ==user.getContactNo() || null == user.getPassword()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
	    //User savedUser = daoImpl.getUserLogin(authRequest);
//	    
//	    if(null != user && user.getPassword().equals(authRequest.getPassword())) {
//	    	//return new ResponseEntity<>(HttpStatus.OK);
//	    	try {
//	    	authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(user.getContactNo(),user.getPassword()));
//	    	}catch (BadCredentialsException ex) {
//				return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
//			}
//	    	
//	    }
//	    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//	    
//	    String jwt = jwtUtil.generateToken(user.getContactNo());
//		response.addHeader("Authorization", "Bearer " + jwt);
//		return new ResponseEntity<Void>(HttpStatus.OK);
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getContactNo(),user.getPassword()));
		} catch (BadCredentialsException ex) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		String jwt = jwtUtil.generateToken(user.getContactNo());
		response.addHeader("Authorization", "Bearer " + jwt);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
