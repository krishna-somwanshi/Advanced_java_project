package com.cdac.service;

import java.util.List;

import com.cdac.dto.Management;

public interface ManagementService {

	void addinfo(Management management);
	void removeinfo(int manid);
	Management selectinfo(int manid);
	void modifyinfo(Management management);
	List<Management> selectAll(int employeeId);
	List<Management> selectAllman(int managerId);
}