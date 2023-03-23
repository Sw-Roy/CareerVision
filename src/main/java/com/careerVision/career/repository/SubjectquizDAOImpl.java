package com.careerVision.career.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.careerVision.career.model.QuizSubject;

@Repository
public class SubjectquizDAOImpl
{
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<QuizSubject> getQuizSubjects(int id) {
		String query = "Select * from tbl_quiz_subject where subject = :id";
	    SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
	    try 
	    {
	        return jdbcTemplate.query(query, parameterSource, new RowMapper<QuizSubject>() {
	            @Override
	            public QuizSubject mapRow(ResultSet rs, int rowNum) throws SQLException
	            {
	            	QuizSubject quizSubject=new QuizSubject();
	            	quizSubject.setSubject(rs.getInt("subject"));
	            	quizSubject.setQuestion(rs.getString("question"));
	            	quizSubject.setOption1(rs.getString("option_1"));
	            	quizSubject.setOption2(rs.getString("option_2"));
	            	quizSubject.setOption3(rs.getString("option_3"));
	            	
	            	return quizSubject;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e) 
	    {
	        return null;
	    }
	}
}
