package com.careerVision.career.repository;

import java.sql.SQLException;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.careerVision.career.entity.AuthRequest;
import com.careerVision.career.model.User;

@Repository
public class LogInDAOImpl 
{
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	public AuthRequest getUserLogin(int contactNo)
	{
		String query = "Select password from tbl_user where contact_no = :contactNo ";
		
	    SqlParameterSource parameterSource = new MapSqlParameterSource("contactNo", contactNo);
	    
	    try 
	    {
	        return jdbcTemplate.queryForObject(query, parameterSource, new RowMapper<AuthRequest>() {
	            @Override
	            public AuthRequest mapRow(ResultSet rs, int rowNum) throws SQLException
	            {
	            	AuthRequest authRequest = new AuthRequest();
	            	authRequest.setPassword(rs.getString("password")); //here password is the "password" column in tbl_user
	            	
	            	return authRequest;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e) 
	    {
	        return null;
	    }
		
	}
}
