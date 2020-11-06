package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.ManagerDao;
import com.cdac.dto.Manager;

@Service
public class ManagerServiceImple implements ManagerService{

	@Autowired
	private ManagerDao managerDao;
	
	@Override
	public void addManager(Manager manager) {
		managerDao.insertmanager(manager);
	}

	@Override
	public boolean findManager(Manager manager) {
		return managerDao.checkManager(manager);
	}

}