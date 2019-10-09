package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageFactory;
import pageObjects.LoginPageFactory;
import pageObjects.RegisterPageFactory;

public class Level_06_MultipleBrowers_Parallel_Factorypattern extends AbstractTest {
	WebDriver driver;
	WebDriverWait explixitwait;
	String email, currentURL, userID, password;
	LoginPageFactory loginPage;
	RegisterPageFactory registerPage;
	HomePageFactory homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = openMultiBrowser(browserName);

		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/index.php");

		email = "auto_test_" + randomEmail() + "@gmail.com";
		loginPage = PageGeneratorManager.loginPage(driver);

	}

	@Test
	public void TC_01_RegisterToSystem() {
//		openURL(driver, "http://demo.guru99.com/V4/index.php");
//		currentURL = loginPage.getCurrentURL(driver);
//		registerPage = loginPage.clickToHereLink();
//		registerPage.inputToEmailIDTextbox(email);
//		registerPage.clickSubmitButton();
//		userID = registerPage.getUserTextValue();
//		password = registerPage.getPasswordTextValue();

	}

	@Test
	public void TC_02_LoginToSystem() {
//		loginPage = registerPage.OpenURL(currentURL);
//		loginPage.inputToUserIDTextbox(userID);
//		loginPage.inputToPasswordIDTextbox(password);
//		homePage = loginPage.clickLoginButton();
//		Assert.assertTrue(homePage.isWellComeMessageDisplayed());

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
