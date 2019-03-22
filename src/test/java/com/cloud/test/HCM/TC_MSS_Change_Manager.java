/**
 Test Name: TC_MSS_Change_Manager
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to MSS Change Location
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
import com.cloud.pageobjects.HCM.ChangeLocationPage;
import com.cloud.pageobjects.HCM.ChangeManagerPage;
import com.cloud.pageobjects.HCM.MyTeamPage;
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_MSS_Change_Manager extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to MSS Change Manager")	
public void MSS_Change_Manager(String UserName,String Password,String TeamMemberName,String ActionType,String SubActionType,String ChangeReason,String SearchName,String ManagerName,String Type) throws TestException,InterruptedException, TestException
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
	
	report.log(LogStatus.INFO, "Step 6. Click the Actions button and Click the Personal and Employment object");
	report.log(LogStatus.INFO, "Step 7. Click the Change Manager Object");
	objMTPage.selectTeamMemberwithAction(TeamMemberName,ActionType,SubActionType);
	
	report.log(LogStatus.INFO, "Step 8. Scroll down to see the Change Manager list ");
	ChangeManagerPage objMgr=new ChangeManagerPage(driver,report);
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 9. Click the Change Manager Reason list");
	report.log(LogStatus.INFO, "Step 10. Select the Transfer of Manager list item");
	objMgr.selectChangeReason(ChangeReason);
	
	report.log(LogStatus.INFO, "Step 11. Click the Remove button.");
	objMgr.removeManager();
	
	report.log(LogStatus.INFO, "Step 12. Click the Add Manager Details button");
	objMgr.clickAddManagerDetailsButton();
	
	report.log(LogStatus.INFO, "Step 13. Click the Name list");
	objMgr.clickNameList();
	
	report.log(LogStatus.INFO, "Step 14. Click the Search... link.");
	objMgr.clickSearchLink();
	
	report.log(LogStatus.INFO, "Step 15. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
	objMgr.enterLocationName(SearchName);
	
	report.log(LogStatus.INFO, "Step 16. Click the Search button.");
	objMgr.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 17. Click the Name cell");
	objMgr.selectManagerName(ManagerName);
	
	report.log(LogStatus.INFO, "Step 18. Click the OK button.");
	objMgr.clickBUOKButton();
	
	report.log(LogStatus.INFO, "Step 19. Click the Type list.");
	report.log(LogStatus.INFO, "Step 20. Click the Line manager list item.");
	objMgr.selectManagerType("Line manager");
	
	report.log(LogStatus.INFO, "Step 21. Scroll up to click the Review button");
	SeleniumUtils.scroll(driver, 0, -1500);
	
	report.log(LogStatus.INFO, "Step 22. Click the Review button.");
	objMgr.clickLocationReviewButton();
	
	report.log(LogStatus.INFO, "Step 23. Click the Submit button.");
	objMgr.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 24. Click the Yes button on confirmation dailog");
	objMgr.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 25. Click the OK button.");
	objMgr.clickOKButton();
	
	sAssert.assertAll();

}

}
