package com.nopcommerce.share;

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

public class Product_Detail extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(Common_Register.emailAddress);
		loginPage.enterToPasswordTextbox(Common_Register.password);
		
		homePage = loginPage.clickToLoginButton();
		customerPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerPage.getEmailAttributeValue(), Common_Register.emailAddress);
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), Common_Register.firstName);
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), Common_Register.lastName);
		
		System.out.println("Email at Product_Detail = " + Common_Register.emailAddress);
		System.out.println("Password at Product_Detail = " + Common_Register.password);
	}

	@Test
	public void Product_01_New_Product() {
		
	}
	
	@Test
	public void Product_02_View_Product() {
		
	}
	
	@Test
	public void Product_03_Edit_Product() {
		
	}
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
