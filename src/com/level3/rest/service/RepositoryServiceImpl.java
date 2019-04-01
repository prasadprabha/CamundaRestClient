package com.level3.rest.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.level3.rest.dao.RepositoryDao;
import com.level3.rest.request.DeploymentRequest;
import com.level3.rest.response.DeploymentResponse;

public class RepositoryServiceImpl implements RepositoryService{
	
	public static final Logger logger=Logger.getLogger(ProcessServiceImpl.class);

	@Autowired
	private RepositoryDao repositoryDao;

	@Override
	public List<DeploymentResponse> getDeployments() {
		logger.debug("calling getDeployments");
		return repositoryDao.getDeployments();

	}

	@Override
	public DeploymentResponse deployProcess(DeploymentRequest deploymentRequest) {
		logger.debug("calling deployProcess");
		return repositoryDao.deployProcess(deploymentRequest);
	}
	
	@Override
	public String unDeploy(String deploymentId) {
		logger.debug("Calling unDeployment in Repository DAo");
		return repositoryDao.unDeploy(deploymentId);
	}
}

