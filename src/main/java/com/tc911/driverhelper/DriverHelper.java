package com.tc911.driverhelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHelper {
	public static WebDriver getInternetExploreDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("requireWindowFocus", true);

		System.setProperty("webdriver.ie.driver"
				, System.getProperty("user.dir") + "/src/main/resources/IE/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getChromeDriver() {
		// ChromeDriverManager.getInstance().setup();
		System.setProperty("webdriver.chrome.driver"
				, System.getProperty("user.dir") + "/src/main/resources/Chrome/chromedriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("disable-notifications");
		chromeOptions.addArguments("process-per-site");
		chromeOptions.addArguments("dns-prefetch-disable");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		chromeOptions.setExperimentalOption("prefs", prefs);

		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver getFirefoxDriver() {
		// FirefoxDriverManager.getInstance().setup();
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "/src/main/resources/Gecko/geckodriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver getEdgeDriver() {
		// EdgeDriverManager.getInstance().setup();
		System.setProperty("webdriver.edge.driver",
				System.getProperty("user.dir") + "/src/main/resources/Edge/MicrosoftWebDriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		WebDriver driver = new EdgeDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * Return WebDriver by name, default is ChromeDriver.
	 */
	public static WebDriver getDriverByName(String name) {
		if (name.equals(Constant.InternetExplorer)) {
			return DriverHelper.getInternetExploreDriver();
		} else if (name.equals(Constant.Chrome)) {
			return DriverHelper.getChromeDriver();
		} else if (name.equals(Constant.Firefox)) {
			return DriverHelper.getFirefoxDriver();
		} else if (name.equals(Constant.Edge)) {
			return DriverHelper.getEdgeDriver();
		} else {
			return DriverHelper.getChromeDriver();
		}
	}
}