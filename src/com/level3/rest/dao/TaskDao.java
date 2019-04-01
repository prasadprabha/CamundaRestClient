package com.level3.rest.dao;

import java.util.List;

import com.level3.rest.request.CompleteTaskRequest;
import com.level3.rest.request.CreateTaskRequest;
import com.level3.rest.request.TaskFormRequest;
import com.level3.rest.request.TaskSetAssigneeRequest;
import com.level3.rest.response.StartProcessWithFormResponse;
import com.level3.rest.response.TaskResponse;

public interface TaskDao {
	
	public List<TaskResponse> getTaskList();
	public List<TaskResponse> getTaskByAssignee(String assignee);
	public void createTask(CreateTaskRequest createTaskReq);
	public void setAssignee(TaskSetAssigneeRequest setAssigneeRequest,String id);
	public void claimtask(TaskSetAssigneeRequest claimRequest,String id); 
	public void unClaimtask(String id);
	public void completeTask(CompleteTaskRequest completeTaskRequest,String id);
	public List<TaskResponse> getCurrentActiveTask(String processInstanceId);
	public String submitTaskWithForm(TaskFormRequest request,String taskId);
    public TaskResponse getTaskById(String taskId);




}
