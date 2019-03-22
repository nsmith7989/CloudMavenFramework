/**
Test Name: TC_ApplyMissingConversionRates
 Created By: Ciber
 Creation Date:May 22,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Apply Missing Conversion Rates
 Prerequisite: Test data should be proper before running this script
 */
package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.MissingConversion_SubmitRequestPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TC_ApplyMissingConversionRates extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is to Apply Missing Conversion Rates")
	public void Cloud_Apply_Missing_Conv_Rates(String UserName,String Password,String BusinessUnit)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);

		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");

		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 4. Click on Payments link");
		OverviewPage objOverview=objHome.clickPayments();
		
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Missing Conversion Rates link");
		objOverview.isApplyMissingConversionRatesLinkDisplayed(); 
		MissingConversion_SubmitRequestPage objMisConversion=objOverview.clickApplyMissingConversionRatesLink();
		
		report.log(LogStatus.INFO, "Step 7. Select Business Unit");
		objMisConversion.isSelectBusinessUnitDisplayed();
		objMisConversion.SelectBusinessUnit(BusinessUnit);
		objMisConversion.clickSubmissionNotes();
		
		report.log(LogStatus.INFO, "Step 8. Click on Submit Button");
		objMisConversion.isSubmitBtnDisplayed();
		objMisConversion.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 9. Click on Confirmation Ok Button");
		objMisConversion.isConfOkBtnDisplayed();
		objMisConversion.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 10. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 11. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
		
		
	}

}
