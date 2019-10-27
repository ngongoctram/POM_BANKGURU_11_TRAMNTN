package commons;

import org.openqa.selenium.WebDriver;

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

public class PageGeneratorManagerForPayment {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static AccCreateMsgPageObject getAccCreateMsgPage(WebDriver driver) {
		return new AccCreateMsgPageObject(driver);
	}

	public static AccountUpdateMsgPageObject getAccountUpdateMsgPage(WebDriver driver) {
		return new AccountUpdateMsgPageObject(driver);
	}

	public static AddAccountPageObject getAddAccountPage(WebDriver driver) {
		return new AddAccountPageObject(driver);
	}

	public static AddCustomerPageObject getAddCustomerPage(WebDriver driver) {
		return new AddCustomerPageObject(driver);
	}

	public static BalanceEnqInputPageObject getBalanceEnqInputPage(WebDriver driver) {
		return new BalanceEnqInputPageObject(driver);
	}

	public static BalEnquiryPageObject getBalEnquiryPage(WebDriver driver) {
		return new BalEnquiryPageObject(driver);
	}

	public static CustomerRegMsgPageObject getCustomerRegMsgPage(WebDriver driver) {
		return new CustomerRegMsgPageObject(driver);
	}

	public static CustomerUpdateMsgPageObject getCustomerUpdateMsgPage(WebDriver driver) {
		return new CustomerUpdateMsgPageObject(driver);
	}

	public static DeleteAccountInputPageObject getDeleteAccountInputPage(WebDriver driver) {
		return new DeleteAccountInputPageObject(driver);
	}

	public static DeleteCustomerInputPageObject getDeleteCustomerInputPage(WebDriver driver) {
		return new DeleteCustomerInputPageObject(driver);
	}

	public static DepositInputPageObject getDepositInputPage(WebDriver driver) {
		return new DepositInputPageObject(driver);
	}

	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}

	public static EditAccountInputPageObject getEditAccountInputPage(WebDriver driver) {
		return new EditAccountInputPageObject(driver);
	}

	public static EditAccountPageObject getEditAccountPage(WebDriver driver) {
		return new EditAccountPageObject(driver);
	}

	public static EditCustomerInputPageObject getEditCustomerInputPage(WebDriver driver) {
		return new EditCustomerInputPageObject(driver);
	}

	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}

	public static FundTransInputPageObject getFundTransInputPage(WebDriver driver) {
		return new FundTransInputPageObject(driver);
	}

	public static FunTransPageObject getFunTransPage(WebDriver driver) {
		return new FunTransPageObject(driver);
	}

	public static WithdrawInputPageObject getWithdrawInputPage(WebDriver driver) {
		return new WithdrawInputPageObject(driver);
	}

	public static WithdrawPageObject getWithdrawPage(WebDriver driver) {
		return new WithdrawPageObject(driver);
	}

}
