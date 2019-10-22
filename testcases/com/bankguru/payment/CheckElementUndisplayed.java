package com.bankguru.payment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckElementUndisplayed {
	WebDriver driver;
	WebDriverWait explixitwait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@Test
	public void TC_01() {
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='create-account_form']")).isDisplayed());
		Assert.assertTrue(isElementInVisible("//form[@id='form_forgotpassword']"));
		Assert.assertTrue(isElementInVisible("//div[@id='create-account_error']"));
	}

	public boolean isElementVisible(String Xpath) {
		setImplicitWait(shortTimeout);
		try {
			WebElement element = driver.findElement(By.xpath(Xpath));
			setImplicitWait(longTimeout);
			boolean status = element.isDisplayed();
			return status;
		} catch (Exception e) {
			setImplicitWait(longTimeout);
			return false;
		}
	}

	public boolean isElementInVisible(String locator) {
		setImplicitWait(shortTimeout);

		List<WebElement> elements = driver.findElements(By.xpath(locator));

		if (elements.size() == 0) {
			setImplicitWait(longTimeout);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			setImplicitWait(longTimeout);
			return true;
		} else {
			setImplicitWait(longTimeout);
			return false;
		}
	}

	public void setImplicitWait(long timeSecond) {
		driver.manage().timeouts().implicitlyWait(timeSecond, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	long shortTimeout = 5;
	long longTimeout = 30;

}
