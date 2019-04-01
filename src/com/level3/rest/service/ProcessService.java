package com.level3.rest.service;

import java.util.List;

import com.level3.rest.request.ActivateOrSuspendProcessDefByIdRequest;
import com.level3.rest.request.StartProcessRequest;
import com.level3.rest.request.StartProcessWithFormRequest;
import com.level3.rest.response.PIStatisticsResponse;
import com.level3.rest.response.ProcessDefinitionResponse;
import com.level3.rest.response.ProcessInstanceResponse;
import com.level3.rest.response.StartProcessResponse;
import com.level3.rest.response.StartProcessWithFormResponse;

import org.apache.log4j.Logger;

public interface ProcessService {
	
	public static final Logger logger=Logger.getLogger(ProcessService.class);
	
	
	//Query for process definitions that fulfill given parameters. Parameters may be the properties of process definitions, such as the name, key or version
	public List<ProcessDefinitionResponse> getProcessDefinitions();
	
	
	//Instantiates a given process definition. Process variables and business key may be supplied in the request body.
	public StartProcessResponse startProcess(StartProcessRequest startProcessRequest,String id);
	
	/* Retrieves runtime statistics of a given process definition grouped by activities. This does not include historic data.
	 * in getProcessInstanceStatistics API query parameters String incidentsForType and Boolean incidents are exclusive. either one only used at the time.
	 */
	public List<PIStatisticsResponse> getProcessInstanceStatistics(Boolean failedJobs,Boolean incidents);
	
	
	/*Activate or suspend a given process definition by id or by latest version of process definition key.
	 * in suspendProcessDefByIdRequest.suspended: When the value is set to true, the given process definition will be suspended and when the value is set to false, the given process definition will be activated.
	 */
	public void activateorSuspendProcessById(ActivateOrSuspendProcessDefByIdRequest suspendProcessDefByIdRequest ,String id); 
	
	
	
	public StartProcessWithFormResponse startProcessWithForm(StartProcessWithFormRequest request,String processDefinitionId);
	
	public List<ProcessInstanceResponse> getProcessInstances(String processDefinitionId);
	

}
