package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.DepositPageUI;

public class DepositPageObject extends AbstractPages {
	private WebDriver driver;

	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedMsgSuccess() {
		waitToElementVisible(driver, DepositPageUI.TRANSACTION_DEPOSIT_MSG);
		return isElementDisplayed(driver, DepositPageUI.TRANSACTION_DEPOSIT_MSG);

	}

	public String getCurrentAmount() {
		waitToElementVisible(driver, DepositPageUI.CURRENT_BALANCE_TEXT);
		return getText(driver, DepositPageUI.CURRENT_BALANCE_TEXT);

	}

}
