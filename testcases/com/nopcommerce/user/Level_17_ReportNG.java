package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.admin.AdminDashBoardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.PageGeneratorManager;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

public class Level_17_ReportNG extends BaseTest {
	//ReportNG đã lỗi thời nên không dùng tới, nếu cần thì xem lại video topic 71

	private WebDriver driver;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	
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
	public void User_01_Register() {
		log.info("User_01 - Step 01: Verify Register link isdisplayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		log.info("User_01 - Step 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("User_01 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01 - Step 04: Verify error message at Firs Name textbox");
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		log.info("User_01 - Step 05: Verify error message at Last Name textbox");
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		log.info("User_01 - Step 06: Enter to First Name textbox");
		registerPage.enterToFirstNameTextbox(firstName);
		
		log.info("User_01 - Step 07: Enter to Last Name textbox");
		registerPage.enterToLastNameTextbox(lastName);
		
		log.info("User_01 - Step 08: Enter to Email textbox");
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("User_01 - Step 09: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("User_01 - Step 10: Enter to Confirm Password textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("User_01 - Step 11: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01 - Step 12: Verify success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
		
	}
	
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
