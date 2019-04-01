package com.level3.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueInfo {
	private String objectTypeName;
	private String serializationDataFormat;
	
	public String getObjectTypeName() {
		return objectTypeName;
	}
	public void setObjectTypeName(String objectTypeName) {
		this.objectTypeName = objectTypeName;
	}
	public String getSerializationDataFormat() {
		return serializationDataFormat;
	}
	public void setSerializationDataFormat(String serializationDataFormat) {
		this.serializationDataFormat = serializationDataFormat;
	}
	
    

}
