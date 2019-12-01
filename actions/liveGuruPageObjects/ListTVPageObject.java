package liveGuruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import liveGuruPageUIs.ListTVPageUI;

public class ListTVPageObject extends AbstractPages {
	WebDriver driver;

	public ListTVPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getMsgAddWishlist() {
		waitToElementVisible(driver, ListTVPageUI.MSG_ADD_WISHLIST);
		return getText(driver, ListTVPageUI.MSG_ADD_WISHLIST);

	}

}
