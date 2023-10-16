package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static AdminDashBoardPageObject getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminPostPageObject getAdminPostPage(WebDriver driver) {
		return new AdminPostPageObject(driver);
	}
	
	public static AdminMenuItemPageObject getAdminMenuItemPage(WebDriver driver) {
		return new AdminMenuItemPageObject(driver);
	}
	
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserPostPageObject getUserPostPage(WebDriver driver) {
		return new UserPostPageObject(driver);
	}
	
	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
	
	
	
}
