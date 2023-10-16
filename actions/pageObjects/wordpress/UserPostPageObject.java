package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserPostPageUI;

public class UserPostPageObject extends BasePage {

	WebDriver driver;

	public UserPostPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isPostTitleDetailDisplayed(String postTitle) {
		waitForElementVisible(driver, UserPostPageUI.POST_TITLE_DETAIL, postTitle);
		return isElementDisplayed(driver, UserPostPageUI.POST_TITLE_DETAIL, postTitle);
	}

	public boolean isPostAuthorDetailDisplayed(String postAuthor) {
		waitForElementVisible(driver, UserPostPageUI.POST_AUTHOR_DETAIL, postAuthor);
		return isElementDisplayed(driver, UserPostPageUI.POST_AUTHOR_DETAIL, postAuthor);
	}

	public boolean isPostBodyDetailDisplayed(String postBody) {
		waitForElementVisible(driver, UserPostPageUI.POST_CONTENT_DETAIL, postBody);
		return isElementDisplayed(driver, UserPostPageUI.POST_CONTENT_DETAIL, postBody);
	}

	public boolean isPostCategoryDetailDisplayed(String postCategory) {
		waitForElementVisible(driver, UserPostPageUI.POST_CATEGORY_DETAIL, postCategory);
		return isElementDisplayed(driver, UserPostPageUI.POST_CATEGORY_DETAIL, postCategory);
	}

	public boolean isPostTagNameDetailDisplayed(String postTagName) {
		waitForElementVisible(driver, UserPostPageUI.POST_TAG_NAME_DETAIL, postTagName);
		return isElementDisplayed(driver, UserPostPageUI.POST_TAG_NAME_DETAIL, postTagName);
	}
}
