/**
 Test Name: TC_HR_Applies_Leave_on_Behalf_of_Employee
 Created By: Ciber
 Creation Date:May 07,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to apply the leave
 Prerequisite: Test data should be proper before running this script
 */
package com.cloud.test.HCM;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_HR_Applies_Leave_on_Behalf_of_Employee extends BaseWebTest  {
SoftAssert sAssert;

public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to HR Applies Leave on Behalf of Employee")	
public void HR_Applies_Leave(String UserName,String Password,String LeaveType,String Frequency,String SelectStartDate,String SelectReason,String Comments,String PersonName,String StartDate,String PersonNumber) throws TestException,InterruptedException, TestException
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
	
	report.log(LogStatus.INFO, "Step 5. Click on Person Management link");
	PersonManagementPage objPMP=objHome.clickPersonManagement();
	
	report.log(LogStatus.INFO, "Step 6. Click in the Person Number field,Enter the desired information into the Person Number field");
	objPMP.enterPersonNumber(PersonNumber);
	
	report.log(LogStatus.INFO, "Step 7. Click the Search button");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 8. Scroll down to see the results ");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 9. Click the Name link. ");
	objPMP.selectPersonName(PersonName);
	
	report.log(LogStatus.INFO, "Step 10. Click the Tasks button.");
	objPMP.clickTasksButton();
	
	report.log(LogStatus.INFO, "Step 11. Click the Manage Absence Records link ");
	objPMP.clickManageAbsenceRecordLink();
	
	report.log(LogStatus.INFO, "Step 12. Click the vertical scrollbar");
	// ((JavascriptExecutor)driver).executeScript("scroll(0,300)");
	SeleniumUtils.scroll(driver, 0, 300);
	
	report.log(LogStatus.INFO, "Step 13. Click the Add button");
	objPMP.clickAddButton();
	
	report.log(LogStatus.INFO, "Step 14. Click the Type list and Click the Ciber_Annual_Type Prospective US Legal entity list item.");
	objPMP.selectType(LeaveType);
	
	report.log(LogStatus.INFO, "Step 15. Click the Single day option");
	objPMP.checkSingleDay();
	
	report.log(LogStatus.INFO, "Step 16. Click in the Start Date field.Enter the desired information into the Start Date field");
	objPMP.enterStartDate(StartDate);
	
	report.log(LogStatus.INFO, "Step 17. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, -4000);
		
	report.log(LogStatus.INFO, "Step 18. Click in the Comments field and Enter the desired information into the Comments field");
	objPMP.enterComments(Comments);
	
	report.log(LogStatus.INFO, "Step 19. Click the Submit button.");
	objPMP.clicSubmitButton();
	
	report.log(LogStatus.INFO, "Step 20. Click the OK button");
	objPMP.clickOKButton();
	
	report.log(LogStatus.INFO, "Step 21. Click the Done button.");
	objPMP.clicDoneButton();
	
	/*report.log(LogStatus.INFO, "Step 22. Click the Yes button");
	objPMP.clicYesButton();*/
			
	sAssert.assertAll();
			
}

}
