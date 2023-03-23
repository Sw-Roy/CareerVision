package com.careerVision.career.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerVision.career.model.Hobby;
import com.careerVision.career.repository.HobbyDAOImpl;

@RestController
public class HobbyController
{
	@Autowired
	HobbyDAOImpl hobbydaoImpl;
	
    @GetMapping(value = "/hobby")
    public List<Hobby> getHobbys(){
		System.out.println("getting the hobby");
        return hobbydaoImpl.getHobbys();
    }
}
