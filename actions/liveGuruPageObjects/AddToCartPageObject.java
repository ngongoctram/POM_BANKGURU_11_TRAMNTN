package liveGuruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import liveGuruPageUIs.AddToCartPageUI;

public class AddToCartPageObject extends AbstractPages {
	WebDriver driver;

	public AddToCartPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getMessageDisplayed() {
		waitToElementVisible(driver, AddToCartPageUI.MESSAGE);
		return getText(driver, AddToCartPageUI.MESSAGE);

	}

	public String getDiscountText() {
		waitToElementVisible(driver, AddToCartPageUI.DISCOUNT_TEXT);
		return getText(driver, AddToCartPageUI.DISCOUNT_TEXT);

	}

	public String getDiscountPrice() {
		waitToElementVisible(driver, AddToCartPageUI.DISCOUNT_PRICE);
		return getText(driver, AddToCartPageUI.DISCOUNT_PRICE);

	}

	public String getTotalPrice() {
		waitToElementVisible(driver, AddToCartPageUI.TOTAL_PRICE);
		return getText(driver, AddToCartPageUI.TOTAL_PRICE);

	}

	public void inputToQTYTextbox(String QTYValue) {
		waitToElementVisible(driver, AddToCartPageUI.QTY_INPUT);
		senkeyToElement(driver, AddToCartPageUI.QTY_INPUT, QTYValue);

	}

	public String getWarningMsgForQTY() {
		waitToElementVisible(driver, AddToCartPageUI.MSG_ERR_QTY);
		return getText(driver, AddToCartPageUI.MSG_ERR_QTY);

	}

	public String getMsgForEmptyItem1() {
		waitToElementVisible(driver, AddToCartPageUI.MSG_FOR_EMPTY1);
		return getText(driver, AddToCartPageUI.MSG_FOR_EMPTY1);

	}

	public String getMsgForEmptyItem2() {
		waitToElementVisible(driver, AddToCartPageUI.MSG_FOR_EMPTY2);
		return getText(driver, AddToCartPageUI.MSG_FOR_EMPTY2);
	}

	public void enterShippingCountry(String countryValue) {
		waitToElementVisible(driver, AddToCartPageUI.SHIPPING_CONUNTRY);
		selectItemInDropdown(driver, AddToCartPageUI.SHIPPING_CONUNTRY, countryValue);

	}

	public void enterProvince(String provincyValue) {
		waitToElementVisible(driver, AddToCartPageUI.PROVINCY);
		selectItemInDropdown(driver, AddToCartPageUI.PROVINCY, provincyValue);

	}

	public void enterZip(String zipValue) {
		waitToElementVisible(driver, AddToCartPageUI.ZIP);
		senkeyToElement(driver, AddToCartPageUI.ZIP, zipValue);

	}

	public boolean isDisplayedShippingCost() {
		waitToElementVisible(driver, AddToCartPageUI.SHIPPING_COST);
		return isElementDisplayed(driver, AddToCartPageUI.SHIPPING_COST);

	}

	public String getShippingCost() {
		waitToElementVisible(driver, AddToCartPageUI.SHIPPING_COST);
		return getText(driver, AddToCartPageUI.SHIPPING_COST);

	}

	public void selectShippingCost() {
		waitToElementVisible(driver, AddToCartPageUI.SHIPPING_COST_RADIOCHECK);
		checkToCheckbox(driver, AddToCartPageUI.SHIPPING_COST_RADIOCHECK);

	}

}
