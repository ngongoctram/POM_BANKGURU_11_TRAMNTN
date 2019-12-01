package commons;

import org.openqa.selenium.WebDriver;

import liveGuruPageObjects.AccountInforPageObject;
import liveGuruPageObjects.AddToCartPageObject;
import liveGuruPageObjects.CheckoutPageObject;
import liveGuruPageObjects.DetailMobilePageObject;
import liveGuruPageObjects.DetailTVPageObject;
import liveGuruPageObjects.HomePageObject;
import liveGuruPageObjects.ListMobilePageObject;
import liveGuruPageObjects.ListTVPageObject;
import liveGuruPageObjects.LoginPageObject;
import liveGuruPageObjects.MyWishlistPageObject;
import liveGuruPageObjects.RegisterPageObject;
import liveGuruPageObjects.ReviewPageObject;
import liveGuruPageObjects.SearchPageObject;

public class PageGeneratorManagerForLiveGuru {

	public static AccountInforPageObject getAccountInforPage(WebDriver driver) {
		return new AccountInforPageObject(driver);
	}

	public static AddToCartPageObject getAddToCartPage(WebDriver driver) {
		return new AddToCartPageObject(driver);
	}

	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}

	public static DetailMobilePageObject getDetailMobilePage(WebDriver driver) {
		return new DetailMobilePageObject(driver);
	}

	public static DetailTVPageObject getDetailTVPage(WebDriver driver) {
		return new DetailTVPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static ListMobilePageObject getListMobilePage(WebDriver driver) {
		return new ListMobilePageObject(driver);
	}

	public static ListTVPageObject getListTVPage(WebDriver driver) {
		return new ListTVPageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static MyWishlistPageObject getMyWishlistPage(WebDriver driver) {
		return new MyWishlistPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static ReviewPageObject getReviewPage(WebDriver driver) {
		return new ReviewPageObject(driver);
	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}

}