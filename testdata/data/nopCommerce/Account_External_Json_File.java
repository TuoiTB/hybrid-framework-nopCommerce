package data.nopCommerce;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class Account_External_Json_File {
	public static Account_External_Json_File getAccountData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.DATA_PATH + "Account.json"), Account_External_Json_File .class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	static class Login{
		@JsonProperty("emailaddress")
		private String emailAddress;
		

		@JsonProperty("webemail")
		private String webEmailServer;
		
		@JsonProperty("password")
		private String password;
		
		@JsonProperty("firstname")
		private String firstName;
		
		@JsonProperty("lastname")
		private String lastName;
		
	}
	@JsonProperty("address")
	private String address;
	
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("Login")
	private Login login;
	
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getEmailAddress() {
		return login.emailAddress;
	}
	
	public String getWebEmailServer() {
		return login.webEmailServer;
	}
	public String getPassword() {
		return login.password;
	}
	
	public String getFirstName() {
		return login.firstName;
	}
	
	public String getLastName() {
		return login.lastName;
	}
	
	public String getFullName() {
		return login.firstName + " " + login.lastName;
	}
	
	
}
