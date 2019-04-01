package com.level3.rest.dao;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.level3.rest.constants.RestURLConstants;
import com.level3.rest.request.ActivateOrSuspendProcessDefByIdRequest;
import com.level3.rest.request.StartProcessRequest;
import com.level3.rest.request.StartProcessWithFormRequest;
import com.level3.rest.response.PIStatisticsResponse;
import com.level3.rest.response.ProcessDefinitionResponse;
import com.level3.rest.response.ProcessInstanceResponse;
import com.level3.rest.response.StartProcessResponse;
import com.level3.rest.response.StartProcessWithFormResponse;
import com.level3.rest.service.ProcessServiceImpl;

public class ProcessDaoRestImpl implements ProcessDao{
	
	public static final Logger logger=Logger.getLogger(ProcessServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<ProcessDefinitionResponse> getProcessDefinitions() {
		ProcessDefinitionResponse[] definitionResponses=restTemplate.getForObject(RestURLConstants.REST_API_URI_PROCESS_DEFINITIONS, ProcessDefinitionResponse[].class);
		for(ProcessDefinitionResponse definitionResponse: definitionResponses) {
			logger.debug("After calling getProcessDefinitions REST:"+ definitionResponse.toString());
		}
		return Arrays.asList(definitionResponses);

	}
	
	@Override
	public List<ProcessInstanceResponse> getProcessInstances(String processDefinitionId) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_GET_PROCESS_INSTANCE).path("/").queryParam("processDefinitionId", processDefinitionId).build();
		ProcessInstanceResponse[] instanceResponses=restTemplate.getForObject(uriComponents.toUri(), ProcessInstanceResponse[].class);
		for(ProcessInstanceResponse instanceResponse: instanceResponses) {
			logger.debug("After calling getProcessDefinitions REST:"+ instanceResponse.toString());
		}
		return Arrays.asList(instanceResponses);

	}

	@Override
	public StartProcessResponse startProcess(
			StartProcessRequest startProcessRequest,String id) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_PROCESS_DEFINITIONS).path("/").path(id).path(RestURLConstants.REST_API_URI_START_PROCESS).build();
		logger.debug("Before calling startProcess REST: URI-"+uriComponents.toUriString()+"Payload-"+startProcessRequest.toString());
		StartProcessResponse startProcessResponse=restTemplate.postForObject(uriComponents.toUri(),startProcessRequest,StartProcessResponse.class);
		logger.debug("After calling startProcess REST:"+startProcessResponse.toString());
		System.out.println("PROCESS HAS STARTED");
		return startProcessResponse;
	}
	
	@Override
	public StartProcessWithFormResponse startProcessWithForm(StartProcessWithFormRequest request,String processDefinitionId) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_PROCESS_DEFINITIONS).path("/").path(processDefinitionId).path(RestURLConstants.REST_API_URI_START_PROCESS_WITH_FORM).build();
		logger.debug("Before calling startProcess with form REST: URI-"+uriComponents.toUriString()+"Payload-"+request.toString());
		StartProcessWithFormResponse startProcessWithResponse = restTemplate.postForObject(uriComponents.toUri(),request,StartProcessWithFormResponse.class);
		logger.debug("After calling startProcess REST:"+startProcessWithResponse.toString());
		return startProcessWithResponse;
	}

	@Override
	public List<PIStatisticsResponse> getProcessInstanceStatistics(
			Boolean failedJobs, Boolean incidents) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_PROCESS_DEFINITIONS).queryParam("failedJobs", failedJobs).
				queryParam("incidents", incidents).build();
		logger.debug("Before calling getProcessInstanceStatistics REST: URI-"+uriComponents.toUriString()+"Payload-"+uriComponents.toUriString());
		PIStatisticsResponse[] piStatisticsResponse=restTemplate.getForObject(uriComponents.toUri(), PIStatisticsResponse[].class);
		logger.debug("After calling getProcessInstanceStatistics REST :"+piStatisticsResponse.toString());
		return Arrays.asList(piStatisticsResponse);
	}

	@Override
	public void activateorSuspendProcessById(ActivateOrSuspendProcessDefByIdRequest suspendProcessDefByIdRequest,String id) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_PROCESS_DEFINITIONS).path("/").path(id).path(RestURLConstants.REST_API_URI_PROCESS_DEFINITION_SUSPEND).build();
		logger.debug("Before calling activateorSuspendProcessById REST:"+uriComponents.toString());
		restTemplate.put(uriComponents.toUri(), suspendProcessDefByIdRequest);
	}

}
