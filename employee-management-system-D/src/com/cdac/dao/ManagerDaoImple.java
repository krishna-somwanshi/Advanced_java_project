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

import com.cdac.dto.Manager;

@Repository
public class ManagerDaoImple implements ManagerDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insertmanager(Manager manager) {
		hibernateTemplate.execute(new HibernateCallback<Void>(){

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(manager);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
	}

	@Override
	public boolean checkManager(Manager manager) {
		boolean b = hibernateTemplate.execute(new HibernateCallback<Boolean>() { 

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Manager where managerName = ? and managerPass = ?");
				q.setString(0, manager.getManagerName()); 
				q.setString(1, manager.getManagerPass()); 
				List<Manager> li = q.list(); 
				boolean flag = !li.isEmpty();
				manager.setManagerId(li.get(0).getManagerId());
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
			
		});
		return b;
	}

}
