package com.level3.rest.service;


public interface IdentityManagementService {
	
	public void createGroup(String groupId, String groupName, String groupType);
	public void createUser(String userId,String password,String firstName,String lastName,String email);

}
