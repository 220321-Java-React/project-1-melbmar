package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Type;

public interface TypeDAOInterface {
    
	//get all roles
	ArrayList<Type> getType();
	//get all roles by ID
	Type getTypeById(int id);
	
	

}
