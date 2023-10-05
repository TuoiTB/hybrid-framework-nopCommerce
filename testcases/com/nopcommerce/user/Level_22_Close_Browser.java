package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.PageGeneratorManager;
import pageObjects.users.RegisterPageObject;

public class Level_22_Close_Browser extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	public static String firstName, lastName, password, emailAddress;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "John";
		lastName = "Wick";
		emailAddress = getEmailRandom();
		password = "auto@123";
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		System.out.println("Email at Common = " + emailAddress);
		System.out.println("Password at Common = " + password);
	}
	//@Test
	public void Register_Success() {
		
		homePage = registerPage.clickToHomePageLogo();
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();
		
		loginPage = homePage.clickToLoginLink();
		
		homePage = loginPage.loginAsUser(emailAddress, password);
		
		customerPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(),firstName);
		Assert.assertEquals(customerPage.getLastNameAttributeValue(),lastName);
		Assert.assertEquals(customerPage.getEmailAttributeValue(),emailAddress);
		
	}
	
	@Test
	public void Login() {
		
		homePage = registerPage.clickToHomePageLogo();
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		
		homePage = loginPage.clickToLoginButton();
		customerPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), firstName);
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), lastName);
		
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		quitBrowserDriver();
	}

}
