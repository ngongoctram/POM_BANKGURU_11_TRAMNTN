package liveGuruPageUIs;

public class AddToCartPageUI {
	public static final String MESSAGE = "//span[text()='Sony Xperia was added to your shopping cart.']";
	public static final String DISCOUNT_TEXT = "//table[@id ='shopping-cart-totals-table']//tr[2]/td[1]";
	public static final String DISCOUNT_PRICE = "//table[@id ='shopping-cart-totals-table']//tr[2]/td[2]/span";
	public static final String TOTAL_PRICE = "//table[@id ='shopping-cart-totals-table']//tfoot//tr[1]//td[2]//span";
	public static final String QTY_INPUT = "//input[@class='input-text qty']";
	public static final String MSG_ERR_QTY = "//p[@class ='item-msg error']";
	public static final String MSG_FOR_EMPTY1 = "//h1[text()='Shopping Cart is Empty']";
	public static final String MSG_FOR_EMPTY2 = "//div[@class='cart-empty']//p[1]";
	public static final String SHIPPING_CONUNTRY = "//select[@id='country']";
	public static final String PROVINCY = "//select[@id='region_id']";
	public static final String ZIP = "//input[@id='postcode']";
	public static final String SHIPPING_COST = "//label[@for='s_method_flatrate_flatrate']//span";
	public static final String SHIPPING_COST_RADIOCHECK = "//input[@id='s_method_flatrate_flatrate']";

}
