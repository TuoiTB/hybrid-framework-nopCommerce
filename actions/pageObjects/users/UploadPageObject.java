package pageObjects.users;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUI.jquery.UploadPageUI;
import pageUI.users.HomePageUI;
import pageUI.users.RegisterPageUI;

public class UploadPageObject extends BasePage{
	//Contains actions as functions of that page. Ex: Click/ Select/ Verify/ getText/... 
	private WebDriver driver;
	WebDriverWait explicitWait;
	
	public UploadPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isFileLoadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
		
	}

	public void clickStartButtonOnEachFile() {
		List<WebElement> startButtons = getListElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);
		for (WebElement startButton : startButtons) {
			waitForElementClickable(driver, startButton);
			clickToElement(driver, startButton);
			sleepInSecond(2);
		}
		
	}

	public boolean isFileUploadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
	}
	
}
