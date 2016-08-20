package com.dao;

import java.util.List;

import com.model.Register;

public interface RegisterDao {
	public int insertRow(Register reg);
	public List<Register> getRegisterId(String username);
	
}
