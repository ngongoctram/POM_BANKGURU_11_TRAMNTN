package com.bankguru.payment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractTest;
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

public class Payment_Demo_10TCs extends AbstractTest {
	WebDriver driver;
	WebDriverWait explixitwait;
	String email, loginPageURL, userID, password;
	String customerID, customerName, dateOfBirth, address, city, state, pin, mobile, customerEmail, pass;
	String addressEdit, cityEdit, stateEdit, pinEdit;
	String accountID_1, accountID_2;
	int depositBeforeAc1, depositBeforeAc2, amountDeposit, depositAfter, amountWithdrawl, amountTranfer;

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

		depositBeforeAc1 = 50000;
		depositBeforeAc2 = 30000;
		amountDeposit = 5000;
		amountWithdrawl = 40000;
		amountTranfer = 2000;

		email = "auto_test_" + randomEmail() + "@gmail.com";
		driver.get("http://demo.guru99.com/V4/index.php");
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
	public void TC_03_AddNewCustomer() {
		homePage.OpenPageByDynamicLocator(driver, "New Customer");
		addCustomerPage = PageGeneratorManagerForPayment.getAddCustomerPage(driver);
		addCustomerPage.inputToDynamicTextbox(driver, customerName, "name");
		addCustomerPage.inputToDynamicTextbox(driver, dateOfBirth, "dob");
		addCustomerPage.inputToDynamicTextArea(driver, address, "addr");
		addCustomerPage.inputToDynamicTextbox(driver, city, "city");
		addCustomerPage.inputToDynamicTextbox(driver, state, "state");
		addCustomerPage.inputToDynamicTextbox(driver, pin, "pinno");
		addCustomerPage.inputToDynamicTextbox(driver, mobile, "telephoneno");
		addCustomerPage.inputToDynamicTextbox(driver, customerEmail, "emailid");
		addCustomerPage.inputPassword(pass);
		addCustomerPage.inputToDynamicTextbox(driver, pass, "password");
		addCustomerPage.clickToSubmitButton();
		customerCreatedPage = PageGeneratorManagerForPayment.getCustomerRegMsgPage(driver);
		customerID = customerCreatedPage.getCustomerID();
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
	public void TC_04_EditCustomer() {
		customerCreatedPage.OpenPageByDynamicLocator(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManagerForPayment.getEditCustomerInputPage(driver);
		editCustomerPage.inputCustomerID(customerID);
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
	public void TC_05_AddNewAccount_1() {
		customerUpdatedPage.OpenPageByDynamicLocator(driver, "New Account");
		addAccountPage = PageGeneratorManagerForPayment.getAddAccountPage(driver);
		addAccountPage.inputCustomerID(customerID);
		addAccountPage.selectAccountType("Savings");
		addAccountPage.inputDeposit(depositBeforeAc1);
		addAccountPage.clickSubmitButton();
		accountCreatedPage = PageGeneratorManagerForPayment.getAccCreateMsgPage(driver);
		Assert.assertTrue(accountCreatedPage.isDisplayedMsgSuccess());
		Assert.assertEquals(accountCreatedPage.getTextDeposit(), String.valueOf(depositBeforeAc1));
		accountID_1 = accountCreatedPage.getAccountIDNO();
	}

	@Test
	public void TC_06_AddNewAccount_2() {
		accountCreatedPage.OpenPageByDynamicLocator(driver, "New Account");
		addAccountPage = PageGeneratorManagerForPayment.getAddAccountPage(driver);
		addAccountPage.inputCustomerID(customerID);
		addAccountPage.selectAccountType("Savings");
		addAccountPage.inputDeposit(depositBeforeAc2);
		addAccountPage.clickSubmitButton();
		accountCreatedPage = PageGeneratorManagerForPayment.getAccCreateMsgPage(driver);
		Assert.assertTrue(accountCreatedPage.isDisplayedMsgSuccess());
		Assert.assertEquals(accountCreatedPage.getTextDeposit(), String.valueOf(depositBeforeAc2));
		accountID_2 = accountCreatedPage.getAccountIDNO();
	}

	@Test
	public void TC_07_EditAccount() {
		accountCreatedPage.OpenPageByDynamicLocator(driver, "Edit Account");
		editAccountPage = PageGeneratorManagerForPayment.getEditAccountInputPage(driver);
		editAccountPage.inputToAccountNo(accountID_1);
		editAccountPage.clickToSubmitButton();
		accountEditedPage = PageGeneratorManagerForPayment.getEditAccountPage(driver);
		accountEditedPage.EditAccountType("Current");
		accountEditedPage.clickSubmitBtn();
		accountUpdatedPage = PageGeneratorManagerForPayment.getAccountUpdateMsgPage(driver);
		Assert.assertTrue(accountUpdatedPage.isDisplayedMsgSuccess());
		Assert.assertEquals(accountUpdatedPage.getTextAccountType(), "Current");

	}

	@Test
	public void TC_08_CheckDepositOfAccount() {
		accountUpdatedPage.OpenPageByDynamicLocator(driver, "Deposit");
		depositInputPage = PageGeneratorManagerForPayment.getDepositInputPage(driver);
		depositInputPage.inputAccountNo(accountID_1);
		depositInputPage.inputAmountValue(amountDeposit);
		depositInputPage.inputDescription("deposit");
		depositInputPage.clickToSubmitBtn();
		depositPage = PageGeneratorManagerForPayment.getDepositPage(driver);
		Assert.assertTrue(depositPage.isDisplayedMsgDynamic(driver, "Transaction details of Deposit for Account " + accountID_1));
		Assert.assertEquals(depositPage.getCurrentAmount(), String.valueOf(depositBeforeAc1 + amountDeposit));
		depositAfter = depositBeforeAc1 + amountDeposit;

	}

	@Test
	public void TC_09_CheckWithdrawl() {
		depositPage.OpenPageByDynamicLocator(driver, "Withdrawal");
		withdrawalInputPage = PageGeneratorManagerForPayment.getWithdrawInputPage(driver);
		withdrawalInputPage.inputAccountNo(accountID_1);
		withdrawalInputPage.inputAmount(amountWithdrawl);
		withdrawalInputPage.inputDescription("Withdrawl");
		withdrawalInputPage.clickSubmitBtn();
		withdrawalPage = PageGeneratorManagerForPayment.getWithdrawPage(driver);
		Assert.assertTrue(withdrawalPage.isDisplayedMsgDynamic(driver, "Transaction details of Withdrawal for Account " + accountID_1));
		Assert.assertEquals(withdrawalPage.getCurrentAmount(), String.valueOf(depositAfter - amountWithdrawl));
	}

	@Test
	public void TC_10_CheckTransferAmountToOtherAccount() {
		accountCreatedPage.OpenPageByDynamicLocator(driver, "Fund Transfer");
		transInputPage = PageGeneratorManagerForPayment.getFundTransInputPage(driver);
		transInputPage.inputToDynamicTextbox(driver, accountID_1, "payersaccount");
		transInputPage.inputToDynamicTextbox(driver, accountID_2, "payeeaccount");
		transInputPage.inputToDynamicTextbox(driver, amountTranfer, "ammount");
		transInputPage.inputToDynamicTextbox(driver, "fund transfer", "desc");
		transInputPage.clickToDynamicButton(driver, "AccSubmit");
		transPage = PageGeneratorManagerForPayment.getFunTransPage(driver);
		Assert.assertTrue(transPage.isDisplayedMsgDynamic(driver, "Fund Transfer Details"));
		Assert.assertEquals(transPage.getDynamicTextInTable(driver, "Amount"), String.valueOf(amountTranfer));
	}

	@Test
	public void TC_11_CheckBalanceOfAccount() {
		transPage.OpenPageByDynamicLocator(driver, "Balance Enquiry");
		balanceInputPage = PageGeneratorManagerForPayment.getBalanceEnqInputPage(driver);
		balanceInputPage.inputToDynamicTextbox(driver, accountID_1, "accountno");
		balanceInputPage.clickToDynamicButton(driver, "AccSubmit");
		balancePage = PageGeneratorManagerForPayment.getBalEnquiryPage(driver);
		Assert.assertTrue(balancePage.isDisplayedMsgDynamic(driver, "Balance Details for Account " + accountID_1));
		Assert.assertEquals(balancePage.getDynamicTextInTable(driver, "Balance"), String.valueOf(depositAfter - amountWithdrawl - amountTranfer));
		balancePage.OpenPageByDynamicLocator(driver, "Balance Enquiry");
		balanceInputPage = PageGeneratorManagerForPayment.getBalanceEnqInputPage(driver);
		balanceInputPage.inputToDynamicTextbox(driver, accountID_2, "accountno");
		balanceInputPage.clickToDynamicButton(driver, "AccSubmit");
		balancePage = PageGeneratorManagerForPayment.getBalEnquiryPage(driver);
		Assert.assertTrue(balancePage.isDisplayedMsgDynamic(driver, "Balance Details for Account " + accountID_2));
		Assert.assertEquals(balancePage.getDynamicTextInTable(driver, "Balance"), String.valueOf(depositBeforeAc2 + amountTranfer));
	}

	@Test
	public void TC_12_CheckDeleteAccount() {
		balancePage.OpenPageByDynamicLocator(driver, "Delete Account");
		deleteAccountPage = PageGeneratorManagerForPayment.getDeleteAccountInputPage(driver);
		deleteAccountPage.inputToDynamicTextbox(driver, accountID_1, "accountno");
		deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");
		deleteAccountPage.acceptAlert(driver);
		Assert.assertEquals(deleteAccountPage.getTextAlert(driver), "Account Deleted Sucessfully");
		deleteAccountPage.cancelAlert(driver);

		homePage.OpenPageByDynamicLocator(driver, "Delete Account");
		deleteAccountPage = PageGeneratorManagerForPayment.getDeleteAccountInputPage(driver);
		deleteAccountPage.inputToDynamicTextbox(driver, accountID_2, "accountno");
		deleteAccountPage.clickToDynamicButton(driver, "AccSubmit");
		deleteAccountPage.acceptAlert(driver);
		Assert.assertEquals(deleteAccountPage.getTextAlert(driver), "Account Deleted Sucessfully");
		deleteAccountPage.cancelAlert(driver);

		deleteAccountPage.OpenPageByDynamicLocator(driver, "Edit Account");
		editAccountPage = PageGeneratorManagerForPayment.getEditAccountInputPage(driver);
		editAccountPage.inputToAccountNo(accountID_1);
		editAccountPage.clickToSubmitButton();
		Assert.assertEquals(editAccountPage.getTextAlert(driver), "Account does not exist");
		editAccountPage.cancelAlert(driver);

	}

	@Test
	public void TC_13_CheckDeleteCustomer() {
		editAccountPage.OpenPageByDynamicLocator(driver, "Delete Customer");
		deleteCustomerPage = PageGeneratorManagerForPayment.getDeleteCustomerInputPage(driver);
		deleteCustomerPage.inputToDynamicTextbox(driver, customerID, "cusid");
		deleteCustomerPage.clickToDynamicButton(driver, "AccSubmit");
		deleteCustomerPage.acceptAlert(driver);
		Assert.assertEquals(deleteCustomerPage.getTextAlert(driver), "Customer deleted Successfully");
		deleteAccountPage.cancelAlert(driver);
		deleteAccountPage.OpenPageByDynamicLocator(driver, "Edit Customer");
		editCustomerPage = PageGeneratorManagerForPayment.getEditCustomerInputPage(driver);
		editCustomerPage.inputCustomerID(customerID);
		editCustomerPage.clickToSubmitButton();
		Assert.assertEquals(editCustomerPage.getTextAlert(driver), "Customer does not exist!!");
		editCustomerPage.cancelAlert(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
