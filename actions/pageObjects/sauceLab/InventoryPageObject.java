package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.sauceLab.InventortyPageUI;

public class InventoryPageObject extends BasePage{
	WebDriver driver;
	
	public InventoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSortDropDown(String valueItem) {
		waitForElementClickable(driver, InventortyPageUI.SORT_DROPDOWN);
		selectDropdown(driver, InventortyPageUI.SORT_DROPDOWN, valueItem);
	}

	public boolean isProductNameSortAscending() {
		waitForListElementVisible(driver, InventortyPageUI.PRODUCT_NAME);
		
		List<WebElement> productName = getListElement(driver, InventortyPageUI.PRODUCT_NAME);
		
		//Lưu tất cả các text trên UI vào list
		List<String> productNameTextUI = new ArrayList<String>();
		for (WebElement product : productName) {
			productNameTextUI.add(product.getText());
		}
		
		//Sort Data
		List<String> productNameTextSort = new ArrayList<String>(productNameTextUI);
		
		//Collection sort
		Collections.sort(productNameTextSort);
		
		return productNameTextUI.equals(productNameTextSort);
	}

	public boolean isProductNameSortDescending() {
		waitForListElementVisible(driver, InventortyPageUI.PRODUCT_NAME);
		
		List<WebElement> productName = getListElement(driver, InventortyPageUI.PRODUCT_NAME);
		
		//Lưu tất cả các text trên UI vào list
		List<String> productNameTextUI = new ArrayList<String>();
		for (WebElement product : productName) {
			productNameTextUI.add(product.getText());
		}
		
		//Sort Data
		List<String> productNameTextSort = new ArrayList<String>(productNameTextUI);
		
		//Collection sort
		Collections.sort(productNameTextSort);
		
		//Reverse data
		Collections.reverse(productNameTextSort);
		
		return productNameTextUI.equals(productNameTextSort);
	}

	public boolean isProductPriceSortAscending() {
		waitForListElementVisible(driver, InventortyPageUI.PRODUCT_PRICE);
		
		List<WebElement> productPrice = getListElement(driver, InventortyPageUI.PRODUCT_PRICE);
		
		//Lưu tất cả các text trên UI vào list
		List<Float> productPriceTextUI = new ArrayList<Float>();
		for (WebElement product : productPrice) {
			//get text xong thì xóa kí tự $
			String priceText = product.getText();
			priceText = priceText.replace("$", "").replace(",", "");
			
			//Convert text qua kiểu số thực
			Float priceNumber = Float.valueOf(priceText);
			
			productPriceTextUI.add(priceNumber);
		}
		
		//Sort Data
		List<Float> productPriceTextSort = new ArrayList<Float>(productPriceTextUI);
		
		//Collection sort
		Collections.sort(productPriceTextSort);
		
		return productPriceTextUI.equals(productPriceTextSort);
	}

	public boolean isProductPriceSortDescending() {
		waitForListElementVisible(driver, InventortyPageUI.PRODUCT_PRICE);
		
		List<WebElement> productPrice = getListElement(driver, InventortyPageUI.PRODUCT_PRICE);
		
		//Lưu tất cả các text trên UI vào list
		List<Float> productPriceTextUI = new ArrayList<Float>();
		for (WebElement product : productPrice) {
			//get text xong thì xóa kí tự $
			String priceText = product.getText();
			priceText = priceText.replace("$", "").replace(",", "");
			
			//Convert text qua kiểu số thực
			Float priceNumber = Float.valueOf(priceText);
			
			productPriceTextUI.add(priceNumber);
		}
		
		//Sort Data
		List<Float> productPriceTextSort = new ArrayList<Float>(productPriceTextUI);
		
		//Collection sort
		Collections.sort(productPriceTextSort);
		
		//Reverse data
		Collections.reverse(productPriceTextSort);
		
		return productPriceTextUI.equals(productPriceTextSort);
	}


}
