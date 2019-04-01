package com.level3.rest.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.level3.rest.constants.RestURLConstants;

import com.level3.rest.response.StartProcessResponse;
import com.level3.rest.request.CreateGroupRequest;
import com.level3.rest.request.CreateUserRequest;
import com.level3.rest.service.ProcessServiceImpl;

public class IdentityManagementRestDaoImpl implements IdentityManagementDao {
	
	public static final Logger logger=Logger.getLogger(IdentityManagementRestDaoImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void createGroup(String groupId, String groupName, String groupType) {
		CreateGroupRequest createGroupRequest = new CreateGroupRequest();
		createGroupRequest.setId(groupId);
		createGroupRequest.setName(groupName);
		createGroupRequest.setType(groupType);
		logger.debug("Before calling create User REST: URI-");
		String status = restTemplate.postForObject(RestURLConstants.REST_API_URI_IDENTITY_MANAGEMENT_CREATE_GROUP,createGroupRequest,String.class);
		System.out.println(status);
		
	}
	
	@Override
	public void createUser(String userId,String password,String firstName,String lastName,String email) {
		CreateUserRequest createUserRequest = new CreateUserRequest(userId, password, firstName, lastName, email);
		String status = restTemplate.postForObject(RestURLConstants.REST_API_URI_IDENTITY_MANAGEMENT_CREATE_USER,createUserRequest,String.class);
		System.out.println(status);
		
	}
}
