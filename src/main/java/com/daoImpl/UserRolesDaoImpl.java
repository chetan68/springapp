package com.daoImpl;

import com.dao.UserRolesDao;
import com.model.Product;
import com.model.UserRoles;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserRolesDaoImpl implements UserRolesDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public int insertRow(UserRoles urole) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(urole);
		tx.commit();
		session.close();
		return 1;
	}

	@Override
	public List<Product> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategory(String cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRow(UserRoles urole) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int dbGetMaxID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

