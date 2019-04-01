package com.level3.test;


import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.level3.rest.configuration.AppConfig;
import com.level3.rest.request.DeploymentRequest;
import com.level3.rest.service.RepositoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class RepositoryServicesTest {
	
	@Autowired 
	RepositoryService repositoryService;
	
	@Test
	public void testGetDeployments(){
		assertNotNull(repositoryService.getDeployments());
	}
	
	@Test
	public void testUnDeploy() {
		String deploymentId = "915daf62-2be5-11e6-bbc3-f44d305481eb";
		repositoryService.unDeploy(deploymentId.trim());
	}
	
	@Test
	public void testDeployProcess(){
		DeploymentRequest deploymentRequest=new DeploymentRequest();
		deploymentRequest.setDeployChangedOnly("false");
		deploymentRequest.setDeploymentName("myDeployment_1");
		deploymentRequest.setEnableDuplicateFiltering("true");
		List<String> arguments=new ArrayList<String>();
		arguments.add("C:\\Users\\prasad.suseela\\Desktop\\process_flow_example.bpmn");
		deploymentRequest.setResourceFiles(arguments);
		assertNotNull(repositoryService.deployProcess(deploymentRequest));
	}
	

}
