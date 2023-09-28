package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.users.HomePageObject;
import pageObjects.users.PageGeneratorManager;
import pageObjects.users.RegisterPageObject;

public class Level_21_Pattern_Object extends BaseTest {

	private WebDriver driver;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private pageObjects.users.LoginPageObject loginPage;
	
	private String firstName = "John";
	private String lastName = "Wick";
	private String password = "auto@123";
	private String emailAddress = getEmailRandom();
	
	private String userUrl = GlobalConstants.DEV_USER_URL;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}
	
	@Test
	public void User_01_Register_Empty_Data() {
		log.info("User_01 - Step 01: Click to Log Register link");
		homePage.clickToHeaderLinkByName("Register");
		registerPage =PageGeneratorManager.getRegisterPage(driver);
		
		log.info("User_01 - Step 02: Enter to First Name textbox");
		registerPage.enterToFirstNameTextbox(firstName);
		
		log.info("User_01 - Step 03: Enter to Last Name textbox");
		registerPage.enterToLastNameTextbox(lastName);
		
		log.info("User_01 - Step 04: Enter to Email textbox");
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("User_01 - Step 05: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("User_01 - Step 06: Enter to Confirm Password textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("User_01 - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01 - Step 08: Verify success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("User_01 - Step 09: Click to Log in link");
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("User_01 - Step 10: Enter to Email textbox");
		loginPage.enterToEmailTextbox(emailAddress);
		
		log.info("User_01 - Step 11: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(password);
		
		log.info("User_01 - Step 12: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("User_01 - Step 13: Click to Logout link");
		homePage.clickToHeaderLinkByName("Log out");
	}
	
	

	@AfterClass
	public void afterClass() {
		//quitBrowserDriver();
	}

}
