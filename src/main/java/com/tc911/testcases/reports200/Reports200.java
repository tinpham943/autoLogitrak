package com.tc911.testcases.reports200;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tc911.common.element.QuickCheck;
import com.tc911.driverhelper.Constant;

public class Reports200 {

	private QuickCheck quickCheck; 

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setUp(String browser) throws InterruptedException {
		quickCheck = new QuickCheck(browser);
		quickCheck.setupLogin();
//		quickCheck.printConsole();
	}

	@AfterMethod(alwaysRun = true)
	public void accessMainMenu() throws InterruptedException {
		Thread.sleep(500);
//		quickCheck.navigateMainMenu();
		quickCheck.logOutLogiTrak();
		quickCheck.quitDriver();
	}

	@Test(invocationCount = 210)
	public void logInOut() throws InterruptedException {
		boolean check = quickCheck.checkLoginSuccess();
		assertTrue(check);
	}

	@Test
	public void creat200CaseLogout() throws InterruptedException {
		for(int count=1; count < 211; count++) {
			quickCheck.navigateToCase();
			quickCheck.createCaseThenLogout(count, 210);
		}
	}

	/**
	 * @author: DatLe
	 * Test case #1.a. To CREATE ~200 Case Report.
	 */
	@Test(priority=1)
	public void createCase200() throws InterruptedException {
		for(int count=1; count < 211; count++) {
			quickCheck.navigateToCase();
			quickCheck.createCase(count);
		}
	}

	/**
	 * @author: DatLe
	 * Test case #1.b. To OPEN ~200 Case Report.
	 */
	@Test(priority=2)
	public void openCase200() throws InterruptedException {
		for(int count=1; count < 211; count++) {
			quickCheck.navigateToCase();
			quickCheck.openCase(Constant.Case_Name+count);
		}
	}

	/**
	 * @author: DatLe
	 * Test case #2. To LINK ~200 Case Report.
	 */
	@Test(priority=3)
	public void linkCase200() throws InterruptedException {
		quickCheck.navigateToCase();
//		quickCheck.openCase(Constant.Case_Name+"1");
		quickCheck.openCase("AUTOTEST999999");
		quickCheck.linkCase();
	}

	/**
	 * @author: DatLe
	 * Test case #3. To PRINT ~200 LINKED Case Report. 
	 */
	@Test(priority=4)
	public void printCase200() throws InterruptedException {
		quickCheck.navigateToCase();
		quickCheck.openCase(Constant.Case_Name+"1");
		for(int count=1; count < 211; count++) {
			quickCheck.printCase("CA01");
		}
	}
}