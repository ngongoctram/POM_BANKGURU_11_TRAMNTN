package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {
	private WebDriver driverGlobal;

	public RegisterPageObject(WebDriver driverLocal) {
		driverGlobal = driverLocal;
	}

	public void inputToEmailIDTextbox(String EmailValue) {
		waitToElementVisible(driverGlobal, RegisterPageUI.EMAIL_ID_TEXTBOX);
		senkeyToElement(driverGlobal, RegisterPageUI.EMAIL_ID_TEXTBOX, EmailValue);
	}

	public void clickSubmitButton() {
		waitToElementVisible(driverGlobal, RegisterPageUI.SUBMIT_BUTTTON);
		clickToElement(driverGlobal, RegisterPageUI.SUBMIT_BUTTTON);

	}

	public String getUserTextValue() {
		waitToElementVisible(driverGlobal, RegisterPageUI.USER_ID_TEXT);
		return getText(driverGlobal, RegisterPageUI.USER_ID_TEXT);

	}

	public String getPasswordTextValue() {
		waitToElementVisible(driverGlobal, RegisterPageUI.PASSWORD_ID_TEXT);
		return getText(driverGlobal, RegisterPageUI.PASSWORD_ID_TEXT);

	}

}
