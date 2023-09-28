package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.users.HomePageObject;
import pageObjects.users.PageGeneratorManager;
import pageUI.users.BaseElementUI;

public class BaseElement extends BasePage{
	private WebDriver driver;
	public BaseElement(WebDriver driver) {
		//super();
		this.driver = driver;
	}
	public HomePageObject clickToHomePageLogo() {
		waitForElementClickable(driver, BaseElementUI.HOMEPAGE_LOGO_IMAGE);
		clickToElement(driver, BaseElementUI.HOMEPAGE_LOGO_IMAGE);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public void clickToHeaderLinkByName(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
	}
}
