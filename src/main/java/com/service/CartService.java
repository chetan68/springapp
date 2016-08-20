package com.service;

import java.util.List;

import com.model.Cart;

public interface CartService {

	public Cart getCartById(int id);
	public int insertRow(Cart ct);
	public List<Cart> getCartList(int registerid);
}
