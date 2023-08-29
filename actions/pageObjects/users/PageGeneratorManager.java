package pageObjects.users;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashBoardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {

	
	/*User*/
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerPageObject getCustomerPage(WebDriver driver) {
		return new CustomerPageObject(driver);
	}
	
	public static DownloadableProductPageObject getDownloadableProductPage(WebDriver driver) {
		return new DownloadableProductPageObject(driver);
	}
	
	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
	}
	
	public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
	
	/*Admin*/
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashBoardPageObject getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPageObject(driver);
	}
}
