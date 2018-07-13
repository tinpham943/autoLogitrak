package com.tc911.common.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	private static final int DEFAULT_TIMEOUT = 15;
	private WebDriverWait wait;
	private WebDriver driver;

	public Wait(WebDriver webDriver) {
		this.driver = webDriver;
		this.wait = new WebDriverWait(webDriver, DEFAULT_TIMEOUT);
	}

	public WebElement forElementPresent(By by) { return forElementPresent(by, true); }

	public WebElement forElementPresent(By by, boolean failOnTimeout) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (TimeoutException e) {
			if (failOnTimeout) {
				e.printStackTrace();
			}
			throw e;
		} finally {
			restoreDefaultImplicitWait();
		}
	}

	public WebElement forElementPresent(By by, int timeout) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try {
			return new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw e;
		} finally {
			restoreDefaultImplicitWait();
		}
	}

	public WebElement forElementClickable(By by) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try { return wait.until(ExpectedConditions.elementToBeClickable(by)); }
		finally { restoreDefaultImplicitWait(); }
	}

	public WebElement forElementClickable(By by, int timeout) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try {
			return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
		} finally { restoreDefaultImplicitWait(); }
	}

	public WebElement forElementClickable(WebElement element, int timeout) {
		changeImplicitWait(0, TimeUnit.MILLISECONDS);
		try { element.getTagName(); }
		catch (WebDriverException e) { e.printStackTrace(); }
		try {
			return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		} finally {
			restoreDefaultImplicitWait();
		}
	}

	public WebElement forElementVisible(WebElement element, int timeout, int polling) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try { 
			return new WebDriverWait(driver, timeout, polling).until(ExpectedConditions.visibilityOf(element));
		} finally { restoreDefaultImplicitWait(); }
	}

	public WebElement forElementVisible(WebElement element, int timeout) {
		return forElementVisible(element, timeout, 500);
	}

	public WebElement forElementVisible(By by) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try { return wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }
		finally { restoreDefaultImplicitWait(); }
	}

	public WebElement forElementVisible(By by, int timeout, int polling) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try {
			return new WebDriverWait(driver, timeout, polling).until(
					ExpectedConditions.visibilityOfElementLocated(by));
		} finally { restoreDefaultImplicitWait(); }
	}

	public boolean forElementNotVisible(By by) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try {
			return new WebDriverWait(driver, DEFAULT_TIMEOUT).until(
					ExpectedConditions.invisibilityOfElementLocated(by));
		} finally { restoreDefaultImplicitWait(); }
	}

	public boolean forElementNotVisible(By by, int timeout, int polling) {
		changeImplicitWait(250, TimeUnit.MILLISECONDS);
		try {
			return new WebDriverWait(driver, timeout, polling).until(
					ExpectedConditions.invisibilityOfElementLocated(by));
		} finally { restoreDefaultImplicitWait(); }
	}

	private void restoreDefaultImplicitWait() {
		changeImplicitWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	}

	private void changeImplicitWait(int value, TimeUnit timeUnit) {
		driver.manage().timeouts().implicitlyWait(value, timeUnit);
	}
}
