/**
 Test Name: TC_MSS_Manage_Direct_Reports
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to you will be able to manage direct reports
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
import com.cloud.pageobjects.HCM.ManageDirectReportsPage;
import com.cloud.pageobjects.HCM.MyTeamPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_MSS_Manage_Direct_Reports extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to manage direct reports")	
public void MSS_Manage_Direct_Reports(String UserName,String Password,String TeamMemberName,String ActionType,String SubActionType,String SearchName,String PersonName,String VerifyName) throws TestException,InterruptedException, TestException
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
	report.log(LogStatus.INFO, "Step 7. Click the Manage Direct Reports link");
	objMTPage.selectTeamMemberwithAction(TeamMemberName,ActionType,SubActionType);
	
	//Create instance for Manage Direct Reports page
	ManageDirectReportsPage objMDR=new ManageDirectReportsPage(driver,report);
	
	report.log(LogStatus.INFO, "Step 8. Click the Add Manager Details button");
	objMDR.clickSelectAndAddbutton();
	
	report.log(LogStatus.INFO, "Step 9. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
	objMDR.enterPersonName(SearchName);
	
	report.log(LogStatus.INFO, "Step 10. Click the Search button.");
	objMDR.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 11. Click the Name cell");
	objMDR.selectPersonName(PersonName);
	
	report.log(LogStatus.INFO, "Step 12. Click the Apply button.");
	objMDR.clickApplyButton();
	
	report.log(LogStatus.INFO, "Step 13 Click the OK button.");
	objMDR.clickNamesOKButton();
	
	report.log(LogStatus.INFO, "Step 14 Verify that Direct Report is selected and added or not");
	if(objMDR.verifyDirectReportName(VerifyName))
	{
		report.log(LogStatus.PASS, "Step 14.1. Direct Report is selected and added");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 14.1.Direct Report is not selected and added");	
	}
	
	report.log(LogStatus.INFO, "Step 15. Scroll up to click the Review button");
	SeleniumUtils.scroll(driver, 0, -1500);
	
	report.log(LogStatus.INFO, "Step 16. Click the Review button.");
	objMDR.clickLocationReviewButton();
	
	report.log(LogStatus.INFO, "Step 17. Click the Submit button.");
	objMDR.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 18. Click the Yes button on confirmation dailog");
	objMDR.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 19. Click the OK button.");
	objMDR.clickOKButton();
	
	sAssert.assertAll();

}

}
