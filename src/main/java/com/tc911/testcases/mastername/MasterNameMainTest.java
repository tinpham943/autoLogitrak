package com.tc911.testcases.mastername;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tc911.common.core.TestLink;
import com.tc911.common.element.MasterName;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
public class MasterNameMainTest implements IRetryAnalyzer {
	
	private int retryCount = 0;
    private int maxRetryCount = 0;
   
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
	private MasterName masterName;
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws InterruptedException{
		masterName = new MasterName(browser);
		masterName.setupLogin();
		Thread.sleep(500);
		masterName.navigateMasterName();
	}
/*	@BeforeMethod(alwaysRun = true)
	public void accessMasterName() throws InterruptedException{
		Thread.sleep(500);
		masterName.navigateMasterName();
		Thread.sleep(500);
	}*/
	@AfterMethod(alwaysRun = true)
	public void accessMainMenu() throws InterruptedException{
		Thread.sleep(500);
		masterName.navigateMainMenu();
		masterName.logOutLogiTrak();
		masterName.quitDriver();
	}
	/**
	 *@author sangtran
	 *@category MasterName
	 *@date 04/25/2017
	 */
	@Test(groups = "MasterName", priority=3,retryAnalyzer = MasterNameMainTest.class)
	public void MN_Opens_All_Fields_Disabled() throws IllegalArgumentException, IllegalAccessException, InterruptedException{
		System.out.println("MN_Opens_All_Fields_Disabled");
		boolean check = masterName.checkDisableElements();
		try{
			if(check == true){
				check = true;
				 TestLink.exception = "Passed Note";
				 TestLink.updateTestLinkResult(3,198,ExecutionStatus.PASSED,2,"Passed");
			}
		}
		catch(Exception e){
			check = false;
			TestLink.exception = "Failed Note";
			TestLink.updateTestLinkResult(3,198,ExecutionStatus.FAILED,2,e.getMessage());
		}
		assertTrue(check);
	}
	/**
	 *@author sangtran
	 *@category MasterName
	 *@date 04/25/2017
	 */
	@Test(groups = "MN_S1_TC2", priority=4,retryAnalyzer = MasterNameMainTest.class)
	public void No_Data_In_Disabled_Fields() throws InterruptedException, IllegalArgumentException, IllegalAccessException {
		boolean check = masterName.checkDataExists();
		if(check == true){
			masterName.insertResulttoExcel("MN_S1_TC2", "FAILED", 2, 1, 2);
		}
		else{
			masterName.insertResulttoExcel("MN_S1_TC2", "PASSED", 2, 1, 2);
		}
		assertFalse(check);
	}
	/**
	 *@author datle
	 *@category MasterName
	 *@date 04/25/2017
	 */
	@Test(groups = "MN_S1_TC6", priority=5,retryAnalyzer = MasterNameMainTest.class)
	public void Add_New_MasterName_ByFindForm() throws InterruptedException, IllegalArgumentException, IllegalAccessException {
		String masterIndex = masterName.createNewMN();
		boolean check = false;
		if(masterIndex.trim().length() >0){
			check = true;
		}
		if(check == true){
			check = true;
			masterName.insertResulttoExcel("MN_S1_TC6", "PASSED", 6, 1, 2);
		}
		else{
			check = false;
			masterName.insertResulttoExcel("MN_S1_TC6", "FAILED", 6, 1, 2);
		}
		assertTrue(check);
	}
	/**
	 *@author datle
	 *@category MasterName
	 *@date 04/25/2017
	 */
	@Test(groups="MN_S1_TC4", priority=6,retryAnalyzer = MasterNameMainTest.class)
	public void Open_NonExist_MasterName() throws InterruptedException{
		masterName.sendKeysToField("masterIndex", "999");
		Thread.sleep(1000);
		assertTrue(masterName.isAlertPresent());
		boolean check = masterName.isAlertPresent();
		if(check == true){
			masterName.closeAlert();
		}
		if(check == true){
			masterName.insertResulttoExcel("MN_S1_TC4", "PASSED", 4, 1, 2);
		}
		else{
			masterName.insertResulttoExcel("MN_S1_TC4", "FAILED", 4, 1, 2);
		}
		
	}
	/**
	 *@author tinpham
	 *@category MasterName
	 *@date 04/25/2017
	 */
	@Test(groups="MN_S1_TC3", priority=7,retryAnalyzer = MasterNameMainTest.class)
	public void Reopen_Created_MasterName() throws InterruptedException{
		String masterIndex = masterName.inputMNbyExcel();	
		boolean check = false;
		if(masterIndex.equals("true")){
			check = true;
			masterName.insertResulttoExcel("MN_S1_TC3", "PASSED", 3, 1, 2);
			masterName.insertResulttoExcel("VIA_MN_S1_TC3", "PASSED", 5, 1, 2);
			masterName.insertResulttoExcel("VIA_MN_S1_TC3", "PASSED", 10, 1, 2);
		}
		else{
			check = false;
			masterName.insertResulttoExcel("MN_S1_TC5", "FAILED", 3, 1, 2);
			masterName.insertResulttoExcel("VIA_MN_S1_TC3", "FAILED", 5, 1, 2);
			masterName.insertResulttoExcel("VIA_MN_S1_TC3", "FAILED", 10, 1, 2);
		}
		assertTrue(check);
	}
	/**
	 *@author tinpham
	 *@category MasterName
	 *@date 04/25/2017
	 */
	@Test(groups = "MN_S1_TC8", priority=8,retryAnalyzer = MasterNameMainTest.class)
	public void Check_Age_Calculates() throws InterruptedException {
		boolean check = masterName.checkAgeNewMN();
		if(check == true){
			masterName.insertResulttoExcel("MN_S1_TC8", "PASSED", 8, 1, 2);
		}
		else{
			masterName.insertResulttoExcel("MN_S1_TC8", "FAILED", 8, 1, 2);
		}
		assertTrue(check);
	}
	/**
	 *@author tinpham
	 *@category MasterName
	 *@date 04/25/2017
	 */
	@Test(groups = "MN_S1_TC11", priority= 11,retryAnalyzer = MasterNameMainTest.class)
	public void Check_Juvenile_isChecked() throws InterruptedException {
		boolean check = masterName.checJuvenileMN();
		if(check == true){
			//masterName.insertResulttoExcel("MN_S1_TC8", "FAILED", 8, 1, 2);
		}
		else{
			//masterName.insertResulttoExcel("MN_S1_TC8", "PASSED", 8, 1, 2);
		}
		assertTrue(check);
	}
	/**
	 *@author tinpham
	 *@category MasterName
	 *@date 04/25/2017
	 */
	@Test(groups = "MN_S1_TC7", priority=12,retryAnalyzer = MasterNameMainTest.class)
	public void Check_Juvenile_Right() throws InterruptedException {
		boolean check = masterName.checkJuvenileRight();
		if(check == true){
			masterName.insertResulttoExcel("MN_S1_TC7", "FAILED", 7, 1, 2);
		}
		else{
			masterName.insertResulttoExcel("MN_S1_TC7", "PASSED", 7, 1, 2);
		}
		assertTrue(check);
	}
	

	/*@Test(groups = "MN_S1_TC20" , priority=20)
	public void runT() throws InterruptedException {
		boolean check = masterName.createNewName();
		assertTrue(check);
	}*/

	
	/*@AfterClass(alwaysRun = true)
	public void tearDown(){
		masterName.logOutLogiTrak();
		masterName.quitDriver();
	}*/
}