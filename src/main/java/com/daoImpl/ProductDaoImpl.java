package com.daoImpl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;
import com.dao.ProductDao;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int dbGetMaxID()
	{
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unused")
		Transaction tx = session.beginTransaction();
		int maxid=session.createQuery("select max(id) from Product").getFirstResult();
		tx.commit();
		session.close();
		return maxid;
	}

	@Transactional
	public int insertRow(Product prod) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(prod);
		tx.commit();
		session.close();
		return 1;
	}

	@Transactional
	public int updateRow(Product prod) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(prod);
		tx.commit();
		Serializable id = session.getIdentifier(prod);
		session.flush();
		session.close();
		return (Integer) id;
	}

	@Transactional
	public int deleteRow(int id) {
		//return sessionFactory.getCurrentSession().createQuery("delete from Product where id=" + id).executeUpdate();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("delete from Product where id=" + id).executeUpdate();
		tx.commit();
		session.flush();
		session.close();
		return (Integer) id;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getByCategory(String cat) {
		Session session = sessionFactory.openSession();
		List<Product> plist = session.createQuery("from Product where category = '"+cat +"'").list();
		return plist;
	}
	
	@Transactional
	public List<Product> getList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> plist = session.createQuery("from Product").list();
		tx.commit();
		session.close();
		return plist;
		
		//return (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
	}
	
	@Transactional
	public SessionFactory getSf() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		return sessionFactory;
	}

	@Transactional
	public void setSf(SessionFactory sf) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		this.sessionFactory = sf;
	}

	@Transactional
	public Product getProductById(int id) 
	{
		//return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
		Session session = sessionFactory.openSession();  
		Product prod = (Product) session.load(Product.class, id);  
		return prod; 
	}
}
