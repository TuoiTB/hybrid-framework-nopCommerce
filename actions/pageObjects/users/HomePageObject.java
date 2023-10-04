package pageObjects.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BaseElement;
import io.qameta.allure.Step;
import pageUI.users.HomePageUI;

public class HomePageObject extends BaseElement{
	//Contains actions as functions of that page. Ex: Click/ Select/ Verify/ getText/... 
	private WebDriver driver;
	WebDriverWait explicitWait;
	
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	@Step("Click to Register link")
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	@Step("Click to Login link")
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	@Step("Click to My Account link")
	public CustomerPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}

	@Step("Click to My Account link")
	public CustomerPageObject openMyAccountLink() {
		String myAccountLink = getElementAttribute(driver, HomePageUI.MY_ACCOUNT_LINK, "href");
		openUrl(driver, myAccountLink);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	@Step("Verify Register link is displayed")
	public boolean isRegisterLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
	}


	

	
}
