package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.DeleteAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageFactory;
import pageObjects.HomePageObject;
import pageObjects.LoginPageFactory;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageFactory;

public class PageGeneratorManager {

	public static LoginPageFactory loginPage(WebDriver driver) {
		return new LoginPageFactory(driver);
	}

	public static RegisterPageFactory registerPage(WebDriver driver) {
		return new RegisterPageFactory(driver);
	}

	public static HomePageFactory homePage(WebDriver driver) {
		return new HomePageFactory(driver);
	}

	public static NewCustomerPageObject newCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}

	public static EditCustomerPageObject editCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}

	public static DeleteAccountPageObject deleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}

	public static LoginPageObject loginPage1(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static HomePageObject homePage1(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
