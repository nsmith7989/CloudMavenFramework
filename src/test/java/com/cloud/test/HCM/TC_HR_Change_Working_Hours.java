/**
 Test Name: TC_HR_Change_Working_Hours
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to HR Change Working Hours
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
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_HR_Change_Working_Hours extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to HR Change Working Hours")	
public void HR_Change_Working_Hours(String UserName,String Password,String SearchName,String FullName,String ActionType,String StartTime,String WorkingHours) throws TestException,InterruptedException, TestException
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
	
	report.log(LogStatus.INFO, "Step 6. Enter the desired information into the Name field. Enter a valid value");
	objPMP.enterName(SearchName);
	
	report.log(LogStatus.INFO, "Step 7. Click the Search button");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 8. Scroll down to see the results ");
	
	report.log(LogStatus.INFO, "Step 9. Click the Name link. ");
	objPMP.selectPersonName(FullName);
	
	report.log(LogStatus.INFO, "Step 10. Click the Edit button.");
	objPMP.clickEditButton();
	
	report.log(LogStatus.INFO, "Step 11. Click the Correct list item.");
	objPMP.selectCorrectFromEditList();
	
	report.log(LogStatus.INFO, "Step 12. Click the Working Hours Change list item");
	objPMP.selectCorrectActionType(ActionType);
	
	report.log(LogStatus.INFO, "Step 13. Click the OK button");
	objPMP.clickUpdateOKButton();
	
	report.log(LogStatus.INFO, "Step 14. Scroll down to see the Location list ");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 15. Click in the Start Time field.");
	report.log(LogStatus.INFO, "Step 16. Press [Delete].");
	report.log(LogStatus.INFO, "Step 17. Enter the desired information into the Start Time field. Enter a valid value ");
	objPMP.enterStartTime(StartTime);
	
	report.log(LogStatus.INFO, "Step 18. Scroll down to see the Location list ");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 19. Click in the Working Hours field");
	report.log(LogStatus.INFO, "Step 20. Press [Delete].");
	report.log(LogStatus.INFO, "Step 21. Enter the desired information into the Working Hours field. Enter a valid value");
	objPMP.enterWorkingHours(WorkingHours);
	
	report.log(LogStatus.INFO, "Step 22. Scroll up to click the Review button");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 23. Click the Review button.");
	objPMP.clickLocationReviewButton();
	
	report.log(LogStatus.INFO, "Step 24. Use the Edit Employment: Review page to verify the changes");
	sAssert.assertTrue(objPMP.isEditReviewPageDisplayed());
	
	report.log(LogStatus.INFO, "Step 25. Scroll down to see the changed values");
	SeleniumUtils.scroll(driver, 0, 100);
	
	report.log(LogStatus.INFO, "Step 25. Click the Submit button.");
	objPMP.clickReviewSubmitButton();
	
	report.log(LogStatus.INFO, "Step 26. Click the Yes button on confirmation dailog");
	objPMP.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 27. Click the OK button.");
	objPMP.clickOKButton();
	
	sAssert.assertAll();

}

}
