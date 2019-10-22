package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageObjects.DeleteAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Level_10_CheckElementUndisplayed extends AbstractPages {
	WebDriver driver;
	WebDriverWait explixitwait;

	private LoginPageObject loginPage1;
	private HomePageObject homePage1;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private DeleteAccountPageObject deleteAccountPage;
	String email, currentURL, userID, password;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		email = "auto_test_" + randomEmail() + "@gmail.com";
		driver.get("http://demo.guru99.com/V4/index.php");
		loginPage1 = PageGeneratorManager.loginPage1(driver);

	}

	@Test
	public void TC_00_LoginToSystem() {
		Assert.assertFalse(loginPage1.isEmailIDTextboxatRegisterPageUndisplayed());
		Assert.assertFalse(loginPage1.isFileUploadLinkUndisplayed());
		loginPage1.inputToUserIDTextbox("mngr226944");
		loginPage1.inputToPasswordIDTextbox("Azuzemu");
		loginPage1.clickLoginButton();
		homePage1 = loginPage1.openHomePage(driver);
		Assert.assertTrue(homePage1.isWellComeMessageDisplayed());

	}

	@Test
	public void TC_01_OpenDynamicPage() {
		editCustomerPage = (EditCustomerPageObject) homePage1.OpenDynamicPage(driver, "Edit Customer");
		deleteAccountPage = (DeleteAccountPageObject) editCustomerPage.OpenDynamicPage(driver, "Delete Account");

		homePage1 = (HomePageObject) deleteAccountPage.OpenDynamicPage(driver, "Manager");

		newCustomerPage = (NewCustomerPageObject) homePage1.OpenDynamicPage(driver, "New Customer");

		homePage1.OpenPageByDynamicLocator(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.newCustomerPage(driver);

	}

	public int randomEmail() {
		Random random = new Random();
		return random.nextInt(999999);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
