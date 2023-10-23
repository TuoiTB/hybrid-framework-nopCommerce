package utitlities;

import com.github.javafaker.Faker;

public class DataFaker {
	Faker faker;
	public DataFaker() {
		faker = new Faker();
	}
	
	public static DataFaker getDataFaker() {
		return new DataFaker();
	}
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getCityName() {
		return faker.address().cityName();
	}
	
	public String getStateName() {
		return faker.address().state();
	}
	
	public String getZipCode() {
		return faker.address().zipCode();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
	
	
}
