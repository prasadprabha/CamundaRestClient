package com.level3.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskCountResponse
{

		private String count;

	

		public String getCount() {
			return count;
		}



		public void setCount(String count) {
			this.count = count;
		}



		@Override
	    public String toString()
	    {
			    return "Task count Response :"+ this.count;
	    }


}
