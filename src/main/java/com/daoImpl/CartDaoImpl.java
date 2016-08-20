package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Cart;
import com.model.Product;
import com.dao.CartDao;


@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Cart getCartById(int id)
	{
		Session session = sessionFactory.openSession();  
		Cart cart = (Cart) session.load(Cart.class, id);  
		return cart;
	}
	
	@Transactional
	public int insertRow(Cart ct) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(ct);
		tx.commit();
		session.close();
		return 1;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cart> getCartList(int registerid){
		Session session = sessionFactory.openSession();
		List<Cart> clist = session.createQuery("from Cart where registerid = " + registerid + " and cartstatus='pending'").list();
		return clist;
	}
	
}

