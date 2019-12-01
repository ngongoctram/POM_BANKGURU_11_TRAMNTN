package com.bankguru.payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_12_Sort_ASC_DESC {
	WebDriver driver;
	Select select;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Sort_ASC() {
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.findElement(By.xpath("//button[@class='w3-btn w3-dark-grey']")).click();
		Assert.assertTrue(isDataSortedAscending("//table[@id=\"myTable\"]//td[1]"));

	}

	@Test
	public void TC_02_Sort_ASC_float() {
		driver.get("https://www.saucedemo.com/inventory.html");
		select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		select.selectByVisibleText("Price (low to high)");
		Assert.assertTrue(isPriceSortedAscending("//div[@class='inventory_item_price']"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public boolean isDataSortedAscending(String locator) {
		// Khai bao 1 Array List
		ArrayList<String> arrayList = new ArrayList<>();

		// Tim tat ca cac element matching voi dieu kien
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lay text cua tung element add vao ArrayList
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("-------------Du lieu tren UI:-------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Copy qua 1 arrayList mới để SORT trong code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// Thuc hien SORT ASC
		Collections.sort(arrayList);

		System.out.println("------Du lieu da SORT ASC trong code:--------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// verify 2 array bang nhau
		return sortedList.equals(arrayList);
	}

	public boolean isDataSortedDescending(String locator) {
		// Khai bao 1 Array List
		ArrayList<String> arrayList = new ArrayList<>();

		// Tim tat ca cac element matching voi dieu kien
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lay text cua tung element add vao ArrayList
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("-------------Du lieu tren UI:-------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Copy qua 1 arrayList mới để SORT trong code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		// Thuc hien SORT ASC
		Collections.sort(arrayList);

		System.out.println("------Du lieu da SORT ASC trong code:--------");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Reverse data để sort DESC
		Collections.reverse(arrayList);

		System.out.println("-----------Du liệu đã SORT DESC trong code:---------");
		for (String name : arrayList) {
			System.out.println(name);
		}
		// verify 2 array bang nhau
		return sortedList.equals(arrayList);
	}

	public boolean isPriceSortedAscending(String locator) {
		// Khai bao 1 arrayList
		ArrayList<Float> arrayList = new ArrayList<Float>();

		// Tim tat ca cac element matching voi dieu kien
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lay text cua tung element add vao ArrayList
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));

		}
		System.out.println("-----------Du lieu tren UI:---------------");
		for (Float name : arrayList) {
			System.out.println(name);
		}

		// Copy qua 1 array list moi der SORT trong code
		ArrayList<Float> sortedList = new ArrayList<Float>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		// Thuc hien SORT ASC
		Collections.sort(arrayList);

		System.out.println("Du lieu da SORT ASC trong code:-------");
		for (Float name : arrayList) {
			System.out.println(name);
		}

		// verify 2 array bang nhau
		return sortedList.equals(arrayList);

	}

}
