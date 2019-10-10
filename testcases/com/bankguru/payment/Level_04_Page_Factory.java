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

import commons.AbstractPageFactory;
import commons.PageGeneratorManager;
import pageObjects.HomePageFactory;
import pageObjects.LoginPageFactory;
import pageObjects.RegisterPageFactory;

public class Level_04_Page_Factory extends AbstractPageFactory {
	WebDriver driver;
	WebDriverWait explixitwait;
	LoginPageFactory loginPage;
	RegisterPageFactory registerPage;
	HomePageFactory homePage;
	String email, currentURL, userID, password;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		email = "auto_test_" + randomEmail() + "@gmail.com";
		loginPage = PageGeneratorManager.loginPage(driver);

	}

	@Test
	public void TC_01_RegisterToSystem() {
		openURL(driver, "http://demo.guru99.com/V4/index.php");
		currentURL = loginPage.getCurrentURL(driver);
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickSubmitButton();
		userID = registerPage.getUserTextValue();
		password = registerPage.getPasswordTextValue();

	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = registerPage.OpenURL(currentURL);
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordIDTextbox(password);
		homePage = loginPage.clickLoginButton();
		Assert.assertTrue(homePage.isWellComeMessageDisplayed());

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
