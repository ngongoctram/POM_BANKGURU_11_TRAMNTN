package liveGuruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import liveGuruPageUIs.MyWishlistPageUI;

public class MyWishlistPageObject extends AbstractPages {
	WebDriver driver;

	public MyWishlistPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public String getMsgShareWhishlist() {
		waitToElementVisible(driver, MyWishlistPageUI.MSG_SHARE_WISHLIST);
		return getText(driver, MyWishlistPageUI.MSG_SHARE_WISHLIST);

	}

	public int countItemsInWishListPage() {
		waitToElementVisible(driver, MyWishlistPageUI.ITEMS_WISHLIST);
		return countNumberOfElement(driver, MyWishlistPageUI.ITEMS_WISHLIST);

	}

}
