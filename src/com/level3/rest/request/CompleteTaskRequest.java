package com.level3.rest.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompleteTaskRequest
{
    private CompleateTaskRequestVariable variables;

    

    public CompleateTaskRequestVariable getVariables() {
		return variables;
	}



	public void setVariables(CompleateTaskRequestVariable variables) {
		this.variables = variables;
	}



	@Override
    public String toString()
    {
        return "CompleateTaskRequest [variables = "+variables+"]";
    }
}
