package com.level3.rest.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.level3.rest.constants.RestURLConstants;
import com.level3.rest.request.CompleteTaskRequest;
import com.level3.rest.request.CreateTaskRequest;
import com.level3.rest.request.StartProcessWithFormRequest;
import com.level3.rest.request.TaskFormRequest;
import com.level3.rest.request.TaskSetAssigneeRequest;
import com.level3.rest.response.StartProcessWithFormResponse;
import com.level3.rest.response.TaskResponse;
import com.level3.rest.service.ProcessServiceImpl;

public class TaskDaoRestImpl implements TaskDao {
	public static final Logger logger=Logger.getLogger(ProcessServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;
	
	
	/*public TaskResponse getTask(String taskId) {
		
	}*/
	
	@Override
	public List<TaskResponse> getTaskList() {
		 TaskResponse[] taskArray = restTemplate.getForObject(RestURLConstants.REST_API_URI_TASK_LIST, TaskResponse[].class);
			logger.debug("TaskList Response:"+taskArray.toString());
		 return Arrays.asList(taskArray);
	}
	
	@Override
	public List<TaskResponse> getTaskByAssignee(String assignee) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_TASK_LIST).queryParam("assignee", assignee).build();
		logger.debug("Before calling REST for TaskByAssignee: "+uriComponents.toUriString());
		TaskResponse[] taskArray = restTemplate.getForObject(uriComponents.toUri(), TaskResponse[].class);
		logger.debug(taskArray.toString());
		return Arrays.asList(taskArray);
	}
	
	@Override
	public void createTask(CreateTaskRequest createTaskReq) {
		logger.debug("Before calling create task REST :"+RestURLConstants.REST_API_URI_TASK_CREATE);
		restTemplate.postForObject(RestURLConstants.REST_API_URI_TASK_CREATE, createTaskReq,Object.class);
	}

	@Override
	public void setAssignee(TaskSetAssigneeRequest setAssigneeRequest, String id) {
		UriComponents uriComponents=UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_COMMON_ENDPOINT).path(RestURLConstants.REST_API_URI_TASK).path("/").path(id).path(RestURLConstants.REST_API_URI_ASSIGNEE).build();
		logger.debug("Before calling Set assignee REST :"+uriComponents.toUriString());
		restTemplate.postForLocation(uriComponents.toUri(), setAssigneeRequest);
		
	}

	@Override
	public void claimtask(TaskSetAssigneeRequest claimRequest, String id) {
		UriComponents uriComponents=UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_COMMON_ENDPOINT).path(RestURLConstants.REST_API_URI_TASK).path("/").path(id).path(RestURLConstants.REST_API_URI_CLAIM).build();
		logger.debug("Before calling claimtask REST :"+uriComponents.toUriString());
		restTemplate.postForLocation(uriComponents.toUri(), claimRequest);
				
	}

	@Override
	public void unClaimtask(String id) {
		UriComponents uriComponents=UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_COMMON_ENDPOINT).path(RestURLConstants.REST_API_URI_TASK).path("/").path(id).path(RestURLConstants.REST_API_URI_UNCLAIM).build();
		logger.debug("Before calling unClaimtask REST :"+uriComponents.toUriString());
		restTemplate.postForLocation(uriComponents.toUri(), Object.class);
	}

	@Override
	public void completeTask(CompleteTaskRequest completeTaskRequest,
			String id) {
		UriComponents uriComponents=UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_COMMON_ENDPOINT).path(RestURLConstants.REST_API_URI_TASK).path("/").path(id).path(RestURLConstants.REST_API_URI_TASK_COMPLETE).build();
		logger.debug("Before calling compleateTask REST :"+uriComponents.toUriString());
		restTemplate.postForObject(uriComponents.toUri(), completeTaskRequest,Object.class);
	}
	
	@Override
	public List<TaskResponse> getCurrentActiveTask(String processInstanceId) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_TASK_CURRENT_ACTIVE_TASK).path("/").queryParam("processInstanceId", processInstanceId).build();
		logger.debug("Before calling REST for getCurrentActiveTask: "+uriComponents.toUriString());
		TaskResponse[] taskArray = restTemplate.getForObject(uriComponents.toUri(), TaskResponse[].class);
		logger.debug(taskArray.toString());
		return Arrays.asList(taskArray);
	}
	
	@Override
	public String submitTaskWithForm(TaskFormRequest request,String taskId) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_TASK_LIST).path("/").path(taskId).path(RestURLConstants.REST_API_URI_TASK_SUBMIT_FORM).build();
		logger.debug("Before calling TASK with form REST: URI-"+uriComponents.toUriString()+"Payload-"+request.toString());
		String status = restTemplate.postForObject(uriComponents.toUri(),request,String.class);
		logger.debug("After calling task REST:"+status);
		return status;
	}
	
	@Override
    public TaskResponse getTaskById(String taskId) {
           UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_TASK_LIST).path("/").path(taskId).build();
           logger.debug("Before calling REST for TaskByID: "+uriComponents.toUriString());
           TaskResponse task=restTemplate.getForObject(uriComponents.toUri(), TaskResponse.class);
           logger.debug(task.toString());
           System.out.println(task.toString());
           return task;
    }

	
}
