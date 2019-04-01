package com.level3.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Incidents {
    private String incidentCount;

    private String incidentType;

    public String getIncidentCount ()
    {
        return incidentCount;
    }

    public void setIncidentCount (String incidentCount)
    {
        this.incidentCount = incidentCount;
    }

    public String getIncidentType ()
    {
        return incidentType;
    }

    public void setIncidentType (String incidentType)
    {
        this.incidentType = incidentType;
    }

}
