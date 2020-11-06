package com.cdac.dao;

import com.cdac.dto.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee employee);
	boolean checkEmployee(Employee employee); 
}