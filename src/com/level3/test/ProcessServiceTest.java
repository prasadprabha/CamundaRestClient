package com.level3.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.level3.rest.configuration.AppConfig;
import com.level3.rest.request.ActivateOrSuspendProcessDefByIdRequest;
import com.level3.rest.request.StartProcessRequest;
import com.level3.rest.request.StartProcessWithFormRequest;
import com.level3.rest.response.Link;
import com.level3.rest.response.ProcessDefinitionResponse;
import com.level3.rest.response.ProcessInstanceResponse;
import com.level3.rest.response.StartProcessResponse;
import com.level3.rest.response.StartProcessWithFormResponse;
import com.level3.rest.service.ProcessService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class ProcessServiceTest {
	
	@Autowired
	private ProcessService processService;
	
	@Autowired
	private Environment env;
/*=======================================================================*/	
	@Test
	public void testGetProcessDefinitions(){
		List<ProcessDefinitionResponse> processDefinitionResponses = processService.getProcessDefinitions();
		assertNotNull(processService.getProcessDefinitions());
		for (ProcessDefinitionResponse response : processDefinitionResponses) {
			System.out.println(response);
			String dbUrl = env.getProperty("bpm.env");
			System.out.println("DB URL : "+dbUrl);
		}
		
	}
	
	@Test
	public void testStartProcess(){
		StartProcessRequest startProcessRequest=new StartProcessRequest();
		String processDefinitionId = "id_flow_example:1:9d6b77f3-2bf0-11e6-b980-f44d305481eb";
		StartProcessResponse response = processService.startProcess(startProcessRequest, processDefinitionId.trim());
		assertNotNull(response);
		System.out.println("=======" + response +"");
		for(Link link : response.getLinks()) {
			System.out.println(link);
		}
	}
	
	
	@Test
	public void testGetProcessInstances() {
		String processDefinitionId = "id_flow_example:1:9d6b77f3-2bf0-11e6-b980-f44d305481eb";
		List<ProcessInstanceResponse>  processInstances = processService.getProcessInstances(processDefinitionId);
		for(ProcessInstanceResponse response : processInstances){
			System.out.println(response);
			
		}
	}
	/*=======================================================================*/		

	@Test
	public void testStartProcessWithForm() {
		StartProcessWithFormRequest startProcessWithFormRequest = new StartProcessWithFormRequest();
		startProcessWithFormRequest.setBusinessKey(null);
		Map<String, HashMap<String, String>> variableMap  = startProcessWithFormRequest.getVariables();
		HashMap<String,String> value = new HashMap<String,String>();
		value.put("value", "Prasad");
		value.put("type", "String");
		variableMap.put("creditor", value);
		
		HashMap<String,String> value1 = new HashMap<String,String>();
		value1.put("value", "1000");
		value1.put("type", "Double");
		variableMap.put("amount", value1);
		
		HashMap<String,String> value2 = new HashMap<String,String>();
		value2.put("value", "P-1000");
		value2.put("type", "String");
		
		
		
		variableMap.put("invoiceNumber", value2);
		
		HashMap<String,String> value3 = new HashMap<String,String>();
		value3.put("value", "Travel Expenses");
		value3.put("type", "String");
		
		variableMap.put("invoiceCategory", value3);
		
		
		HashMap<String,String> value4 = new HashMap<String,String>();
		
		value4.put("value", "true");
		value4.put("type", "Boolean");
		variableMap.put("clarified", value4);
		
		String processDefinitionId = "BroadBandRequest_Process:1:89e09320-274d-11e6-b0f1-a41f7268d598";
		StartProcessWithFormResponse response = processService.startProcessWithForm(startProcessWithFormRequest, processDefinitionId);
		System.out.println(response);
	}
	
	@Test
	public void testGetProcessInstanceStatistics(){
		assertNotNull(processService.getProcessInstanceStatistics(false, false));
	}
	
	@Test
	public void testActivateorSuspendProcessById(){
		ActivateOrSuspendProcessDefByIdRequest suspendProcessDefByIdRequest=new ActivateOrSuspendProcessDefByIdRequest();
		suspendProcessDefByIdRequest.setExecutionDate("2016-05-25T16:00:45");
		suspendProcessDefByIdRequest.setIncludeProcessInstances("true");
		suspendProcessDefByIdRequest.setSuspended("true");
		processService.activateorSuspendProcessById(suspendProcessDefByIdRequest, "Process_2:1:cb455b93-225a-11e6-83fb-d43d7ec95f92");
	}

}
