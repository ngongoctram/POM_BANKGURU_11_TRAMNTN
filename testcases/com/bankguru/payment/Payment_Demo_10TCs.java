package com.bankguru.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPages;
import commons.PageGeneratorManagerForPayment;
import pageObjectPayment.AccCreateMsgPageObject;
import pageObjectPayment.AccountUpdateMsgPageObject;
import pageObjectPayment.AddAccountPageObject;
import pageObjectPayment.AddCustomerPageObject;
import pageObjectPayment.BalEnquiryPageObject;
import pageObjectPayment.BalanceEnqInputPageObject;
import pageObjectPayment.CustomerRegMsgPageObject;
import pageObjectPayment.CustomerUpdateMsgPageObject;
import pageObjectPayment.DeleteAccountInputPageObject;
import pageObjectPayment.DeleteCustomerInputPageObject;
import pageObjectPayment.DepositInputPageObject;
import pageObjectPayment.DepositPageObject;
import pageObjectPayment.EditAccountInputPageObject;
import pageObjectPayment.EditAccountPageObject;
import pageObjectPayment.EditCustomerInputPageObject;
import pageObjectPayment.EditCustomerPageObject;
import pageObjectPayment.FunTransPageObject;
import pageObjectPayment.FundTransInputPageObject;
import pageObjectPayment.WithdrawInputPageObject;
import pageObjectPayment.WithdrawPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Payment_Demo_10TCs extends AbstractPages {
	WebDriver driver;
	WebDriverWait explixitwait;
	String email, loginPageURL, userID, password;
	String customerID_1, customerName, dateOfBirth, address, city, state, pin, mobile, customerEmail, pass;
	String customerID_2, addressEdit, cityEdit, stateEdit, pinEdit;
	String accountID;
	int depositBefore, amountDeposit, depositAfter, amountWithdrawl;

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private AccCreateMsgPageObject accountCreatedPage;
	private AccountUpdateMsgPageObject accountUpdatedPage;
	private AddAccountPageObject addAccountPage;
	private AddCustomerPageObject addCustomerPage;
	private BalanceEnqInputPageObject balanceInputPage;
	private BalEnquiryPageObject balancePage;
	private CustomerRegMsgPageObject customerCreatedPage;
	private CustomerUpdateMsgPageObject customerUpdatedPage;
	private DeleteAccountInputPageObject deleteAccountPage;
	private DeleteCustomerInputPageObject deleteCustomerPage;
	private DepositInputPageObject depositInputPage;
	private DepositPageObject depositPage;
	private EditAccountInputPageObject editAccountPage;
	private EditAccountPageObject accountEditedPage;
	private EditCustomerInputPageObject editCustomerPage;
	private EditCustomerPageObject customerEditedPage;
	private FundTransInputPageObject transInputPage;
	private FunTransPageObject transPage;
	private WithdrawInputPageObject withdrawalInputPage;
	private WithdrawPageObject withdrawalPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		explixitwait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		customerName = "Claire Brannigan";
		dateOfBirth = "2018-12-05";
		address = "14371 Victoria Plaza";
		city = "Richmond";
		state = "Virginia";
		pin = "123321";
		mobile = "8045039837";
		customerEmail = "gemma_" + randomEmail() + "@gmail.com";
		pass = "123456";

		addressEdit = "711 Fuller Street";
		cityEdit = "Boulder";
		stateEdit = "Colorado";
		pinEdit = "235647";

		depositBefore = 50000;
		amountDeposit = 5000;
		amountWithdrawl = 40000;

		email = "auto_test_" + randomEmail() + "@gmail.com";
		openAnyURL(driver, "http://demo.guru99.com/V4/index.php");
		loginPage = PageGeneratorManagerForPayment.getLoginPage(driver);

	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPageURL = loginPage.getLoginPageURL();
		loginPage.clickToHereLink();
		registerPage = PageGeneratorManagerForPayment.getRegisterPage(driver);
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickSubmitButton();
		userID = registerPage.getUserTextValue();
		password = registerPage.getPasswordTextValue();

	}

	@Test
	public void TC_02_LoginToSystem() {
		driver.get(loginPageURL);
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordIDTextbox(password);
		loginPage.clickLoginButton();
		loginPage.OpenPageByDynamicLocator(driver, "Manager");
		homePage = PageGeneratorManagerForPayment.getHomePage(driver);
		Assert.assertTrue(homePage.isWellComeMessageDisplayed());

	}

	@Test
	public void TC_03_AddNewCustomer_1() {
		homePage.OpenPageByDynamicLocator(driver, "New Customer");
		addCustomerPage = PageGeneratorManagerForPayment.getAddCustomerPage(driver);
		addCustomerPage.inputCustomerName(customerName);
		addCustomerPage.inputDateOfBirth(dateOfBirth);
		addCustomerPage.inputAddress(address);
		addCustomerPage.inputCity(city);
		addCustomerPage.inputState(state);
		addCustomerPage.inputPIN(pin);
		addCustomerPage.inputMobileNumber(mobile);
		addCustomerPage.inputEmail(customerEmail);
		addCustomerPage.inputPassword(pass);
		addCustomerPage.clickToSubmitButton();
		customerCreatedPage = PageGeneratorManagerForPayment.getCustomerRegMsgPage(driver);
		customerID_1 = customerCreatedPage.getCustomerID();
		Assert.assertTrue(customerCreatedPage.isDisplayedMsgCreateCustomer());
		Assert.assertEquals(customerCreatedPage.getTextCustomerName(), customerName);
		Assert.assertEquals(customerCreatedPage.getTextDateOfBirth(), dateOfBirth);
		Assert.assertEquals(customerCreatedPage.getTextAddress(), address);
		Assert.assertEquals(customerCreatedPage.getTextCity(), city);
		Assert.assertEquals(customerCreatedPage.getTextState(), state);
		Assert.assertEquals(customerCreatedPage.getTextpin(), pin);
		Assert.assertEquals(customerCreatedPage.getTextMobileNumber(), mobile);
		Assert.assertEquals(customerCreatedPage.getTextEmail(), customerEmail);

	}

	@Test
	public void TC_04_EditCustomer_1() {
		customerCreatedPage.OpenPageByDynamicLocator(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManagerForPayment.getEditCustomerInputPage(driver);
		editCustomerPage.inputCustomerID(customerID_1);
		editCustomerPage.clickToSubmitButton();

		customerEditedPage = PageGeneratorManagerForPayment.getEditCustomerPage(driver);
		customerEditedPage.inputCityValue(cityEdit);
		customerEditedPage.inputStateValue(stateEdit);
		customerEditedPage.inputPinvalue(pinEdit);
		customerEditedPage.clickToSubmitButton();

		customerUpdatedPage = PageGeneratorManagerForPayment.getCustomerUpdateMsgPage(driver);
		Assert.assertTrue(customerUpdatedPage.isDisplayedCustomerUpdateMsg());
		customerUpdatedPage.clickToContinueLink();

	}

	@Test
	public void TC_05_AddNewAccount() {
		customerUpdatedPage.OpenPageByDynamicLocator(driver, "New Account");
		addAccountPage = PageGeneratorManagerForPayment.getAddAccountPage(driver);
		addAccountPage.inputCustomerID(customerID_1);
		addAccountPage.selectAccountType("Savings");
		addAccountPage.inputDeposit(depositBefore);
		addAccountPage.clickSubmitButton();
		accountCreatedPage = PageGeneratorManagerForPayment.getAccCreateMsgPage(driver);
		Assert.assertTrue(accountCreatedPage.isDisplayedMsgSuccess());
		Assert.assertEquals(accountCreatedPage.getTextDeposit(), depositBefore);
		accountID = accountCreatedPage.getAccountIDNO();

	}

	@Test
	public void TC_06_EditAccount() {
		accountCreatedPage.OpenPageByDynamicLocator(driver, "Edit Account");
		editAccountPage = PageGeneratorManagerForPayment.getEditAccountInputPage(driver);
		editAccountPage.inputToAccountNo(accountID);
		editAccountPage.clickToSubmitButton();
		accountEditedPage = PageGeneratorManagerForPayment.getEditAccountPage(driver);
		accountEditedPage.EditAccountType("Current");
		accountEditedPage.clickSubmitBtn();
		accountUpdatedPage = PageGeneratorManagerForPayment.getAccountUpdateMsgPage(driver);
		Assert.assertTrue(accountUpdatedPage.isDisplayedMsgSuccess());
		Assert.assertEquals(accountUpdatedPage.getTextAccountType(), "Current");

	}

	@Test
	public void TC_06_Deposit() {
		accountUpdatedPage.OpenPageByDynamicLocator(driver, "Deposit");
		depositInputPage = PageGeneratorManagerForPayment.getDepositInputPage(driver);
		depositInputPage.inputAccountNo(accountID);
		depositInputPage.inputAmountValue(amountDeposit);
		depositInputPage.inputDescription("deposit");
		depositInputPage.clickToSubmitBtn();
		depositPage = PageGeneratorManagerForPayment.getDepositPage(driver);
		Assert.assertTrue(depositPage.isDisplayedMsgSuccess());
		Assert.assertEquals(depositPage.getCurrentAmount(), String.valueOf(depositBefore + amountDeposit));
		depositAfter = depositBefore + amountDeposit;

	}

	@Test
	public void TC_07_Withdrawl() {
		depositPage.OpenPageByDynamicLocator(driver, "Withdrawal");
		withdrawalInputPage = PageGeneratorManagerForPayment.getWithdrawInputPage(driver);
		withdrawalInputPage.inputAccountNo(accountID);
		withdrawalInputPage.inputAmount(amountWithdrawl);
		withdrawalInputPage.inputDescription("Withdrawl");
		withdrawalInputPage.clickSubmitBtn();
		withdrawalPage = PageGeneratorManagerForPayment.getWithdrawPage(driver);
		Assert.assertTrue(withdrawalPage.isDisplayedMsgSuccess());
		Assert.assertEquals(withdrawalPage.getCurrentAmount(), String.valueOf(depositAfter - amountWithdrawl));
	}

	@Test
	public void TC_08_Transfer() {

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
