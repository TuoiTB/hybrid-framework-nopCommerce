package pageUI.wordpress;

public class UserHomePageUI {
	public static final String SEARCH_POSTS_BUTTON = "id=search-submit";
	public static final String POST_TITLE_TEXT = "XPATH=//h3/a[contains(text(),'%s')]";
	public static final String POST_AUTHOR = "XPATH=//a[contains(text(),'%s')]//parent::h3//preceding-sibling::div//a[contains(text(),'%s')]";
	public static final String POST_CONTENT = "XPATH=//div[@class='post-content' and contains(text(),'%s')]";
	public static final String POST_TITLE_LINK = "XPATH=//h3/a[contains(text(),'%s')]";
	
	
	
}
