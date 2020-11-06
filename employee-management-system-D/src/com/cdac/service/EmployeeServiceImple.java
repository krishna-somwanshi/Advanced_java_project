package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.EmployeeDao;
import com.cdac.dto.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public boolean findEmployee(Employee employee) {
		return employeeDao.checkEmployee(employee);
	}
	
}
