package com.service;

import java.util.List;

import com.model.Register;

public interface RegisterService {

	public int insertRow(Register reg);
	public List<Register> getRegisterId(String username);
}
