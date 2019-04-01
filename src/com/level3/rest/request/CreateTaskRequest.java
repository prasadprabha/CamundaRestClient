package com.level3.rest.request;

public class CreateTaskRequest {
	private String id;

	private String caseInstanceId;

	private String priority;

	private String description;

	private String name;

	private String owner;

	private String due;

	private String assignee;

	private String parentTaskId;

	private String followUp;

	private String delegationState;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCaseInstanceId() {
		return caseInstanceId;
	}

	public void setCaseInstanceId(String caseInstanceId) {
		this.caseInstanceId = caseInstanceId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public String getFollowUp() {
		return followUp;
	}

	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}

	public String getDelegationState() {
		return delegationState;
	}

	public void setDelegationState(String delegationState) {
		this.delegationState = delegationState;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", caseInstanceId = " + caseInstanceId
				+ ", priority = " + priority + ", description = " + description
				+ ", name = " + name + ", owner = " + owner + ", due = " + due
				+ ", assignee = " + assignee + ", parentTaskId = "
				+ parentTaskId + ", followUp = " + followUp
				+ ", delegationState = " + delegationState + "]";
	}
}
