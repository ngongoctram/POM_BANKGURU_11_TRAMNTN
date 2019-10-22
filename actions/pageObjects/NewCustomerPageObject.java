package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;

public class NewCustomerPageObject extends AbstractPages {
	private WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
