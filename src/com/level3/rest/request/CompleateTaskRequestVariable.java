package com.level3.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompleateTaskRequestVariable {
	private CompleateTaskRequestaVariable aVariable;
	private CompleateTaskRequestaVariable aVariable1;

	public CompleateTaskRequestaVariable getaVariable() {
		return aVariable;
	}

	public void setaVariable(CompleateTaskRequestaVariable aVariable) {
		this.aVariable = aVariable;
	}

	public CompleateTaskRequestaVariable getaVariable1() {
		return aVariable1;
	}

	public void setaVariable1(CompleateTaskRequestaVariable aVariable1) {
		this.aVariable1 = aVariable1;
	}
	
	
	


}
