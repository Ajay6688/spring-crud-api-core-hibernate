package com.springcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcrud.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {
	
//	define EntityManager variable 
	private EntityManager entityManager ;
	
//	constructor injection 
	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
//		get the current hibernate session from entityManager
		Session currentSession = entityManager.unwrap(Session.class);
		
//		create a Query 
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
//		execute the query and getResult
		List<Employee> employeeList = query.getResultList();
		
		return employeeList;
	}
	

	@Override
	public Employee findById(int empId) {
		
//		get the current session from entityManager
	    Session currentSession = entityManager.unwrap(Session.class);
	    
//	    get the employee using its id
	    Employee employee = currentSession.get(Employee.class, empId);
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee employee) {
		
//		get the currentSession from entityManager 
		Session currentSession = entityManager.unwrap(Session.class);
		
//		save data of employee in the table 
		currentSession.save(employee); 
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		
//		get the currentSession from entityManager 
		Session currentSession = entityManager.unwrap(Session.class);
		
//		save data of employee in the table 
		currentSession.merge(employee); 
		
	}
	
	@Override
	public void deleteEmployee(int empId) {
		
//		get the currentSession from entityManager 
	    Session currentSession = entityManager.unwrap(Session.class);
	    
//	    delete data from table 
		Query query = currentSession.createQuery("delete from Employee where id=:empId");

		query.setParameter("empId", empId);
		
		query.executeUpdate();
		
	}

}
