package com.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RegisterDao;
import com.model.Register;
import com.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService
{
	@Autowired
	RegisterDao rdao;
	
	@Transactional	
	public int insertRow(Register reg) {
		return rdao.insertRow(reg);
	}

	@Override
	public List<Register> getRegisterId(String UserName) {
		return rdao.getRegisterId(UserName);
	}
	
}
