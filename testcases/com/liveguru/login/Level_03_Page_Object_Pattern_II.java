package com.liveguru.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPages;
import pageObjects.LiveGuruDashboardPageObject;
import pageObjects.LiveGuruLoginPageObject;

public class Level_03_Page_Object_Pattern_II extends AbstractPages {
	WebDriver driver;
	LiveGuruLoginPageObject loginPage;
	LiveGuruDashboardPageObject dashboardPage;

	WebDriverWait explixitwait;
	String validEmail, validPassword, invalidEmail, invalidPassword, incorrectPassword;

	@BeforeClass
	public void initClass() {
		driver = new FirefoxDriver();
		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		loginPage = new LiveGuruLoginPageObject(driver);
		dashboardPage = new LiveGuruDashboardPageObject(driver);

		validEmail = "ngoctramtk94@gmail.com";
		validPassword = "123456";
		invalidEmail = "123@456";
		invalidPassword = "1111";
		incorrectPassword = "2223456";

		openAnyURL(driver, "http://live.guru99.com/index.php/customer/account/login/");

	}

	@Test
	public void TC_01_LoginWithEmptyEmail() {
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
	}

	@Test
	public void TC_02_LoginWithEmptyPassword() {
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
	}

	@Test
	public void TC_03_LoginWithInvalidEmail() {
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_04_LoginWithPasswordLessThan6Chars() {
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(invalidPassword);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getPasswordLessErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		loginPage.inputToEmailTextbox(validEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(dashboardPage.isDisplayedLoginSuccessInDashboard());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
