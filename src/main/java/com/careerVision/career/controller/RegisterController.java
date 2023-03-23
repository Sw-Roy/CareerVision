package com.careerVision.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.careerVision.career.model.NewUser;
import com.careerVision.career.repository.RegisterDAOImpl;

@RestController
public class RegisterController 
{
	@Autowired
	RegisterDAOImpl registerdaoImpl;
	
	@PostMapping(value = "/save/newuser")
    public ResponseEntity<Void> saveUser(@RequestBody NewUser newuser) {
		System.out.println("Save user details: user"+newuser);
		try 
		{
			registerdaoImpl.saveNewUserPersonalDetails(newuser);
			registerdaoImpl.saveAditionalDetails(newuser);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) 
		{
        	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
