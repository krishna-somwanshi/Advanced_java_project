package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.ManagementDao;
import com.cdac.dto.Management;

@Service
public class ManagementServiceImple implements ManagementService{

	@Autowired
	private ManagementDao managementDao;
	
	@Override
	public void addinfo(Management management) {
		managementDao.insertinfo(management);
	}

	@Override
	public void removeinfo(int manid) {
		managementDao.deleteinfo(manid);
		
	}

	@Override
	public Management selectinfo(int manid) {
		return managementDao.selectinfo(manid);
	}

	@Override
	public void modifyinfo(Management management) {
		managementDao.updateinfo(management);
	}

	@Override
	public List<Management> selectAll(int employeeId) {
		return managementDao.selectAll(employeeId);
	}

	@Override
	public List<Management> selectAllman(int managerId) {
		return managementDao.selectAllman(managerId);
	}

}
