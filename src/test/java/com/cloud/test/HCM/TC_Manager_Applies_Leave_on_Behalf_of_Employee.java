/**
 Test Name: TC_Manager_Applies_Leave_on_Behalf_of_Employee
 Created By: Ciber
 Creation Date:May 03,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to apply the leave by Manager on behalf of Employee
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
import com.cloud.pageobjects.HCM.ManageAbsenceRecordsPage;
import com.cloud.pageobjects.HCM.MyTeamPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_Manager_Applies_Leave_on_Behalf_of_Employee extends BaseWebTest  {
SoftAssert sAssert;

public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Manager Applies Leave on Behalf of Employee")	
public void Manager_Applies_Leave(String UserName,String Password,String LeaveType,String Frequency,String SelectStartDate,String SelectReason,String Comments,String TeamMemberName,String StartDate) throws TestException,InterruptedException, TestException
{
	sAssert=new SoftAssert();
	report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
	LoginPage objLogin = new LoginPage(driver, report);
	sAssert.assertTrue(objLogin.isUserNameDisplayed());
	
	report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
	HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
	
	report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
	sAssert.assertTrue(objHome.isHomeImageDisplayed());
	
	report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
	objHome.clickNavigatorIcon();
	
	report.log(LogStatus.INFO, "Step 5. Click the My Team link");
	MyTeamPage objMTPage=objHome.clickMyTeamLink();
	
	report.log(LogStatus.INFO, "Step 6. Click the Actions button and Click the Absences menu");
	report.log(LogStatus.INFO, "Step 7. Click the Manage Absence Records link");
	objMTPage.selectTeamMember(TeamMemberName);
	
	report.log(LogStatus.INFO, "Step 8. Click the Absence Type list");
	ManageAbsenceRecordsPage objMAPobj=new ManageAbsenceRecordsPage(driver,report);
	objMAPobj.clickAddButton();
	
	report.log(LogStatus.INFO, "Step 9. Click the Type list and Click the Ciber_Annual_Type Prospective US Legal entity list item.");
	objMAPobj.selectType(LeaveType);
	
	report.log(LogStatus.INFO, "Step 10. Click the Single day option");
	objMAPobj.checkSingleDay();
	
	report.log(LogStatus.INFO, "Step 11. Click in the Start Date field.Enter the desired information into the Start Date field");
	objMAPobj.enterStartDate(StartDate);
		
	report.log(LogStatus.INFO, "Step 12. Click in the Comments field and Enter the desired information into the Comments field");
	objMAPobj.enterComments(Comments);
	
	report.log(LogStatus.INFO, "Step 13. Click the Submit button.");
	objMAPobj.clicSubmitButton();
	
	report.log(LogStatus.INFO, "Step 14. Click the OK button");
	objMAPobj.clicOKButton();
	
	report.log(LogStatus.INFO, "Step 15. Click the Done button.");
	objMAPobj.clicDoneButton();
		
	sAssert.assertAll();
			
}

}
