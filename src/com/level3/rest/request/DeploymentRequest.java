package com.level3.rest.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentRequest {
	private String deploymentName;
	private String enableDuplicateFiltering;
	private String deployChangedOnly;
	private String deploymentSource;
	private List<String> resourceFiles;
	
	public String getDeploymentName() {
		return deploymentName;
	}
	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}
	public String getEnableDuplicateFiltering() {
		return enableDuplicateFiltering;
	}
	public void setEnableDuplicateFiltering(String enableDuplicateFiltering) {
		this.enableDuplicateFiltering = enableDuplicateFiltering;
	}
	public String getDeployChangedOnly() {
		return deployChangedOnly;
	}
	public void setDeployChangedOnly(String deployChangedOnly) {
		this.deployChangedOnly = deployChangedOnly;
	}
	
	public String getDeploymentSource() {
		return deploymentSource;
	}
	public void setDeploymentSource(String deploymentSource) {
		this.deploymentSource = deploymentSource;
	}
	public List<String> getResourceFiles() {
		return resourceFiles;
	}
	public void setResourceFiles(List<String> resourceFiles) {
		this.resourceFiles = resourceFiles;
	}
	

}
