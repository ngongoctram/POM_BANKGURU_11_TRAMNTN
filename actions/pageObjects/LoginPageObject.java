package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPages {
	private WebDriver driverGlobal;

	public LoginPageObject(WebDriver driverLocal) {
		driverGlobal = driverLocal;

	}

	public String getLoginPageURL() {
		return getCurrentUrl(driverGlobal);
	}

	public void clickToHereLink() {
		waitToElementVisible(driverGlobal, LoginPageUI.HERE_LINK);
		clickToElement(driverGlobal, LoginPageUI.HERE_LINK);

	}

	public void inputToUserIDTextbox(String userIDValue) {
		waitToElementVisible(driverGlobal, LoginPageUI.USERNAME_TEXTBOX);
		senkeyToElement(driverGlobal, LoginPageUI.USERNAME_TEXTBOX, userIDValue);
	}

	public void inputToPasswordIDTextbox(String passwordIDValue) {
		waitToElementVisible(driverGlobal, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driverGlobal, LoginPageUI.PASSWORD_TEXTBOX, passwordIDValue);

	}

	public void clickLoginButton() {
		waitToElementVisible(driverGlobal, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driverGlobal, LoginPageUI.LOGIN_BUTTON);

	}

}
