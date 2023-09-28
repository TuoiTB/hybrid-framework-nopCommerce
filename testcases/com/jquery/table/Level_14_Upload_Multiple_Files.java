package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import graphql.Assert;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.users.UploadPageObject;


public class Level_14_Upload_Multiple_Files extends BaseTest {

	WebDriver driver;
	UploadPageObject uploadPage;
	String large = "large.jpg";
	String sea = "sea.jpg";
	String medium = "medium.jpg";
	
	String[] fileNames = {"large.jpg","medium.jpg","sea.jpg"};
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadPage = PageGeneratorManager.getUploadPage(driver);
	}
	
	//@Test
	public void TC_01_Upload_Single_File() {
		uploadPage.uploadMultipleFiles(driver, large);
		uploadPage.sleepInSecond(2);
		
		uploadPage.uploadMultipleFiles(driver, sea);
		uploadPage.sleepInSecond(2);
		
		uploadPage.uploadMultipleFiles(driver, medium);
		uploadPage.sleepInSecond(2);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(large));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(sea));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(medium));
		
		uploadPage.clickStartButtonOnEachFile();
		
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(large));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(sea));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(medium));
	}
	
	//@Test
	public void TC_02_Upload_Multiple_Files() {
		uploadPage.refreshCurrentPage(driver);
		
		uploadPage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(large));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(sea));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(medium));
		
		uploadPage.clickStartButtonOnEachFile();
		
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(large));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(sea));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(medium));
	}
	
	@Test
		public void TC_03_Upload_Multiple_Files() {
			uploadPage.refreshCurrentPage(driver);
			
			uploadPage.uploadMultipleFiles(driver, fileNames);
			
			Assert.assertTrue(uploadPage.isFileLoadedSuccess(large));
			Assert.assertTrue(uploadPage.isFileLoadedSuccess(sea));
			Assert.assertTrue(uploadPage.isFileLoadedSuccess(medium));
			
			uploadPage.clickStartButtonOnEachFile();
			
			Assert.assertTrue(uploadPage.isFileUploadedSuccess(large));
			Assert.assertTrue(uploadPage.isFileUploadedSuccess(sea));
			Assert.assertTrue(uploadPage.isFileUploadedSuccess(medium));
		}
	
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
