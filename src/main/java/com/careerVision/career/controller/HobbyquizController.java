package com.careerVision.career.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.careerVision.career.model.QuizHobby;
import com.careerVision.career.repository.HobbyquizDAOImpl;

@RestController
public class HobbyquizController
{

	@Autowired
	HobbyquizDAOImpl hobbyQuizdaoImpl;
	
    @GetMapping(value = "/quizHobby/{id}")
    public List<QuizHobby> getQuizHobbys(@PathVariable int id)
    {
    	System.out.println("getting the quizHobby of hobby:"+id);
    	return hobbyQuizdaoImpl.getQuizHobbys(id);
    }
}
