package com.level3.rest.request;

public class InstructionVar {
	private String value;

    private String local;

    private String type;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getLocal ()
    {
        return local;
    }

    public void setLocal (String local)
    {
        this.local = local;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }


}
