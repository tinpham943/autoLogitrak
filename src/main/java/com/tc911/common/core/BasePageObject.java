package com.tc911.common.core;

import com.tc911.driverhelper.DriverHelper;
import com.tc911.driverhelper.PropertiesCfg;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;

public class BasePageObject {

	public final Wait wait;

	protected WebDriver driver;
	public WebDriverWait waitFor;
	public Actions builder;
	protected int timeOut = 15;
	protected JavascriptAction jsActions;

	public BasePageObject() {
		this.waitFor = new WebDriverWait(driver, timeOut);
		this.builder = new Actions(driver);
		this.wait = new Wait(driver);
		this.jsActions = new JavascriptAction(driver);
		PageFactory.initElements(driver, this);
	}

	public BasePageObject(String browser) {
		driver = DriverHelper.getDriverByName(browser);
		this.waitFor = new WebDriverWait(driver, timeOut);
		this.builder = new Actions(driver);
		this.wait = new Wait(driver);
		this.jsActions = new JavascriptAction(driver);
		PageFactory.initElements(driver, this);
	}

	public void openLogiTrak() {
		String url = PropertiesCfg.url;
		String port = PropertiesCfg.port;	  
		driver.get("http://"+url+":"+port+"/JavaWeb/login.do");
	}

	public void logOutLogiTrak() {
		String url = PropertiesCfg.url;
		String port = PropertiesCfg.port;	  
		driver.get("http://"+url+":"+port+"/JavaWeb/logout.do");
	}

	public void quitDriver() {
		this.driver.close();
		this.driver.quit();
	}

	public void navigateMainMenu() {
		String url = PropertiesCfg.url;
		String port = PropertiesCfg.port;	  
		driver.get("http://"+url+":"+port+"/JavaWeb/main.do");
	}

	public void selectComboBox(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}

	public void navigateModule(String module) {
		String url = PropertiesCfg.url;
		String port = PropertiesCfg.port;
		this.driver.navigate().to("http://"+url+":"+port+"/JavaWeb/"+module+"?preEntry=true");
	}

	public void navigateModuleByXPath(String xpathTab, String module) throws InterruptedException {
		builder.moveToElement(driver.findElement(By.xpath("//*[@id='"+xpathTab+"']")));
		builder.click().build().perform();
		Thread.sleep(800);
		wait.forElementClickable(By.xpath("//*[@id='"+module+"']"),30);
		driver.findElement(By.xpath("//*[@id='"+module+"']")).click();
	}

	public void setupLogin() throws InterruptedException {
		this.openLogiTrak();
		this.wait.forElementVisible(By.cssSelector("#txtUsername"));
		WebElement userId = driver.findElement(By.cssSelector("#txtUsername"));
		WebElement passWord = driver.findElement(By.cssSelector("#passWord"));
		WebElement submit = driver.findElement(By.cssSelector("#LoginForm_button_submit"));
		userId.sendKeys(PropertiesCfg.Login_username);
		passWord.sendKeys(PropertiesCfg.Login_password);
		submit.click();
		Thread.sleep(1800);
	}

	public void setupLogin_nojuvenile() throws InterruptedException {
		this.openLogiTrak();
		this.wait.forElementVisible(By.cssSelector("#txtUsername"));
		WebElement userId = driver.findElement( By.cssSelector("#txtUsername"));
		WebElement passWord =driver.findElement( By.cssSelector("#passWord"));
		WebElement submit = driver.findElement(By.cssSelector("#LoginForm_button_submit"));
		userId.sendKeys(PropertiesCfg.Login_username_noJuvenile);
		passWord.sendKeys(PropertiesCfg.Login_password_noJuvenile);
		submit.click();
	}

	public static String getCurrentTimeStamp() {
		Date time = new Date();
		long timeCurrent = time.getTime();
		return String.valueOf(timeCurrent);
	}

	protected boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Function to check if the current URL contains the given string.
	 * @param givenString
	 */
	public boolean isStringInURL(String givenString) {
		String currentURL = driver.getCurrentUrl();
		if (currentURL.toLowerCase().contains(givenString.toLowerCase())) {
			return true;
		} else { return false; }
	}

	public void refreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeysToField(String field, String value) {
		driver.findElement(By.id(field)).sendKeys(value);
		driver.findElement(By.id(field)).sendKeys(Keys.TAB);
	}

	public boolean isAlertPresent() { 
		try { 
			driver.switchTo().alert(); 
			return true; 
		} catch (NoAlertPresentException Ex) { 
			return false; 
		}
	}

	public void closeAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception Ex) { Ex.printStackTrace();; }
	}
}
