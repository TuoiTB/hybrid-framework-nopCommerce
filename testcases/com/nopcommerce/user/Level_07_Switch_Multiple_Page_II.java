package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.PageGeneratorManager;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

public class Level_07_Switch_Multiple_Page_II extends BaseTest {

	private WebDriver driver;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProductPage;
	private AddressesPageObject addressesPage;
	private RewardPointPageObject rewardPointPage;
	
	
	private String firstName = "John";;
	private String lastName = "Wick";;
	Random rand = new Random();
	private String emailAddress = "automation" + rand.nextInt(999) + "@gmail.vn";
	private String password = "auto@123";;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
	}
	
	@Test
	public void User_01_Register() {
		
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
	public void User_02_Switch_Page() {
		//Open page functions is wrote in BasePage
		
		//Custormer infor => Downloadable products
		downloadableProductPage = customerPage.openDownloadableProductPage(driver); 
		
		//Downloadable products => Addresses
		addressesPage = downloadableProductPage.openAddressesPage(driver);
		
		//Addresses => Reward points
		rewardPointPage = addressesPage.openRewardPointPage(driver);
		
		//Reward points => Customer infor
		customerPage = rewardPointPage.openCustomerPage(driver);
		
		//Customer infor => Addresses
		addressesPage = customerPage.openAddressesPage(driver);
		
		//Addresses => Downloadable products
		downloadableProductPage = addressesPage.openDownloadableProductPage(driver);
	}
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
