package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class AdminDashBoardPageObject extends AdminMenuItemPageObject {

	WebDriver driver;

	public AdminDashBoardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	
}
