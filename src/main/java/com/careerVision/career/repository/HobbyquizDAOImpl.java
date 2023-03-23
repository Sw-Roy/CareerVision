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

import com.careerVision.career.model.QuizHobby;

@Repository
public class HobbyquizDAOImpl 
{
	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<QuizHobby> getQuizHobbys(int id) {
		String query = "Select * from tbl_quiz_hobby where hobby = :id";
	    SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
	    try 
	    {
	        return jdbcTemplate.query(query, parameterSource, new RowMapper<QuizHobby>() {
	            @Override
	            public QuizHobby mapRow(ResultSet rs, int rowNum) throws SQLException
	            {
	            	QuizHobby quizHobby=new QuizHobby();
	            	quizHobby.setHobby(rs.getInt("hobby"));
	            	quizHobby.setQuestion(rs.getString("question"));
	            	quizHobby.setOption1(rs.getString("option_1"));
	            	quizHobby.setOption2(rs.getString("option_2"));
	            	quizHobby.setOption3(rs.getString("option_3"));
	            	
	            	return quizHobby;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e) 
	    {
	        return null;
	    }
	}
}
