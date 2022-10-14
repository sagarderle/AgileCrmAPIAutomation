package com.AgilecrmAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class UpdatedExcelUtilTest {
  

  @DataProvider(name="getLoginTestData")
  public Object[][] getTestData() {
	  String filePath = "C:\\AgilecrmTestCases\\TestCase_Agilecrm.xlsx";
	  UpdatedExcelUtil excelvalues = new UpdatedExcelUtil();
	  Object[][] data = excelvalues.getSheetdata(filePath,"Agile_TestCase_creation");
    return data;
  }
  @Test(dataProvider = "getLoginTestData")
  public void loginTestCase(Object TS_ID, Object TS_Description) {
	  System.out.println(TS_ID + " : " +TS_Description);
  }
}
