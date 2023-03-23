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

import com.careerVision.career.model.Hobby;

@Repository
public class HobbyDAOImpl 
{
	@Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Hobby> getHobbys()
	{
		String query =  "Select * from tbl_hobby";
	    SqlParameterSource parameterSource = new MapSqlParameterSource();
	    try 
	    {
	        return (List<Hobby>) jdbcTemplate.query(query, parameterSource, new RowMapper<Hobby>() {
	        	@Override
	            public Hobby mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	Hobby hobby = new Hobby();
	            	hobby.setHobby(rs.getString("hobby"));
	            	hobby.setHobby_id(rs.getInt("hobby_id"));
	            	
	            	return hobby;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e) 
	    {
	        return null;
	    }
	}
}
