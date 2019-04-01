package com.level3.rest.dao;

import java.util.List;

import com.level3.rest.request.ActivateOrSuspendProcessDefByIdRequest;
import com.level3.rest.request.StartProcessRequest;
import com.level3.rest.request.StartProcessWithFormRequest;
import com.level3.rest.response.PIStatisticsResponse;
import com.level3.rest.response.ProcessDefinitionResponse;
import com.level3.rest.response.ProcessInstanceResponse;
import com.level3.rest.response.StartProcessResponse;
import com.level3.rest.response.StartProcessWithFormResponse;

public interface ProcessDao {
	
	public List<ProcessDefinitionResponse> getProcessDefinitions();
	public StartProcessResponse startProcess(StartProcessRequest startProcessRequest,String id);
	public List<PIStatisticsResponse> getProcessInstanceStatistics(Boolean failedJobs,Boolean incidents);
	public void activateorSuspendProcessById(ActivateOrSuspendProcessDefByIdRequest suspendProcessDefByIdRequest,String id);
	public StartProcessWithFormResponse startProcessWithForm(StartProcessWithFormRequest request,String processDefinitionId);
	public List<ProcessInstanceResponse> getProcessInstances(String processDefinitionId);
	
}
