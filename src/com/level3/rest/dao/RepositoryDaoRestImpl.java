package com.level3.rest.dao;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.level3.rest.constants.RestURLConstants;
import com.level3.rest.request.DeploymentRequest;
import com.level3.rest.response.DeploymentResponse;
import com.level3.rest.response.ProcessDefinitionResponse;
import com.level3.rest.service.ProcessServiceImpl;
import com.level3.rest.util.CamundaClientRestUtils;

public class RepositoryDaoRestImpl implements RepositoryDao{
	public static final Logger logger=Logger.getLogger(ProcessServiceImpl.class);


	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<DeploymentResponse> getDeployments() {
		logger.debug("Before calling getDeployments REST:"+RestURLConstants.REST_API_URI_GET_DEPLOYMENTS);
		DeploymentResponse[] deployments=restTemplate.getForObject(RestURLConstants.REST_API_URI_GET_DEPLOYMENTS, DeploymentResponse[].class);
		for(DeploymentResponse response : deployments) {
			System.out.println(response.toString());
			logger.info("After calling getDeployments REST:"+response);
		}
		
		logger.debug("After calling getDeployments REST:"+deployments.toString());
		return Arrays.asList(deployments);
	}

	@Override
	public DeploymentResponse deployProcess(DeploymentRequest deploymentRequest) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("deployment-name", deploymentRequest.getDeploymentName());
		map.add("enable-duplicate-filtering", deploymentRequest.getEnableDuplicateFiltering());
		map.add("deploy-changed-only", deploymentRequest.getDeployChangedOnly());
		map.add("deployment-source", deploymentRequest.getDeploymentSource());
		List<String> resourceFiles=deploymentRequest.getResourceFiles();
		addResourceFiles(map, resourceFiles);
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new    HttpEntity<LinkedMultiValueMap<String, Object>>(
				map, headers);
		logger.debug("Before calling deployProcess REST: URI-"+RestURLConstants.REST_API_URI_DO_DEPLOYMENT+"payload-"+requestEntity.toString());
		ResponseEntity<DeploymentResponse> s=restTemplate.exchange(RestURLConstants.REST_API_URI_DO_DEPLOYMENT,HttpMethod.POST,requestEntity,DeploymentResponse.class);
		DeploymentResponse deployment=s.getBody();
		logger.debug("After calling deployProcess REST: Response code"+s.getStatusCode()+"Response Payload-"+deployment.toString());
		return deployment;
	}
	
	@Override
	public String unDeploy(String deploymentId) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(RestURLConstants.REST_API_URI_UNDEPLOY).path("/").path(deploymentId).queryParam("cascade", "true").build();
		restTemplate.delete(uriComponents.toUri());
		return "success";
	}

	private void addResourceFiles(LinkedMultiValueMap<String, Object> map,
			List<String> resourceFiles) {
		for (String resource : resourceFiles) {
			File resourceFile=new File(resource);
			final String fileName = resourceFile.getName();
			ByteArrayResource contentsAsResource = new ByteArrayResource(CamundaClientRestUtils.getBytes(resourceFile.getAbsolutePath())){
				@Override
				public String getFilename(){
					return fileName;
				}
			};
			map.add(resourceFile.getName(), contentsAsResource);
		}
	}


}
