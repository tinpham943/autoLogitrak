package com.tc911.common.element;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tc911.common.core.BasePageObject;
import com.tc911.common.core.ExcelUtils;
import com.tc911.common.core.Wait;
import com.tc911.driverhelper.Constant;


public class MasterName extends BasePageObject {
	@FindBy(css = "#masterIndex")
	private WebElement masterIndex;
	@FindBy(css = "#txtName")
	private WebElement txtName;
	@FindBy(css = "#btnAlerts")
	private WebElement btnAlerts;
	@FindBy(css = "#btnInvolvements")
	private WebElement btnInvolvements;
	@FindBy(css = "#txtStatus")
	private WebElement txtStatus;
	@FindBy(css = "#txtConfidentialCode")
	private WebElement txtConfidentialCode;
	@FindBy(css = "#tabAddnl")
	private WebElement tabAddnl;
	@FindBy(css = "#tabAttach")
	private WebElement tabAttach;
	@FindBy(css = "#tabLink")
	private WebElement tabLink;
	@FindBy(css = "#btnNewName")
	private WebElement btnNewName;
	@FindBy(css = "#btnDeleteName")
	private WebElement btnDeleteName;
	@FindBy(css = "#btnOpenName")
	private WebElement btnOpenName;
	@FindBy(css = "#btnNewAddr")
	private WebElement btnNewAddr;
	@FindBy(css = "#btnDeleteAddr")
	private WebElement btnDeleteAddr;
	@FindBy(css = "#btnOpenAddr")
	private WebElement btnOpenAddr;
	@FindBy(css = "#txtAge")
	private WebElement txtAge;
	@FindBy(css = "#txtAgeRange")
	private WebElement txtAgeRange;
	@FindBy(css = "#optAgeUnitYearY")
	private WebElement optAgeUnitYearY;
	@FindBy(css = "#optAgeUnitMonthM")
	private WebElement optAgeUnitMonthM;
	@FindBy(css = "#optAgeUnitDayD")
	private WebElement optAgeUnitDayD;
	@FindBy(css = "#txtHeight")
	private WebElement txtHeight;
	@FindBy(css = "#txtHeightRange")
	private WebElement txtHeightRange;
	@FindBy(css = "#txtWeight")
	private WebElement txtWeight;
	@FindBy(css = "#txtWeightRange")
	private WebElement txtWeightRange;
	@FindBy(css = "#chkJuvenile")
	private WebElement chkJuvenile;
	@FindBy(css = "#txtBuildCode")
	private WebElement txtBuildCode;
	@FindBy(css = "#txtEyesCode")
	private WebElement txtEyesCode;
	@FindBy(css = "#txtGlassesCode")
	private WebElement txtGlassesCode;
	@FindBy(css = "#txtTeethCode")
	private WebElement txtTeethCode;
	@FindBy(css = "#txtSkinCode")
	private WebElement txtSkinCode;
	@FindBy(css = "#txtHairColorCode")
	private WebElement txtHairColorCode;
	@FindBy(css = "#txtHairLengthCode")
	private WebElement txtHairLengthCode;
	@FindBy(css = "#txtHairStyleCode")
	private WebElement txtHairStyleCode;
	@FindBy(css = "#txtFacialHairCode")
	private WebElement txtFacialHairCode;
	@FindBy(css = "#txtDemeanorCode")
	private WebElement txtDemeanorCode;
	@FindBy(css = "#txtHandedCode")
	private WebElement txtHandedCode;
	@FindBy(css = "#txtResStatusCode")
	private WebElement txtResStatusCode;
	@FindBy(css = "#txtSpeechCode")
	private WebElement txtSpeechCode;
	@FindBy(css = "#txtEthnicityCode")
	private WebElement txtEthnicityCode;
	@FindBy(css = "#txtMarital")
	private WebElement txtMarital;
	@FindBy(css = "#txtPOB")
	private WebElement txtPOB;
	@FindBy(css = "#txtOccupation")
	private WebElement txtOccupation;
	@FindBy(css = "#txtUniqueId")
	private WebElement txtUniqueId;
	@FindBy(css = "#txtSID")
	private WebElement txtSID;
	@FindBy(css = "#txtFBI")
	private WebElement txtFBI;
	@FindBy(css = "#txtOtherNoType")
	private WebElement txtOtherNoType;
	@FindBy(css = "#txtOtherNo")
	private WebElement txtOtherNo;
	@FindBy(css = "#txtMugShotIDNo")
	private WebElement txtMugShotIDNo;
	@FindBy(css = "#txtOtherCode1")
	private WebElement txtOtherCode1;
	@FindBy(css = "#txtOtherCode2")
	private WebElement txtOtherCode2;
	@FindBy(css = "#txtOtherCode3")
	private WebElement txtOtherCode3;
	@FindBy(css = "#btnNewSmt")
	private WebElement btnNewSmt;
	@FindBy(css = "#btnDeleteSmt")
	private WebElement btnDeleteSmt;
	@FindBy(css = "#btnOpenSmt")
	private WebElement btnOpenSmt;
	@FindBy(css = "#updatedByText")
	private WebElement updatedByText;
	@FindBy(css = "#txtLastUpdate")
	private WebElement txtLastUpdate;
	@FindBy(css = "#txtLastUpTime")
	private WebElement txtLastUpTime;

	@FindBy(css = "#grdName")
	private WebElement grdName;
	@FindBy(css = "#grdAddr")
	private WebElement grdAddr;
	@FindBy(css = "#grdSMTInfo")
	private WebElement grdSMTInfo;
	/**
	 * element of find form
	 */
	/*
	 * @FindBy(css = "#last") private WebElement last;
	 * 
	 * @FindBy(css = "#first") private WebElement first;
	 * 
	 * @FindBy(css = "#middle") private WebElement middle;
	 * 
	 * @FindBy(css = "#suffix") private WebElement suffix;
	 * 
	 * @FindBy(css = "#txtDOB") private WebElement txtDOB;
	 * 
	 * @FindBy(css = "#race") private WebElement race;
	 * 
	 * @FindBy(css = "#sex") private WebElement sex;
	 * 
	 * @FindBy(css = "#dlNum") private WebElement dlNum;
	 * 
	 * @FindBy(css = "#dlState_combobox_input") private WebElement
	 * dlState_combobox_input;
	 * 
	 * @FindBy(css = "#ssn") private WebElement ssn;
	 * 
	 * @FindBy(xpath = ".//*[@id='1']/td[11]") private WebElement ssn2;
	 * 
	 * @FindBy(css = "#txtPhone") private WebElement txtPhone;
	 * 
	 * @FindBy(css = "#height") private WebElement height;
	 * 
	 * @FindBy(css = "#heightRange") private WebElement heightRange;
	 * 
	 * @FindBy(css = "#weight") private WebElement weight;
	 * 
	 * @FindBy(css = "#weightRange") private WebElement weightRange;
	 * 
	 * @FindBy(css = "#hairColor") private WebElement hairColor;
	 * 
	 * @FindBy(css = "#eyeColor") private WebElement eyeColor;
	 * 
	 * @FindBy(css = "#txtAddressType") private WebElement txtAddressType;
	 * 
	 * @FindBy(css = "#address") private WebElement address;
	 * 
	 * @FindBy(css = "#commonTab") private WebElement commonTab;
	 * 
	 * @FindBy(css = "#masterNameFind") private WebElement masterNameFind;
	 * 
	 * @FindBy(css = "#btnClose") private WebElement btnClose;
	 * 
	 * @FindBy(css = "#btnSearch") private WebElement btnSearch;
	 * 
	 * @FindBy(css = "#btnAddMaster") private WebElement btnAddMaster;
	 * 
	 * @FindBy(css = "#masterName") private WebElement masterName;
	 */

	private NameGlobal nameForm;
	public MasterName(String browser){
		super(browser);
	}
	/**
	 * login then navigation to MasterName
	 * 
	 * @throws InterruptedException
	 */
	public void navigateMasterName() throws InterruptedException {
		// this.navigateModule(Constant.Module_MasterName);
		this.navigateModuleByXPath(Constant.Menu_Master, Constant.Module_MasterName);
	}

	/**
	 * @author sangtran
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public boolean checkDisableElements() throws IllegalArgumentException, IllegalAccessException {
		Class<?> objClass = this.getClass();
		boolean imasterIndex = false;
		boolean iobject = false;
		boolean check = false;
		Field[] fields = objClass.getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			System.out.println(name);
			// omit case nameGlobal
			if(name.equalsIgnoreCase("nameForm")){
				continue;
			}
			WebElement value = (WebElement) field.get(this);
			if (name.equals("masterIndex")) {
				if (value.isEnabled())
					imasterIndex = true;
			} else {
				if (checkDisable(value, name)) {
					iobject = true;
					// logfile
				} else {
					iobject = false;
					System.out.println("error"+name);
					break;
				}
			}
		}
		if (imasterIndex && iobject) {
			check = true;
		} else {
			check = false;
		}
		// logfile
		return check;
	}

	/**
	 * check disable an element, if element is disable return true;
	 * @author sangtran
	 * @param element
	 * @param name
	 * @return
	 */
	public boolean checkDisable(WebElement element, String name) {
		String type = name.substring(0, Math.min(name.length(), 3));
		if (type.equalsIgnoreCase("btn") || type.equalsIgnoreCase("opt")) {
			if (element.isEnabled()) {
				return false;
			}
			return true;
		} else if (type.equalsIgnoreCase("txt") || type.equalsIgnoreCase("chk") || name.equals("updatedByText")) {
			String readonly = element.getAttribute("readonly");
			System.out.println("readonly" + readonly);
			if (name.equals("txtAge")) {
				System.out.println("a" + readonly);
			}
			if (readonly != null && (readonly.equals("true") || readonly.equals("readonly"))) {
				return true;
			}
			return false;
		} else if (type.equalsIgnoreCase("grd")) {
			WebElement table_element = driver.findElement(By.id(name));
			List<WebElement> tr_collection = table_element.findElements(By.xpath("id('" + name + "')/tbody/tr"));
			if (tr_collection.size() > 1) {
				return false;
			}
			return true;
		} else {
			// default tab not check
			if (type.equals("tab"))
				return true;
			return false;
		}
	}
	/**
	 * check All Data exists, if data exists return true;
	 * @author sangtran
	 * @param element
	 * @param name
	 * @return
	 */
	public boolean checkDataExists() throws IllegalArgumentException, IllegalAccessException {
		Class<?> objClass = this.getClass();
		boolean check = false;
		Field[] fields = objClass.getDeclaredFields();
		
		for (Field field : fields) {
			String name = field.getName();
			// omit case nameGlobal
			if(name.equalsIgnoreCase("nameForm")){
				continue;
			}
			WebElement value = (WebElement) field.get(this);
			check = checkDataExist(value, name);
			if (check == true)
				break;
		}
		return check;
	}

	/**
	 * if element has data return true, else return false
	 * 
	 * @param element
	 * @param name
	 * @return
	 */
	public boolean checkDataExist(WebElement element, String name) {
		String type = name.substring(0, Math.min(name.length(), 3));
		// System.out.println(name+ "value:"+element.getAttribute("value")+"
		// text:"+element.getText());
		if (type.equalsIgnoreCase("opt") || type.equalsIgnoreCase("chk")) {
			String value = element.getAttribute("checked");
			// System.out.println(name+ "opt:"+element.getAttribute("checked"));
			if (value != null && value.equals("true")) {
				return true;
			}
			return false;
		} else if (type.equalsIgnoreCase("txt") || name.equals("updatedByText")) {
			String value = element.getAttribute("value");
			if (value != null && value.trim().length() > 1) {
				return true;
			}
			return false;
		} else if (type.equalsIgnoreCase("grd")) {
			WebElement table_element = driver.findElement(By.id(name));
			List<WebElement> tr_collection = table_element.findElements(By.xpath("id('" + name + "')/tbody/tr"));
			if (tr_collection.size() > 1) {
				return true;
			}
			return false;
		} else {
			// default tab not check
			return false;
		}
	}

	/**
	 * create new MN by FindForm
	 * @author datle
	 * @throws InterruptedException
	 */
	public String createNewMN() throws InterruptedException {
		Thread.sleep(2000);
		this.navigateModuleByXPath(Constant.Menu_Master, Constant.Module_MasterNameFind);
		String originWin = driver.getWindowHandle();

		for (String searchWin : driver.getWindowHandles()) {
			if (searchWin.equals(originWin))
				continue;
			driver.switchTo().window(searchWin);
			wait.forElementClickable(By.id("btnSearch"), 5);
			try {
				if (driver.findElement(By.id("btnSearch")).isEnabled()) {
					driver.findElement(By.id("btnSearch")).click();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnAddMaster"))));
					driver.findElement(By.id("btnAddMaster")).click();
					Thread.sleep(2000);
					driver.findElement(By.id("btnClose")).click();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.switchTo().window(originWin);
		Thread.sleep(2000);
		return masterIndex.getAttribute("value");
	}

	/**
	 * random number in min - (max-1)
	 * 
	 * @param max
	 * @param min
	 * @return myRandomInt
	 * @author tinpham
	 */
	public int random(int max, int min) {
		int myRandomInt = new Random().nextInt(max - min) + min;
		return myRandomInt;
	}

	/**
	 * Insert results passed or failed into excel file
	 * 
	 * @param tcname
	 * @param result
	 * @param row
	 * @param col1
	 * @param col2
	 * @author tinpham
	 */
	public void insertResulttoExcel(String tcname, String result, int row, int col1, int col2) {
		try {
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "sheet1");
			ExcelUtils.setCellData(result, row, col1);
			ExcelUtils.setCellData(tcname, row, col2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Re open MN by FindForm
	 * 
	 * @return
	 * @throws InterruptedException
	 * @author tinpham
	 */
	public String inputMNbyExcel() throws InterruptedException {
		String originWin = driver.getWindowHandle();
		Thread.sleep(1000);
		String mti = null;
		this.navigateModuleByXPath(Constant.Menu_Master, Constant.Module_MasterNameFind);
		String sSSN = "" + this.random(999999999, 100000000);
		String sPhone = "0" + this.random(999999999, 100000000);
		for (String searchWin : driver.getWindowHandles()) {
			if (searchWin.equals(originWin))
				continue;
			driver.switchTo().window(searchWin);
			wait.forElementClickable(By.id("btnSearch"), 5);
			try {
				if (driver.findElement(By.id("btnSearch")).isEnabled()) {
					// Perform the actions on new window
					ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData_Mastername,
							"Matername info");
					// start variable
					String sLast = ExcelUtils.getCellData(this.random(5, 1), 0);
					String sFirst = ExcelUtils.getCellData(this.random(5, 1), 1);
					String sMiddle = ExcelUtils.getCellData(this.random(5, 1), 2);
					String sSuffix = ExcelUtils.getCellData(this.random(5, 1), 3);
					String sDOB = ExcelUtils.getCellData(this.random(5, 1), 4);
					String sRace = ExcelUtils.getCellData(this.random(5, 1), 6);
					String sSex = ExcelUtils.getCellData(this.random(5, 1), 7);
					String sDL = ExcelUtils.getCellData(this.random(5, 1), 8).toString();
					String sST = ExcelUtils.getCellData(this.random(5, 1), 9);
					String sHeight = ExcelUtils.getCellData(this.random(5, 1), 11).toString();
					String sWeight = ExcelUtils.getCellData(this.random(5, 1), 12).toString();
					String sHaircolor = ExcelUtils.getCellData(this.random(5, 1), 13);
					String sEyecolor = ExcelUtils.getCellData(this.random(5, 1), 14);
					String sEthnicity = ExcelUtils.getCellData(this.random(5, 1), 15);
					String sAddrType = ExcelUtils.getCellData(this.random(5, 1), 16);
					String sAddr = ExcelUtils.getCellData(this.random(5, 1), 17);
					String sStatus = ExcelUtils.getCellData(this.random(5, 1), 19);
					// end variable
					driver.findElement(By.id("last")).sendKeys(sLast);
					driver.findElement(By.id("first")).sendKeys(sFirst);
					driver.findElement(By.id("middle")).sendKeys(sMiddle);
					driver.findElement(By.id("suffix")).sendKeys(sSuffix);
					driver.findElement(By.id("txtDOB")).sendKeys(sDOB, Keys.TAB);
					this.selectComboBox(driver.findElement(By.id("race")), sRace);
					this.selectComboBox(driver.findElement(By.id("sex")), sSex);
					driver.findElement(By.id("dlNum")).sendKeys(sDL);
					driver.findElement(By.id("dlState")).sendKeys(sST);
					driver.findElement(By.id("ssn")).sendKeys(sSSN);
					driver.findElement(By.id("height")).sendKeys(sHeight);
					driver.findElement(By.id("weight")).sendKeys(sWeight);
					driver.findElement(By.id("heightRange")).sendKeys(sHeight);
					driver.findElement(By.id("weightRange")).sendKeys(sWeight);
					this.selectComboBox(driver.findElement(By.id("hairColor")), sHaircolor);
					this.selectComboBox(driver.findElement(By.id("eyeColor")), sEyecolor);
					this.selectComboBox(driver.findElement(By.id("txtEthnicityCode")), sEthnicity);
					this.selectComboBox(driver.findElement(By.id("txtAddressType")), sAddrType);
					driver.findElement(By.id("address")).sendKeys(sAddr);
					driver.findElement(By.id("txtPhone")).sendKeys(sPhone);
					this.selectComboBox(driver.findElement(By.id("txtStatus")), sStatus);
					// add new mastername
					driver.findElement(By.id("btnSearch")).click();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnAddMaster"))));
					driver.findElement(By.id("btnAddMaster")).click();
					Thread.sleep(3000);
					driver.findElement(By.id("btnClose")).click();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		driver.switchTo().window(originWin);
		 mti = masterIndex.getAttribute("value");
		this.navigateMasterName();
		Thread.sleep(6000);
		this.wait.forElementVisible(masterIndex, 2000);
		this.masterIndex.sendKeys(mti, Keys.TAB);
		
		wait.forElementVisible(driver.findElement(By.xpath(".//*[@id='1']/td[11]")), 2000);
		assertEquals(sSSN,
				driver.findElement(By.xpath(".//*[@id='1']/td[11]")).getAttribute("title").replaceAll("-", ""));
		String result = "true";
		return result;
	}

	/**
	 * calculate age
	 * 
	 * @author tinpham
	 * @param sbirthday
	 * @return
	 */
	public static int getAge(String sbirthday) {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthday = LocalDate.parse(sbirthday, formatter);
		Period p = Period.between(birthday, today);
		return p.getYears();
	}

	/**
	 * check age
	 * 
	 * @author tinpham
	 * @return
	 * @throws InterruptedException
	 */
	public boolean checkAgeNewMN() throws InterruptedException {
		Thread.sleep(1000);
		this.navigateModuleByXPath(Constant.Menu_Master, Constant.Module_MasterNameFind);
		String originWin = driver.getWindowHandle();

		for (String searchWin : driver.getWindowHandles()) {
			if (searchWin.equals(originWin))
				continue;
			driver.switchTo().window(searchWin);
			wait.forElementClickable(By.id("btnSearch"), 5);
			try {
				if (driver.findElement(By.id("btnSearch")).isEnabled()) {
					ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData_Mastername,
							"Matername info");
					String sDOBB = ExcelUtils.getCellData(this.random(5, 1), 4);
					driver.findElement(By.id("txtDOB")).sendKeys(sDOBB, Keys.TAB);
					assertEquals(String.valueOf(getAge(sDOBB)), driver.findElement(By.id("age")).getAttribute("value"));
					driver.findElement(By.id("btnClose")).click();
				System.out.println(driver.findElement(By.id("btnClose")).getTagName());	
					
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.switchTo().window(originWin);
		return true;
	}

	/**
	 * check Juvenile is checked if age <18
	 * 
	 * @author tinpham
	 * @return
	 * @throws InterruptedException
	 */
	public boolean checJuvenileMN() throws InterruptedException {
		Thread.sleep(1000);
		this.navigateModuleByXPath(Constant.Menu_Master, Constant.Module_MasterNameFind);
		String originWin = driver.getWindowHandle();
		String sDOB = null;
		for (String searchWin : driver.getWindowHandles()) {
			if (searchWin.equals(originWin))
				continue;
			driver.switchTo().window(searchWin);
			wait.forElementClickable(By.id("btnSearch"), 5);
			try {
				if (driver.findElement(By.id("btnSearch")).isEnabled()) {
					ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData_Mastername,
							"Matername info");
					sDOB = ExcelUtils.getCellData(this.random(7, 5), 4);
					System.out.println((getAge(sDOB)));
					driver.findElement(By.id("txtDOB")).sendKeys(sDOB, Keys.TAB);
					assertEquals(String.valueOf(getAge(sDOB)), driver.findElement(By.id("age")).getAttribute("value"));
					driver.findElement(By.id("btnSearch")).click();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnAddMaster"))));
					driver.findElement(By.id("btnAddMaster")).click();
					Thread.sleep(1000);
					driver.findElement(By.id("btnClose")).click();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.switchTo().window(originWin);
		Thread.sleep(1000);
		if ((getAge(sDOB) < 18) && (chkJuvenile.isSelected()))
			
			return true;
		else
			return false;
	}

	public boolean checkJuvenileRight() throws InterruptedException {
		Thread.sleep(1000);
		this.navigateModuleByXPath(Constant.Menu_Master, Constant.Module_MasterNameFind);
		String originWin = driver.getWindowHandle();
		String sDOB1 = null;

		for (String searchWin : driver.getWindowHandles()) {
			if (searchWin.equals(originWin))
				continue;
			driver.switchTo().window(searchWin);
			wait.forElementClickable(By.id("btnSearch"), 5);
			try {
				if (driver.findElement(By.id("btnSearch")).isEnabled()) {
					ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData_Mastername,
							"Matername info");
					sDOB1 = ExcelUtils.getCellData(this.random(7, 5), 4);
					driver.findElement(By.id("txtDOB")).sendKeys(sDOB1, Keys.TAB);
					assertEquals(String.valueOf(getAge(sDOB1)), driver.findElement(By.id("age")).getAttribute("value"));
					driver.findElement(By.id("btnSearch")).click();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnAddMaster"))));
					driver.findElement(By.id("btnAddMaster")).click();
					Thread.sleep(1000);
					driver.findElement(By.id("btnClose")).click();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.switchTo().window(originWin);
		Thread.sleep(1000);
		String mti = masterIndex.getAttribute("value");
		if ((getAge(sDOB1) < 18) && (chkJuvenile.isSelected())) {
			this.logOutLogiTrak();
			Thread.sleep(2000);
			this.setupLogin_nojuvenile();
			Thread.sleep(1000);
			this.navigateModuleByXPath(Constant.Menu_Master, Constant.Module_MasterName);
			Wait wait = new Wait(driver);
			wait.forElementVisible(masterIndex, 2000);
			masterIndex.sendKeys(mti, Keys.TAB);
			wait.forElementVisible(driver.findElement(By.xpath("(//tr[@id='1']/td[3])[2]")), 2000);
			assertEquals(driver.findElement(By.xpath("(//tr[@id='1']/td[3])[2]")).getAttribute("title"),"XXXXX");
			return true;
		}
		else
			return false;
	}

	public boolean createNewName() throws InterruptedException {
		this.navigateModuleByXPath(Constant.Menu_Master, Constant.Module_MasterNameFind);
		String originWin = driver.getWindowHandle();

		for (String searchWin : driver.getWindowHandles()) {
			if (searchWin.equals(originWin))
				continue;
			driver.switchTo().window(searchWin);
			wait.forElementClickable(By.id("btnSearch"), 5);
			try {
				if (driver.findElement(By.id("btnSearch")).isEnabled()) {
					driver.findElement(By.id("btnSearch")).click();
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnAddMaster"))));
					driver.findElement(By.id("btnAddMaster")).click();
					driver.findElement(By.id("btnClose")).click();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		driver.switchTo().window(originWin);
		this.wait.forElementClickable(this.btnNewName, 10);
		Thread.sleep(2000);
		// create new name form
		this.btnNewName.click();
		Thread.sleep(3000);
		;
		// open name section to create new name for this mastername
		// inject driver
		this.nameForm = new NameGlobal(this.driver);
		this.nameForm.fillForm();

		driver.findElement(By.id("nameAddrOK")).click();

		Thread.sleep(4000);
		return true;
	}

}