/**
 Test Name: TC_ESS_Manage_Document_Records
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Manage Document Records
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.HCM;
import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.HCM.MyDetailsPage;
import com.cloud.pageobjects.HCM.MyDocumentsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_ESS_Manage_Document_Records extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to ESS Manage Document Records")	
public void ESS_Manage_Document_Records(String UserName,String Password,String DocumentType,String DocumentName,String FromDateMonth,String FromDateNumber,String ToDateMonth,String ToDateNumber) throws TestException,InterruptedException, TestException
{
	sAssert=new SoftAssert();
	report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
	LoginPage objLogin = new LoginPage(driver, report);
	sAssert.assertTrue(objLogin.isUserNameDisplayed());
	
	report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
	HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
	//HomePage objHome =objLogin.loginToCloudApplication("bettina.verlaine","Welcome123");
	
	report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
	sAssert.assertTrue(objHome.isHomeImageDisplayed());
	
	report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
	objHome.clickNavigatorIcon();
	
	report.log(LogStatus.INFO, "Step 5. Click on Personal Information link");
	MyDetailsPage objMyDetails=objHome.clickPersonalInformation();
	
	report.log(LogStatus.INFO, "Step 6. Click the My Documents button");
	MyDocumentsPage objMDPobj=objMyDetails.clickMyDocuments();
	
	report.log(LogStatus.INFO, "Step 7. Click the Create button");
	objMDPobj.clickCreateButton();
	
	report.log(LogStatus.INFO, "Step 8. Expand Document Type list and click on Search link");
	try {
		objMDPobj.clickSearchFromDocumentTypeList();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	report.log(LogStatus.INFO, "Step 9. Click in the Document Type field");
	report.log(LogStatus.INFO, "Step 10. Enter the desired information into the Document Type field");
	objMDPobj.enterDocumentType(DocumentType);
	
	report.log(LogStatus.INFO, "Step 11. Click the Search button");
	objMDPobj.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 12. Click the Personal Files cell.");
	objMDPobj.clickPersonlaFiles();
	
	report.log(LogStatus.INFO, "Step 13. Click the OK button");
	objMDPobj.clickOKButton();
	
	report.log(LogStatus.INFO, "Step 14. Click in the Document Name field");
	report.log(LogStatus.INFO, "Step 15. Enter the desired information into the Document Name field");
	objMDPobj.enterDocumentName(DocumentName);
	
	report.log(LogStatus.INFO, "Step 16. Click the Select From Date button.");
	objMDPobj.clickFromDatePicker();
	
	report.log(LogStatus.INFO, "Step 17. Click the Select Month list.");
	report.log(LogStatus.INFO, "Step 18. Click the January list item");
	objMDPobj.selectFromDateMonth(FromDateMonth);
	
	report.log(LogStatus.INFO, "Step 19. Select the appropriate date. Click the 1 cell.");
	objMDPobj.selectFromDate(FromDateNumber);
	
	report.log(LogStatus.INFO, "Step 20. Click the Select To Date button.");
	objMDPobj.clickToDatePicker();
	
	report.log(LogStatus.INFO, "Step 21. Click the Select Month list.");
	report.log(LogStatus.INFO, "Step 22. Click the December list item");
	objMDPobj.selectToDateMonth(ToDateMonth);
	
	report.log(LogStatus.INFO, "Step 23. Select the appropriate date. Click the 31 cell.");
	objMDPobj.selectToDate(ToDateNumber);
	
	report.log(LogStatus.INFO, "Step 24. Click the scroll down to click on Add button");
	 ((JavascriptExecutor)driver).executeScript("scroll(0,300)");
	
	report.log(LogStatus.INFO, "Step 25. Click the Add button");
	objMDPobj.clickAddButton();
	
	report.log(LogStatus.INFO, "Step 26. Click the Browse... button");
	//objMDPobj.clickBrowseButton();
	
	report.log(LogStatus.INFO, "Step 27. Click the Address proof list item");
	objMDPobj.uploadAddressProof();
	
	report.log(LogStatus.INFO, "Step 28. Click the Submit button");
	objMDPobj.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 29. Click the Yes button");
	objMDPobj.clickYesButton();
	
	report.log(LogStatus.INFO, "Step 30. Click the OK button.");
	objMDPobj.clickConfirmationOKButton();
	
	sAssert.assertAll();

}

}
