package com.level3.rest.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.level3.rest.dao.TaskDao;
import com.level3.rest.request.CompleteTaskRequest;
import com.level3.rest.request.CreateTaskRequest;
import com.level3.rest.request.TaskFormRequest;
import com.level3.rest.request.TaskSetAssigneeRequest;
import com.level3.rest.response.TaskResponse;


public class TaskServiceImpl implements TaskService{
	public static final Logger logger=Logger.getLogger(ProcessServiceImpl.class);

	
	@Autowired
	private TaskDao taskDao;
	
	@Override
	public List<TaskResponse> getTaskList() {
		logger.debug("calling getTaskList");
		return taskDao.getTaskList();
	}
	
	@Override
	public List<TaskResponse> getTaskByAssignee(String assignee) {
		logger.debug("calling getTaskByAssignee");
		return taskDao.getTaskByAssignee(assignee);
	}
	
	@Override
	public void createTask(CreateTaskRequest createTaskReq) {
		logger.debug("calling createTask");
		taskDao.createTask(createTaskReq);
	}

	@Override
	public void setAssignee(TaskSetAssigneeRequest setAssigneeRequest, String id) {
		logger.debug("calling setAssignee");
		taskDao.setAssignee(setAssigneeRequest, id);
		
	}

	@Override
	public void claimtask(TaskSetAssigneeRequest claimRequest, String id) {
		logger.debug("calling claimtask");
		taskDao.claimtask(claimRequest, id);
		
	}

	@Override
	public void unClaimtask(String id) {
		logger.debug("calling unClaimtask");
		taskDao.unClaimtask(id);		
	}

	@Override
	public void completeTask(CompleteTaskRequest completeTaskRequest,
			String id) {
		logger.debug("calling compleateTask");
		taskDao.completeTask(completeTaskRequest, id);		
	}
	
	/*The next call we’re going to make is to get details of the task that the process instance is currently waiting at. */
	@Override
	public List<TaskResponse> getCurrentActiveTask(String processInstanceId) {
		logger.debug("calling getCurrentActiveTask");
		return taskDao.getCurrentActiveTask(processInstanceId);
	}
	
	
	@Override
	public String submitTaskWithForm(TaskFormRequest request,String taskId) {
		return taskDao.submitTaskWithForm(request, taskId);
		
	}
	
	@Override
    public TaskResponse getTaskById(String taskId) {
           return taskDao.getTaskById(taskId);
    }


}
