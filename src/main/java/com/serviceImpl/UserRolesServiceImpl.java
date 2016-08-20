package com.serviceImpl;

import com.model.UserRoles;
import com.service.UserRolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserRolesDao;

@Service
public class UserRolesServiceImpl implements UserRolesService {

	@Autowired
	UserRolesDao urd;
	
	@Transactional
	public int insertRow(UserRoles urole)
	{
		return urd.insertRow(urole);
	}
}
