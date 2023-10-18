package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminMenuItemPageUI;

public class AdminMenuItemPageObject extends BasePage {

	WebDriver driver;

	public AdminMenuItemPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostPageObject clickToPostLink() {
		waitForElementClickable(driver, AdminMenuItemPageUI.POST_LINK);
		clickToElement(driver, AdminMenuItemPageUI.POST_LINK);
		return PageGeneratorManager.getAdminPostPage(driver);
	}
	
	
}
