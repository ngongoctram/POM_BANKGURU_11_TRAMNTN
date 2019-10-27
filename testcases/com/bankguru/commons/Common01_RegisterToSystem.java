package com.bankguru.commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageFactory;
import pageObjects.LoginPageFactory;
import pageObjects.RegisterPageFactory;

public class Common01_RegisterToSystem extends AbstractTest {
	private WebDriver driver;
	private LoginPageFactory loginPage;
	private RegisterPageFactory registerPage;
	private HomePageFactory homePage;
	public static String USER_ID_VALUE, PASSWORD_VALUE;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {

		driver = openMultiBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/index.php");
		loginPage = PageGeneratorManager.loginPage(driver);

	}

	@Test
	public void TC_01_RegisterToSystem() {
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox("auto_test_" + randomEmail() + "@gmail.com");
		registerPage.clickSubmitButton();
		USER_ID_VALUE = registerPage.getUserTextValue();
		PASSWORD_VALUE = registerPage.getPasswordTextValue();

	}

	@AfterTest
	public void cleanData() {
		driver.quit();
	}

}
