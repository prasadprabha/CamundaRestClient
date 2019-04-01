package com.level3.rest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentResponse {
	
	  private String id;

	    private String deploymentTime;

	    private String name;
	    
	    private List<Link> links;
	    
	    private String source;
	    

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getDeploymentTime ()
	    {
	        return deploymentTime;
	    }

	    public void setDeploymentTime (String deploymentTime)
	    {
	        this.deploymentTime = deploymentTime;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }
	    
		public List<Link> getLinks() {
			return links;
		}

		public void setLinks(List<Link> links) {
			this.links = links;
		}

		

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		@Override
	    public String toString()
	    {
	        return "DeploymentResponse [id = "+id+", deploymentTime = "+deploymentTime+", name = "+name+"]";
	    }


}
