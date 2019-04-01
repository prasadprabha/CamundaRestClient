package com.level3.rest.request;


public class StartProcessRequest {
	
	  private StartInstructions[] startInstructions;

	    private String skipCustomListeners;

	    private String businessKey;

	    private Variables variables;

	    public StartInstructions[] getStartInstructions ()
	    {
	        return startInstructions;
	    }

	    public void setStartInstructions (StartInstructions[] startInstructions)
	    {
	        this.startInstructions = startInstructions;
	    }

	    public String getSkipCustomListeners ()
	    {
	        return skipCustomListeners;
	    }

	    public void setSkipCustomListeners (String skipCustomListeners)
	    {
	        this.skipCustomListeners = skipCustomListeners;
	    }

	    public String getBusinessKey ()
	    {
	        return businessKey;
	    }

	    public void setBusinessKey (String businessKey)
	    {
	        this.businessKey = businessKey;
	    }

	    public Variables getVariables ()
	    {
	        return variables;
	    }

	    public void setVariables (Variables variables)
	    {
	        this.variables = variables;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [startInstructions = "+startInstructions+", skipCustomListeners = "+skipCustomListeners+", businessKey = "+businessKey+", variables = "+variables+"]";
	    }


}

