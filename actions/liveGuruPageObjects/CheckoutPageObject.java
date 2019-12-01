package liveGuruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import liveGuruPageUIs.CheckoutPageUI;

public class CheckoutPageObject extends AbstractPages {
	WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickToContinueShippingMethodButton() {
		waitToElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_BTN);
		clickToElement(driver, CheckoutPageUI.SHIPPING_METHOD_BTN);

	}

	public void choosePaymentInformation() {
		waitToElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_BTN);
		clickToElement(driver, CheckoutPageUI.SHIPPING_METHOD_BTN);
	}

	public void clickToContinuePaymentButton() {
		waitToElementVisible(driver, CheckoutPageUI.PAYMENT_BTN);
		clickToElement(driver, CheckoutPageUI.PAYMENT_BTN);
	}

	public boolean isDisplayedMsgOrderSuccess() {
		waitToElementVisible(driver, CheckoutPageUI.PAYMENT_BTN);
		return isElementDisplayed(driver, CheckoutPageUI.PAYMENT_BTN);

	}

	public boolean orderNumberIsGenerated() {
		waitToElementVisible(driver, CheckoutPageUI.ORDER_NUMBER);
		return isElementDisplayed(driver, CheckoutPageUI.ORDER_NUMBER);

	}

}
