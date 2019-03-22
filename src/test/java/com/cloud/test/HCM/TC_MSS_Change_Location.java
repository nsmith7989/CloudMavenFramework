/**
 Test Name: TC_MSS_Change_Location
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
import com.cloud.pageobjects.HCM.MyTeamPage;
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_MSS_Change_Location extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to MSS Change Location")	
public void MSS_Change_Location(String UserName,String Password,String TeamMemberName,String ActionType,String SubActionType,String LocationSearch,String LocationName,String WorkAtHome,String BuildingInfo,String Floor) throws TestException,InterruptedException, TestException
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
	report.log(LogStatus.INFO, "Step 7. Click the Change Location link");
	objMTPage.selectTeamMemberwithAction(TeamMemberName,ActionType,SubActionType);
	
	ChangeLocationPage objLoc=new ChangeLocationPage(driver,report);
	
	report.log(LogStatus.INFO, "Step 8. Scroll down to see the Location list ");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 9. Click the Location list");
	objLoc.clickLocationList();
	
	report.log(LogStatus.INFO, "Step 10. Click the Search... link.");
	objLoc.clickSearchLink();
	
	report.log(LogStatus.INFO, "Step 11. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
	objLoc.enterLocationName(LocationSearch);
	
	report.log(LogStatus.INFO, "Step 12. Click the Search button.");
	objLoc.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 13. Click the CiberGlobal cell");
	objLoc.selectLocationName(LocationName);
	
	report.log(LogStatus.INFO, "Step 14. Click the OK button.");
	objLoc.clickBUOKButton();
	
	report.log(LogStatus.INFO, "Step 15. Click the Working at Home list and Click the Yes list item");
	objLoc.selectWorkAtHome(WorkAtHome);
	
	report.log(LogStatus.INFO, "Step 15. Click in the Building field.Enter the desired information into the Building field. Enter a valid value ");
	objLoc.enterBuildingInfo(BuildingInfo);
	
	report.log(LogStatus.INFO, "Step 16. Click in the Floor field.Enter the desired information into the Floor field. Enter a valid value ");
	objLoc.enterFloor(Floor);
	
	report.log(LogStatus.INFO, "Step 17. Scroll up to click the Review button");
	SeleniumUtils.scroll(driver, 0, -1500);
	
	report.log(LogStatus.INFO, "Step 18. Click the Review button.");
	objLoc.clickLocationReviewButton();
	
	report.log(LogStatus.INFO, "Step 19. Click the Submit button.");
	objLoc.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 20. Click the Yes button on confirmation dailog");
	objLoc.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 21. Click the OK button.");
	objLoc.clickOKButton();
	
	sAssert.assertAll();

}

}
