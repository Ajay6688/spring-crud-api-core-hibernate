package com.springcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.entity.Employee;
import com.springcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// mapping to get all employees from the table 

	@GetMapping("employee")
	public List<Employee> findAll(){
		
		System.out.println("finding all employees from the database...");
		return employeeService.findAll();
	}
	
	// mapping to get an employee by its id 
	@GetMapping("employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		System.out.println("finding the employee using id : "+employeeId);
		
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee Id not found - "+employeeId);
		}
		
		return employee;
	}
	
	// mapping to save the employee 
	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
//		making emplyee id to zero to force the saveOrUpdate function in dao to save a new employee
		employee.setId(0);
		
	    System.out.println("adding employee to the database...");
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
		
		employeeService.saveEmployee(employee);
		
		return employee;
	}
	
	// adding mapping to update the employee
	@PutMapping("employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
	
		System.out.println("updating the employee...");
		System.out.println(employee.getId());
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmail());
		
		employeeService.updateEmployee(employee);
		
		return employee;
	}
	
	// delete mapping to delete employee using its id 
	@DeleteMapping("employee/{employeeId}")
	public String delEmployee(@PathVariable int employeeId) {
		
		System.out.println("deleting employee process started...");
		
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null ) {
			throw new RuntimeException("employee not found with employeeId - "+employeeId);
		}
		
		employeeService.deleteEmployee(employeeId);
		
		return "Deleted employee id : "+employeeId;
		
	}
		
}
