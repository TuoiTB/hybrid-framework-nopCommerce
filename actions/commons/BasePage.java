package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.PageGeneratorManager;
import pageObjects.users.RewardPointPageObject;
import pageUI.admin.AdminBasePageUI;
import pageUI.users.AddressesPageUI;
import pageUI.users.BasePageUI;
import pageUI.users.CustomerPageUI;
import pageUI.users.DownloadableProductPageUI;
import pageUI.users.RewardPointPageUI;
import pageUI.users.SideBarMyAccountPageUI;

public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}
	// contains common function for layer page object
	// Viết các hàm cho Web Browser
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptToAlert(WebDriver driver) {
		// driver.switchTo().alert().accept();
		waitForAlertPresence(driver).accept();
	}

	public void cancelToAlert(WebDriver driver) {
		// driver.switchTo().alert().dismiss();
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textToSendkey) {
		// driver.switchTo().alert().sendKeys(textToSendkey);
		waitForAlertPresence(driver).sendKeys(textToSendkey);
	}

	

	// Chỉ dùng cho duy nhất 2 window/tab
	public void switchToWindowById(WebDriver driver, String windowID) {
		// windowID = driver.getWindowHandle(); => Id của window mà driver đang đứng
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
				break;
			}
		}
	}

	// Có thể chạy cho 2 hoặc nhiều hơn 2 window/tab
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	// Hàm close hết các window/tab ngoại trừ window/tab cha ban đầu
	public void closeAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public By getByXpath(String xpathExpression) {
		return By.xpath(xpathExpression);
	}
	
	public By getByLocator(String locatorValue) {
		By by = null;
		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("xPath=") 
				|| locatorValue.startsWith("XPATH=") || locatorValue.startsWith("Xpath=")) {
			by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=") 
				|| locatorValue.startsWith("CSS=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id=") 
				|| locatorValue.startsWith("ID=")) {
			by = By.id(locatorValue.substring(3));
		} else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") 
				|| locatorValue.startsWith("NAME=")) {
			by = By.name(locatorValue.substring(5));
		} else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") 
				|| locatorValue.startsWith("CLASS=")) {
			by = By.className(locatorValue.substring(6));
		} else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("tagName=")
				|| locatorValue.startsWith("TAGNAME=")) {
			by = By.tagName(locatorValue.substring(8));
		} else {
			throw new RuntimeException("Locator type is not valid");
		}
		
		return by;
		
	}
	
	public WebElement getElement(WebDriver driver, String xpathExpression) {
		return driver.findElement(getByLocator(xpathExpression));
	}
	
	public List<WebElement> getListElement(WebDriver driver, String xpathExpression) {
		return driver.findElements(By.xpath(xpathExpression));
	}
	
	public void clickToElement(WebDriver driver, String xpathExpression) {
		//driver.findElement(By.xpath(xpathExpression));
		getElement(driver, xpathExpression).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String xpathExpression, String value) {
		//driver.findElement(By.xpath(xpathExpression)).clear();
		//driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
		getElement(driver, xpathExpression).clear();
		getElement(driver, xpathExpression).sendKeys(value);
	}
	
	
	
	
	
	public void selectDropdown(WebDriver driver, String xpathExpression, String itemText ) {
		new Select(getElement(driver, xpathExpression)).selectByVisibleText(itemText);
	}
	
	public String getFirstSelectedOptionText(WebDriver driver, String xpathExpression) {
		return new Select(getElement(driver, xpathExpression)).getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathExpression) {
		return new Select(getElement(driver, xpathExpression)).isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String xpathParent, String xpathChild, String expectedText) {
		getElement(driver, xpathParent).click();
		sleepInSecond(2);
		List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));
		for (WebElement tempElement : allItems) {

			if (tempElement.getText().equals(expectedText)) {

				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", tempElement);
				sleepInSecond(5);
				
				tempElement.click();
				break;
			}
		}
	}
	
	
	
	
	
	public String getElementText(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).getText();
	}
	
	public String getElementAttribute(WebDriver driver, String xpathExpression, String attributeName) {
		return getElement(driver, xpathExpression).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String xpathExpression, String propertyName) {
		return getElement(driver, xpathExpression).getCssValue(propertyName);
	}
	
	public String getHexaColorByRGBA(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex().toUpperCase();
	}
	
	public int getListElementSize(WebDriver driver, String xpathExpression) {
		return getListElement(driver, xpathExpression).size();
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String xpathExpression) {
		if (!isElementSelected(driver, xpathExpression)) {
			clickToElement(driver, xpathExpression);
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String xpathExpression) {
		if (isElementSelected(driver, xpathExpression)) {
			clickToElement(driver, xpathExpression);
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isEnabled();
	}
	
	public void switchToFrame(WebDriver driver, String xpathExpression) {
		driver.switchTo().frame(getElement(driver, xpathExpression));
		
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).moveToElement(getElement(driver, xpathExpression)).perform();
	
	}
	
	public void doubleClickToElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).doubleClick(getElement(driver, xpathExpression)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).contextClick((getElement(driver, xpathExpression))).perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, String sourceXpath, String targetXpath) {
		new Actions(driver).dragAndDrop(getElement(driver, sourceXpath), getElement(driver, targetXpath)).perform();;
	}
	
	public void sendkeyBoardToElement(WebDriver driver, String xpathExpression, Keys key) {
		new Actions(driver).sendKeys(getElement(driver, xpathExpression), key).perform();;
	}

	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor)driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor)driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor)driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor)driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String xpathExpression) {
		WebElement element = getElement(driver, xpathExpression);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", getElement(driver, xpathExpression));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, xpathExpression));
	}

	public void scrollToElementOnDown(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, xpathExpression));
	}
	
	public void setAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName, String attributeValue) {
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver, xpathExpression));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathExpression, String attributeRemove) {
		((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, xpathExpression));
	}
	
	public void sendkeyToElementByJS(WebDriver driver, String xpathExpression, String value) {
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, xpathExpression));
	}
	
	public String getAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName) {
		return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, xpathExpression));
	}

	public String getElementValidationMessage(WebDriver driver, String xpathExpression) {
		return (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].validationMessage;", getElement(driver, xpathExpression));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathExpression) {
		return (boolean) ((JavascriptExecutor)driver).executeScript(
				"return arguments[0].complete && typeof arguments[0]."
				+ "naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, xpathExpression));
	}
	
	public boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		
		//Điều kiện 1
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
		
		//Điều kiện 2
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	
	public void waitForElementVisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathExpression)));
	}
	
	public void waitForListElementVisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(xpathExpression)));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(xpathExpression)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathExpression)));
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
	}
	//-----------------------Switch Multiple page
	public RewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, AddressesPageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, AddressesPageUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}

	public DownloadableProductPageObject openDownloadableProductPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
	
	public AddressesPageObject openAddressesPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, BasePageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}
	public CustomerPageObject openCustomerPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMER_INFOR_PAGE_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFOR_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	//---------
	public HomePageObject clickToLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
		clickToElement(driver, BasePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
		
	}
	
	
	//--------------------------------------------------
	public HomePageObject userAbleToLogout(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
		clickToElement(driver, BasePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public AdminLoginPageObject adminAbleToLogout(WebDriver driver) {
		waitForElementClickable(driver, AdminBasePageUI.LOGOUT_LINK);
		clickToElement(driver,  AdminBasePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
}
