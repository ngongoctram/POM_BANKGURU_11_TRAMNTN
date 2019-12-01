package liveGuruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import liveGuruPageUIs.ListMobilePageUI;

public class ListMobilePageObject extends AbstractPages {
	WebDriver driver;

	public ListMobilePageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getPriceOfProductInList() {
		waitToElementVisible(driver, ListMobilePageUI.PRICE_SONY_XPERIA_LIST);
		return getText(driver, ListMobilePageUI.PRICE_SONY_XPERIA_LIST);

	}

	public String getPriceOfProductInDetail() {
		waitToElementVisible(driver, ListMobilePageUI.PRICE_SONY_XPERIA_DETAIL);
		return getText(driver, ListMobilePageUI.PRICE_SONY_XPERIA_DETAIL);
	}

	public void clickAddToCart() {
		waitToElementVisible(driver, ListMobilePageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, ListMobilePageUI.ADD_TO_CART_BUTTON);

	}

	public String getMsgAddSony() {
		waitToElementVisible(driver, ListMobilePageUI.MSG_ADD_COMPARE_SONY);
		return getText(driver, ListMobilePageUI.MSG_ADD_COMPARE_SONY);

	}

	public String getMsgAddSamsung() {
		waitToElementVisible(driver, ListMobilePageUI.MSG_ADD_COMPARE_SAMSUNG);
		return getText(driver, ListMobilePageUI.MSG_ADD_COMPARE_SAMSUNG);

	}

	public String getHeaderCompareWindow() {
		waitToElementVisible(driver, ListMobilePageUI.HEADER_COMPARE);
		return getText(driver, ListMobilePageUI.HEADER_COMPARE);

	}

	public boolean displayedProductSelectedSony() {
		waitToElementVisible(driver, ListMobilePageUI.PRODUCT_SELECTED_SONY);
		return isElementDisplayed(driver, ListMobilePageUI.PRODUCT_SELECTED_SONY);

	}

	public boolean displayedProductSelectedSamsung() {
		waitToElementVisible(driver, ListMobilePageUI.PRODUCT_SELECTED_SAMSUNG);
		return isElementDisplayed(driver, ListMobilePageUI.PRODUCT_SELECTED_SAMSUNG);

	}

}
