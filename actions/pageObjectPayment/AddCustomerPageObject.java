package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.AddCustomerPageUI;

public class AddCustomerPageObject extends AbstractPages {
	private WebDriver driver;

	public AddCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerName(String nameValue) {
		waitToElementVisible(driver, AddCustomerPageUI.CUSTOMER_NAME_TXT);
		senkeyToElement(driver, AddCustomerPageUI.CUSTOMER_NAME_TXT, nameValue);

	}

	public void inputDateOfBirth(String dateValue) {
		waitToElementVisible(driver, AddCustomerPageUI.DATE_BIRTH_TXT);
		senkeyToElement(driver, AddCustomerPageUI.DATE_BIRTH_TXT, dateValue);

	}

	public void inputAddress(String addressValue) {
		waitToElementVisible(driver, AddCustomerPageUI.ADDRESS_TXT);
		senkeyToElement(driver, AddCustomerPageUI.ADDRESS_TXT, addressValue);

	}

	public void inputCity(String cityValue) {
		waitToElementVisible(driver, AddCustomerPageUI.CITY_TXT);
		senkeyToElement(driver, AddCustomerPageUI.CITY_TXT, cityValue);

	}

	public void inputState(String stateValue) {
		waitToElementVisible(driver, AddCustomerPageUI.STATE_TXT);
		senkeyToElement(driver, AddCustomerPageUI.STATE_TXT, stateValue);

	}

	public void inputPIN(String pinValue) {
		waitToElementVisible(driver, AddCustomerPageUI.PIN_TXT);
		senkeyToElement(driver, AddCustomerPageUI.PIN_TXT, pinValue);

	}

	public void inputMobileNumber(String mobileValue) {
		waitToElementVisible(driver, AddCustomerPageUI.MOBILE_TXT);
		senkeyToElement(driver, AddCustomerPageUI.MOBILE_TXT, mobileValue);
	}

	public void inputEmail(String emailValue) {
		waitToElementVisible(driver, AddCustomerPageUI.EMAIL_TXT);
		senkeyToElement(driver, AddCustomerPageUI.EMAIL_TXT, emailValue);

	}

	public void inputPassword(String passValue) {
		waitToElementVisible(driver, AddCustomerPageUI.PASSWORD_TXT);
		senkeyToElement(driver, AddCustomerPageUI.PASSWORD_TXT, passValue);

	}

	public void clickToSubmitButton() {
		waitToElementVisible(driver, AddCustomerPageUI.SUBMIT_BTN);
		clickToElement(driver, AddCustomerPageUI.SUBMIT_BTN);

	}

}
