package com.tc911.common.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameGlobal {
	public WebElement txtLast;
	public WebElement txtFirst;
	public WebElement txtMiddle;
	public WebElement txtSuf;
	WebDriver driver;
	public NameGlobal(WebDriver driverInj){
		this.txtLast = driverInj.findElement(By.id("txtLast"));
		this.txtFirst = driverInj.findElement(By.id("txtFirst"));
		this.txtMiddle = driverInj.findElement(By.id("txtMiddle"));
		this.txtSuf = driverInj.findElement(By.id("txtSuf"));
	}
	/**
	 * fillForm from excel
	 * @author sangtran
	 * @param 222
	 *
	 */
	public void fillForm(){
		// excel	
		this.txtFirst.sendKeys("quince");
		this.txtLast.sendKeys("abab");
		this.txtMiddle.sendKeys("mid lane");
	}
	
}
