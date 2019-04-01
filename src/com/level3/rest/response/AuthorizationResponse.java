package com.level3.rest.response;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationResponse implements Serializable {
	private String id;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private int type;

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	private ArrayList<String> permissions;

	public ArrayList<String> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(ArrayList<String> permissions) {
		this.permissions = permissions;
	}

	private String userId;

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String groupId;

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	private int resourceType;

	public int getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}

	private String resourceId;

	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@Override
	public String toString() {
		return "Authorization [id=" + id + ", type=" + type + ", permissions="
				+ permissions + ", userId=" + userId + ", groupId=" + groupId
				+ ", resourceType=" + resourceType + ", resourceId="
				+ resourceId + "]";
	}
}