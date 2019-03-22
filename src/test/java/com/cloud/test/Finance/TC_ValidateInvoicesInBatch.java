/**
Test Name: TC_ValidateInvoicesInBatch
 Created By: Ciber
 Creation Date:May 18,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Validate Invoices In Batch
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
import com.cloud.pageobjects.Finance.Validate_SubmitRequestPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_ValidateInvoicesInBatch extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Validate Invoices in Batch")
	public void Cloud_Validate_Invoices_InBatch(String UserName,String Password,String BusinessUnit,String FromInvoiceDate,String ToInvoiceDate,String PartyName)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 6. Click on Validate Invoices link");
		objInvoices.isValidateInvoiceLinkDisplayed(); 
		Validate_SubmitRequestPage objValdRequest=objInvoices.clickValidateInvoiceLink();
		
		report.log(LogStatus.INFO, "Step 7. Select Business Unit");
		objValdRequest.isSelectBusinessUnitDisplayed();
		objValdRequest.SelectBusinessUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 8. Click on From Invoice Date button");
		objValdRequest.isFromInvoiceDtBtnDisplayed();
		objValdRequest.clickFromInvoiceDtButton();
		
		String fromDateParts[] = FromInvoiceDate.split("-");
		String fromMonth  = fromDateParts[0];
		String fromDay  = fromDateParts[1];
		String fromYear = fromDateParts[2];
		report.log(LogStatus.INFO, "Step 9. Select Month and From Invoice Date from Calendar");
		objValdRequest.isFromInvoiceMonthDisplayed();
		objValdRequest.selectFromInvoiceMonth(fromMonth);
		objValdRequest.selectFromInvoiceDate(fromDay);
		
		report.log(LogStatus.INFO, "Step 10. Click on To Invoice Date button");
		objValdRequest.isToInvoiceDtBtnDisplayed();
		objValdRequest.clickToInvoiceDtButton();
		
		String toDateParts[] = ToInvoiceDate.split("-");
		String toMonth  = toDateParts[0];
		String toDay  = toDateParts[1];
		String toYear = toDateParts[2];
		report.log(LogStatus.INFO, "Step 11. Select Month and To Invoice Date from Calendar");
		objValdRequest.isToInvoiceMonthDisplayed();
		objValdRequest.selectToInvoiceMonth(toMonth);
		objValdRequest.selectToInvoiceDate(toDay);
		
		report.log(LogStatus.INFO, "Step 12. Click on Party Search Icon");
		objValdRequest.isPartySearchIconDisplayed();
		objValdRequest.clickPartySearchIcon();
		report.log(LogStatus.INFO, "Step 13. Click on Party Search link");
		objValdRequest.isPartySearchLinkDisplayed();
		objValdRequest.clickPartySearchLink();	
		report.log(LogStatus.INFO, "Step 14. Enter the Party Value in Suplier Or Party text field");
		objValdRequest.isPartyValueDisplayed();
		objValdRequest.enterPartyValue(PartyName);
		objValdRequest.clickExpandPartySearchButton();
		report.log(LogStatus.INFO, "Step 15. Click on Party Search button");
		objValdRequest.isPartySearchButtonDisplayed();
		objValdRequest.clickPartySearchButton();
		report.log(LogStatus.INFO, "Step 16. Select Party from dropdown");
		objValdRequest.selectEvent(PartyName);
		report.log(LogStatus.INFO, "Step 17. Click on Party Ok button");
		objValdRequest.isPartyOkButtonDisplayed();
		objValdRequest.clickPartyOkButton();
		
		report.log(LogStatus.INFO, "Step 18. Click on Submit button");
		objValdRequest.isSubmitButtonDisplayed();
		objValdRequest.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 19. Click on confirmation Ok button");
		objValdRequest.isConfOkButtonDisplayed();
		objValdRequest.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 20. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 21. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
			
		
	}

}
