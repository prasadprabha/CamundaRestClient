package com.level3.rest.request;

public class ActivateOrSuspendProcessDefByIdRequest {
	
	 private String includeProcessInstances;

	    private String executionDate;

	    private String suspended;

	    public String getIncludeProcessInstances ()
	    {
	        return includeProcessInstances;
	    }

	    public void setIncludeProcessInstances (String includeProcessInstances)
	    {
	        this.includeProcessInstances = includeProcessInstances;
	    }

	    public String getExecutionDate ()
	    {
	        return executionDate;
	    }

	    public void setExecutionDate (String executionDate)
	    {
	        this.executionDate = executionDate;
	    }

	    public String getSuspended ()
	    {
	        return suspended;
	    }

	    public void setSuspended (String suspended)
	    {
	        this.suspended = suspended;
	    }

	    @Override
	    public String toString()
	    {
	        return "ActivateOrSuspendProcessDefByIdRequest [includeProcessInstances = "+includeProcessInstances+", executionDate = "+executionDate+", suspended = "+suspended+"]";
	    }


}
