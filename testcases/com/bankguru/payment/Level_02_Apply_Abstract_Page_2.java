package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPages;

public class Level_02_Apply_Abstract_Page_2 extends AbstractPages {
	WebDriver driver;
	WebDriverWait explixitwait;
	String email, currentURL, userID, password;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		email = "auto_test_" + randomEmail() + "@gmail.com";

	}

	@Test
	public void TC_01_RegisterToSystem() {
		openAnyURL(driver, "http://demo.guru99.com/V4/index.php");
		currentURL = getCurrentUrl(driver);
		clickToElement(driver, "//a[text()='here']");
		waitToElementVisible(driver, "//input[@name='emailid']");
		sedkeyToElement(driver, "//input[@name='emailid']", email);
		clickToElement(driver, "//input[@type='submit']");
		userID = getText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getText(driver, "//td[text()='Password :']/following-sibling::td");

	}

	@Test
	public void TC_02_LoginToSystem() {
		driver.get(currentURL);
		sedkeyToElement(driver, "//input[@name ='uid']", userID);
		sedkeyToElement(driver, "//input[@name ='password']", password);
		clickToElement(driver, "//input[@name ='btnLogin']");

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
