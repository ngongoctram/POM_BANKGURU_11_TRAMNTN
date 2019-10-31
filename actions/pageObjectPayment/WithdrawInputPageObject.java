package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.WithdrawInputPageUI;

public class WithdrawInputPageObject extends AbstractPages {
	private WebDriver driver;

	public WithdrawInputPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAccountNo(String accountValue) {
		waitToElementInvisible(driver, WithdrawInputPageUI.ACCOUNT_NO_TXT);
		senkeyToElement(driver, WithdrawInputPageUI.ACCOUNT_NO_TXT, accountValue);

	}

	public void inputAmount(int amountValue) {
		waitToElementInvisible(driver, WithdrawInputPageUI.AMOUNT_TXT);
		sendkeyToElementConvertToString(driver, WithdrawInputPageUI.AMOUNT_TXT, amountValue);
	}

	public void inputDescription(String description) {
		waitToElementInvisible(driver, WithdrawInputPageUI.DESCRIPTION);
		senkeyToElement(driver, WithdrawInputPageUI.DESCRIPTION, description);

	}

	public void clickSubmitBtn() {
		waitToElementInvisible(driver, WithdrawInputPageUI.SUBMIT_BTN);
		clickToElement(driver, WithdrawInputPageUI.SUBMIT_BTN);
	}

}
