package com.level3.rest.service;

import java.util.List;

import com.level3.rest.request.CompleteTaskRequest;
import com.level3.rest.request.CreateTaskRequest;
import com.level3.rest.request.TaskFormRequest;
import com.level3.rest.request.TaskSetAssigneeRequest;
import com.level3.rest.response.TaskResponse;

public interface TaskService {
	
	/*
	 * Query all the tasks in system.
	 */
	public List<TaskResponse> getTaskList();
	
	/*
	 * Query for tasks that fulfill a given filter(ie., assignee)
	 */
	public List<TaskResponse> getTaskByAssignee(String assignee);
	
	/*
	 * Create a new task.
	 */
	public void createTask(CreateTaskRequest createTaskReq);
	
	/*
	 * Change the assignee of a task to a specific user.The difference with claim a task is that this method does not check if the task already has a user assigned to it.
	 */
	public void setAssignee(TaskSetAssigneeRequest setAssigneeRequest,String id);
	
	/*
	 * Claim a task for a specific user.Note: The difference with set a assignee is that here a check is performed to see if the task already has a user assigned to it.
	 */
	public void claimtask(TaskSetAssigneeRequest claimRequest,String id); 
	
	/*
	 * Resets a task’s assignee. If successful, the task is not assigned to a user.
	 */
	public void unClaimtask(String id);
	
	/*
	 * Complete a task and update process variables.
	 */
	public void completeTask(CompleteTaskRequest compleateTaskRequest,String id);
	
	
	public List<TaskResponse> getCurrentActiveTask(String processInstanceId);
	
	public String submitTaskWithForm(TaskFormRequest request,String taskId);

	public TaskResponse getTaskById(String taskId);


}
