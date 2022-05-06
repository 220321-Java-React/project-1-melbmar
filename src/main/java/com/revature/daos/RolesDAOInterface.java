package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Roles;

//This interface will lay out every method that I want my RoleDAO to have
public interface RolesDAOInterface {

	
	//get all roles
	ArrayList<Roles> getRoles();
	//get all roles by ID
	Roles getRoleById(int id);
	
	
	
	

}
