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

public class Level_15_Assert_Verify extends BaseTest {

	private WebDriver driver;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProductPage;
	private AddressesPageObject addressesPage;
	
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
		//verify register link isdisplayed => Failed
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		//Verify error msg at Firstname textbox => Passed
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		//Verify error msg at LastName textbox => Failed
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		//Verify success msg => Failed
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
		
	}
	
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
