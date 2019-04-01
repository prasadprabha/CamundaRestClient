package com.level3.rest.request;

public class CreateUserRequest
{
    public  Credentials credentials;

    public Profile profile;
    
    public CreateUserRequest(String userId,String password,String firstName,String lastName,String email) {
    	credentials = new Credentials();
    	profile = new Profile();
    	getProfile().setEmail(email);
    	getProfile().setFirstName(firstName);
    	getProfile().setLastName(lastName);
    	getProfile().setId(userId);
    	getCredentials().setPassword(password);
    }

    public Credentials getCredentials ()
    {
        return credentials;
    }

    public void setCredentials (Credentials credentials)
    {
        this.credentials = credentials;
    }

    public Profile getProfile ()
    {
        return profile;
    }

    public void setProfile (Profile profile)
    {
        this.profile = profile;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [credentials = "+credentials+", profile = "+profile+"]";
    }
    
    private class Profile {
    	private String id;
    	private String firstName;
    	private String lastName;
    	private String email;
    	
    	
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
    	
    }
    
    private class Credentials {
    	private String password;

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
    	
    }
}
