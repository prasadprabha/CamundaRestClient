package com.level3.rest.request;

public class StartInstructions {
	private String activityId;
	private String transitionId;

    private String type;

    private InstructionVariables variables;

    public String getActivityId ()
    {
        return activityId;
    }

    public void setActivityId (String activityId)
    {
        this.activityId = activityId;
    }
    
    

    public String getTransitionId() {
		return transitionId;
	}

	public void setTransitionId(String transitionId) {
		this.transitionId = transitionId;
	}

	public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    

    public InstructionVariables getVariables() {
		return variables;
	}

	public void setVariables(InstructionVariables variables) {
		this.variables = variables;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [activityId = "+activityId+", type = "+type+", variables = "+variables+"]";
    }


}
