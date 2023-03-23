package com.careerVision.career.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.careerVision.career.model.NewUser;


@Repository
public class UserDAOImpl 
{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public void updateUserDetails(NewUser user) 
	{
		System.out.println("name"+ user.getName()+ "ContactNo"+user.getContactNo()+"password"+ user.getPassword()+"pincode"+ user.getPincode()+"role"+user.getRole());
		
		String query ="Update tbl_user SET user_name=:name,pincode=:pincode,role=:role where contact_no=:contactNo";
		
        SqlParameterSource parameterSource = new MapSqlParameterSource("name", user.getName())
        		.addValue("contactNo", user.getContactNo()).addValue("pincode", user.getPincode()).addValue("role", user.getRole());

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
