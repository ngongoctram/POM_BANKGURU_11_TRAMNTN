package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.WithdrawPageUI;

public class WithdrawPageObject extends AbstractPages {
	private WebDriver driver;

	public WithdrawPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedMsgSuccess() {
		waitToElementVisible(driver, WithdrawPageUI.TRANS_WITHDRAWAL_MSG);
		return isElementDisplayed(driver, WithdrawPageUI.TRANS_WITHDRAWAL_MSG);
	}

	public String getCurrentAmount() {
		waitToElementVisible(driver, WithdrawPageUI.CRRENT_BALANCE);
		return getText(driver, WithdrawPageUI.CRRENT_BALANCE);
	}

}
