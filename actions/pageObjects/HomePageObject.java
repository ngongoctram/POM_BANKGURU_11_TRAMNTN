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

}
