package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import commons.PageFactoryManager;

public class RegisterPageFactory extends AbstractPageFactory {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	private WebElement emailTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='btnLogin']")
	private WebElement submitButton;

	@FindBy(how = How.XPATH, using = "//td[text()='User ID :']/following-sibling::td")
	private WebElement userText;

	@FindBy(how = How.XPATH, using = "//td[text()='Password :']/following-sibling::td")
	private WebElement passwordText;

	public RegisterPageFactory(WebDriver mappingDriver) {
		driver = mappingDriver;
		PageFactory.initElements(driver, this);
	}

	public LoginPageFactory OpenURL(String url) {
		openURL(driver, url);
		return PageFactoryManager.loginPage(driver);
	}

	public void inputToEmailIDTextbox(String EmailValue) {
		waitToElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, EmailValue);

	}

	public void clickSubmitButton() {
		waitToElementVisible(driver, submitButton);
		clickToElement(driver, submitButton);

	}

	public String getUserTextValue() {
		waitToElementVisible(driver, userText);
		return getTextToElement(driver, userText);
	}

	public String getPasswordTextValue() {
		waitToElementVisible(driver, passwordText);
		return getTextToElement(driver, passwordText);
	}

}
