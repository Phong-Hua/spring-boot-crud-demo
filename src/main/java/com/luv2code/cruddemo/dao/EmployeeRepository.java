package com.luv2code.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> // Employee is entity type, 
																				// Integer is Primary key type
{

	/**
	 * JpaRepository allows us to plugin the Entity class, Primary key type And we
	 * get CRUD method for free. No need to code
	 */
}
