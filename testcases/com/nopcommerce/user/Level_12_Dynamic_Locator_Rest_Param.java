package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.PageGeneratorManager;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

public class Level_12_Dynamic_Locator_Rest_Param extends BaseTest {

	private WebDriver driver;
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProductPage;
	private AddressesPageObject addressesPage;
	private RewardPointPageObject rewardPointPage;
	
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
	public void User_02_Switch_Page_10_to_20_pages() {
		//Custormer infor => Downloadable products
		downloadableProductPage = (DownloadableProductPageObject) customerPage.openDynamicSideBarPage("Downloadable products"); 
		
		//Downloadable products => Addresses
		addressesPage = (AddressesPageObject) downloadableProductPage.openDynamicSideBarPage("Addresses");
		
		//Addresses => Reward points
		rewardPointPage = (RewardPointPageObject) addressesPage.openDynamicSideBarPage("Reward points");
	}
	
	@Test
	public void User_03_Switch_Page_than_20_pages() {
		rewardPointPage.openDynamicSideBarPageByName("Downloadable products"); 
		downloadableProductPage = PageGeneratorManager.getDownloadableProductPage(driver);
		
		downloadableProductPage.openDynamicSideBarPageByName("Customer info");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		
		customerPage.openDynamicSideBarPageByName("Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);
	}
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
