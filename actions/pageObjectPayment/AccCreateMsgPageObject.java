package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.AccCreateMsgPageUI;

public class AccCreateMsgPageObject extends AbstractPages {
	private WebDriver driver;

	public AccCreateMsgPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedMsgSuccess() {
		waitToElementVisible(driver, AccCreateMsgPageUI.ACCOUNT_CREATE_SUCCESS_MSG);
		return isElementDisplayed(driver, AccCreateMsgPageUI.ACCOUNT_CREATE_SUCCESS_MSG);

	}

	public String getTextDeposit() {
		waitToElementVisible(driver, AccCreateMsgPageUI.CURRENT_AMOUNT_TEXT);
		return getText(driver, AccCreateMsgPageUI.CURRENT_AMOUNT_TEXT);

	}

}
