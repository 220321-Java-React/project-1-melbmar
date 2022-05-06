package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Status;

public interface StatusDAOInterface {
	//get all roles
	ArrayList<Status> getStatus();
	//get all roles by ID
	Status getStatusById(int id);
	
	
	

}
