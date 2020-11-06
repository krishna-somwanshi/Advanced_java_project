package com.cdac.service;

import com.cdac.dto.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee employee);
	boolean findEmployee(Employee employee);
}
