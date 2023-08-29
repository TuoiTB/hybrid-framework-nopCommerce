package com.nopcommerce.user;

import java.util.Random;

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

public class Level_11_Global_Contants extends BaseTest {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProductPage;
	private AddressesPageObject addressesPage;
	private RewardPointPageObject rewardPointPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject adminDashBoardPage;
	
	private String firstName = "John";
	private String lastName = "Wick";
	private String password = "auto@123";
	private String emailAddress = getEmailRandom();
	
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;
	private String userUrl = GlobalConstants.DEV_USER_URL;
	
	@Parameters({"browser","userUrl","adminUrl"})
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
	public void User_02_Switch_Url() {
		//Custormer page
		
		//Logout từ user
		homePage = customerPage.clickToLogoutLink(driver);
		
		//từ trang user qua trang admin
		homePage.openUrl(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		//Login thành công vào admin
		adminDashBoardPage = adminLoginPage.loginAsAdmin(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
		Assert.assertTrue(adminDashBoardPage.isPageLoadedSuccess(driver));
		
		//Logout khỏi trang admin 
		adminLoginPage = adminDashBoardPage.adminAbleToLogout(driver);
		
		//Qua trang user
		adminLoginPage.openUrl(driver, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		//Login vào user
		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.loginAsUser(emailAddress, password);
	}
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
