package liveGuruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import liveGuruPageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getDisplayedMessage() {
		waitToElementVisible(driver, RegisterPageUI.MESSAGE);
		return getText(driver, RegisterPageUI.MESSAGE);
	}

}
