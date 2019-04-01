package com.level3.rest.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.level3.rest.dao.ProcessDao;
import com.level3.rest.request.ActivateOrSuspendProcessDefByIdRequest;
import com.level3.rest.request.StartProcessRequest;
import com.level3.rest.request.StartProcessWithFormRequest;
import com.level3.rest.response.PIStatisticsResponse;
import com.level3.rest.response.ProcessDefinitionResponse;
import com.level3.rest.response.ProcessInstanceResponse;
import com.level3.rest.response.StartProcessResponse;
import com.level3.rest.response.StartProcessWithFormResponse;

public class ProcessServiceImpl implements ProcessService{
	
	public static final Logger logger=Logger.getLogger(ProcessServiceImpl.class);

	
	@Autowired
	private ProcessDao processDao;
	
	@Override
	public List<ProcessDefinitionResponse> getProcessDefinitions(){
		logger.debug("calling getProcessDefinitions");
		return processDao.getProcessDefinitions();
	}

	@Override
	public List<ProcessInstanceResponse> getProcessInstances(String processDefinitionId) {
		return processDao.getProcessInstances(processDefinitionId);
	}
	

	@Override
	public List<PIStatisticsResponse> getProcessInstanceStatistics(
			Boolean failedJobs, Boolean incidents) {
		logger.debug("calling getProcessInstanceStatistics");
		return processDao.getProcessInstanceStatistics(failedJobs, incidents);
		
	}

	@Override
	public StartProcessResponse startProcess(
			StartProcessRequest startProcessRequest, String id) {
		logger.debug("calling startProcess");
		return processDao.startProcess(startProcessRequest, id);

}


	@Override
	public void activateorSuspendProcessById(ActivateOrSuspendProcessDefByIdRequest suspendProcessDefByIdRequest,String id) {
		logger.debug("calling activateorSuspendProcessById");

		processDao.activateorSuspendProcessById(suspendProcessDefByIdRequest, id);
	}
	
	@Override
	public StartProcessWithFormResponse startProcessWithForm(StartProcessWithFormRequest request,String processDefinitionId) {
		return processDao.startProcessWithForm(request, processDefinitionId);
	}
}
