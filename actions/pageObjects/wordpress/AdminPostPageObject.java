package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import pageUI.wordpress.AdminPostPageUI;

public class AdminPostPageObject extends AdminMenuItemPageObject {

	WebDriver driver;

	public AdminPostPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostPageUI.ADD_NEW_BUTTON);
	}

	public void enterToPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostPageUI.POST_TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostPageUI.POST_TITLE_TEXTBOX, postTitle);
	}

	public void enterToPostBody(String postContent) {
		//Switch to Iframe
		switchToFrame(driver, AdminPostPageUI.POST_CONTENT_IFRAME);
		
		//click to content texbox
		waitForElementClickable(driver, AdminPostPageUI.POST_CONTENT_TEXBOX);
		clickToElement(driver, AdminPostPageUI.POST_CONTENT_TEXBOX);
		
		//enter to content textbox
		waitForElementVisible(driver, AdminPostPageUI.POST_CONTENT_TEXBOX);
		sendkeyToElement(driver, AdminPostPageUI.POST_CONTENT_TEXBOX, postContent);
		
		//switch to  default content
		switchToDefaultContent(driver);
	}

	public void selectCategoryCheckbox(String catagoryName) {
		waitForElementClickable(driver, AdminPostPageUI.POST_CATEGORIES_CHECKBOX, catagoryName);
		checkToCheckboxOrRadio(driver, AdminPostPageUI.POST_CATEGORIES_CHECKBOX, catagoryName);
	}

	public void enterToTagsName(String tagName) {
		waitForElementVisible(driver, AdminPostPageUI.POST_TAG_TEXTBOX);
		sendkeyToElement(driver, AdminPostPageUI.POST_TAG_TEXTBOX, tagName);
		waitForElementClickable(driver, AdminPostPageUI.POST_TAG_ADD_BUTTON);
		clickToElement(driver, AdminPostPageUI.POST_TAG_ADD_BUTTON);
	}
	
	public void clickToPublishAndEditButton() {
		scrollToElementOnTop(driver, AdminPostPageUI.POST_PUBLISH_AND_EDIT_BUTTON);
		waitForElementClickable(driver, AdminPostPageUI.POST_PUBLISH_AND_EDIT_BUTTON);
		clickToElement(driver, AdminPostPageUI.POST_PUBLISH_AND_EDIT_BUTTON);
	}
	
	public boolean IsPostMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostPageUI.POST_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostPageUI.POST_MESSAGE, message);
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchPostsButton() {
		waitForElementClickable(driver, AdminPostPageUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostPageUI.SEARCH_POSTS_BUTTON);
	}

	public boolean isPostInforDisplayed(String postTitle, String postAuthor, String postCategory, String postTagName) {
		waitForElementVisible(driver, AdminPostPageUI.POST_INFOR_ROW, postTitle, postAuthor, postCategory, postTagName);
		return isElementDisplayed(driver, AdminPostPageUI.POST_INFOR_ROW, postTitle, postAuthor, postCategory, postTagName);
	}

	public boolean isPostInforDisplayedByColumnName(String columnName, String columnValue) {
		waitForElementVisible(driver, AdminPostPageUI.POST_INFOR_BY_COLUMN_NAME, columnName, columnValue);
		return isElementDisplayed(driver, AdminPostPageUI.POST_INFOR_BY_COLUMN_NAME, columnName, columnValue);
	}

	public void clickToRowActionLinkByPostTitle(String postTitle, String rowAction) {
		waitForElementClickable(driver, AdminPostPageUI.POST_TITLE_IN_ROW, postTitle);
		hoverToElement(driver, AdminPostPageUI.POST_TITLE_IN_ROW, postTitle);
		
		waitForElementClickable(driver, AdminPostPageUI.ROW_ACTION_LINK_BY_POST_TITLE, postTitle, rowAction);
		clickToElement(driver, AdminPostPageUI.ROW_ACTION_LINK_BY_POST_TITLE, postTitle, rowAction);
		
	}

	public void unCheckToOldCategory(String catagoryName) {
		waitForElementClickable(driver, AdminPostPageUI.POST_CATEGORIES_CHECKBOX, catagoryName);
		uncheckToCheckbox(driver, AdminPostPageUI.POST_CATEGORIES_CHECKBOX, catagoryName);
	}

	public void removeOldTag(String postTagName) {
		waitForElementClickable(driver, AdminPostPageUI.POST_REMOVE_TAG_ICON);
		clickToElement(driver, AdminPostPageUI.POST_REMOVE_TAG_ICON);
	}
	
	public boolean IsNoPostFoundMessageDisplayed() {
		waitForElementVisible(driver, AdminPostPageUI.NO_POSTS_MESSAGE);
		return isElementDisplayed(driver, AdminPostPageUI.NO_POSTS_MESSAGE);
	}

}
