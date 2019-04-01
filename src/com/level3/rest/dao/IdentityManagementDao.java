package com.level3.rest.dao;

public interface IdentityManagementDao {
	public void createGroup(String groupId, String groupName, String groupType);
	public void createUser(String userId,String password,String firstName,String lastName,String email);
}
