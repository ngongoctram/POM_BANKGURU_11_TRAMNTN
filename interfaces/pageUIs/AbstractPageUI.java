package pageUIs;

public class AbstractPageUI {
	public static final String HOMEPAGE_LINK = "//a[text()='Manager']";
	public static final String NEW_CUSTOMER_LINK = "//a[text()='New Customer']";
	public static final String EDIT_CUSTOMER_LINK = "//a[text()='Edit Customer']";
	public static final String DELETE_CUSTOMER_LINK = "//a[text()='Delete Customer']";
	public static final String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
	public static final String EDIT_ACCOUNT_LINK = "//a[text()='Edit Account']";
	public static final String DELETE_ACCOUNT_LINK = "//a[text()='Delete Account']";
	public static final String DEPOSIT_LINK = "//a[text()='Deposit']";
	public static final String WITHDRAWAL_LINK = "//a[text()='Withdrawal']";
	public static final String FUND_TRANSFER_LINK = "//a[text()='Fund Transfer']";
	public static final String CHANGE_PASSWORD = "//a[text()='Change Password']";
	public static final String BALANCE_ENQUIRY = "//a[text()='Balance Enquiry']";
	public static final String MINI_STATEMENT_LINK = "//a[text()='Mini Statement']";
	public static final String CUSTOMISED_STATEMENT_LINK = "//a[text()='Customised Statement']";

	public static final String DYNAMIC_PAGE_XPATH = "//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";
	public static final String DYNAMIC_BUTTON = "//button[@name ='%s']";
	public static final String DYNAMIC_BUTTON2 = "//button[@title='%s']";
	public static final String DYNAMIC_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_PAGE_HEADING = "//p[@class ='heading3' and text() ='%s']";
	public static final String DYNAMIC_TEXTAREA = "//textarea[@name='%s']";
	public static final String DYNAMIC_TABLE_ROW_NAME = "//td[text()='%s']/following-sibling::td";
	public static final String DYNAMIC_MENU = "//span[text() ='%s']";
	public static final String DYNAMIC_TITLE = "//a[@title='%s']";
	public static final String DYNAMIC_IMAGE = "//img[@alt='%s']";

	public static final String DYNAMIC_ADD_TO_COMPARE = "//a[@title='%s']//parent::h2//following-sibling::div[@class='actions']//ul//li[2]//a";
	public static final String DYNAMIC_ADD_TO_WISHLIST = "//a[@title='%s']//parent::h2//following-sibling::div[@class='actions']//ul//a[text()='Add to Wishlist']";
	public static final String DYNAMIC_DETAIL_TV = "//a[@title='%s']//img";
	public static final String DYNAMIC_WARNING_MSG = "//label[@for ='%s']/following-sibling::div//div";
	public static final String DYNAMIC_MSG = "//span[text()='%s']";
	public static final String DYNAMIC_PRICE_IN_CART = "//h2[@class='product-name']/a[text()='%s']//ancestor::td//following-sibling::td[@class='product-cart-price']//span[@class='price']";

}
