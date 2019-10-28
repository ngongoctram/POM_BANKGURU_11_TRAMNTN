package commons;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {
	@Override
	protected void createDriver() {
//		String projectFolder = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", projectFolder + ".\\resources\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);

	}

}
