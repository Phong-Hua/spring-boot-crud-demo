package com.luv2code.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	// define field for entityManager
	private EntityManager entityManger;

	// setup constructor injection
	@Autowired
		public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
			this.entityManger = theEntityManager;
		}

	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query theQuery = entityManger.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		return entityManger.find(Employee.class, theId);
	}

	@Override
	public void save(Employee theEmployee) {
		
		// save or update the employee
		Employee dbEmployee = entityManger.merge(theEmployee);
		
		// update with id from db ... so we can get generate id for save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		// delete object with primary key
		Query theQuery = entityManger.createQuery("delete from Employee where id=:theId");
		theQuery.setParameter("theId", theId);
		
		theQuery.executeUpdate();
	}

}
