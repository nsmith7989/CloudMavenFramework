/**
 Test Name: TC_Employee_Applies_Leave
 Created By: Ciber
 Creation Date:May 03,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to apply the leave
 Prerequisite: Test data should be proper before running this script
 */
package com.cloud.test.HCM;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.HCM.ScheduleAbsencePage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_Employee_Applies_Leave extends BaseWebTest  {
SoftAssert sAssert;

public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Employee Applies Leave")	
public void Employee_Applies_Leave(String UserName,String Password,String LeaveType,String Frequency,String SelectStartDate,String SelectReason,String Comments) throws TestException,InterruptedException, TestException
{
	sAssert=new SoftAssert();
	report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
	LoginPage objLogin = new LoginPage(driver, report);
	sAssert.assertTrue(objLogin.isUserNameDisplayed());
	
	report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
	HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
	//HomePage objHome =objLogin.loginToCloudApplication("Julie.Andrews","Welcome123");
	
	report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
	sAssert.assertTrue(objHome.isHomeImageDisplayed());
	
	report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
	objHome.clickNavigatorIcon();
	
	report.log(LogStatus.INFO, "Step 5. Click the Time link");
	ScheduleAbsencePage objSAPage=objHome.clickTimeLink();
	
	report.log(LogStatus.INFO, "Step 6. Click the Schedule Absence button");
	objSAPage.clickScheduleAbsenceButton();
	
	report.log(LogStatus.INFO, "Step 7. Click the Type list and Click the Ciber_Annual_Type Prospective US Legal entity list item.");
	objSAPage.selectType(LeaveType);
	
	report.log(LogStatus.INFO, "Step 8. Click the Frequency list and Click the Single day list item.");
	objSAPage.selectFrequency(Frequency);
	
	report.log(LogStatus.INFO, "Step 9. Click the Start Date button");
	objSAPage.clickStartDatePicker();
	
	report.log(LogStatus.INFO, "Step 10. Click the 23 cell");
	objSAPage.selectStartDate(SelectStartDate);
		
	report.log(LogStatus.INFO, "Step 11. Click the Ciber_PTO list item.");
	objSAPage.selectReason(SelectReason);
	
	report.log(LogStatus.INFO, "Step 12. Click in the Comments field and Enter the desired information into the Comments field");
	objSAPage.enterComments(Comments);
	
	report.log(LogStatus.INFO, "Step 13. Click the Calculate accruals and balances button");
	objSAPage.clickCalculateAccruals();
	
	report.log(LogStatus.INFO, "Step 14. Click the Submit button.");
	objSAPage.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 15. Click the OK button");
	objSAPage.clicOKButton();
		
	sAssert.assertAll();
			
}

}
