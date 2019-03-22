/**
Test Name: TC_ProcessPayablesToLedgerReconciliation
 Created By: Ciber
 Creation Date:May 22,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Process Payables To Ledger Reconciliation
 Prerequisite: Test data should be proper before running this script
 */
package com.cloud.test.Finance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.PayablesToLedgerReconciliationReportPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TC_ProcessPayablesToLedgerReconciliation extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Process Payables To Ledger Reconciliation")
	public void Cloud_Proc_P_Led_Reconciliation(String UserName,String Password,String Ladger,String RequestName)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
	
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");

		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 4. Click on Invoices link");
		InvoicesPage objInvoices=objHome.clickInvoices();
		
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		sAssert.assertTrue(objInvoices.isTasksBtnDisplayed());
		objInvoices.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Payables to Ledger Reconciliation link");
		objInvoices.isPayablesLedgerReconciliationLinkDisplayed();
		PayablesToLedgerReconciliationReportPage objPLRecReport=objInvoices.clickPayablesLedgerReconciliationLink();
		
		/*WebElement frame= driver.findElement(By.xpath("//*[contains(@id,'_biExecBinding1_iframe')]"));
    	driver.switchTo().frame(frame);
    	*/
		report.log(LogStatus.INFO, "Step 7. Select Ladger");
		//objPLRecReport.isLadgerDisplayed();
		objPLRecReport.clickLadgerButton();
		
		objPLRecReport.SelectLadger(Ladger);
		
		report.log(LogStatus.INFO, "Step 8. Select Request Name");
		objPLRecReport.SelectRequestName(RequestName);
		
		report.log(LogStatus.INFO, "Step 9. Click on Apply Button");
		objPLRecReport.isApplyBtnDisplayed();
		objPLRecReport.clickApplyButton();
		
		driver.switchTo().parentFrame();
		
		report.log(LogStatus.INFO, "Step 10. Click on Done Button");
		objPLRecReport.isDoneBtnDisplayed();
		objPLRecReport.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 11. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 12. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
		
	}

}
