package com.careerVision.career.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.careerVision.career.model.NewUser;

@Repository
public class DashboardDAOImpl 
{
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	 
	public NewUser getUserDetails(int contactNo) {
		
		String query = "Select * from tbl_user where contact_no = :id";
		
	    SqlParameterSource parameterSource = new MapSqlParameterSource("id",contactNo);
	    
	    try {
	        return jdbcTemplate.queryForObject(query, parameterSource, new RowMapper<NewUser>() {
	            @Override
	            public NewUser mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	NewUser user = new NewUser();
	            	user.setName(rs.getString("user_name"));
	            	user.setContactNo(rs.getString("contact_no"));
	            	user.setPassword(rs.getString("password")); //here password is the "password" column in tbl_user
	            	user.setPincode(rs.getInt("pincode"));
	            	user.setRole(rs.getString("role"));
	            	return user;
	            }
	        });
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	}
	
	public NewUser getUserAdditinalDetails(int contactNo) 
	{	
		String query = "Select * from tbl_user_educational_details where contact_no = :id";
	    SqlParameterSource parameterSource = new MapSqlParameterSource("id",contactNo);
	    
	    try 
	    {
	        return jdbcTemplate.queryForObject(query, parameterSource, new RowMapper<NewUser>()
	        {
	            @Override
	            public NewUser mapRow(ResultSet rs, int rowNum) throws SQLException 
	            {
	            	NewUser user = new NewUser();
	            	user.setGrade(rs.getString("grade"));
	            	user.setSubjectId(rs.getInt("subject"));
	            	user.setHobbyId(rs.getInt("hobby")); 
	            	
	            	return user;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e)
	    {
	        return null;
	    }
	}
}
