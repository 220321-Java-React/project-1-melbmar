package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class UsersDAO {
	

		
		//This method will return true in the case of successful login, otherwise it will return false
		public Users login() {
			 
			try(Connection conn = ConnectionUtil.getConnection()){
				
				     //String will connect put send(inside) of the database
				     String sql = "select * from ers_users where ers_username = ? and ers_password = ?; ";
				     //Instantiate a PreparedStatement to fill in the variables of our initial SQL String
				     PreparedStatement ps = conn.prepareStatement(sql);
				     //executeQuery() is what actually queries the database! Then we put the records into a ResultSet
				     //ResultSet rs = ps.executeQuery(sql);
				     ResultSet rs = ps.executeQuery(); 
				     
				     
				     ps.setString(1, ers_username);
				     ps.setString(2, ers_password);

					
				     while(rs.next()) {
						 Users user = new Users(
								 rs.getInt("ers_users_id"),
								 rs.getString("ers_username"),
								 rs.getString("ers_password"),
								 rs.getString("ers_first_name"),
								 rs.getString("ers_second_name"),
								 rs.getString("ers_mail"),
								 rs.getInt("ers_user_roles_id")
								 
								 );		
						 return user;
					}
			
			} catch (SQLException e) {
				System.out.println("Something happened inserting Your Information !");
				e.printStackTrace();}
			
			return null;
			}


		}
		

	
	
	
	

