package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.EditCustomerPageUI;

public class EditCustomerPageObject extends AbstractPages {
	private WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAddressEditValue(String addressEdit) {
		waitToElementVisible(driver, EditCustomerPageUI.ADDRESS_TXT);
		senkeyToElement(driver, EditCustomerPageUI.ADDRESS_TXT, addressEdit);

	}

	public void inputCityValue(String cityEdit) {
		waitToElementVisible(driver, EditCustomerPageUI.CITY_TXT);
		senkeyToElement(driver, EditCustomerPageUI.CITY_TXT, cityEdit);

	}

	public void inputStateValue(String stateEdit) {
		waitToElementVisible(driver, EditCustomerPageUI.STATE_TXT);
		senkeyToElement(driver, EditCustomerPageUI.STATE_TXT, stateEdit);
	}

	public void inputPinvalue(String pinEdit) {
		waitToElementVisible(driver, EditCustomerPageUI.PIN_TXT);
		senkeyToElement(driver, EditCustomerPageUI.PIN_TXT, pinEdit);

	}

	public void clickToSubmitButton() {
		waitToElementVisible(driver, EditCustomerPageUI.SUBMIT_BTN);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BTN);

	}

}
