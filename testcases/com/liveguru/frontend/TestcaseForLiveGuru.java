package com.liveguru.frontend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManagerForLiveGuru;
import liveGuruPageObjects.AccountInforPageObject;
import liveGuruPageObjects.AddToCartPageObject;
import liveGuruPageObjects.CheckoutPageObject;
import liveGuruPageObjects.DetailMobilePageObject;
import liveGuruPageObjects.DetailTVPageObject;
import liveGuruPageObjects.HomePageObject;
import liveGuruPageObjects.ListMobilePageObject;
import liveGuruPageObjects.ListTVPageObject;
import liveGuruPageObjects.MyWishlistPageObject;
import liveGuruPageObjects.RegisterPageObject;
import liveGuruPageObjects.SearchPageObject;

public class TestcaseForLiveGuru extends AbstractTest {
	WebDriver driver;
	String firstName, middleName, lastName, email, password, confirmPassword;
	String priceInList, counpon, QTYValue, emailShare;
	String priceInListTrim$, discountPriceTrim$;
	String detail, title, nickname, country, provincy, zip, shippingCost, priceProductInCart;
	int priceFrom, priceTo;

	private AccountInforPageObject accountInforPage;
	private AddToCartPageObject addToCartPage;
	private CheckoutPageObject checkoutPage;
	private DetailMobilePageObject detailMobilePage;
	private DetailTVPageObject detailTVPage;
	private HomePageObject homePage;
	private ListMobilePageObject listMobilePage;
	private ListTVPageObject listTVPage;
	private MyWishlistPageObject myWishlistPage;
	private RegisterPageObject registerPage;
	private SearchPageObject searchPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		firstName = "Tony";
		middleName = "";
		lastName = "Becker";
		email = "mailtest" + randomEmail() + "@gmail.com";
		password = "1234567";
		confirmPassword = "1234567";

		counpon = "GURU50";
		QTYValue = "501";

		emailShare = "ngoctramtk94@gmail.com";

		detail = "review";
		title = "ABCD";
		nickname = "gemma";

		country = "United States";
		provincy = "New York";
		zip = "543432";

		priceFrom = 0;
		priceTo = 150;

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://live.demoguru99.com/");
		homePage = PageGeneratorManagerForLiveGuru.getHomePage(driver);

	}

	@Test
	public void TC_01_RegisterToSystem() {
		homePage.clickToDynamicMenu(driver, "Account");
		homePage.clickToDynamicTitle(driver, "Register");
		registerPage = PageGeneratorManagerForLiveGuru.getRegisterPage(driver);
		registerPage.inputToDynamicTextbox(driver, firstName, "firstname");
		registerPage.inputToDynamicTextbox(driver, lastName, "lastname");
		registerPage.inputToDynamicTextbox(driver, email, "email");
		registerPage.inputToDynamicTextbox(driver, password, "password");
		registerPage.inputToDynamicTextbox(driver, confirmPassword, "confirmation");
		registerPage.clickToDynamicButton2(driver, "Register");
		Assert.assertEquals(registerPage.getDisplayedMessage(), "Thank you for registering with Main Website Store.");

	}

	@Test
	public void TC_02_VerifyAccountInformation() {
		registerPage.OpenPageByDynamicLocator(driver, "Account Information");
		accountInforPage = PageGeneratorManagerForLiveGuru.getAccountInforPage(driver);
		Assert.assertEquals(accountInforPage.getDynamicTextInTextbox(driver, "firstname"), firstName);
		Assert.assertEquals(accountInforPage.getDynamicTextInTextbox(driver, "lastname"), lastName);
		Assert.assertEquals(accountInforPage.getDynamicTextInTextbox(driver, "email"), email);

	}

	@Test
	public void TC_03_VerifyCostOfProduct() {
		accountInforPage.clickToDynamicLink(driver, "Mobile");
		listMobilePage = PageGeneratorManagerForLiveGuru.getListMobilePage(driver);
		priceInListTrim$ = listMobilePage.getPriceOfProductInList().replace("$", "").trim();
		priceInList = listMobilePage.getPriceOfProductInList();
		listMobilePage.clickToDynamicImage(driver, "Xperia");
		Assert.assertEquals(listMobilePage.getPriceOfProductInDetail(), priceInList);

	}

	@Test
	public void TC_04_VerifyDiscountCoupon() {
		listMobilePage.clickToDynamicLink(driver, "Mobile");
		listMobilePage = PageGeneratorManagerForLiveGuru.getListMobilePage(driver);
		listMobilePage.clickAddToCart();
		addToCartPage = PageGeneratorManagerForLiveGuru.getAddToCartPage(driver);
		Assert.assertEquals(addToCartPage.getMessageDisplayed(), "Sony Xperia was added to your shopping cart.");
		addToCartPage.inputToDynamicTextbox(driver, counpon, "coupon_code");
		addToCartPage.clickToDynamicButton2(driver, "Apply");
		Assert.assertEquals(addToCartPage.getDiscountText(), "DISCOUNT (" + counpon + ")");
		Assert.assertEquals(addToCartPage.getDiscountPrice(), "-$5.00");
		discountPriceTrim$ = addToCartPage.getDiscountPrice().replace("-$", "").trim();
		Assert.assertEquals(addToCartPage.getTotalPrice(), "$" + String.valueOf(Float.parseFloat(priceInListTrim$) - Float.parseFloat(discountPriceTrim$)));

	}

	@Test
	public void TC_05_VerifyAddMore500Items() {
		addToCartPage.inputToQTYTextbox(QTYValue);
		addToCartPage.clickToDynamicButton2(driver, "Update");
		Assert.assertEquals(addToCartPage.getWarningMsgForQTY(), "* The maximum quantity allowed for purchase is 500.");
		addToCartPage.clickToDynamicButton2(driver, "Empty Cart");
		Assert.assertEquals(addToCartPage.getMsgForEmptyItem1(), "SHOPPING CART IS EMPTY");
		Assert.assertEquals(addToCartPage.getMsgForEmptyItem2(), "You have no items in your shopping cart.");

	}

	@Test
	public void TC_06_VerifyCompareProduct() {
		addToCartPage.clickToDynamicLink(driver, "Mobile");
		listMobilePage = PageGeneratorManagerForLiveGuru.getListMobilePage(driver);
		listMobilePage.clickToDynamicCompare(driver, "Sony Xperia");
		Assert.assertEquals(listMobilePage.getMsgAddSony(), "The product Sony Xperia has been added to comparison list.");
		listMobilePage.clickToDynamicCompare(driver, "Samsung Galaxy");
		Assert.assertEquals(listMobilePage.getMsgAddSamsung(), "The product Samsung Galaxy has been added to comparison list.");
		listMobilePage.clickToDynamicButton2(driver, "Compare");
		listMobilePage.switchToWindowByTitle(driver, "Products Comparison List - Magento Commerce");
		Assert.assertEquals(listMobilePage.getHeaderCompareWindow(), "COMPARE PRODUCTS");
		Assert.assertTrue(listMobilePage.displayedProductSelectedSony());
		Assert.assertTrue(listMobilePage.displayedProductSelectedSamsung());
		listMobilePage.clickToDynamicButton2(driver, "Close Window");
		listMobilePage.switchToWindowByTitle(driver, "Mobile");

	}

	@Test
	public void TC_07_VerifyShareWishlist() {
		listMobilePage.clickToDynamicLink(driver, "TV");
		listTVPage = PageGeneratorManagerForLiveGuru.getListTVPage(driver);
		listTVPage.clickToDynamicAddWishlist(driver, "LG LCD");
		Assert.assertEquals(listTVPage.getMsgAddWishlist(), "LG LCD has been added to your wishlist. Click here to continue shopping.");
		myWishlistPage = PageGeneratorManagerForLiveGuru.getMyWishlistPage(driver);
		myWishlistPage.clickToDynamicButton2(driver, "Share Wishlist");
		myWishlistPage.inputToDynamicTextArea(driver, emailShare, "emails");
		myWishlistPage.clickToDynamicButton2(driver, "Share Wishlist");
		Assert.assertEquals(myWishlistPage.getMsgShareWhishlist(), "Your Wishlist has been shared.");
		Assert.assertEquals(myWishlistPage.countItemsInWishListPage(), 1);

	}

	@Test
	public void TC_08_VerifyAddReview() {
		myWishlistPage.clickToDynamicLink(driver, "TV");
		listTVPage = PageGeneratorManagerForLiveGuru.getListTVPage(driver);
		listTVPage.clickToDynamicDetailProductTV(driver, "Samsung LCD");
		detailTVPage = PageGeneratorManagerForLiveGuru.getDetailTVPage(driver);
		detailTVPage.clickToDynamicLink(driver, "Add Your Review");
		detailTVPage.inputToDynamicTextArea(driver, "", "detail");
		detailTVPage.inputToDynamicTextbox(driver, "", "title");
		detailTVPage.inputToDynamicTextbox(driver, "", "nickname");
		detailTVPage.clickToDynamicButton2(driver, "Submit Review");
		Assert.assertEquals(detailTVPage.getDynamicMsgWarning(driver, "review_field"), "THIS IS A REQUIRED FIELD.");
		Assert.assertEquals(detailTVPage.getDynamicMsgWarning(driver, "summary_field"), "THIS IS A REQUIRED FIELD.");
		Assert.assertEquals(detailTVPage.getDynamicMsgWarning(driver, "nickname_field"), "THIS IS A REQUIRED FIELD.");
		detailTVPage.inputToDynamicTextArea(driver, detail, "detail");
		detailTVPage.inputToDynamicTextbox(driver, title, "title");
		detailTVPage.inputToDynamicTextbox(driver, nickname, "nickname");
		detailTVPage.clickToDynamicButton2(driver, "Submit Review");
		Assert.assertTrue(detailTVPage.isDisplayedMsgDynamicSuccess(driver, "Your review has been accepted for moderation."));

	}

	// @Test
	public void TC_09_VerifyPurchaseProduct() {
		detailTVPage.clickToDynamicMenu(driver, "Account");
		detailTVPage.clickToDynamicTitle(driver, "My Account");
		detailTVPage.OpenPageByDynamicLocator(driver, "My Wishlist");
		myWishlistPage = PageGeneratorManagerForLiveGuru.getMyWishlistPage(driver);
		myWishlistPage.clickToDynamicButton2(driver, "Add to Cart");
		addToCartPage = PageGeneratorManagerForLiveGuru.getAddToCartPage(driver);
		addToCartPage.enterShippingCountry(country);
		addToCartPage.enterProvince(provincy);
		addToCartPage.enterZip(zip);
		addToCartPage.clickToDynamicButton2(driver, "Estimate");
		Assert.assertTrue(addToCartPage.isDisplayedShippingCost());
		priceProductInCart = getDynamicPriceInMyCart(driver, "LG LCD").replace("$", "").trim();
		shippingCost = addToCartPage.getShippingCost().replace("$", "").trim();
		addToCartPage.selectShippingCost();
		addToCartPage.clickToDynamicButton2(driver, "Update Total");
		Assert.assertEquals(addToCartPage.getTotalPrice(), "$" + String.valueOf(Float.parseFloat(priceProductInCart) - Float.parseFloat(shippingCost)));
		addToCartPage.clickToDynamicButton2(driver, "Proceed to Checkout");
		checkoutPage = PageGeneratorManagerForLiveGuru.getCheckoutPage(driver);
		checkoutPage.clickToDynamicButton2(driver, "Continue");
		checkoutPage.clickToContinueShippingMethodButton();
		checkoutPage.choosePaymentInformation();
		checkoutPage.clickToContinuePaymentButton();
		checkoutPage.clickToDynamicButton2(driver, "Place Order");
		Assert.assertTrue(checkoutPage.isDisplayedMsgOrderSuccess());
		Assert.assertTrue(checkoutPage.orderNumberIsGenerated());

	}

	@Test
	public void TC_10_VerifySearch() {
		driver.get("http://live.demoguru99.com/index.php/");
		searchPage = PageGeneratorManagerForLiveGuru.getSearchPage(driver);
		searchPage.clickToDynamicLink(driver, "Advanced Search");
		searchPage.inputToDynamicTextbox(driver, priceFrom, "price[from]");
		searchPage.inputToDynamicTextbox(driver, priceTo, "price[to]");
		searchPage.clickToDynamicButton2(driver, "Search");
		searchPage.verifySearch(priceFrom, priceTo);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
