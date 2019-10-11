package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.AddAccountPageUI;

public class AddAccountPageObject extends AbstractPages {
	private WebDriver driver;

	public AddAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerID(String customerID) {
		waitToElementVisible(driver, AddAccountPageUI.CUSTOMER_ID_TXT);
		senkeyToElement(driver, AddAccountPageUI.CUSTOMER_ID_TXT, customerID);

	}

	public void selectAccountType(String accountType) {
		waitToElementVisible(driver, AddAccountPageUI.ACCOUNT_TYPE_DRL);
		selectItemInDropdown(driver, AddAccountPageUI.ACCOUNT_TYPE_DRL, accountType);
	}

	public void inputDeposit(String depositValue) {
		waitToElementVisible(driver, AddAccountPageUI.INITIAL_DEPOSIT_TXT);
		senkeyToElement(driver, AddAccountPageUI.INITIAL_DEPOSIT_TXT, depositValue);

	}

	public void clickSubmitButton() {
		waitToElementVisible(driver, AddAccountPageUI.SUBMIT_BTN);
		clickToElement(driver, AddAccountPageUI.SUBMIT_BTN);

	}

	public void clickToAccountTypeDropdown() {
		waitToElementVisible(driver, AddAccountPageUI.ACCOUNT_TYPE_DRL);
		clickToElement(driver, AddAccountPageUI.ACCOUNT_TYPE_DRL);

	}

}
