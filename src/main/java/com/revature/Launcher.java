package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;
import com.revature.controllers.EmployeeController;
import io.javalin.Javalin;

public class Launcher {

    public static void main(String[] args) {
    	
    	//here we go again... have fun!!
    	
    	/*
    	  
    	  
		       _.---._    /\\
		    ./'       "--`\//
		  ./              o \
		 /./\  )______   \__ \
		./  / /\ \   | \ \  \ \
		   / /  \ \  | |\ \  \7
		    "     "    "  "        
    	  
    	  
    	  Here's an aardvark this time... not as friendly or cute as a dog, but take him anyway.
    	  // Nice! ^_-
    	   
    	   * 
    	   *
    	   
    	 */
    	        //In this try/catch, we're just testing whether our Connection (from the ConnectionUtil Class) is successful
    			//The getConnection() method will return a Connection Object if you connect successfully
    			try(Connection conn = ConnectionUtil.getConnection()){
    				System.out.println("CONNECTION SUCCESSFUL :)");
    			} catch (SQLException e) { //if creating this connection fails... catch the exception and print the stack trace
    				System.out.println("connection failed... :(");
    				e.printStackTrace();
    			}
    	
    			
    			//Instantiating an EmployeeController object so that we can access it's Handlers
		        EmployeeController ec = new EmployeeController();
		        
    			//Typical Javalin syntax to create a Javalin object
    			Javalin app = Javalin.create(
    					//The config lambda lets us specify certain configurations.
    					config ->{ 
    						config.enableCorsForAllOrigins();
    						
    					}
			
    					).start(3000); //we need this to start our application on port 3000
    			
    			//handler ending in /employees that takes in GET requests - will return all employees
    			//the app.get() method takes in a URL endpoint, and a place in the server to send the request to
    			app.get("/employees", ec.getEmployeesHandler);
    }
    
}
