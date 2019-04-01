package com.level3.rest.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.level3.rest.dao.IdentityManagementDao;

public class IdentityManagementServiceImpl implements IdentityManagementService {
	
	@Autowired
	private IdentityManagementDao identityManagementDao;
	
	@Override
	public void createGroup(String groupId, String groupName, String groupType) {
		identityManagementDao.createGroup(groupId, groupName, groupType);
		
	}
	
	public void createUser(String userId,String password,String firstName,String lastName,String email) {
		identityManagementDao.createUser(userId, password, firstName, lastName, email);
	}

}
