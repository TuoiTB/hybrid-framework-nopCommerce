package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
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

public class Level_09_Switch_Page_Url extends BaseTest {

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
	
	private String firstName = "John";;
	private String lastName = "Wick";;
	Random rand = new Random();
	private String emailAddress = "automation" + rand.nextInt(999) + "@gmail.vn";
	private String password = "auto@123";;
	
	private String userUrl, adminUrl;
	
	@Parameters({"browser","userUrl","adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
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
		adminDashBoardPage = adminLoginPage.loginAsAdmin("admin@yourstore.com","admin");
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
