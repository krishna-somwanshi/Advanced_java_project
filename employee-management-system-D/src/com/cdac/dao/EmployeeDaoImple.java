package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Employee;

@Repository
public class EmployeeDaoImple implements EmployeeDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insertEmployee(Employee employee) {
		hibernateTemplate.execute(new HibernateCallback<Void>(){

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(employee);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}

	@Override
	public boolean checkEmployee(Employee employee) {
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() { 
				@Override
				public Boolean doInHibernate(Session session) throws HibernateException {
					Transaction tr = session.beginTransaction();
					Query q = session.createQuery("from Employee where employeeName = ? and employeePass = ?");
					q.setString(0, employee.getEmployeeName());
					q.setString(1, employee.getEmployeePass());
					List<Employee> li = q.list();
					boolean flag = !li.isEmpty();
					employee.setEmployeeId(li.get(0).getEmployeeId());
					tr.commit();
					session.flush();
					session.close();
					return flag;
				
			}
			
		});
		return b;
	}
}
