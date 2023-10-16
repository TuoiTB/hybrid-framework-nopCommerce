package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserHomePageUI;

public class UserHomePageObject extends BasePage {

	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleDisplayed(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}
	
	public boolean isPostAuthorDisplayed(String postTitle, String postAuthor) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR, postTitle, postAuthor);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR, postTitle, postAuthor);
	}
	
	public boolean isPostBodyDisplayed(String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_CONTENT, postBody);
		return isElementDisplayed(driver, UserHomePageUI.POST_CONTENT, postBody);
	}
	
	public UserPostPageObject openPostDetail(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_LINK, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_LINK, postTitle);
		return PageGeneratorManager.getUserPostPage(driver);
	}

	


	
}
