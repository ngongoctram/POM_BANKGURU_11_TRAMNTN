package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.CustomerRegMsgPageUI;

public class CustomerRegMsgPageObject extends AbstractPages {

	private WebDriver driver;

	public CustomerRegMsgPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedMsgCreateCustomer() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.REGISTER_SUCCESS_MSG);
		return isElementDisplayed(driver, CustomerRegMsgPageUI.REGISTER_SUCCESS_MSG);

	}

	public String getTextCustomerName() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.CUSTOMER_NAME_TEXT);
		return getText(driver, CustomerRegMsgPageUI.CUSTOMER_NAME_TEXT);
	}

	public String getTextDateOfBirth() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.DATE_BIRTH_TEXT);
		return getText(driver, CustomerRegMsgPageUI.DATE_BIRTH_TEXT);
	}

	public String getTextAddress() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.ADDRESS_TEXT);
		return getText(driver, CustomerRegMsgPageUI.ADDRESS_TEXT);
	}

	public String getTextCity() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.CITY_TEXT);
		return getText(driver, CustomerRegMsgPageUI.CITY_TEXT);
	}

	public String getTextState() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.STATE_TEXT);
		return getText(driver, CustomerRegMsgPageUI.STATE_TEXT);
	}

	public String getTextpin() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.PIN_TEXT);
		return getText(driver, CustomerRegMsgPageUI.PIN_TEXT);
	}

	public String getTextMobileNumber() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.MOBILE_TEXT);
		return getText(driver, CustomerRegMsgPageUI.MOBILE_TEXT);
	}

	public String getTextEmail() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.EMAIL_TEXT);
		return getText(driver, CustomerRegMsgPageUI.EMAIL_TEXT);
	}

	public void clickToContinueLink() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.CONTINUE_LINKTEXT);
		clickToElement(driver, CustomerRegMsgPageUI.CONTINUE_LINKTEXT);

	}

	public String getCustomerID() {
		waitToElementVisible(driver, CustomerRegMsgPageUI.CUSTOMER_ID);
		return getText(driver, CustomerRegMsgPageUI.CUSTOMER_ID);
	}

}
