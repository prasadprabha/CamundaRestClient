package com.level3.rest.constants;

public class RestURLConstants {
	
	public final static String REST_API_COMMON_ENDPOINT="http://localhost:8080/engine-rest"; 
	
	//Task 
	public final static String REST_API_URI_GET_AUTHORIZATIONS = REST_API_COMMON_ENDPOINT+"/authorization";
	public final static String REST_API_URI_TASK = "/task";
	public final static String REST_API_URI_TASK_COUNT = REST_API_COMMON_ENDPOINT+REST_API_URI_TASK+"/count";
	public final static String REST_API_URI_TASK_LIST = REST_API_COMMON_ENDPOINT+REST_API_URI_TASK;
	public final static String REST_API_URI_TASK_CREATE = REST_API_COMMON_ENDPOINT+REST_API_URI_TASK+"/create";
	public final static String REST_API_URI_ASSIGNEE = "/assignee";
	public final static String REST_API_URI_CLAIM = "/claim";
	public final static String REST_API_URI_UNCLAIM = "/unclaim";
	public final static String REST_API_URI_TASK_COMPLETE= "/complete";
	public final static String REST_API_URI_TASK_SUBMIT_FORM= "/submit-form";
	public final static String REST_API_URI_TASK_CURRENT_ACTIVE_TASK = REST_API_COMMON_ENDPOINT+REST_API_URI_TASK;

	//Process
	public final static String REST_API_URI_PROCESS_DEFINITIONS = REST_API_COMMON_ENDPOINT+"/process-definition";
	public final static String REST_API_URI_START_PROCESS = "/start";
	public final static String REST_API_URI_PROCESS_DEFINITION_SUSPEND = "/suspended";
	public final static String REST_API_URI_START_PROCESS_WITH_FORM = "/submit-form";
	public final static String REST_API_URI_GET_PROCESS_INSTANCE = REST_API_COMMON_ENDPOINT+"/process-instance";
	
	//Deployment
	public final static String REST_API_URI_GET_DEPLOYMENTS = REST_API_COMMON_ENDPOINT+"/deployment";
	public final static String REST_API_URI_DO_DEPLOYMENT = REST_API_COMMON_ENDPOINT+"/deployment/create";
	public final static String REST_API_URI_UNDEPLOY = REST_API_COMMON_ENDPOINT+"/deployment";
	
	//Identity Management
	
	public final static String REST_API_URI_IDENTITY_MANAGEMENT_CREATE_GROUP = REST_API_COMMON_ENDPOINT + "/group/create";
	public final static String REST_API_URI_IDENTITY_MANAGEMENT_CREATE_USER = REST_API_COMMON_ENDPOINT +"/user/create";
	
	

}
