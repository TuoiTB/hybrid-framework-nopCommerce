package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashBoardPageObject;
import pageObjects.wordpress.AdminLoginPageObject;
import pageObjects.wordpress.AdminPostPageObject;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePageObject;
import pageObjects.wordpress.UserPostPageObject;
import pageObjects.wordpress.UserSearchPageObject;

public class Admin_01_Post extends BaseTest{
	WebDriver driver;
	String userUrl, adminUrl, username, password;
	String postTitle, postBody, postAuthor, postTagName, postCategory;
	int randomNumber = getNumberRandom();
	
	@Parameters({"browser","userUrl","adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
		username = "automationfc";
		password = "automationfc";
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminLoginPage.enterToUsernameTextbox(username);
		adminLoginPage.enterToPasswordTextbox(password);
		adminDashBoardPage = adminLoginPage.clickToLoginButton();
		
		postTitle = "Selenium WebDriver " + randomNumber;
		postBody = "Selenium WebDriver Body " + randomNumber;
		postTagName = postTitle.replace(" ", "_").toLowerCase();
		postCategory = "Selenium";	
		postAuthor = "Tuoi TB";
	}
	
	@Test
	public void Post_01_Create_New_Post() {
		log.info("Post_01 - Step 00: Click to Post link");
		adminPostPage = adminDashBoardPage.clickToPostLink();
		
		log.info("Post_01 - Step 01: Click to Add New button");
		adminPostPage.clickToAddNewButton();
		
		log.info("Post_01 - Step 02: Enter to Post title");
		adminPostPage.enterToPostTitle(postTitle);
		
		log.info("Post_01 - Step 03: Enter to Post body");
		adminPostPage.enterToPostBody(postBody);
		
		log.info("Post_01 - Step 04: Select categories checkbox");
		adminPostPage.selectCategoryCheckbox(postCategory);
		
		log.info("Post_01 - Step 05: Enter to Tags textbox");
		adminPostPage.enterToTagsName(postTagName);
		
		log.info("Post_01 - Step 06: Click to Publish button");
		adminPostPage.clickToPublishButton();
		adminPostPage.sleepInSecond(3);
		
		log.info("Post_01 - Step 07: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostPage.IsPostPublishedMessageDisplayed("Post published."));
		
	}
	
	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Post_02 - Step 01: Click to Post link in menu");
		adminPostPage.clickToPostLink();
		
		log.info("Post_02 - Step 02: Enter to Search textbox");
		adminPostPage.enterToSearchTextbox(postTitle);
		
		log.info("Post_02 - Step 03: Click to Search Posts button");
		adminPostPage.clickToSearchPostsButton();
		
		log.info("Post_02 - Step 04: Verify created post is displayed");
		//Cach 1:
		//verifyTrue(adminPostPage.isPostInforDisplayed( postTitle, postAuthor, postCategory, postTagName));
		
		//Cach 2:
		verifyTrue(adminPostPage.isPostInforDisplayedByColumnName("Title", postTitle));
		verifyTrue(adminPostPage.isPostInforDisplayedByColumnName("Author", postAuthor));
		verifyTrue(adminPostPage.isPostInforDisplayedByColumnName("Categories", postCategory));
		verifyTrue(adminPostPage.isPostInforDisplayedByColumnName("Tags", postTagName));
		
		log.info("Post_02 - Step 05: Open user site");
		userHomePage = adminPostPage.wordPressOpenUserHomePage(driver, userUrl);
		
		log.info("Post_02 - Step 06: Verify created post is displayed at Homepage");
		verifyTrue(userHomePage.isPostTitleDisplayed(postTitle));
		verifyTrue(userHomePage.isPostAuthorDisplayed(postTitle, postAuthor));
		verifyTrue(userHomePage.isPostBodyDisplayed(postBody));
		
		
		
		log.info("Post_02 - Step 07: Open Post detail");
		userPostPage = userHomePage.openPostDetail(postTitle);
		
		log.info("Post_02 - Step 08: Verify post title and body infor");
		verifyTrue(userPostPage.isPostTitleDetailDisplayed(postTitle));
		verifyTrue(userPostPage.isPostAuthorDetailDisplayed(postAuthor));
		verifyTrue(userPostPage.isPostBodyDetailDisplayed(postBody));
		verifyTrue(userPostPage.isPostCategoryDetailDisplayed(postCategory));
		verifyTrue(userPostPage.isPostTagNameDetailDisplayed(postTagName));
	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Post_03 - Step 01: Open admin site");
		
		log.info("Post_03 - Step 02: Click to Post link in menu");
		
		log.info("Post_03 - Step 03: Enter to Search textbox");
		
		log.info("Post_03 - Step 04: Click to Search Posts button");
		
		log.info("Post_03 - Step 05: Click to Edit button");
		
		log.info("Post_03 - Step 06: Enter to Post title");
		
		log.info("Post_03 - Step 07: Enter to Post body");
		
		log.info("Post_03 - Step 08: Select categories checkbox");
			//uncheck old checkbox, check new checkbox
		
		log.info("Post_03 - Step 09: Enter to Tags textbox");
			//remove old tags, enter new tags
		
		log.info("Post_03 - Step 10: Click to Update button");
		
		log.info("Post_03 - Step 11: Verify 'Post Updated.' message is displayed");
		
		log.info("Post_03 - Step 12: Click to Post link in menu");
		
		log.info("Post_03 - Step 13: Enter to Search textbox");
		
		log.info("Post_03 - Step 14: Click to Search Posts button");
		
		log.info("Post_03 - Step 15: Verify updated post is displayed");
		
		log.info("Post_03 - Step 16: Open user site");
		
		log.info("Post_03 - Step 17: Verify updated post is displayed at Homepage");
		
		log.info("Post_03 - Step 18: Open Post detail");
		
		log.info("Post_03 - Step 19: Verify post title and body infor");
	}
	
	@Test
	public void Post_04_Delete_Post() {
		log.info("Post_04 - Step 01: Open admin site");
		
		log.info("Post_04 - Step 02: Click to Post link in menu");
		
		log.info("Post_04 - Step 03: Enter to Search textbox");
		
		log.info("Post_04 - Step 04: Click to Search Posts button");
		
		log.info("Post_04 - Step 05: Click to Trash button");
		
		log.info("Post_04 - Step 06: Verify '1 post moved to the Trash.' message is displayed");
		
		log.info("Post_04 - Step 07: Enter to Search textbox");
		
		log.info("Post_04 - Step 08: Click to Search Posts button");
		
		log.info("Post_04 - Step 09: Verify 'No posts found.' message is displayed in Posts table");
		
		log.info("Post_04 - Step 10: Open user site");
		
		log.info("Post_04 - Step 11: Verify deleted post is not displayed at Homepage");
		
		log.info("Post_04 - Step 12: Enter to Search textbox at Homepage");
		
		log.info("Post_04 - Step 13: Click to Search button at Homepage");

		log.info("Post_04 - Step 14: Verify 'Sorry, no post found on this archive.' message is displayed in Search detail");
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//quitBrowserDriver();
	}
	
	AdminDashBoardPageObject adminDashBoardPage;
	AdminLoginPageObject adminLoginPage;
	AdminPostPageObject adminPostPage;
	UserHomePageObject userHomePage;
	UserPostPageObject userPostPage;
	UserSearchPageObject userSearchPage;
}
