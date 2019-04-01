package com.level3.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StartProcessResponse {
	private String id;

    private String businessKey;

    private Link[] links;

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

    public String getBusinessKey ()
    {
        return businessKey;
    }

    public void setBusinessKey (String businessKey)
    {
        this.businessKey = businessKey;
    }


    public Link[] getLinks() {
		return links;
	}

	public void setLinks(Link[] links) {
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
        return "Process started : [ProcessInstance Id = "+id+", businessKey = "+businessKey+", links = "+links+", ended = "+ended+", suspended = "+suspended+", definitionId = "+definitionId+"]";
    }


}
