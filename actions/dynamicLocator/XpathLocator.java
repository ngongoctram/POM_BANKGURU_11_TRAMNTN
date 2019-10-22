package dynamicLocator;

public class XpathLocator {
	// interfaces (14 pages)
	static String HOME_PAGE_XPATH = "//a[text()='Manager']";
	static String NEW_CUSTOMER_PAGE_XPATH = "//a[text()='New Customer']";
	static String EDIT_CUSTOMER_PAGE_XPATH = "//a[text()='Edit Customer']";
	static String DELETE_CUSTOMER_PAGE_XPATH = "//a[text()='Delete Customer']";
	// ...

	// interface (dynamic page)
	static String DYNAMIC_PAGE_XPATH = "//a[text()='%s']";

	static String DYNAMIC_COUNTRY_EDIT_ICON = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-edit-row-btn']";
	static String DYNAMIC_COUNTRY_DYNAMIC_ICON = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";
	static String DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_ICON = "//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";

	static String DYNAMIC_FULL_INFO = "//a[text()='%s']//a[text()='%s']//a[text()='%s']//a[text()='%s']//a[text()='%s']";

	// common (Abstract Page)
	public void clickToElement(String locator) {
		System.out.println("Click to element = " + locator);
	}

	public void clickToElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println("Click to element = " + locator);
	}

	public static void main(String[] args) {
		XpathLocator xpathLocator = new XpathLocator();

		// Dynamic page name
		xpathLocator.clickToElement(DYNAMIC_PAGE_XPATH, "Manager");
		xpathLocator.clickToElement(DYNAMIC_PAGE_XPATH, "New Customer");
		xpathLocator.clickToElement(DYNAMIC_PAGE_XPATH, "Edit Customer");
		xpathLocator.clickToElement(DYNAMIC_PAGE_XPATH, "Withdrawal");

		// Dynamic country name
		xpathLocator.clickToElement(DYNAMIC_COUNTRY_EDIT_ICON, "Argentina");
		xpathLocator.clickToElement(DYNAMIC_COUNTRY_EDIT_ICON, "Angola");

		// Dynamic country + icon
		xpathLocator.clickToElement(DYNAMIC_COUNTRY_DYNAMIC_ICON, "Angola", "edit");
		xpathLocator.clickToElement(DYNAMIC_COUNTRY_DYNAMIC_ICON, "Angola", "remove");

		// Dynamic country + total + icon
		xpathLocator.clickToElement(DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_ICON, "Angola", "553353", "edit");
		xpathLocator.clickToElement(DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_ICON, "Angola", "553353", "remove");

		// Dynamic 5 values
		xpathLocator.clickToElement(DYNAMIC_FULL_INFO, "Dam Dao", "Da Nang", "Cam Le", "550000", "0123456789");
	}

}
