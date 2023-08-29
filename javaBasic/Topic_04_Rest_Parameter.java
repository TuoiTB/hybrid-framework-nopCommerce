package javaBasic1;

import org.testng.annotations.Test;

public class Topic_04_Rest_Parameter {
	String addressLink ="//div[@class='listbox']//a[text()='Downloadable products']";
	String orderLink = "//div[@class='listbox']//a[text()='Orders']";
	String sideBarLink = "//div[@class='listbox']//a[text()='%s']";

	@Test
	public void  TC_01_Rest_Param() {
		clickToElement(addressLink);
		clickToElement(orderLink);
		clickToElement(sideBarLink, "Downloadable products");
		
	}
	
	//Static
	public void clickToElement(String locatorValue) {
		System.out.println("Click to: " + locatorValue);
		
	}
	
	//Dynamic element with 2 arguments
	public void clickToElement(String locatorValue, String pageName) {
		locatorValue = String.format(locatorValue, pageName);
		System.out.println("Click to: " + locatorValue);
	}
	
	//Dynamic element with n arguments (use: Var Arguments = Rest Parameter)
	public void clickToElement(String locatorValue, String... values) {
		locatorValue = String.format(locatorValue, (Object[])values);
		System.out.println("Click to: " + locatorValue);
	}
	
}
