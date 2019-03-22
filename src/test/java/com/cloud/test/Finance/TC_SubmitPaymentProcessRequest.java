/**
Test Name: TC_SubmitPaymentProcessRequest
 Created By: Ciber
 Creation Date:May 18,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Submit Payment Process Request
 Prerequisite: Test data should be proper before running this script(Name should be Unique)
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
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.SubmitPaymentProcessRequestPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TC_SubmitPaymentProcessRequest extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Submit Payment Process Request")
	public void Cloud_Submit_Pmnt_Prcs_Request(String UserName,String Password,String Name,String PayThroughDate,String BusinessUnit,String PartyName,String DisbursementBankAccount,String PaymentDocument,String PaymentProcessProfile)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);

		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");

		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 5. Click on Payments link");
		OverviewPage objOverview=objHome.clickPayments();
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Submit Payment Process Request link");
		objOverview.isSubmitPaymentProcessRequestLinkDisplayed(); 
		SubmitPaymentProcessRequestPage objSubPmntRequest=objOverview.clickSubmitPaymentProcessRequestLink();
		
		report.log(LogStatus.INFO, "Step 8. Enter Name in Name field");
		objSubPmntRequest.isNameDisplayed();
		objSubPmntRequest.enterName(Name);
		
		report.log(LogStatus.INFO, "Step 9. Click on Pay Through Date button");
		objSubPmntRequest.isPayThroughDateBtnDisplayed();
		objSubPmntRequest.clickPayThroughDateButton();
		
		String PayDateParts[] = PayThroughDate.split("-");
		String payMonth  = PayDateParts[0];
		String payDay  = PayDateParts[1];
		String payYear = PayDateParts[2];
		report.log(LogStatus.INFO, "Step 10. Select Month and Pay Through Date from Calendar");
		objSubPmntRequest.isPayThroughDateMonthDisplayed();
		objSubPmntRequest.selectPayThroughDateMonth(payMonth);
		objSubPmntRequest.selectPayThroughDate(payDay);
		
		report.log(LogStatus.INFO, "Step 11. Select Business Unit invoice Radio button for the payment process request ");
		objSubPmntRequest.isBusinessUnitinvoiceRadioBtnDisplayed();
		objSubPmntRequest.clickBusinessUnitinvoiceRadioButton();
		
		report.log(LogStatus.INFO, "Step 12. Click the Add Row Button");
		objSubPmntRequest.isAddRowBtnDisplayed();
		objSubPmntRequest.clickAddRowButton();
		
		report.log(LogStatus.INFO, "Step 13. Select Business Unit");
		objSubPmntRequest.isSelectBusinessUnitDisplayed();
		objSubPmntRequest.SelectBusinessUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 14. Click on Party Search Icon");
		objSubPmntRequest.isPartySearchIconDisplayed();
		objSubPmntRequest.clickPartySearchIcon();
		report.log(LogStatus.INFO, "Step 15. Click on Party Search link");
		objSubPmntRequest.isPartySearchLinkDisplayed();
		objSubPmntRequest.clickPartySearchLink();	
		report.log(LogStatus.INFO, "Step 16. Enter the Party Value in Suplier Or Party text field");
		objSubPmntRequest.isPartyValueDisplayed();
		objSubPmntRequest.enterPartyValue(PartyName);
		objSubPmntRequest.clickSupplierNumber();
		report.log(LogStatus.INFO, "Step 17. Click on Party Search button");
		objSubPmntRequest.isPartySearchButtonDisplayed();
		objSubPmntRequest.clickPartySearchButton();
		report.log(LogStatus.INFO, "Step 18. Select Party from dropdown");
		objSubPmntRequest.selectEvent(PartyName);
		report.log(LogStatus.INFO, "Step 19. Click on Party Ok button");
		objSubPmntRequest.isPartyOkButtonDisplayed();
		objSubPmntRequest.clickPartyOkButton();
		
		report.log(LogStatus.INFO, "Step 20. Click on Payment and Processing Options tab");
		objSubPmntRequest.isPaymentAndProcessingOptionsTabDisplayed();
		objSubPmntRequest.clickPaymentAndProcessingOptionsTab();
		
		report.log(LogStatus.INFO, "Step 21. Select Disbursement Bank Account");
		objSubPmntRequest.isDisbursementBankAccountDisplayed();
		objSubPmntRequest.SelectDisbursementBankAccount(DisbursementBankAccount);
		
		report.log(LogStatus.INFO, "Step 22. Select Payment Document");
		objSubPmntRequest.isPaymentDocumentDisplayed();
		objSubPmntRequest.selectPaymentDocument(PaymentDocument);
		
		report.log(LogStatus.INFO, "Step 23. Select Payment Process Profile");
		objSubPmntRequest.isPaymentProcessProfileDisplayed();
		objSubPmntRequest.SelectPaymentProcessProfile(PaymentProcessProfile);
		
		report.log(LogStatus.INFO, "Step 24. Click on Submit button");
		objSubPmntRequest.isSubmitButtonDisplayed();
		objSubPmntRequest.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 25. Click on confirmation Ok button");
		objSubPmntRequest.isConfOkButtonDisplayed();
		objSubPmntRequest.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 26. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 27. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
		
		
		
	}

}
