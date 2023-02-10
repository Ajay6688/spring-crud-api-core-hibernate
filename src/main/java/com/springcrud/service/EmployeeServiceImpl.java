package com.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcrud.dao.EmployeeDao;
import com.springcrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

	@Override
	@Transactional 
	public Employee findById(int empId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(empId);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		 employeeDao.saveEmployee(employee);
		 
	}
	
	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		 employeeDao.updateEmployee(employee);
		 
	}
	
	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		
	}

}
