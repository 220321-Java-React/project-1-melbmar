package com.revature.models;

public class Employee {
	
	private int employee_id;
	private String first_name;
	private String last_name;
	private Roles roles;
	private Status status;
	private Type type;

	//no args constuctor (source -> constructor from superclass)
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor (source -> constructor from fields)
	public Employee(int employee_id, String first_name, String last_name, Roles roles, Status status, Type type) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.roles = roles;
		this.status = status;
		this.type = type;
	}

	    //the toString() method lets us actually print out our objects, since it would print a memory address otherwise
		//(source -> generate toString)
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", roles=" + roles + ", status=" + status + ", type=" + type + "]";
	}

	
	// I created getter/Setter (ENCAPSULATION) one of the pillar of OOP-Java
    // Both allows me to access and change variable to private
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
	