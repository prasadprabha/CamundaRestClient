package com.level3.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompleateTaskRequestaVariable {
	 private ValueInfo valueInfo;

	    private Object value;

	    private String type;

	    public ValueInfo getValueInfo ()
	    {
	        return valueInfo;
	    }

	    public void setValueInfo (ValueInfo valueInfo)
	    {
	        this.valueInfo = valueInfo;
	    }

	    public Object getValue ()
	    {
	        return value;
	    }

	    public void setValue (Object value)
	    {
	        this.value = value;
	    }

	    public String getType ()
	    {
	        return type;
	    }

	    public void setType (String type)
	    {
	        this.type = type;
	    }

	    @Override
	    public String toString()
	    {
	        return "CompleateTaskRequestProcess [valueInfo = "+valueInfo+", value = "+value+", type = "+type+"]";
	    }

}
