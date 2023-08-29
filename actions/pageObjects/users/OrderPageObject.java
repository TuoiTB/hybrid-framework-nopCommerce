package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.users.AddressesPageUI;

public class OrderPageObject extends SideBarMyAccountPageObject{

	private WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, AddressesPageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, AddressesPageUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, AddressesPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, AddressesPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
	

}
