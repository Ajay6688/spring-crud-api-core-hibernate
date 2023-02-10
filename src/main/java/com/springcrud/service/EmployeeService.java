package com.springcrud.service;

import java.util.List;

import com.springcrud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int empId);
	
	public void saveEmployee(Employee employee);
	 
	public void deleteEmployee(int id);

	void updateEmployee(Employee employee);
}
