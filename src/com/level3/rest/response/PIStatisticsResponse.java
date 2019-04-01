package com.level3.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PIStatisticsResponse {

    private Incidents[] incidents;

    private String id;

    private ProcessDefinitionResponse definition;

    private String failedJobs;

    private String instances;

    public Incidents[] getIncidents ()
    {
        return incidents;
    }

    public void setIncidents (Incidents[] incidents)
    {
        this.incidents = incidents;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public ProcessDefinitionResponse getDefinition ()
    {
        return definition;
    }

    public void setDefinition (ProcessDefinitionResponse definition)
    {
        this.definition = definition;
    }

    public String getFailedJobs ()
    {
        return failedJobs;
    }

    public void setFailedJobs (String failedJobs)
    {
        this.failedJobs = failedJobs;
    }

    public String getInstances ()
    {
        return instances;
    }

    public void setInstances (String instances)
    {
        this.instances = instances;
    }

    @Override
    public String toString()
    {
        return "PIStatisticsResponse [incidents = "+incidents+", id = "+id+", definition = "+definition+", failedJobs = "+failedJobs+", instances = "+instances+"]";
    }

}
