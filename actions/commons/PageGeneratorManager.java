package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class PageGeneratorManager {

	public static LoginPageObject loginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject registerPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject homePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
