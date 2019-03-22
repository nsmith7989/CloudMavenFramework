/**
 Test Name: TC_HR_Change_Location
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to HR Change Location
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
public class TC_HR_Change_Location extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to HR Change Location")	
public void HR_Change_Location(String UserName,String Password,String SearchName,String FullName,String ActionType,String StartDate,String LocationSearch,String LocationName) throws TestException,InterruptedException, TestException
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
	SeleniumUtils.scroll(driver, 0, 1000);

	report.log(LogStatus.INFO, "Step 9. Click the Name link. ");
	objPMP.selectPersonName(FullName);
	
	report.log(LogStatus.INFO, "Step 10. Click the Edit button.");
	objPMP.clickEditButton();
	
	report.log(LogStatus.INFO, "Step 11. Click the Update list item.");
	objPMP.clickUpdateList();
	
	report.log(LogStatus.INFO, "Step 12. Click the Action list and Click the Location Change list item");
	objPMP.selectAction(ActionType);
	
	report.log(LogStatus.INFO, "Step 13. Click the OK button");
	objPMP.clickUpdateOKButton();
	
	report.log(LogStatus.INFO, "Step 14. Scroll down to see the results ");
	SeleniumUtils.scroll(driver, 0, 300);
	
	report.log(LogStatus.INFO, "Step 15. Click the Assignment: E100181 link");
	objPMP.clickAssignmentLink();
	
	report.log(LogStatus.INFO, "Step 16. Scroll down to see the Location list ");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 17. Click the Location list");
	objPMP.clickLocationList();
	
	report.log(LogStatus.INFO, "Step 18. Click the Search... link.");
	objPMP.clickSearchLink();
	
	report.log(LogStatus.INFO, "Step 19. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
	objPMP.enterLocationName(LocationSearch);
	
	report.log(LogStatus.INFO, "Step 20. Click the Search button.");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 21. Click the CiberGlobal cell");
	objPMP.selectLocationName(LocationName);
	
	report.log(LogStatus.INFO, "Step 22. Click the OK button.");
	objPMP.clickBUOKButton();
	
	report.log(LogStatus.INFO, "Step 23. Scroll up to click the Review button");
	SeleniumUtils.scroll(driver, 0, -1500);
	
	report.log(LogStatus.INFO, "Step 24. Click the Review button.");
	objPMP.clickLocationReviewButton();
	
	/*report.log(LogStatus.INFO, "Step 24. Verify BusinessUnit is updated with expected one or not");
	sAssert.assertEquals(objPMP.getBusinessUnitText(),BusinessUnit,"Actaul and Exepced BusinessUnit is not matching ");
	*/
	
	report.log(LogStatus.INFO, "Step 25. Click the Submit button.");
	objPMP.clickLocationSubmitButton();
	
	report.log(LogStatus.INFO, "Step 26. Click the Yes button on confirmation dailog");
	objPMP.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 27. Click the OK button.");
	objPMP.clickOKButton();
	
	report.log(LogStatus.INFO, "Step 28. Click the Done button");
	objPMP.clickDoneButton();
	
	/*report.log(LogStatus.INFO, "Step 29. Click the Yes button");
	objPMP.clicYesButton();*/

	sAssert.assertAll();

}

}
