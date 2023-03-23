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

import com.careerVision.career.model.Subject;

@Repository
public class SubDAOImpl
{
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	

	public List<Subject> getSubjects()
	{
		String query =  "Select * from tbl_subject";
	    SqlParameterSource parameterSource = new MapSqlParameterSource();
	    try 
	    {
	        return jdbcTemplate.query(query, parameterSource, new RowMapper<Subject>() {
	        	@Override
	            public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	Subject subject = new Subject();
	            	subject.setSubject(rs.getString("subject"));
	            	subject.setSubject_id(rs.getInt("subject_id"));
	            	
	            	return subject;
	            }
	        });
	    } 
	    catch (EmptyResultDataAccessException e) 
	    {
	        return null;
	    }
	}
}
