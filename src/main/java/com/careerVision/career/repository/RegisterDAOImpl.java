package com.careerVision.career.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.careerVision.career.model.NewUser;

@Repository
public class RegisterDAOImpl
{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public void saveNewUserPersonalDetails(NewUser newuser) throws Exception
	{
		System.out.println("name"+ newuser.getName()+ "ContactNo"+newuser.getContactNo()+"password"+ newuser.getPassword()+"pincode"+ newuser.getPincode()+"role"+newuser.getRole());
		
		String query = "Insert into tbl_user(user_name, contact_no,password,pincode,role) VALUES(:name,:contactNo,:password,:pincode,:role)";
		
        SqlParameterSource parameterSource = new MapSqlParameterSource("name", newuser.getName())
        		.addValue("contactNo", newuser.getContactNo()).addValue("password",newuser.getPassword()).addValue("pincode", newuser.getPincode())
        		.addValue("role", newuser.getRole());

        try 
        {
        	jdbcTemplate.update(query, parameterSource);
        } 
        catch (DataAccessException e) 
        {
        	e.printStackTrace();
        }	
	}
	
	public void saveAditionalDetails(NewUser newuser) throws Exception  
	{
		System.out.println("grade"+newuser.getGrade()+"subjectId"+newuser.getSubjectId()+"hobby"+newuser.getHobbyId());
		
		String query = "Insert into tbl_user_educational_details (contact_no,grade,subject,hobby) VALUES(:contactNo,:grade,:subject,:hobby)";
		
        SqlParameterSource parameterSource = new MapSqlParameterSource("contactNo", newuser.getContactNo()).addValue("grade", newuser.getGrade())
        		.addValue("subject", newuser.getSubjectId()).addValue("hobby", newuser.getHobbyId());

        try 
        {
        	jdbcTemplate.update(query, parameterSource);
        } 
        catch (DataAccessException e) 
        {
        	  e.printStackTrace();
        }
	}
}
