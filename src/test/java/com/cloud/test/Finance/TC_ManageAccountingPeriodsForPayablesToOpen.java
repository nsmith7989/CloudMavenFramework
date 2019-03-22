/**
Test Name: TC_ManageAccountingPeriodsForPayablesToOpen
 Created By: Ciber
 Creation Date:May 29,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Manage Accounting Periods for Payables to Open the Period
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
import com.cloud.pageobjects.Finance.EditAccountingPeriodStatusesPage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.ManageAccountingPeriodsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TC_ManageAccountingPeriodsForPayablesToOpen extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Manage Accounting Periods for Payables to Open the Period")
	public void Cloud_Manage_Acc_Periods_Open(String UserName,String Password,String Ladger,String PeriodToOpen)throws TestException,InterruptedException, TestException {
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
		InvoicesPage objInvoices=objHome.clickInvoices();
		
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		sAssert.assertTrue(objInvoices.isTasksBtnDisplayed());
		objInvoices.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Manage Accounting Periods link");
		objInvoices.isManageAccountingPeriodsLinkDisplayed();
		ManageAccountingPeriodsPage objMgmntPeriod=objInvoices.clickManageAccountingPeriodsLink();
		
		report.log(LogStatus.INFO, "Step 7. Select ledger to perform the closing period task");
		objMgmntPeriod.selectTableLadger(Ladger);
		
		EditAccountingPeriodStatusesPage objEditAccount =new EditAccountingPeriodStatusesPage(driver, report);
		report.log(LogStatus.INFO, "Step 8. Select period to close");
		objEditAccount.selectEditAccountingPeriodStatuses(PeriodToOpen);
		
		report.log(LogStatus.INFO, "Step 9. Click on Open Period button");
		objEditAccount.isOpenPeriodButtonDisplayed();
		objEditAccount.clickOpenPeriodButton();
		
		report.log(LogStatus.INFO, "Step 10. Click on Confirmation Ok button");
		objEditAccount.isConfOkButtonDisplayed();
		objEditAccount.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 11. Click on Done button");
		objEditAccount.isDoneButtonDisplayed();
		objEditAccount.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 12. Click on Done button");
		objMgmntPeriod.isDoneButtonDisplayed();
		objMgmntPeriod.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 13. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 14. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
	}

}
