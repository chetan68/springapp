package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDao;
import com.model.Product;
import com.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDao pdao;
	
	public ProductDao getProductDao(){
		return pdao;
	}
	
	public void setProductDao(ProductDao pdao)
	{
		this.pdao=pdao;
	}
	
	@Transactional
	public List<Product> getList() {
		return pdao.getList();
	}

	@Transactional
	public List<Product> getByCategory(String cat) {
		return pdao.getByCategory(cat);
	}
	
	@Transactional
	public Product getProductById(int id)
	{
		return pdao.getProductById(id);
	}

	@Transactional
	public int insertRow(Product prod) {
		
		return pdao.insertRow(prod);
	}

	@Transactional
	public int updateRow(Product prod) {
		return pdao.updateRow(prod);
	}

	@Transactional
	public int deleteRow(int id) {
		return pdao.deleteRow(id);
	}

	@Transactional
	public int dbGetMaxID() {
		return pdao.dbGetMaxID();
	}

}
