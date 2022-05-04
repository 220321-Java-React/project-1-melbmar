package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

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
    	
    }
}
