/**
 Test Name: TC_MSS_Change_WorkingHours
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to change working hours for an employee
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
import com.cloud.pageobjects.HCM.ChangeWorkingHoursPage;
import com.cloud.pageobjects.HCM.MyTeamPage;
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_MSS_Change_WorkingHours extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to change working hours for an employee")	
public void MSS_Change_WorkingHours(String UserName,String Password,String TeamMemberName,String ActionType,String SubActionType,	String StartTime,String WorkingHours) throws TestException,InterruptedException, TestException
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
	report.log(LogStatus.INFO, "Step 7. Click the Change Working Hours link");
	objMTPage.selectTeamMemberwithAction(TeamMemberName,ActionType,SubActionType);
		
	report.log(LogStatus.INFO, "Step 8. Scroll down to see the Change Manager list ");
	ChangeWorkingHoursPage objWhrs=new ChangeWorkingHoursPage(driver,report);
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 9. Click in the Working Hours field");
	report.log(LogStatus.INFO, "Step 10. Press [Delete].");
	report.log(LogStatus.INFO, "Step 11. Enter the desired information into the Working Hours field. Enter a valid value");
	objWhrs.enterWorkingHours(WorkingHours);
	
	report.log(LogStatus.INFO, "Step 12. Click in the Start Time field.");
	report.log(LogStatus.INFO, "Step 13. Press [Delete].");
	report.log(LogStatus.INFO, "Step 14. Enter the desired information into the Start Time field. Enter a valid value ");
	objWhrs.enterStartTime(StartTime);
	
	report.log(LogStatus.INFO, "Step 15. Scroll up to click the Next button");
	SeleniumUtils.scroll(driver, 0, -1500);
	
	report.log(LogStatus.INFO, "Step 16. Click the Next button.");
	objWhrs.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 17. Scroll down to see the changes");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 18. Scroll up to click the Next button");
	SeleniumUtils.scroll(driver, 0, -1500);
	
	report.log(LogStatus.INFO, "Step 19. Click the Next button.");
	objWhrs.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 20. Use the Edit Employment: Review page to verify the changes");
	sAssert.assertTrue(objWhrs.isEditReviewPageDisplayed());
	
	report.log(LogStatus.INFO, "Step 21. Click the Submit button.");
	objWhrs.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 22. Click the Yes button on confirmation dailog");
	objWhrs.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 23. Click the OK button.");
	objWhrs.clickOKButton();
	
	sAssert.assertAll();

}

}
