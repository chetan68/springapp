package com.service;

import java.util.List;
import com.model.Product;

public interface ProductService {
	public List<Product> getList();
	public List<Product> getByCategory(String cat);
	public int insertRow(Product prod);
	public int updateRow(Product prod);
	public int deleteRow(int id);
	public int dbGetMaxID();
	public Product getProductById(int id);
}
