package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.EditAccountPageUI;

public class EditAccountPageObject extends AbstractPages {
	private WebDriver driver;

	public EditAccountPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void EditAccountType(String accountType) {
		waitToElementVisible(driver, EditAccountPageUI.ACCOUNT_TYPE_DRL);
		selectItemInDropdown(driver, EditAccountPageUI.ACCOUNT_TYPE_DRL, accountType);

	}

	public void clickSubmitBtn() {
		waitToElementInvisible(driver, EditAccountPageUI.SUBMIT_BTN);
		clickToElement(driver, EditAccountPageUI.SUBMIT_BTN);
	}

}
