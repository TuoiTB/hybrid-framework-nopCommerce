package com.saucelab;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import graphql.Assert;
import pageObjects.sauceLab.InventoryPageObject;
import pageObjects.sauceLab.LoginPageObject;
import pageObjects.sauceLab.PageGeneratorManager;

public class Level_23_Sort_Data extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	InventoryPageObject inventoryPage;
	String userName;
	String password;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		userName = "standard_user";
		password = "secret_sauce";
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterToUserNameTextbox(userName);
		loginPage.enterToPasswordTextbox(password);
		inventoryPage = loginPage.clickToLoginButton();
		
		
	}
	
	@Test
	public void Sort_01_Name_Ascending() {
		inventoryPage.selectSortDropDown("Name (A to Z)");
		Assert.assertTrue(inventoryPage.isProductNameSortAscending());
	}
	
	@Test
	public void Sort_02_Name_Descending() {
		inventoryPage.selectSortDropDown("Name (Z to A)");
		Assert.assertTrue(inventoryPage.isProductNameSortDescending());
	}
	
	@Test
	public void Sort_03_Price_Ascending() {
		inventoryPage.selectSortDropDown("Price (low to high)");
		Assert.assertTrue(inventoryPage.isProductPriceSortAscending());
	}
	
	@Test
	public void Sort_04_Price_Descending() {
		inventoryPage.selectSortDropDown("Price (high to low)");
		Assert.assertTrue(inventoryPage.isProductPriceSortDescending());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//quitBrowserDriver();
	}

}
