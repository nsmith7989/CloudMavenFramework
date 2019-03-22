/**
 Test Name: TC_MSS_Terminate_an_Employee
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to HR specialists can terminate the work relationships of workers to whom they have security access. Line managers can terminate the work relationships of their direct and indirect reports.
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
import com.cloud.pageobjects.HCM.MyTeamPage;
import com.cloud.pageobjects.HCM.TerminatePage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_MSS_Terminate_an_Employee extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to MSS Terminate of an Employee")	
public void MSS_Terminate_an_Employee(String UserName,String Password,String TeamMemberName,String ActionType,String SubActionType,String ActionsList,String RecommendedforRehire,String Reason) throws TestException,InterruptedException, TestException
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
	report.log(LogStatus.INFO, "Step 7. Click the Terminate object");
	objMTPage.selectTeamMemberwithAction(TeamMemberName,ActionType,SubActionType);
	
	TerminatePage objTerm=new TerminatePage(driver,report);
	report.log(LogStatus.INFO, "Step 8. Click the vertical scrollbar.");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 9. Click the Action list");
	report.log(LogStatus.INFO, "Step 10. Select Resignation item from Action dropdown");
	objTerm.selectTerminateAction(ActionsList);
	
	report.log(LogStatus.INFO, "Step 11. Click the vertical scrollbar.");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 12. Click the Recommended for Rehire list and select the No value from this list");
	objTerm.selectRecommendedforRehire(RecommendedforRehire);
	
	report.log(LogStatus.INFO, "Step 13. Click the vertical scrollbar.");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 14. Click the Reason list and select the Negotiated settlement list item");
	objTerm.selectReason(Reason);
	
	report.log(LogStatus.INFO, "Step 15. Click the vertical scrollbar up");
	SeleniumUtils.scroll(driver, 0, -500);
	
	report.log(LogStatus.INFO, "Step 16. Click the Review button");
	objTerm.clickReviewButton();
	
	report.log(LogStatus.INFO, "Step 17. Click the vertical scrollbar.");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 18. Click the vertical scrollbar up");
	SeleniumUtils.scroll(driver, 0, -500);
	
	/*report.log(LogStatus.INFO, "Step 19. Click the Submit button.");
	objTerm.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 20. Click the Yes button on confirmation dailog");
	objTerm.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 21. Click the OK button.");
	objTerm.clickOKButton();*/
	
	sAssert.assertAll();

}

}
