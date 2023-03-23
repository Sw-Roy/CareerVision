package com.careerVision.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.careerVision.career.model.NewUser;
import com.careerVision.career.repository.DashboardDAOImpl;

@RestController
public class DashboardController 
{
	@Autowired
	DashboardDAOImpl dashboarddaoImpl;
	@GetMapping(value = "/getdata/{contactNo}")
	
	public NewUser getUserDetails(@PathVariable int contactNo ) 
	{
		System.out.println("getting the user details of contact_no:"+ contactNo);
		
		NewUser userBasicDetails= dashboarddaoImpl.getUserDetails(contactNo);
		NewUser userAdditionalDetails= dashboarddaoImpl.getUserAdditinalDetails(contactNo);
		
		userBasicDetails.setGrade(userAdditionalDetails.getGrade());
		userBasicDetails.setSubjectId(userAdditionalDetails.getSubjectId());
		
		return userBasicDetails;
	}
}
