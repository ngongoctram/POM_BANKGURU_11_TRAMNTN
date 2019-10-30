package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.DeleteAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewCustomerPageObject;
import pageUIs.AbstractPageUI;

public class AbstractPages {
	public void openAnyURL(WebDriver driver, String urlvalue) {
		driver.get(urlvalue);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourseCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backTopage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElementForDynamicLocator(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

//	public void sendKeysINTByJS(WebDriver driver, String locator, int attributeValue){
//	    JavascriptExecutor js = ((JavascriptExecutor) driver);
//	    boolean netQtty=false;
//	    js.executeScript("arguments[0].setAttribute('value','"+attributeValue+"');", netQtty);
//	}

	public void sendkeyToElementConvertToString(WebDriver driver, String locator, int value) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(String.valueOf(value));
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem) {
		select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(valueItem);
	}

	public String getFirstItemInDropdown(WebDriver driver, String locator, String valueItem) {
		select = new Select(driver.findElement(By.linkText(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public void ClickToItemInDropdownlist(WebDriver driver, String parentLoacator, String allItemLocator, String expectedItem) throws InterruptedException {
		WebElement parentDropdown = driver.findElement(By.xpath(parentLoacator));
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", parentDropdown);
		Thread.sleep(2000);
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemLocator)));
		List<WebElement> elements = driver.findElements(By.xpath(allItemLocator));
		for (WebElement item : elements) {
			String actualtext = item.getText();
			if (actualtext.equals(expectedItem)) {
				javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				Thread.sleep(1000);
				item.click();
				break;
			}
		}

	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeValue) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeValue);
	}

	public String getText(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countNumberOfElement(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		setOverideTimeout(driver, Constrants.SHORT_TIMEOUT);
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			setOverideTimeout(driver, Constrants.LONG_TIMEOUT);
			boolean status = element.isDisplayed();
			return status;
		} catch (Exception ex) {
			setOverideTimeout(driver, Constrants.LONG_TIMEOUT);
			System.out.println(ex.getMessage());
			return false;
		}
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();

	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();

	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		if (!isElementSelected(driver, locator))
			;
		clickToElement(driver, locator);
	}

	public void unCheckToCheckBox(WebDriver driver, String locator) {
		if (isElementSelected(driver, locator))
			;
		clickToElement(driver, locator);
	}

	public void switchToChildWindowByID(WebDriver driver, String parent) {
		allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}

	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentWindow)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);

	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.doubleClick().perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.contextClick().perform();
	}

	public void dragAndDropToElement(WebDriver driver, String locator, String sourceLocator, String targetLocator) {
		WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.dragAndDrop(source, target).perform();
	}

	public void senKeyboardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.sendKeys(element, key).perform();
	}

	public void uploadOneFile(WebDriver driver, String locator, String filePath_01) {
		relativePath = System.getProperty("user.dir");
		filePath_01 = relativePath + "\\upload\\" + filePath_01;
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(filePath_01);

	}

	public void uploadMultiFiles(WebDriver driver, String locator, String filename_01, String filename_02, String filename_03) {
		relativePath = System.getProperty("user.dir");
		filePath_01 = relativePath + "\\upload\\" + filename_01;
		filePath_02 = relativePath + "\\upload\\" + filename_02;
		filePath_03 = relativePath + "\\upload\\" + filename_03;
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(filePath_01 + "\n" + filePath_02 + "\n" + filePath_03);

	}

	public Object executeForBrowser(WebDriver driver, String javaSript) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		javascriptExecutor = (JavascriptExecutor) driver;
		String textActual = (String) javascriptExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual = " + textActual);
		return textActual.equals(textExpected);
	}

	public Object clickToElementByjavascript(WebDriver driver, String locator) {
		javascriptExecutor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		return javascriptExecutor.executeScript("arguments[0].click();", element);
	}

	public Object scrollToElement(WebDriver driver, WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public Object sendkeyToElementByjavascript(WebDriver driver, WebElement element, String value) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public Object scrollToBottomPage(WebDriver driver) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object removeAttributeInDOM(WebDriver driver, WebElement element, String attributeRemove) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public Object navigateToUrlByjavascript(WebDriver driver, String url) {
		javascriptExecutor = (JavascriptExecutor) driver;
		return javascriptExecutor.executeScript("window.location = '" + url + "'");
	}

	public void waitToElementVisible(WebDriver driver, String locator) {
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, Constrants.SHORT_TIMEOUT);
		try {
			by = By.xpath(locator);
			waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void setOverideTimeout(WebDriver driver, long timeSecond) {
		driver.manage().timeouts().implicitlyWait(timeSecond, TimeUnit.SECONDS);
	}

	public void waitToElementVisibleForDynamicLocator(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		by = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.newCustomerPage(driver);
	}

	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.editCustomerPage(driver);
	}

	public DeleteAccountPageObject openDeleteAcountPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.DELETE_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.DELETE_ACCOUNT_LINK);
		return PageGeneratorManager.deleteAccountPage(driver);
	}

	public HomePageObject openHomePage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.HOMEPAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOMEPAGE_LINK);
		return PageGeneratorManager.homePage1(driver);
	}

	public AbstractPages OpenDynamicPage(WebDriver driver, String pageName) {
		waitToElementVisibleForDynamicLocator(driver, AbstractPageUI.DYNAMIC_PAGE_XPATH, pageName);
		clickToElementForDynamicLocator(driver, AbstractPageUI.DYNAMIC_PAGE_XPATH, pageName);

		switch (pageName) {
		case "Edit Customer":
			return PageGeneratorManager.editCustomerPage(driver);
		case "Delete Account":
			return PageGeneratorManager.deleteAccountPage(driver);
		case "New Customer":
			return PageGeneratorManager.newCustomerPage(driver);
		default:
			return PageGeneratorManager.homePage1(driver);
		}
	}

	public void OpenPageByDynamicLocator(WebDriver driver, String pageName) {
		waitToElementVisibleForDynamicLocator(driver, AbstractPageUI.DYNAMIC_PAGE_XPATH, pageName);
		clickToElementForDynamicLocator(driver, AbstractPageUI.DYNAMIC_PAGE_XPATH, pageName);
	}

	By by;
	WebElement element;
	List<WebElement> elements;
	Select select;
	WebDriverWait waitExplicit;
	JavascriptExecutor javascriptExecutor;
	Set<String> allWindows;
	Actions action;
	String relativePath, filePath_01, filePath_02, filePath_03;
	long shortTimeOut = 5;
	long longTimeOut = 30;

}
