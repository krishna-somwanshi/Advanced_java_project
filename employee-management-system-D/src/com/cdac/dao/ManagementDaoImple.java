package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Management;

@Repository
public class ManagementDaoImple implements ManagementDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void insertinfo(Management management) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {
			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(management);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public void deleteinfo(int manid) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Management(manid));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});
		
	}

	@Override
	public Management selectinfo(int manid) {
		Management management = hibernateTemplate.execute(new HibernateCallback<Management>() {

			@Override
			public Management doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Management man = (Management)session.get(Management.class, manid);
				tr.commit();
				session.flush();
				session.close();
				return man;
			}
		});
		return management;
	}

	@Override
	public void updateinfo(Management management) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Management man = (Management)session.get(Management.class, management.getManid());
				man.setManName(management.getManName());
				man.setManStartTime(management.getManStartTime());
				man.setManStopTime(management.getManStopTime());
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		});

		
	}

	@Override
	public List<Management> selectAll(int employeeId) {
		List<Management> manList = hibernateTemplate.execute(new HibernateCallback<List<Management>>() {

			@Override
			public List<Management> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Management where employeeId = ?");
				q.setInteger(0, employeeId);
				List<Management> li = q.list();
				System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
		return manList;
	}

	@Override
	public List<Management> selectAllman(int managerId) {
		List<Management> manList = hibernateTemplate.execute(new HibernateCallback<List<Management>>() {

			@Override
			public List<Management> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Management where managerId = ?");
				q.setInteger(0, managerId);
				List<Management> li = q.list();
				System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
		});
		return manList;

	}
	
}
