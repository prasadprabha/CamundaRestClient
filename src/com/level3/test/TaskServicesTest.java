package com.level3.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.level3.rest.configuration.AppConfig;
import com.level3.rest.request.CompleteTaskRequest;

import com.level3.rest.request.CreateTaskRequest;
import com.level3.rest.request.TaskFormRequest;
import com.level3.rest.request.TaskSetAssigneeRequest;
import com.level3.rest.response.TaskResponse;
import com.level3.rest.service.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class TaskServicesTest {
	
	@Autowired
	private TaskService taskService;
	
	@Test
	public void testGetTaskList(){
		assertNotNull(taskService.getTaskList());
	}
	
	@Test
	public void testGetTaskByAssignee(){
		assertNotNull(taskService.getTaskByAssignee("john"));
	}
/*=============================================================================================*/	
	/*This will give you the current active task for the processInstance*/
	@Test
	public void testCurrentActiveTask() {
		String processInstanceId = "03950874-2bf1-11e6-b980-f44d305481eb";
		List<TaskResponse> tasks = taskService.getCurrentActiveTask(processInstanceId.trim());
		assertNotNull(tasks);
		for(TaskResponse task : tasks) {
			System.out.println("HERE IS THE CURRENT ACTIVE TASK :");
			System.out.println("TASK ID : " + task.getId());
			System.out.println(task);
		}
		
	}
	
	@Test
	public void testSetAssignee(){
		TaskSetAssigneeRequest setAssigneeRequest=new TaskSetAssigneeRequest();
		setAssigneeRequest.setUserId("brian");
		String taskId = "620c3b4b-2be6-11e6-bbc3-f44d305481eb";
		taskService.setAssignee(setAssigneeRequest,taskId);
	//	testGetTaskById(taskId);
	}
	
	@Test
	public void testCompleteTask(){
		CompleteTaskRequest completeTaskRequest=new CompleteTaskRequest();
		String taskId = "620c3b4b-2be6-11e6-bbc3-f44d305481eb";
		taskService.completeTask(completeTaskRequest, taskId);
	}
	
	@Test
	public void testGetTaskById(){
           String taskId="620c3b4b-2be6-11e6-bbc3-f44d305481eb";
           System.out.println("HERE IS THE TASK DETAILS");
           assertNotNull(taskService.getTaskById(taskId));
    }
    
	
	@Test
	public void testClaimtask(){
		TaskSetAssigneeRequest claimRequest=new TaskSetAssigneeRequest();
		String claimer = "peter";
		String taskId = "f73df96d-28c9-11e6-8626-a41f7268d598";
		claimRequest.setUserId(claimer);
		taskService.claimtask(claimRequest, taskId);
	}
	
	
	


	
/*=============================================================================================*/	
	
	@Test
	public void testSubmitTaskForm() {
		TaskFormRequest request = new TaskFormRequest();
		String taskId = "";
		taskService.submitTaskWithForm(request, taskId);
	}
	
	@Test
	public void testCreateTask(){
		CreateTaskRequest createTaskReq = new CreateTaskRequest();
		createTaskReq.setAssignee("john");
		createTaskReq.setId("123ABCD8E");
		createTaskReq.setName("Webservice Task new");
		createTaskReq.setDescription("This is a sample task");
		createTaskReq.setOwner("peter");
		createTaskReq.setPriority("30");
		taskService.createTask(createTaskReq);
	}
	
	

	
	@Test
	public void testUnClaimtask(){
		taskService.unClaimtask("123ABCDE");
	}
	
	

}
