package com.bankguru.payment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Common01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.DeleteAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

public class Level_11_Assert_Verify_Log_Report extends AbstractTest {
	WebDriver driver;

	private LoginPageObject loginPage1;
	private HomePageObject homePage1;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private DeleteAccountPageObject deleteAccountPage;
	String email, currentURL, userID, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		email = "auto_test_" + randomEmail() + "@gmail.com";
		driver.get("http://demo.guru99.com/V4/index.php");
		loginPage1 = PageGeneratorManager.loginPage1(driver);

	}

	@Test
	public void TC_00_LoginToSystem() {
		log.info("TC_00 Login - Step 01 : Verify Email textbox is not displayed at Login page");
		verifyFalse(loginPage1.isEmailIDTextboxatRegisterPageUndisplayed());

		log.info("TC_00 Login - Step 02 : Verify File Upload Link is not displayed");
		verifyFalse(loginPage1.isFileUploadLinkUndisplayed());

		log.info("TC_00 Login - Step 03 : Input data Email and Password");
		loginPage1.inputToUserIDTextbox(Common01_RegisterToSystem.USER_ID_VALUE);
		loginPage1.inputToPasswordIDTextbox(Common01_RegisterToSystem.PASSWORD_VALUE);
		loginPage1.clickLoginButton();
		homePage1 = loginPage1.openHomePage(driver);

		verifyTrue(homePage1.isWellComeMessageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
