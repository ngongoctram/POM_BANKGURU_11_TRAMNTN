package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	WebDriver driver;

	public WebDriver openMultiBrowser(String browserName) {
		String projectFolder = System.getProperty("user.dir");

		if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectFolder + ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("headless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
		} else {
			System.out.println("Please choose browser name in xml file!");
		}

		return driver;

	}

}
