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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_Pattern extends AbstractPages {
	WebDriver driver;
	WebDriverWait explixitwait;
	String email, loginPageURL, userID, password;

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		email = "auto_test_" + randomEmail() + "@gmail.com";
		openAnyURL(driver, "http://demo.guru99.com/V4/index.php");

	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPage = new LoginPageObject(driver);
		loginPageURL = loginPage.getLoginPageURL();
		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickSubmitButton();
		userID = registerPage.getUserTextValue();
		password = registerPage.getPasswordTextValue();

	}

	@Test
	public void TC_02_LoginToSystem() {
		loginPage = new LoginPageObject(driver);
		driver.get(loginPageURL);
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordIDTextbox(password);
		loginPage.clickLoginButton();
		homePage = new HomePageObject(driver);
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
