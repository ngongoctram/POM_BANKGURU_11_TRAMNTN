package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPages {
	private WebDriver driverGlobal;

	public HomePageObject(WebDriver driverLocal) {
		driverGlobal = driverLocal;
	}

	public boolean isWellComeMessageDisplayed() {
		waitToElementVisible(driverGlobal, HomePageUI.WELLCOME_MSG);
		return isElementDisplayed(driverGlobal, HomePageUI.WELLCOME_MSG);

	}

	public void clickToNewCustomerLink() {
		waitToElementVisible(driverGlobal, HomePageUI.NEW_CUSTOMER_LINKTEXT);
		clickToElement(driverGlobal, HomePageUI.NEW_CUSTOMER_LINKTEXT);

	}

	public void clickToEditCustomer() {
		waitToElementVisible(driverGlobal, HomePageUI.EDIT_CUSTOMER_LINKTEXT);
		clickToElement(driverGlobal, HomePageUI.EDIT_CUSTOMER_LINKTEXT);

	}

}
