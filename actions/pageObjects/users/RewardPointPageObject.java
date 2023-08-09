package pageObjects.users;

import org.openqa.selenium.WebDriver;

import pageUI.users.RewardPointPageUI;

public class RewardPointPageObject extends SideBarMyAccountPageObject{

	private WebDriver driver;

	public RewardPointPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public CustomerPageObject openCustomerPage() {
		waitForElementClickable(driver, RewardPointPageUI.CUSTOMER_INFOR_PAGE_LINK);
		clickToElement(driver, RewardPointPageUI.CUSTOMER_INFOR_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}

}
