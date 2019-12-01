package liveGuruPageUIs;

public class ListMobilePageUI {
	public static final String PRICE_SONY_XPERIA_LIST = "//a[@title='Sony Xperia']//parent::h2//following-sibling::div[@class='price-box']//span[@class='price']";
	public static final String PRICE_SONY_XPERIA_DETAIL = "//span[@class='price']";
	public static final String ADD_TO_CART_BUTTON = "//a[@title='Sony Xperia']//parent::h2//following-sibling::div[@class='actions']/button";
	public static final String MSG_ADD_COMPARE_SONY = "//span[text()='The product Sony Xperia has been added to comparison list.']";
	public static final String MSG_ADD_COMPARE_SAMSUNG = "//span[text()='The product Samsung Galaxy has been added to comparison list.']";
	public static final String HEADER_COMPARE = "//h1[text()='Compare Products']";
	public static final String PRODUCT_SELECTED_SONY = "//table[@id='product_comparison']//td//h2/a[@title='Sony Xperia']";
	public static final String PRODUCT_SELECTED_SAMSUNG = "//table[@id='product_comparison']//td//h2/a[@title='Samsung Galaxy']";

}
