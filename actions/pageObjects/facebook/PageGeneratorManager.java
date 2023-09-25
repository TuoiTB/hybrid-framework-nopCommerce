package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashBoardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {


	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
