package com.cdac.service;

import com.cdac.dto.Manager;

public interface ManagerService {

	void addManager(Manager manager);
	boolean findManager(Manager manager);
}
