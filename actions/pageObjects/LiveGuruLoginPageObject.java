package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.LiveGuruLoginPageUI;

public class LiveGuruLoginPageObject extends AbstractPages {
	WebDriver driver;

	public LiveGuruLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementVisible(driver, LiveGuruLoginPageUI.EMAIL_TXT);
		senkeyToElement(driver, LiveGuruLoginPageUI.EMAIL_TXT, emailValue);
	}

	public void inputToPasswordTextbox(String passValue) {
		waitToElementVisible(driver, LiveGuruLoginPageUI.PASSWORD_TXT);
		senkeyToElement(driver, LiveGuruLoginPageUI.PASSWORD_TXT, passValue);
	}

	public void clickOnLoginButton() {
		waitToElementVisible(driver, LiveGuruLoginPageUI.LOGIN_BTN);
		clickToElement(driver, LiveGuruLoginPageUI.LOGIN_BTN);
	}

	public String getEmptyEmailErrorMessage() {
		waitToElementVisible(driver, LiveGuruLoginPageUI.EMPTY_EMAIL_ERR_MSG);
		return getText(driver, LiveGuruLoginPageUI.EMPTY_EMAIL_ERR_MSG);
	}

	public String getEmptyPasswordErrorMessage() {
		waitToElementVisible(driver, LiveGuruLoginPageUI.EMPTY_PASS_ERR_MSG);
		return getText(driver, LiveGuruLoginPageUI.EMPTY_PASS_ERR_MSG);

	}

	public String getInvalidEmailErrorMessage() {
		waitToElementVisible(driver, LiveGuruLoginPageUI.INVALID_EMAIL_ERR_MSG);
		return getText(driver, LiveGuruLoginPageUI.INVALID_EMAIL_ERR_MSG);

	}

	public String getPasswordLessErrorMessage() {
		waitToElementVisible(driver, LiveGuruLoginPageUI.INVALID_PASS_ERR_MSG);
		return getText(driver, LiveGuruLoginPageUI.INVALID_PASS_ERR_MSG);
	}

	public String getIncorrectEmailOrPasswordErrorMessage() {
		waitToElementVisible(driver, LiveGuruLoginPageUI.INVALID_LOGIN_MSG);
		return getText(driver, LiveGuruLoginPageUI.INVALID_LOGIN_MSG);
	}

}
