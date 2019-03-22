/**
 Test Name: TC_MSS_Promote_an_Employee
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used Human resource specialists can promote workers to whom they have security access. Line managers can promote their direct and indirect reports.
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.HCM;
import java.awt.AWTException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.HCM.MyTeamPage;
import com.cloud.pageobjects.HCM.PromotionPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_MSS_Promote_an_Employee extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to MSS Promote an Employee")	
public void MSS_Promote_an_Employee(String UserName,String Password,String TeamMemberName,String ActionType,String SubActionType,String PositionSearch,String PositionName) throws TestException,InterruptedException, TestException
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
	report.log(LogStatus.INFO, "Step 7. Click the Promote object");
	objMTPage.selectTeamMemberwithAction(TeamMemberName,ActionType,SubActionType);
	
	PromotionPage objProm=new PromotionPage(driver,report);
	report.log(LogStatus.INFO, "Step 7.1. Click the vertical scrollbar.");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 8. Click the Search Positions list");
	try {
		objProm.clickSearchPositionsList();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	report.log(LogStatus.INFO, "Step 9. Click the vertical scrollbar.");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 10. Click the Search... link.");
	objProm.clickSearchLink();
	
	report.log(LogStatus.INFO, "Step 11. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
	objProm.enterPositionName(PositionSearch);
	
	report.log(LogStatus.INFO, "Step 12. Click the Search button.");
	objProm.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 13. Click the Payroll Manager cell");
	objProm.selectPositionName(PositionName);
	
	report.log(LogStatus.INFO, "Step 14. Click the OK button.");
	objProm.clickBUOKButton();
	
	report.log(LogStatus.INFO, "Step 15. Click the Yes button");
	//objProm.clicYesButton();
	
	report.log(LogStatus.INFO, "Step 16. Click the Next button");
	objProm.clickFirstNextButton();
	
	report.log(LogStatus.INFO, "Step 17. Click Scroll down button");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 18. Click Scroll up button");
	SeleniumUtils.scroll(driver, 0, -500);
	
	report.log(LogStatus.INFO, "Step 19. Click the Next button");
	objProm.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 20. Click the Next button");
	objProm.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 21. Click the Submit button.");
	objProm.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 22. Click the Yes button on confirmation dailog");
	objProm.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 23. Click the OK button.");
	objProm.clickOKButton();
	
	sAssert.assertAll();

}

}
