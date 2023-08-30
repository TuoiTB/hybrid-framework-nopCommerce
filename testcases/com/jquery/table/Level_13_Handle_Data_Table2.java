package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;


public class Level_13_Handle_Data_Table2 extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = pageObjects.jquery.PageGeneratorManager.getHomePage(driver);
	}
	
	@Test
	public void TC_01() {
	}
	
	@Test
	public void TC_02() {
		
	}
		
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
