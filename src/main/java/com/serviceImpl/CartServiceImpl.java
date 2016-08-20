package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Cart;
import com.dao.CartDao;
import com.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cdao;
	
	public Cart getCartById(int id)
	{
		return cdao.getCartById(id);
	}
	
	public int insertRow(Cart ct)
	{
		return cdao.insertRow(ct);
	}
	
	public List<Cart> getCartList(int registerid)
	{
		return cdao.getCartList(registerid);
	}
}
