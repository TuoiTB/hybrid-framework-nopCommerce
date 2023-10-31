package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pageObjects.users.HomePageObject;
import pageObjects.users.PageGeneratorManager;
import pageObjects.users.RegisterPageObject;
import utitlities.DataFaker;

@Epic("Account")
@Feature("Create Account")
public class Level_25_4_Data_External_File_Exel extends BaseTest {

	private WebDriver driver;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	DataFaker faker;
	private String firstName;
	private String lastName;
	private String password;
	private String emailAddress;
	
	
	private String userUrl = GlobalConstants.DEV_USER_URL;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		faker = DataFaker.getDataFaker();
		firstName = faker.getFirstName();
		lastName = faker.getLastName();
		password = faker.getPassword();
		emailAddress = faker.getEmailAddress();
	}
	
	@Description("User_01_Validate register form")
	@Story("Register")
	@Test
	public void User_01_Validate_Register() {
		
		
		Assert.assertTrue(homePage.isRegisterLinkDisplayed());
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		
	}
	
	@Test
	public void User_02_Register_Success() {
		
		registerPage.refreshCurrentPage(driver);
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextbox(firstName);
		
		registerPage.enterToLastNameTextbox(lastName);
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPasswordTextbox(password);
		
		registerPage.enterToConfirmPasswordTextbox(password);
	
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
	}
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
