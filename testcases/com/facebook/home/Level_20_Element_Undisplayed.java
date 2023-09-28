package com.facebook.home;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;

public class Level_20_Element_Undisplayed extends BaseTest {

	private WebDriver driver;
	
	private pageObjects.facebook.HomePageObject homePage;
	
	private String emailAddress = getEmailRandom();
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	//@Test
	public void Home_01_Element_Displayed() {
		log.info("Home_01 - Step 01: Click Create New Account Button");
		homePage.clickToCreateNewAccountButton();
		
		log.info("Home_01 - Step 02: Verify First Name textbox is displayed");
		verifyTrue(homePage.isFirstNameTextboxDisplayed());
		
		log.info("Home_01 - Step 03: Verify Sur Name textbox is displayed");
		verifyTrue(homePage.isSurNameTextboxDisplayed());
		
		log.info("Home_01 - Step 04: Verify Email textbox is displayed");
		verifyTrue(homePage.isEmailTextboxDisplayed());
		
		log.info("Home_01 - Step 05: Verify Password textbox is displayed");
		verifyTrue(homePage.isPasswordTextboxDisplayed());
		
		log.info("Home_01 - Step 06: Enter to Email textbox");
		homePage.enterToEmailTextbox(emailAddress);
		
		log.info("Home_01 - Step 07: Verify Confirm Email textbox is displayed");
		verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
		
	}
	
	//@Test
	public void Home_02_Element_Undisplayed_In_HTML() {
		homePage.enterToEmailTextbox("");
		homePage.sleepInSecond(2);
		
		log.info("Home_02 - Step 02: Verify Confirm Email textbox is not displayed");
		verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
		
	}
	
//	@Test
	public void Home_03_Element_Undisplayed_NOT_In_HTML_01() {
		log.info("Home_01 - Step 01: Click Create New Account Button");
		homePage.clickToCloseSignUpPopup();
		
		log.info("Home_01 - Step 02: Verify First Name textbox is not displayed");
		verifyFalse(homePage.isFirstNameTextboxDisplayed());
		
		log.info("Home_01 - Step 03: Verify Sur Name textbox is not displayed");
		verifyFalse(homePage.isSurNameTextboxDisplayed());
		
		log.info("Home_01 - Step 04: Verify Email textbox is not displayed");
		verifyFalse(homePage.isEmailTextboxDisplayed());
		
		log.info("Home_01 - Step 05: Verify Password textbox is not displayed");
		verifyFalse(homePage.isPasswordTextboxDisplayed());
		
		log.info("Home_01 - Step 07: Verify Confirm Email textbox is not displayed");
		verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
		
	}

	@Test
	public void Home_03_Element_Undisplayed_NOT_In_HTML_02() {
		//log.info("Home_01 - Step 01: Click Create New Account Button");
		//homePage.clickToCloseSignUpPopup();
		
		log.info("Home_01 - Step 02: Verify First Name textbox is not displayed");
		verifyTrue(homePage.isFirstNameTextboxUnDisplayed());
		
		log.info("Home_01 - Step 03: Verify Sur Name textbox is not displayed");
		verifyTrue(homePage.isSurNameTextboxUnDisplayed());
		
		log.info("Home_01 - Step 04: Verify Email textbox is not displayed");
		verifyTrue(homePage.isEmailTextboxUnDisplayed());
		
		log.info("Home_01 - Step 05: Verify Password textbox is not displayed");
		verifyTrue(homePage.isPasswordTextboxUnDisplayed());
		
		log.info("Home_01 - Step 07: Verify Confirm Email textbox is not displayed");
		verifyTrue(homePage.isConfirmEmailTextboxUnDisplayed());
		
	}
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
