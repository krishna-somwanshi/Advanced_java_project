package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Management {
	@Id
	@GeneratedValue
	@Column(name = "task_id")
	private int manid;
	@Column(name = "task_desc")
	private String manName;
	@Column(name = "starttime")
	private String manStartTime;
	@Column(name = "stoptime")
	private String manStopTime;
	private int managerId;
	private int employeeId;
	
	public Management() {
		
	}
	public Management(int manid) {
		super();
		this.manid = manid;
	}
	
	public int getManid() {
		return manid;
	}
	public void setManid(int manid) {
		this.manid = manid;
	}
	public String getManName() {
		return manName;
	}
	public void setManName(String manName) {
		this.manName = manName;
	}
	public String getManStartTime() {
		return manStartTime;
	}
	public void setManStartTime(String manStartTime) {
		this.manStartTime = manStartTime;
	}
	public String getManStopTime() {
		return manStopTime;
	}
	public void setManStopTime(String manStopTime) {
		this.manStopTime = manStopTime;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}