package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Step_by_Step {
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
		driver.get("http://demo.guru99.com/V4/index.php");
		currentURL = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		explixitwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@name='emailid']")));

		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

	}

	@Test
	public void TC_02_LoginToSystem() {
		driver.get(currentURL);
		driver.findElement(By.xpath("//input[@name ='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name ='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name ='btnLogin']")).click();

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
