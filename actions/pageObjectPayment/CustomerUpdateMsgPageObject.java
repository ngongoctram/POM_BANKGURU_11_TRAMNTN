package pageObjectPayment;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIForPayment.CustomerUpdateMsgPageUI;

public class CustomerUpdateMsgPageObject extends AbstractPages {
	private WebDriver driver;

	public CustomerUpdateMsgPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayedCustomerUpdateMsg() {
		waitToElementVisible(driver, CustomerUpdateMsgPageUI.UPDATE_SUCCESS_MSG);
		return isElementDisplayed(driver, CustomerUpdateMsgPageUI.UPDATE_SUCCESS_MSG);

	}

}
