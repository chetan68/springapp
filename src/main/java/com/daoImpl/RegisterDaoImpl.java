package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RegisterDao;
import com.model.Product;
import com.model.Register;

@Repository
public class RegisterDaoImpl implements RegisterDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public List<Register> getRegisterId(String username) {
		Session session = sessionFactory.openSession();
		List<Register> rlist = session.createQuery("from Register where UserName = '"+ username +"'").list();
		return rlist;
	}
	
	@Transactional
	public int insertRow(Register reg) {
		System.out.println("Dao:"+reg.getEmail());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(reg);
		tx.commit();
		session.close();
		return 1;
	}
}
