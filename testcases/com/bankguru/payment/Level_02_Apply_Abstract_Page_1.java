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

public class Level_02_Apply_Abstract_Page_1 {
	WebDriver driver;
	WebDriverWait explixitwait;
	String email, currentURL, userID, password;
	public AbstractPages abstractPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		abstractPage = new AbstractPages();

		email = "auto_test_" + randomEmail() + "@gmail.com";

	}

	@Test
	public void TC_01_RegisterToSystem() {
		abstractPage.openAnyURL(driver, "http://demo.guru99.com/V4/index.php");
		currentURL = abstractPage.getCurrentUrl(driver);
		abstractPage.clickToElement(driver, "//a[text()='here']");
		abstractPage.waitToElementVisible(driver, "//input[@name='emailid']");
		abstractPage.senkeyToElement(driver, "//input[@name='emailid']", email);
		abstractPage.clickToElement(driver, "//input[@type='submit']");
		userID = abstractPage.getText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = abstractPage.getText(driver, "//td[text()='Password :']/following-sibling::td");

	}

	@Test
	public void TC_02_LoginToSystem() {
		driver.get(currentURL);
		abstractPage.senkeyToElement(driver, "//input[@name ='uid']", userID);
		abstractPage.senkeyToElement(driver, "//input[@name ='password']", password);
		abstractPage.clickToElement(driver, "//input[@name ='btnLogin']");
		abstractPage.isElementDisplayed(driver, "//marquee[text()=\\\"Welcome To Manager's Page of Guru99 Bank\\");

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
