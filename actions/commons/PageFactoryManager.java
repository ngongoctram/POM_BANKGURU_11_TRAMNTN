package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageFactory;
import pageObjects.LoginPageFactory;
import pageObjects.RegisterPageFactory;

public class PageFactoryManager {

	public static LoginPageFactory loginPage(WebDriver driver) {
		return new LoginPageFactory(driver);
	}

	public static RegisterPageFactory registerPage(WebDriver driver) {
		return new RegisterPageFactory(driver);
	}

	public static HomePageFactory homePage(WebDriver driver) {
		return new HomePageFactory(driver);
	}

}
