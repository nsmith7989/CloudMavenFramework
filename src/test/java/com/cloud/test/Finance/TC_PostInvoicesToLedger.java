/**
 Test Name: TC_PostInvoicesToLedger
 Created By: Ciber
 Creation Date:May 11,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Post Invoices to Ledger
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.Finance;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.SubmitRequestPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_PostInvoicesToLedger extends BaseWebTest  {
SoftAssert sAssert;
public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Post Invoices to Ledger")	
public void Cloud_Post_Invoices_To_Ledger(String UserName,String Password,String SubledgerApplication,String Ledger,String ProcessCategory) throws TestException,InterruptedException, TestException{
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
	
	report.log(LogStatus.INFO, "Step 5. Click on Invoices link");
	InvoicesPage objInvoices=objHome.clickInvoices();
	
	report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
	sAssert.assertTrue(objInvoices.isTasksBtnDisplayed());
	objInvoices.clickTasksButton();
	
	report.log(LogStatus.INFO, "Step 7. Click on Create Accounting link");
	objInvoices.isCreateAccountingLinkDisplayed(); 
	SubmitRequestPage objSubRequest=objInvoices.clickCreateAccountingLink();
	
	report.log(LogStatus.INFO, "Step 8. Select Subledger Application");
	objSubRequest.isSubledgerApplicationDisplayed();
	objSubRequest.selectSubledgerApplication(SubledgerApplication);
	
	report.log(LogStatus.INFO, "Step 9. Select Ladger");
	//objSubRequest.isSubledgerApplicationDisplayed();
	objSubRequest.isSelectLedgerDisplayed();
	objSubRequest.SelectLedger(Ledger);
	//objSubRequest.enterLedger(Ledger);
	objSubRequest.clickJournalBatch();
	
	report.log(LogStatus.INFO, "Step 10. Select Process Category");
	objSubRequest.isProcessCategoryDisplayed();
	objSubRequest.selectProcessCategory(ProcessCategory);
	
	report.log(LogStatus.INFO, "Step 11. Click on Submit button");
	objSubRequest.isSubmitButtonDisplayed();
	objSubRequest.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 12. Click on Confirmation Ok button");
	objSubRequest.isConfOkButtonDisplayed();
	objSubRequest.clickConfOkButton();
		
	report.log(LogStatus.INFO, "Step 13. Click on Sign Out link to sign out from application");
	objHome.clickImgHome();
	objHome.clickUserIcon();
	objHome.clickSignOut();
		
	report.log(LogStatus.INFO, "Step 14. Click on Confirm button to sign out from application");
	SignOffPage objSignOff = new SignOffPage(driver,report);
	objSignOff.clickConfirm();
	
	sAssert.assertAll();
	
}

}
