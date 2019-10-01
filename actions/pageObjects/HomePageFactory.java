package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class HomePageFactory extends AbstractPageFactory {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")
	private WebElement wellcomeMessage;

	public HomePageFactory(WebDriver mappingDriver) {
		driver = mappingDriver;
		PageFactory.initElements(driver, this);
	}

	public boolean isWellComeMessageDisplayed() {
		waitToElementVisible(driver, wellcomeMessage);
		return isElementDisplayed(driver, wellcomeMessage);
	}

}
