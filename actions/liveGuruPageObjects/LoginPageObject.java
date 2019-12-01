package liveGuruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;

public class LoginPageObject extends AbstractPages {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

}
