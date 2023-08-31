package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToColumnTextboxByName(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
	}
	
	public void clickToPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		
	}
	
	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
	}
	
	public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
	}
	
	public void clickToRowActionByCountryName(String countryName, String rowAction) {
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, countryName, rowAction);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, countryName, rowAction);
	}

	public void getAllPageValuesByColumnName(String columnName) {
		List<String> allValues = new ArrayList<String>();
		
		//save all page links  
		List<WebElement> allPageLinks = getListElement(driver, HomePageUI.ALL_PAGE_LINKS);
		
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		//Duyet qua tung page
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			sleepInSecond(1);
			
			//Lay ra tat ca cac gia tri cua 1 cot trong page do
			List<WebElement> allRowValues = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_NAME, String.valueOf(columnIndex));
			
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
			}
		}
		
		//In ra het tat ca gia tri cua 1 cot trong all page
		for (String value : allValues) {
			System.out.println(value);
		}
	}
	public List<String> getAllPageValuesByColumnName1(String columnName) {
		List<String> allValues = new ArrayList<String>();
		
		//save all page links  
		List<WebElement> allPageLinks = getListElement(driver, HomePageUI.ALL_PAGE_LINKS);
		
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		//Duyet qua tung page
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			sleepInSecond(1);
			
			//Lay ra tat ca cac gia tri cua 1 cot trong page do
			List<WebElement> allRowValues = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_NAME, String.valueOf(columnIndex));
			
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
			}
		}
		
		//In ra het tat ca gia tri cua 1 cot trong all page
		for (String value : allValues) {
			System.out.println(value);
		}
		return allValues;
	}

	
	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME_1, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME_1, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex) );
		selectDropdown(driver, HomePageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem, rowIndex, String.valueOf(columnIndex) );
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME_1, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex) );
		checkToCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex) );
	}
}
