package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import commons.PageGeneratorManager;

public class LoginPageFactory extends AbstractPageFactory {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[text()='here']")
	private WebElement hereLink;

	@FindBy(how = How.XPATH, using = "//input[@name='uid']")
	private WebElement userNameTextbox;

	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordTextbox;

	@FindBy(how = How.NAME, using = "btnLogin")
	private WebElement LoginButton;

	public LoginPageFactory(WebDriver mappingDriver) {
		driver = mappingDriver;
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageURL() {
		return getCurrentURL(driver);
	}

	public RegisterPageFactory clickToHereLink() {
		waitToElementVisible(driver, hereLink);
		clickToElement(driver, hereLink);
		return PageGeneratorManager.registerPage(driver);

	}

	public void inputToUserIDTextbox(String userIDValue) {
		waitToElementVisible(driver, userNameTextbox);
		sendKeyToElement(driver, userNameTextbox, userIDValue);

	}

	public void inputToPasswordIDTextbox(String passwordIDValue) {
		waitToElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, passwordIDValue);

	}

	public HomePageFactory clickLoginButton() {
		waitToElementVisible(driver, LoginButton);
		clickToElement(driver, LoginButton);
		return PageGeneratorManager.homePage(driver);
	}

}
