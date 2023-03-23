package com.careerVision.career.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.careerVision.career.model.QuizSubject;
import com.careerVision.career.repository.SubjectquizDAOImpl;

@RestController
public class SubjectquizController 
{	
	@Autowired
	SubjectquizDAOImpl subQuizdaoImpl;
	
    @GetMapping(value = "/quizSubject/{id}")
    public List<QuizSubject> getQuizSubjects(@PathVariable int id)
    {
    	System.out.println("getting the quizSubject of subject:"+id);
    	return subQuizdaoImpl.getQuizSubjects(id);
    }
}
