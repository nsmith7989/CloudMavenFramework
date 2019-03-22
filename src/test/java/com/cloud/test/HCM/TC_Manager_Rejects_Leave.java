/**
 Test Name: TC_Manager_Rejects_Leave
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
import com.cloud.pageobjects.HCM.ApproveOrRejectPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_Manager_Rejects_Leave extends BaseWebTest  {
SoftAssert sAssert;

public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Manager Rejects Leave")	
public void Manager_Applies_Leave(String UserName,String Password,String LeaveType,String Frequency,String SelectStartDate,String SelectReason,String Comments,String TeamMemberName,String StartDate) throws TestException,InterruptedException, TestException
{
	sAssert=new SoftAssert();
	report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
	LoginPage objLogin = new LoginPage(driver, report);
	sAssert.assertTrue(objLogin.isUserNameDisplayed());
	
	report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
	HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
	//HomePage objHome =objLogin.loginToCloudApplication("Cole.Ross","Welcome123");
	
	report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
	sAssert.assertTrue(objHome.isHomeImageDisplayed());
	
	report.log(LogStatus.INFO, "Step 4. Click the Pending Notifications button.");
	objHome.clickNotificationsrIcon();
	
	report.log(LogStatus.INFO, "Step 5. Click the Action Required: Approval of Ciber_Annual_Type Absence Request fo link");
	objHome.selectNotification("Action Required: Approval of Ciber_Annual_Type Absence Request");
	SeleniumUtils.delay(10000);
	
	report.log(LogStatus.INFO, "Step 6. Switch to Approve or Reject page");
	sAssert.assertTrue(SeleniumUtils.swithToWindow(driver, "Approval of Ciber_Annual_Type Absence Request"));
	
	report.log(LogStatus.INFO, "Step 7. Click the Reject button.");
	ApproveOrRejectPage objAORobj=new ApproveOrRejectPage(driver,report);
	objAORobj.clickRejectButton();
			
	sAssert.assertAll();
			
}

}

