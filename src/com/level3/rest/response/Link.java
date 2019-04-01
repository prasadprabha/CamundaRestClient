package com.level3.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
	    private String method;

	    private String rel;

	    private String href;

	    public String getMethod ()
	    {
	        return method;
	    }

	    public void setMethod (String method)
	    {
	        this.method = method;
	    }

	    public String getRel ()
	    {
	        return rel;
	    }

	    public void setRel (String rel)
	    {
	        this.rel = rel;
	    }

	    public String getHref ()
	    {
	        return href;
	    }

	    public void setHref (String href)
	    {
	        this.href = href;
	    }
	    
	    @Override
	    public String toString()
	    {
	        return "Link [method = "+method+", rel = "+rel+", href = "+href+"]";
	    }

}
