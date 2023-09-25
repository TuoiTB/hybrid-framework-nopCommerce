package pageObjects.facebook;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.facebook.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isFirstNameTextboxDisplayed() {
		//Khi check displayed thi phai check visible r moi check isDisplayed
		waitForElementVisible(driver, HomePageUI.FIRST_NAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.FIRST_NAME_TEXTBOX);
	}

	public boolean isSurNameTextboxDisplayed() {
		waitForElementVisible(driver, HomePageUI.SUR_NAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.SUR_NAME_TEXTBOX);
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxDisplayed() {
		waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}

	public void enterToEmailTextbox(String string) {
		waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, string);
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCloseSignUpPopup() {
		waitForElementVisible(driver, HomePageUI.CLOSE_POPUP);
		clickToElement(driver, HomePageUI.CLOSE_POPUP);
	}

	public boolean isFirstNameTextboxUnDisplayed() {
		return isElementUndisplayed(driver, HomePageUI.FIRST_NAME_TEXTBOX);
	}

	public boolean isSurNameTextboxUnDisplayed() {
		return isElementUndisplayed(driver, HomePageUI.SUR_NAME_TEXTBOX);
	}

	public boolean isEmailTextboxUnDisplayed() {
		return isElementUndisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxUnDisplayed() {
		return isElementUndisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxUnDisplayed() {
		return isElementUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}
	
	
	
}
