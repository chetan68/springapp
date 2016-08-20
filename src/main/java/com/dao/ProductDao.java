package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {

	public List<Product> getList();
	public List<Product> getByCategory(String cat);
	public int insertRow(Product prod);
	public int updateRow(Product prod);
	public int deleteRow(int id);
	public int dbGetMaxID();
	public Product getProductById(int id);
}