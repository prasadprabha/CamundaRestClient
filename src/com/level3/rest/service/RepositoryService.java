package com.level3.rest.service;

import java.util.List;

import com.level3.rest.request.DeploymentRequest;
import com.level3.rest.response.DeploymentResponse;

public interface RepositoryService {
	
	/*
	 * Retrieves all deployments 
	 */
	public List<DeploymentResponse> getDeployments();
	
	/*
	 * Create a deployment.This method will upload BPMN2 file to running system.
	 */
	public DeploymentResponse deployProcess(DeploymentRequest deploymentRequest);
	
	public String unDeploy(String deploymentId);

}
