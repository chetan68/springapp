package com.dao;

import java.util.List;

import com.model.Cart;
import com.model.Product;

public interface CartDao {

	public Cart getCartById(int id);
	public int insertRow(Cart ct);
	public List<Cart> getCartList(int registerid);
	//public List<Cart> getCartListByRegID(int registerid);
}