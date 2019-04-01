package com.level3.rest.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.level3.rest.dao.RepositoryDao;
import com.level3.rest.dao.RepositoryDaoRestImpl;
import com.level3.rest.dao.IdentityManagementDao;
import com.level3.rest.dao.IdentityManagementRestDaoImpl;
import com.level3.rest.dao.ProcessDao;
import com.level3.rest.dao.ProcessDaoRestImpl;
import com.level3.rest.dao.TaskDao;
import com.level3.rest.dao.TaskDaoRestImpl;
import com.level3.rest.service.RepositoryService;
import com.level3.rest.service.RepositoryServiceImpl;
import com.level3.rest.service.IdentityManagementService;
import com.level3.rest.service.IdentityManagementServiceImpl;
import com.level3.rest.service.ProcessService;
import com.level3.rest.service.ProcessServiceImpl;
import com.level3.rest.service.TaskService;
import com.level3.rest.service.TaskServiceImpl;


@Configuration
@PropertySource("classpath:camunda.properties")
public class AppConfig {
	
    @Bean
    public TaskService taskService() {
        return new TaskServiceImpl();
    }
    
    @Bean TaskDao taskDao() {
    	return new TaskDaoRestImpl();
    }
    
    @Bean
    public ProcessService processService(){
    	return new ProcessServiceImpl();
    }
    
    @Bean ProcessDao processDao(){
    	return new ProcessDaoRestImpl();
    }
    
    @Bean
    public RepositoryService repositoryService(){
    	return new RepositoryServiceImpl();
    }
    
    @Bean
    public IdentityManagementService identityManagementService() {
    	return new IdentityManagementServiceImpl();
    }
    
    @Bean
    public IdentityManagementDao IdentityManagementDao() {
    	return new IdentityManagementRestDaoImpl();
    }
    
    @Bean
    public RepositoryDao repositoryDao(){
    	return new RepositoryDaoRestImpl();
    }
    @Bean 
    public RestTemplate restTemplate() {
    	RestTemplate template = new RestTemplate();
    	List<HttpMessageConverter<?>> messageConverters = 
				new ArrayList<HttpMessageConverter<?>> ();
    	messageConverters.add(new MappingJackson2HttpMessageConverter());
    	messageConverters.add(new org.springframework.http.converter.FormHttpMessageConverter());
    	messageConverters.add(new org.springframework.http.converter.ByteArrayHttpMessageConverter());
    	messageConverters.add(new org.springframework.http.converter.xml.SourceHttpMessageConverter());
    	messageConverters.add(new org.springframework.http.converter.StringHttpMessageConverter());
    	template.setMessageConverters(messageConverters);
    	return template;
    }
    
    @Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}