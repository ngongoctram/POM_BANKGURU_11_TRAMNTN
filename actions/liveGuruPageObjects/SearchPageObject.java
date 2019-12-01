package liveGuruPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import liveGuruPageUIs.SearchPageUI;

public class SearchPageObject extends AbstractPages {

	public SearchPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	WebDriver driver;

	public void verifySearch(int searchValue1, int searchValue2) {
		waitToElementVisible(driver, SearchPageUI.LIST_ITEM_SEARCH);
		searchResult(driver, SearchPageUI.LIST_ITEM_SEARCH, SearchPageUI.NAME_PRODUCT, SearchPageUI.PRICE_PRODUCT, searchValue1, searchValue2);

	}

}
