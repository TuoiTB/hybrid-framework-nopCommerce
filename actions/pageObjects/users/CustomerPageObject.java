package pageObjects.users;

import org.openqa.selenium.WebDriver;

import pageUI.users.CustomerPageUI;

public class CustomerPageObject extends SideBarMyAccountPageObject{

	private WebDriver driver;
	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}
	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, CustomerPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, CustomerPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, CustomerPageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, CustomerPageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}

}
