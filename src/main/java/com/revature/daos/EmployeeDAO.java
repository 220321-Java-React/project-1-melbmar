package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Employee;
import com.revature.models.Roles;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAO {
	
	//Instantiate a RoleDAO, TypeDAO, and StatusDAO object so that we can use one of it's methods in the getEmployees() method
	RolesDAO rDAO = new RolesDAO();
	TypeDAO tyDAO = new TypeDAO();
	StatusDAO stDAO = new StatusDAO();
	
public ArrayList<Employee> getEmployees(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//a String that will represent our SQL statement
			String sql = "select * from employees;";
			
			//a Statement object to execute our query 
			Statement s = conn.createStatement();
			
			//execute our query into a ResultSet object, which will hold all the data 
			//executeQuery() is what actually queries the database! Then we put the records into a ResultSet
			ResultSet rs = s.executeQuery(sql);
			
			//Instantiate an ArrayList to put our Employee objects into
			ArrayList<Employee> employeeList = new ArrayList<>();
			
			//use rs.next() in a while loop to create Employee objects and populate our ArrayList with them.
			//remember, the ResultSet is what's holding our data. We need to turn it into something Java can read (objects)
			while(rs.next()) {
				//Create a new Employee object from each record in the ResultSet
				//we're using the all args constructor of Employee to fill in new Employee objects with DB data
				Employee e = new Employee(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						null, null, null //there is no JDBC method for getRole... we'll add the Role object in below
						//this is an extra step we have to take because in the DB, the role_id_fk is an int
						//but we need a Role object here

						);
				
				//we need to get the role, type, and Status of each employee somehow...
				//we need to use the DAO method for getRoleById from the RoleDAO
				int roleFK = rs.getInt("ers_user_roles_id_fk");
				int typeFK = rs.getInt("reimb_status_id_fk");
				int stFK = rs.getInt("reimb_type_id_fk");
				
				//get a Role, type, and Status object from the RoleDAO
				Roles r = rDAO.getRoleById(roleFK);
				Type ty = tyDAO.getTypeById(typeFK);
				Status st = stDAO.getStatusById(stFK);
				
				
				//use the SETTER of the Employee class to set the Role, type, and status  object to the one we got from the DB above.
				e.setRoles(r);
				e.setType(ty);
				e.setStatus(st);
				//thanks to this setter, our Employee objects can be FULLY initialized (every variable has a value)
				
				//add the fully initialized Employee into the ArrayList
				employeeList.add(e);
			}
			
			//once the while loop ends (when rs.next() == false), return the ArrayList
			return employeeList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting all employees!");
			e.printStackTrace();
		}
		
		return null;
		
	}

}
