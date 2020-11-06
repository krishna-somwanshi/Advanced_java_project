package com.cdac.dao;

//import java.util.List;

//import com.cdac.dto.Management;
//import com.cdac.dto.Employee;
import com.cdac.dto.Manager;

public interface ManagerDao {
	void insertmanager(Manager manager);
	boolean checkManager(Manager manager);
}
