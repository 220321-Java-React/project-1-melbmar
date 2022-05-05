package com.revature.models;
//The HECK is a LoginDTO? Data transfer object. A DTO is just a model of some data coming in from the front end
//an HTTP handler will take in a JSON object sent in by the user, containing their username and password
//this gets sent to the controller to get turned into this Java object (user Gson)
//the username and password the user sent in will be put into this DTO as variable, wich we'll check in the AuthServide
//NEVER store a DTO in the database, It's purely for DATA TRANSFER.. we're transferring the username/password
public class LogintDTO {

	     // The LoginDTO models only the username/password sent in by the user
		//Using encapsulation (OOP)
		private String username;
		private String password;
		
		
		// args no constructor 
		public LogintDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		//args constructor
		public LogintDTO(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		
		//toString() is an important method because it allows us to print objects and their variables as a String
		@Override
		public String toString() {
			return "LogintDTO [username=" + username + ", password=" + password + "]";
		}

		// I created getter/Setter (ENCAPSULATION) one of the pillar of OOP-Java
	    // Both allows me to access and change variable to private
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
		
		
		
		
	
}
