package pageUI.wordpress;

public class UserPostPageUI {
	public static final String POST_TITLE_DETAIL = "XPATH=//h1[text()='%s']";
	public static final String POST_AUTHOR_DETAIL = "XPATH=//div[@class='headerimgbox-meta']/span[contains(text(),'%s')]";
	public static final String POST_CONTENT_DETAIL = "XPATH=//div[@class='post-content']/p[contains(text(),'%s')]";
	public static final String POST_CATEGORY_DETAIL = "XPATH=//ul[@class='post-categories']//a[contains(text(),'%s')]";
	public static final String POST_TAG_NAME_DETAIL = "XPATH=//div[@class='post-tags']//a[contains(text(),'%s')]";
}
