package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPages {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWellComeMessageDisplayed() {
		waitToElementVisible(driver, HomePageUI.WELLCOME_MSG);
		return isElementDisplayed(driver, HomePageUI.WELLCOME_MSG);

	}

	public void clickToNewCustomerLink() {
		waitToElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINKTEXT);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINKTEXT);

	}

	public void clickToEditCustomer() {
		waitToElementVisible(driver, HomePageUI.EDIT_CUSTOMER_LINKTEXT);
		clickToElement(driver, HomePageUI.EDIT_CUSTOMER_LINKTEXT);

	}

}
