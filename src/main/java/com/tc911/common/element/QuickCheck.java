package com.tc911.common.element;

import java.io.File;
import java.io.PrintStream;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import com.tc911.common.core.BasePageObject;
import com.tc911.driverhelper.Constant;

public class QuickCheck extends BasePageObject {	

	public QuickCheck(String browser) {
		super(browser);
	}

	public void navigateToCase() throws InterruptedException {
		this.navigateModuleByXPath(Constant.Menu_LawEnforcement, Constant.Module_Case);
	}

	/**
	 * Function to export the printed console to TXT file.
	 * @author: DatLe
	 */
	public void printConsole() {
		try {
			System.setOut(new PrintStream(new File("output-file.txt")));
		} catch (Exception e) { e.printStackTrace(); }
	}

	public boolean checkLoginSuccess() {
		boolean check = false;

		if(driver.findElement(By.xpath("//*[@id='expandCase']")).isEnabled()) {
			check = true;
		}

		return check;
	}

	public void createCase(int number) throws InterruptedException {
		Thread.sleep(3300);
		driver.findElement(By.id("caseNo")).sendKeys(Constant.Case_Name+number,Keys.TAB);
		Thread.sleep(1800);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1800);
		driver.findElement(By.id("caseAssignOK")).click();
		Thread.sleep(1000);
	}

	public void createCaseThenLogout(int count, int maxCount) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("caseNo")).sendKeys(Constant.Case_Name+count,Keys.TAB);
		Thread.sleep(700);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(500);
		driver.findElement(By.id("caseAssignOK")).click();
		Thread.sleep(1600);
		if(count < maxCount) {
			this.logOutLogiTrak();
			this.setupLogin();
		}
	}

	public void openCase(String input) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("caseNo")).sendKeys(input,Keys.TAB);
		Thread.sleep(1800);
	}

	public void linkCase() throws InterruptedException {
		wait.forElementClickable(driver.findElement(By.id("txtRepTitle")), 10000);
		driver.findElement(By.id("txtRepTitle")).click();
		String selectAll = Keys.chord(Keys.SHIFT,Keys.TAB);
		driver.findElement(By.id("txtRepTitle")).sendKeys(selectAll,Keys.ENTER);

		for(int count=1; count<3; count++) {
			System.out.println("LINK THE "+count+" TIME");

			try {
				while(driver.findElement(By.id("btnLinks")).isEnabled()) {
						driver.findElement(By.id("btnLinks")).click();
						Thread.sleep(1800);
				}

			} catch(Exception e) {
				selectComboBox(driver.findElement(By.id("toTableType")), "1");
				this.selectComboBox(driver.findElement(By.id("toAgency")), "TRACY");
				driver.findElement(By.id("toReportNo")).sendKeys(Constant.Case_Name+(count+1), Keys.TAB);
				Thread.sleep(800);
				driver.findElement(By.id("btnLinkOK")).click();
				Thread.sleep(1500);
			}
		}
	}

	public void printCase(String value) throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();

		builder.moveToElement(driver.findElement(By.xpath("//*[@id='print']")));
		builder.click().build().perform();
		Thread.sleep(800);

		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Select dropdown = new Select(driver.findElement(By.id("report")));
		dropdown.selectByValue(value);  
		driver.findElement(By.id("Go")).click();
		Thread.sleep(1800);

		for(String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}	
}