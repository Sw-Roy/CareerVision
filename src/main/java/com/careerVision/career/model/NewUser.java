package com.careerVision.career.model;

import lombok.Data;
@Data
public class NewUser 
{
	Long id;
	String name;
	String contactNo;
	String password;
	int pincode;
	String role;
	int subjectId;
	int hobbyId;
	String grade;
}
