package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import graphql.Assert;
import pageObjects.jquery.HomePageObject;


public class Level_13_Handle_Data_Table extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = pageObjects.jquery.PageGeneratorManager.getHomePage(driver);
	}
	
	//@Test
	public void TC_01_Search() {
		//search data on header
		homePage.inputToColumnTextboxByName("Females", "624");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Country", "Seychelles");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Total", "1270");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Females", "777");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Females", "750");
		homePage.sleepInSecond(2);
	}
	
	//@Test
	public void TC_02_Paging() {
		homePage.clickToPageByNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
		
		homePage.clickToPageByNumber("24");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("24"));
		
		homePage.clickToPageByNumber("1");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("1"));
		
	}
	
	//@Test
	public void TC_03_Displayed() {
		homePage.inputToColumnTextboxByName("Country", "Afghanistan");
		//homePage.enterKeyBoard(driver);
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isRowValuesDisplayed("384187", "Afghanistan", "407124", "791312"));
		
		homePage.inputToColumnTextboxByName("Country", "Aruba");
		//homePage.enterKeyBoard(driver);
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isRowValuesDisplayed("750", "Aruba", "756", "1504"));
	}
	
	@Test
	public void TC_04_Checkbox() {
		homePage.clickToRowActionByCountryName("Afghanistan", "remove");
		homePage.refreshCurrentPage(driver);
		homePage.sleepInSecond(2);
		
		homePage.clickToRowActionByCountryName("Afghanistan", "edit");
		homePage.refreshCurrentPage(driver);
		homePage.sleepInSecond(2);
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
