package com.springcrud.dao;

import java.util.List;

import com.springcrud.entity.Employee;

public interface EmployeeDao {

//	to get the full list of the employee table 
	public List<Employee> findAll();
	
//	to get the employee by its id 
	public Employee findById(int empId);
	
//	to save an employee in the database 
	public void saveEmployee(Employee employee);
	
//	to delete employee using its id 
	public void deleteEmployee(int empId);

//	to update the data of an employee using its id 
	public void updateEmployee(Employee employee);
	
}
