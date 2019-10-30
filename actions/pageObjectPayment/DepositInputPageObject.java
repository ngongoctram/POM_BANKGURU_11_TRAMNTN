package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.DepositInputPageUI;

public class DepositInputPageObject extends AbstractPages {
	private WebDriver driver;

	public DepositInputPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAccountNo(String accountValue) {
		waitToElementInvisible(driver, DepositInputPageUI.ACCOUNT_NO_TXT);
		senkeyToElement(driver, DepositInputPageUI.ACCOUNT_NO_TXT, accountValue);

	}

	public void inputAmountValue(int amountValue) {
		waitToElementInvisible(driver, DepositInputPageUI.AMOUNT_TXT);
		sendkeyToElementConvertToString(driver, DepositInputPageUI.AMOUNT_TXT, amountValue);
	}

	public void inputDescription(String description) {
		waitToElementInvisible(driver, DepositInputPageUI.DESCRIPTION_TXT);
		senkeyToElement(driver, DepositInputPageUI.DESCRIPTION_TXT, description);
	}

	public void clickToSubmitBtn() {
		waitToElementInvisible(driver, DepositInputPageUI.SUBMIT_BTN);
		clickToElement(driver, DepositInputPageUI.SUBMIT_BTN);
	}

}
