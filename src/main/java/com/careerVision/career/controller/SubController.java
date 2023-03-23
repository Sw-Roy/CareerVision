package com.careerVision.career.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerVision.career.model.Subject;
import com.careerVision.career.repository.SubDAOImpl;

@RestController
public class SubController 
{	    
	@Autowired
	SubDAOImpl subdaoImpl;
	
    @GetMapping(value = "/subject")
    public List<Subject> getSubjects(){
		System.out.println("getting the subject");
        return subdaoImpl.getSubjects();
    }
}
