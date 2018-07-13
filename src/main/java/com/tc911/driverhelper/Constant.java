package com.tc911.driverhelper;

public interface Constant {
	public static final String InternetExplorer ="IE";
	public static final String Chrome ="Chrome";
	public static final String Firefox ="FF";
	public static final String Edge ="Edge";

	public static final String Menu_LawEnforcement = "policeTab";
	public static final String Menu_Master ="commonTab";
	public static final String Menu_Fire = "fireTab";

	public static final String NO_JQUERY_ERROR ="ReferenceError: $ is not defined";

	public static final String Module_MasterName = "masterName";
	public static final String Module_MasterVehilce = "masterVehicle";
	public static final String Module_MasterProperty="masterProperty";
	public static final String Module_Case ="navIncident";
	public static final String Module_Accident ="accident";
	public static final String Module_WantWarrant ="wantWarrant";
	public static final String Module_FIR ="fir";
	public static final String Module_Citation = "citation";
	public static final String Module_CourtInfo = "courtInfo";
	public static final String Module_CFSInformation = "cfsInformation";
	public static final String Module_StandardReport ="policeStandardReport";
	public static final String Module_Notification = "notifyMessage";
	public static final String Module_MasterNameFind = "masterNameFind";

	public static final String TypeLogin_Officer = "1";
	public static final String TypeLogin_Admin = "0";

	//excel path
	public static final String Path_TestData = System.getProperty("user.dir")+"/src/main/resources/ExcelData/";
	public static final String File_TestData = "TC.xlsx";
	public static final String File_TestData_Mastername = "MaternameData.xlsx";

	public static final String Case_Name = "TRUCTRUC";
}
