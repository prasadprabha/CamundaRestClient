package com.level3.rest.dao;

import java.util.List;

import com.level3.rest.request.DeploymentRequest;
import com.level3.rest.response.DeploymentResponse;

public interface RepositoryDao {
	public List<DeploymentResponse> getDeployments();
	public DeploymentResponse deployProcess(DeploymentRequest deploymentRequest);
	public String unDeploy(String deploymentId);

}
