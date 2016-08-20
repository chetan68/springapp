package com.dao;

import java.util.List;

import com.model.Product;
import com.model.UserRoles;

public interface UserRolesDao {
	public List<Product> getList();
	public List<Product> getByCategory(String cat);
	public int insertRow(UserRoles urole);
	public int updateRow(UserRoles urole);
	public int deleteRow(int id);
	public int dbGetMaxID();
	public Product getProductById(int id);

}
