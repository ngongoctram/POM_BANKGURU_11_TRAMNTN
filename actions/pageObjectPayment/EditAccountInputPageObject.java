package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.EditAccountInputPageUI;

public class EditAccountInputPageObject extends AbstractPages {
	private WebDriver driver;

	public EditAccountInputPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAccountNo(String accountValue) {
		waitToElementInvisible(driver, EditAccountInputPageUI.ACCOUNT_NO_TXT);
		senkeyToElement(driver, EditAccountInputPageUI.ACCOUNT_NO_TXT, accountValue);

	}

	public void clickToSubmitButton() {
		waitToElementInvisible(driver, EditAccountInputPageUI.SUBMIT_BTN);
		clickToElement(driver, EditAccountInputPageUI.SUBMIT_BTN);
	}

}
