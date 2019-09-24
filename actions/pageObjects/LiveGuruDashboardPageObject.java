package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.LiveGuruDashboardPageUI;

public class LiveGuruDashboardPageObject extends AbstractPages {
	WebDriver driver;

	public LiveGuruDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedLoginSuccessInDashboard() {
		waitToElementVisible(driver, LiveGuruDashboardPageUI.DASHBOARD_TEXT);
		return isElementDisplayed(driver, LiveGuruDashboardPageUI.DASHBOARD_TEXT);
	}

}
