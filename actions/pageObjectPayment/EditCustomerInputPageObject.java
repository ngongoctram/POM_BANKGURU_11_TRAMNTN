package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.EditCustomerInputPageUI;

public class EditCustomerInputPageObject extends AbstractPages {
	private WebDriver driver;

	public EditCustomerInputPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerID(String customerID) {
		waitToElementVisible(driver, EditCustomerInputPageUI.CUSTOMER_ID_TXT);
		senkeyToElement(driver, EditCustomerInputPageUI.CUSTOMER_ID_TXT, customerID);

	}

	public void clickToSubmitButton() {
		waitToElementVisible(driver, EditCustomerInputPageUI.SUBMIT_BTN);
		clickToElement(driver, EditCustomerInputPageUI.SUBMIT_BTN);

	}

}
