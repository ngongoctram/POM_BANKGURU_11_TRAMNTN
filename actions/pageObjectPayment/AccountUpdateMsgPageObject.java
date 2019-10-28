package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.AccountUpdateMsgPageUI;

public class AccountUpdateMsgPageObject extends AbstractPages {
	private WebDriver driver;

	public AccountUpdateMsgPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedMsgSuccess() {
		waitToElementVisible(driver, AccountUpdateMsgPageUI.ACCOUNT_UPDATE_MSG);
		return isElementDisplayed(driver, AccountUpdateMsgPageUI.ACCOUNT_UPDATE_MSG);
	}

	public String getTextAccountType() {
		waitToElementVisible(driver, AccountUpdateMsgPageUI.ACCOUNT_TYPE_TEXT);
		return getText(driver, AccountUpdateMsgPageUI.ACCOUNT_TYPE_TEXT);
	}

}
