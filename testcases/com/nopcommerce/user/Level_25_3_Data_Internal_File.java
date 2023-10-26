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

@Epic("Account")
@Feature("Create Account")
public class Level_25_3_Data_Internal_File extends BaseTest {

	private WebDriver driver;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String emailAddress;
	
	
	private String userUrl = GlobalConstants.DEV_USER_URL;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		emailAddress = data.nopCommerce.Account_Internal.Register.PRE_EMAIL_ADDRESS + getNumberRandom() + data.nopCommerce.Account_Internal.Register.WEB_EMAIL_SERVER;
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
		registerPage.enterToFirstNameTextbox(data.nopCommerce.Account_Internal.Register.FIRST_NAME);
		
		registerPage.enterToLastNameTextbox(data.nopCommerce.Account_Internal.Register.LAST_NAME);
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPasswordTextbox(data.nopCommerce.Account_Internal.Register.PASSWORD);
		
		registerPage.enterToConfirmPasswordTextbox(data.nopCommerce.Account_Internal.Register.PASSWORD);
	
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
	}
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
