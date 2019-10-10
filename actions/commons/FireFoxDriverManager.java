package commons;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxDriverManager extends DriverManager {
	@Override

	protected void createDriver() {
		String rootFolder = System.getProperty("user.dir");
		FirefoxProfile profile = new FirefoxProfile();
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		profile.setAcceptUntrustedCertificates(false);
		profile.setAssumeUntrustedCertificateIssuer(true);
		profile.setPreference("dom.webnotifications.enabled", false);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", rootFolder + "\\downloadFiles");
		profile.setPreference("browser.download.downloadDir", rootFolder + "\\downloadFiles");
		profile.setPreference("browser.download.defaultFolder", rootFolder + "\\downloadFiles");
		profile.setPreference("browser.helperApps.nerverAsk.saveToDisk", "text/anytext,text/plain,text/html,application/plain");
		capability = DesiredCapabilities.firefox();
		capability.setCapability(FirefoxDriver.PROFILE, profile);
		driver = new FirefoxDriver(capability);
	}

}
