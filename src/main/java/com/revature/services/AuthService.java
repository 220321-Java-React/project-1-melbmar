package com.revature.services;


import com.revature.daos.RolesDAO;
import com.revature.daos.UsersDAO;
import com.revature.models.Roles;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.Users;

public class AuthService {

	 // Typically, you'll want to validate username/password here in the service...
	 UsersDAO uDAO = new UsersDAO();

	 // by calling some DAO method that gets employees where username = ? and password =?
	 public Users login(String ers_username, String ers_password) {
		
		// we would call the DAO method here, and use its result in the if/else below
		// the DAO method would return whatever gets found
		
		
		// this is hardcoding - telling java exactly what we want the username/password to be
		if(ers_username.equals("user") && ers_password.equals("password")) {
			            //System.out.println("Access was Successfully You're Welcome! ");
                         
			             //Users userlog = new Users(ps.setInt(ers_user_roles_id));
			             Users us = uDAO.login();
			             
			return us;
			
		}else {
			
			return null;
			
		}
		
	}
}