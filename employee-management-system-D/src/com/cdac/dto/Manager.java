package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mngr")
public class Manager {
		@Id
		@GeneratedValue
		@Column(name = "manager_id")
		private int managerId;
		@Column(name = "manager_name")
		private String managerName;
		@Column(name = "manager_pass")
		private String managerPass;
		
		public Manager() {

		}
		public int getManagerId() {
			return managerId;
		}
		public void setManagerId(int managerId) {
			this.managerId = managerId;
		}
		public String getManagerName() {
			return managerName;
		}
		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}
		public String getManagerPass() {
			return managerPass;
		}
		public void setManagerPass(String managerPass) {
			this.managerPass = managerPass;
		}
}