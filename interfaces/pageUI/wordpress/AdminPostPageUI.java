package pageUI.wordpress;

public class AdminPostPageUI {
	public static final String POST_LINK = "xpath=//div[text()='Posts']";
	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";
	public static final String POST_TITLE_TEXTBOX = "css=input[name='post_title']";
	public static final String POST_CONTENT_IFRAME = "css=iframe#content_ifr";
	public static final String POST_CONTENT_TEXBOX = "css=#tinymce>p";
	public static final String POST_CATEGORIES_CHECKBOX = "xpath=//label[contains(text(),'%s')]//input";
	public static final String POST_TAG_TEXTBOX = "CSS=input#new-tag-post_tag";
	public static final String POST_TAG_ADD_BUTTON = "css=input.tagadd";
	public static final String POST_PUBLISH_AND_EDIT_BUTTON = "css=input#publish";
	public static final String POST_MESSAGE = "XPATH=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String SEARCH_TEXTBOX = "id=post-search-input";
	public static final String SEARCH_POSTS_BUTTON = "id=search-submit";
	public static final String POST_INFOR_ROW = "xpath=//td[contains(@class,'column-title') and contains(string(),'%s')]/following-sibling::td[contains(@class,'author') and contains(string(),'%s')]/following-sibling::td[contains(@class,'categories') and contains(string(),'%s')]/following-sibling::td[contains(@class,'tags') and contains(string(),'%s')]";	
	public static final String POST_INFOR_BY_COLUMN_NAME = "xpath=//td[@data-colname='%s' and contains(string(),'%s')]";
	public static final String POST_TITLE_IN_ROW = "xpath=//a[@class='row-title' and text()='%s']";
	public static final String ROW_ACTION_LINK_BY_POST_TITLE = "xpath=//a[text()='%s']/parent::strong/following-sibling::div[@class='row-actions']//*[text()='%s']";
	public static final String POST_REMOVE_TAG_ICON = "css=span.remove-tag-icon";
	public static final String NO_POSTS_MESSAGE = "xpath=//td[@class='colspanchange']";
	
	
			
			

}
