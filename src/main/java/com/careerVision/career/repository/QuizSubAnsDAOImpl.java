package com.careerVision.career.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.careerVision.career.model.QuizSubAns;

@Repository
public class QuizSubAnsDAOImpl 
{
	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	

	public void getSubjectAns(QuizSubAns quizans) throws Exception
	{
		System.out.println("subans:"+quizans.getSubOption()+"hobbyans:"+quizans.getHobbyOption());
		
		String query = "Insert into  tbl_save_ans (contact_no,subject_option,hobby_option) VALUES(:contactNo,:subOption,:hobbyOption)";
		
        SqlParameterSource parameterSource = new MapSqlParameterSource("contactNo", quizans.getContactNo()).addValue("subOption", quizans.getSubOption())
        		.addValue("hobbyOption", quizans.getHobbyOption());

        try 
        {
        	jdbcTemplate.update(query, parameterSource);
        } 
        catch (DataAccessException e) 
        {
        	e.printStackTrace();
        	throw new Exception();
        }
	}
}
