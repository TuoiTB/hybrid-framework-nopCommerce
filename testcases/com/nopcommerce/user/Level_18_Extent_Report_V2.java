//package com.nopcommerce.user;

//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.GlobalConstants;
//import pageObjects.admin.AdminDashBoardPageObject;
//import pageObjects.admin.AdminLoginPageObject;
//import pageObjects.users.AddressesPageObject;
//import pageObjects.users.CustomerPageObject;
//import pageObjects.users.DownloadableProductPageObject;
//import pageObjects.users.HomePageObject;
//import pageObjects.users.LoginPageObject;
//import pageObjects.users.PageGeneratorManager;
//import pageObjects.users.RegisterPageObject;
//import pageObjects.users.RewardPointPageObject;
//import reportConfig.ExtentManager;
//
//public class Level_18_Extent_Report_V2 extends BaseTest {
//
//	private WebDriver driver;
//	
//	private HomePageObject homePage;
//	private RegisterPageObject registerPage;
//	
//	private String firstName = "John";
//	private String lastName = "Wick";
//	private String password = "auto@123";
//	private String emailAddress = getEmailRandom();
//	
//	private String userUrl = GlobalConstants.DEV_USER_URL;
//	
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName, userUrl);
//		homePage = PageGeneratorManager.getHomePage(driver);
//		registerPage = PageGeneratorManager.getRegisterPage(driver);
//	}
//	
//	@Test
//	public void User_01_Register(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register");
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 01: Verify Register link isdisplayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 02: Click to Register link");
//		registerPage = homePage.clickToRegisterLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 04: Verify error message at Firs Name textbox");
//		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 05: Verify error message at Last Name textbox");
//		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 06: Enter to First Name textbox");
//		registerPage.enterToFirstNameTextbox(firstName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 07: Enter to Last Name textbox");
//		registerPage.enterToLastNameTextbox(lastName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 08: Enter to Email textbox");
//		registerPage.enterToEmailTextbox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 09: Enter to Password textbox");
//		registerPage.enterToPasswordTextbox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 10: Enter to Confirm Password textbox");
//		registerPage.enterToConfirmPasswordTextbox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 11: Click to Register button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 12: Verify success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
//	}
//	
//	@Test
//	public void User_02_Register_Success(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Register_Success");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 06: Enter to First Name textbox");
//		registerPage.refreshCurrentPage(driver);
//		registerPage.enterToFirstNameTextbox(firstName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 07: Enter to Last Name textbox");
//		registerPage.enterToLastNameTextbox(lastName);
		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 08: Enter to Email textbox");
//		registerPage.enterToEmailTextbox(emailAddress);
		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 09: Enter to Password textbox");
//		registerPage.enterToPasswordTextbox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 10: Enter to Confirm Password textbox");
//		registerPage.enterToConfirmPasswordTextbox(password);
//	
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 11: Click to Register button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "User_01 - Step 12: Verify success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");
//		
//	}
//	
//
//	@AfterClass
//	public void afterClass() {
//		quitBrowserDriver();
//	}
//
//}
