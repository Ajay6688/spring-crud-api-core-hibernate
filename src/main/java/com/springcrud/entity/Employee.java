/*
 * entity class for employee
 * 
 * author : Ajay Kumar
 * 
 * version : 0.0.1
 * 
 * date : 02/01/2023
 * 
 * copyright : youngsoft india pvt. ltd.
 */

package com.springcrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

//	defining the fields 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="first_name")
	private String firstName ;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email ;
	
//	defining constructor for fields 
	
//	no-arg constructor 
	public Employee() {
		
	}
	
	public Employee(String firstName , String lastName , String email) {
		super();
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.email = email;
	}

//	defining getters and setters 
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
}
