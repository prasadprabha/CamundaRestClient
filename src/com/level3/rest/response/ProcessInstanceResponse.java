package com.level3.rest.response;

public class ProcessInstanceResponse
{
    private String id;

    private String caseInstanceId;

    private String businessKey;

    private String[] links;

    private String ended;

    private String suspended;

    private String definitionId;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getCaseInstanceId ()
    {
        return caseInstanceId;
    }

    public void setCaseInstanceId (String caseInstanceId)
    {
        this.caseInstanceId = caseInstanceId;
    }

    public String getBusinessKey ()
    {
        return businessKey;
    }

    public void setBusinessKey (String businessKey)
    {
        this.businessKey = businessKey;
    }

    public String[] getLinks ()
    {
        return links;
    }

    public void setLinks (String[] links)
    {
        this.links = links;
    }

    public String getEnded ()
    {
        return ended;
    }

    public void setEnded (String ended)
    {
        this.ended = ended;
    }

    public String getSuspended ()
    {
        return suspended;
    }

    public void setSuspended (String suspended)
    {
        this.suspended = suspended;
    }

    public String getDefinitionId ()
    {
        return definitionId;
    }

    public void setDefinitionId (String definitionId)
    {
        this.definitionId = definitionId;
    }

    @Override
    public String toString()
    {
        return "ProcessInstance    : [id = "+id+", caseInstanceId = "+caseInstanceId+", businessKey = "+businessKey+", links = "+links+", ended = "+ended+", suspended = "+suspended+", definitionId = "+definitionId+"]";
    }
}