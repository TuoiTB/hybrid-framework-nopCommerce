package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.users.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage {
	
	WebDriver driver;
	
	public SideBarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
	
	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}
	
	public CustomerPageObject openCustomerPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.CUSTOMER_INFOR_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.CUSTOMER_INFOR_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	public SideBarMyAccountPageObject openDynamicSideBarPage(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerPage(driver);
			
		case "Addresses":
			return PageGeneratorManager.getAddressesPage(driver);
			
		case "Orders":
			return PageGeneratorManager.getOrderPage(driver);
			
		case "Reward points":
			return PageGeneratorManager.getRewardPointPage(driver);
			
		case "Downloadable products":
			return PageGeneratorManager.getDownloadableProductPage(driver);
			
		default:
			new RuntimeException("Side bar page name is incorrect"); 
			return null;
		}
	
	}
	
	public void openDynamicSideBarPageByName(String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDE_BAR_LINK, pageName);
	}
}
