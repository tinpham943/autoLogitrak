package com.tc911.common.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tc911.driverhelper.Constant;

public class JavascriptAction {
	private final static int WEBDRIVER_WAIT_TIMEOUT_SEC = 15;
	private final JavascriptExecutor js;
	private final WebDriver driver;

	public JavascriptAction(WebDriver driver) {
		this.js = (JavascriptExecutor) driver;
		this.driver = driver;
	}

	public void click(String cssSelector) {
		js.executeScript("$('" + cssSelector + "').click()");
	}

	public void click(WebElement element) {
		js.executeScript("$(arguments[0])[0].click()", element);
	}

	public void focus(String cssSelector) {
		js.executeScript("$('" + cssSelector + "').focus()");
	}

	public void focus(WebElement element) {
		js.executeScript("$(arguments[0]).focus()", element);
	}

	public Object execute(String script, WebElement element) {
		return js.executeScript(script, element);
	}

	public Object execute(String script) {
		try {
			Object value = js.executeScript("return " + script);
			Thread.sleep(1000);
			return value;
		} catch (InterruptedException e) {
			return null;
		} catch (UnsupportedOperationException e) {
			return null;
		}
	}

	public void mouseOver(WebElement element) {
		js.executeScript("$(arguments[0]).mouseenter()", element);
	}

	private boolean isElementInViewPort(WebElement element) {
		return (Boolean) js.executeScript(
				"return ($(window).scrollTop() + 60 < $(arguments[0]).offset().top) && ($(window).scrollTop() "
						+ "+ $(window).height() > $(arguments[0]).offset().top + $(arguments[0]).height() + 60)"
						, element);
	}

	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToElement(By elementBy) {
		try {
			js.executeScript(
					"var x = $(arguments[0]);" + "window.scroll(0,parseInt(x.offset().top - 60));"
					, driver.findElement(elementBy));
		} catch (WebDriverException e) {
			if (e.getMessage().contains(Constant.NO_JQUERY_ERROR)) {
				e.printStackTrace();
			}
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			js.executeScript(
					"var x = $(arguments[0]);" + "window.scroll(0,parseInt(x.offset().top - 60));", element);
		} catch (WebDriverException e) {
			if (e.getMessage().contains(Constant.NO_JQUERY_ERROR)) {
				e.printStackTrace();
			}
		}
	}

	public void scrollToSpecificElement(WebElement element) {
		try {
			js.executeScript(
					"arguments[0].scrollIntoView(true);",element);
		} catch (WebDriverException e) {
			if (e.getMessage().contains(Constant.NO_JQUERY_ERROR)) {
				e.printStackTrace();
			}
		}
	}

	public void scrollToElement(WebElement element, int offset) {
		int elementPosition = element.getLocation().getY() - offset;
		js.executeScript("window.scroll(0,arguments[0])",  elementPosition);
	}

	public void scrollToElementInModal(WebElement element, WebElement modal) {
		int elementOffsetTop = Integer.parseInt(
				js.executeScript("return Math.round($(arguments[0]).offset().top)", element).toString());
		int modalOffsetTop = Integer.parseInt(
				js.executeScript("return Math.round($(arguments[0]).offset().top)", modal).toString());
		int scrollTop = elementOffsetTop - modalOffsetTop;

		js.executeScript("$(arguments[0]).scrollTop(arguments[1])", modal, scrollTop);
	}

	public void scrollElementIntoViewPort(WebElement element) {
		if (!isElementInViewPort(element)) { scrollToElement(element); }
	}

	public void scrollBy(int x, int y) {
		js.executeScript("window.scrollBy(arguments[0], arguments[1])", x, y);
	}

	public void waitForJavaScriptTruthy(final String script) {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		try {
			new WebDriverWait(driver, WEBDRIVER_WAIT_TIMEOUT_SEC).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					try {
						return (boolean) js.executeScript("return !!(" + script + ");");
					} catch (WebDriverException e) {
						return false;
					}
				}
			});
		} finally {
			driver.manage().timeouts().implicitlyWait(WEBDRIVER_WAIT_TIMEOUT_SEC, TimeUnit.MILLISECONDS);
		}
	}

	public void changeElementOpacity(String selector, int value) {
		js.executeScript("document.querySelector(arguments[0]).style.opacity = arguments[1];"
				, selector, value);
	}

	public String getWindowErrors() {
		return js.executeScript("return window.errors || ''").toString();
	}

	public void addErrorListenerScript() {
		js.executeScript(
				"var script = document.createElement('script'); " + "script.innerHTML = 'window.onerror = "
						+ "function (e, u, l, c, errorObj) { window.errors = errorObj.stack }';"
						+ "document.querySelector('body').appendChild(script);");
	}
}
