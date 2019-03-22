/**
 Test Name: TC_MSS_Transfer_an_Employee
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: HR specialists can permanently transfer or create temporary assignments for workers for whom they have security access. Line managers can permanently transfer their direct and indirect reports. Permanent transfers and temporary assignments can be within the worker's current legal employer or to a different legal employer.
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
import com.cloud.pageobjects.HCM.TransferPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_MSS_Transfer_an_Employee extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to MSS Transfer of an Employee")	
public void MSS_Transfer_an_Employee(String UserName,String Password,String TeamMemberName,String ActionType,String SubActionType,String ActionReason,String LocationSearch,String LocationName,String Floor,String WorkAtHome,String BuildingInfo) throws TestException,InterruptedException, TestException
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
	report.log(LogStatus.INFO, "Step 7. Click the Transfer object");
	objMTPage.selectTeamMemberwithAction(TeamMemberName,ActionType,SubActionType);
	
	TransferPage objTrans=new TransferPage(driver,report);
	report.log(LogStatus.INFO, "Step 8. Click the vertical scrollbar.");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 9. Click the Action Reason list. and Click the Career Progression list item.");
	objTrans.selectTransferReason(ActionReason);;
	
	report.log(LogStatus.INFO, "Step 10. Scroll down to see the Location list ");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 11. Click the Location list");
	objTrans.clickLocationList();
	
	report.log(LogStatus.INFO, "Step 12. Click the Search... link.");
	objTrans.clickSearchLink();
	
	report.log(LogStatus.INFO, "Step 13. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
	objTrans.enterLocationName(LocationSearch);
	
	report.log(LogStatus.INFO, "Step 14. Click the Search button.");
	objTrans.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 15. Click the CiberGlobal cell");
	objTrans.selectLocationName(LocationName);
	
	report.log(LogStatus.INFO, "Step 16. Click the OK button.");
	objTrans.clickBUOKButton();
	
	report.log(LogStatus.INFO, "Step 17. Click in the Floor field.Enter the desired information into the Floor field. Enter a valid value ");
	objTrans.enterFloor(Floor);
	
	report.log(LogStatus.INFO, "Step 18. Click the Working at Home list and Click the Yes list item");
	objTrans.selectWorkAtHome(WorkAtHome);
	
	report.log(LogStatus.INFO, "Step 19. Click in the Building field.Enter the desired information into the Building field. Enter a valid value ");
	objTrans.enterBuildingInfo(BuildingInfo);
	
	report.log(LogStatus.INFO, "Step 20. Scroll up to click the Next button");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 21. Click the Next button.");
	objTrans.clickFirstNextButton();
	
	report.log(LogStatus.INFO, "Step 22. Scroll down to see the cahnges");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 23. Scroll up to click the Next button");
	SeleniumUtils.scroll(driver, 0, -500);
	
	report.log(LogStatus.INFO, "Step 24. Click the Next button.");
	objTrans.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 25. Click the Next button.");
	objTrans.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 26. Click the Submit button.");
	objTrans.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 27. Click the Yes button on confirmation dailog");
	objTrans.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 28. Click the OK button.");
	objTrans.clickOKButton();
	
	sAssert.assertAll();

}

}
