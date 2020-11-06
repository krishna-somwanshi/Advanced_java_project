package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Management;

public interface ManagementDao {

	void insertinfo(Management management);
	void deleteinfo(int manid);
	Management selectinfo(int manid);
	void updateinfo(Management management);
	List<Management> selectAll(int employeeId);
	List<Management> selectAllman(int managerId);
}
