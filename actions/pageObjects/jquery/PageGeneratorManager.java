package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import pageObjects.users.UploadPageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}

		public static UploadPageObject getUploadPage(WebDriver driver) {
		return new UploadPageObject(driver);
	}
}
