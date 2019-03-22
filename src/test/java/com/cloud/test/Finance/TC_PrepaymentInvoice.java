/**
 Test Name: TC_PrepaymentInvoice
 Created By: Ciber
 Creation Date:May 4,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Create Pre-payment Invoice
 Prerequisite: Test data should be proper before running this script(unique Invoice number)
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
import com.cloud.pageobjects.Finance.CreateInvoicePage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TC_PrepaymentInvoice extends BaseWebTest{

	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Create Pre-payment Invoice")
	public void Cloud_Prepayment_Invoice(String UserName,String Password,String BusinessUnit,String Supplier,String Number,String Amount,String Type,String Amount_Cell,String PaymentProcessProfile)throws TestException,InterruptedException, TestException {
	
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
		
		report.log(LogStatus.INFO, "Step 6. Click on Create Invoices link");
		objInvoices.isCreateInvoiceLinkDisplayed(); 
		CreateInvoicePage objCrtInvoice=objInvoices.clickCreateInvoiceLink();
		
		report.log(LogStatus.INFO, "Step 7. Select Bussiness Unit");
		objCrtInvoice.isSelectBusinessUnitDisplayed();
		objCrtInvoice.SelectBusinessUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 8. Click on Supplier Search Icon");
		objCrtInvoice.isSearchSupplierIconDisplayed();
		objCrtInvoice.clickSearchSupplierIcon();
		
		report.log(LogStatus.INFO, "Step 9. Enter Supplier Name");
		objCrtInvoice.isSupplierDisplayed();
		objCrtInvoice.enterSupplier(Supplier);
		objCrtInvoice.clickSupplierNumber();
		
		report.log(LogStatus.INFO, "Step 10. Click on Supplier Search Button");
		objCrtInvoice.isSupplierSearchBtnDisplayed();
		objCrtInvoice.clickSupplierSearchButton(Supplier);
		
		report.log(LogStatus.INFO, "Step 11. Select Supplier Cell");
		objCrtInvoice.selectEvent(Supplier);
		
		report.log(LogStatus.INFO, "Step 12. Click on Supplier Ok Button");
		objCrtInvoice.isSupplierOkBtnDisplayed();
		objCrtInvoice.clickSupplierOkButton();
		
		report.log(LogStatus.INFO, "Step 13. Enter the Number in Number text field");
		objCrtInvoice.isNumberDisplayed();
		objCrtInvoice.enterNumber(Number);
		
		report.log(LogStatus.INFO, "Step 14. Enter the Amount in Amount text field");
		objCrtInvoice.isAmountDisplayed();
		objCrtInvoice.enterAmount(Amount);
		
		report.log(LogStatus.INFO, "Step 15. Select Type from dropdown");
		objCrtInvoice.isTypeDisplayed();
		objCrtInvoice.selectType(Type);
		
		report.log(LogStatus.INFO, "Step 16. Enter Amount in Amount Cell");
		objCrtInvoice.isAmountCellDisplayed();
		objCrtInvoice.enterAmountCell(Amount_Cell);
		
		report.log(LogStatus.INFO, "Step 17. Click on Distribution Combination field");
		objCrtInvoice.isDistributionCombFieldDisplayed();
		objCrtInvoice.clickDistributionCombField();
				
		report.log(LogStatus.INFO, "Step 18. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 19. Select on Validate item from Invoice Actions Menu");
		objCrtInvoice.isValidateMenuDisplayed();
		objCrtInvoice.selectValidateMenu();
		
		report.log(LogStatus.INFO, "Step 20. Click on Ok button in Information Pop-up");
		objCrtInvoice.isInformationOkBtnDisplayed();
		objCrtInvoice.clickInformationOkButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 22. Select on Post to Ledger item from Invoice Actions Menu");
		objCrtInvoice.isPostLedgerMenuDisplayed();
		objCrtInvoice.selectPostLedgerMenu();
		
		report.log(LogStatus.INFO, "Step 23. Click on Confirmation Ok button");
		objCrtInvoice.isConfOkButtonDisplayed();
		String message="You have successfully created standard invoice with attachment.";
		objCrtInvoice.clickConfOkButton(message);
		
		report.log(LogStatus.INFO, "Step 24. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 25. Select Pay In Full item from Actions Menu");
		objCrtInvoice.isPayInFullActionsMenuDisplayed();
		objCrtInvoice.selectPayInFullActionsMenu();
		
		report.log(LogStatus.INFO, "Step 26. Select Payment Process Profile");
		objCrtInvoice.isSelectPaymentProcessProfileDisplayed();
		objCrtInvoice.SelectPaymentProcessProfile(PaymentProcessProfile);
		objCrtInvoice.clickPaymentNumber();
		
		report.log(LogStatus.INFO, "Step 27. Click on Submit button");
		objCrtInvoice.isSubmitBtnDisplayed();
		objCrtInvoice.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 28. Click on Confirmation Ok button");
		objCrtInvoice.isPayinFullConfOkButtonDisplayed();
		objCrtInvoice.clickPayinFullConfOkButton();
		
		report.log(LogStatus.INFO, "Step 29. Click on Save And Close button");
		objCrtInvoice.isSaveAndCloseBtnDisplayed();
		objCrtInvoice.clickSaveAndCloseButton();
		SeleniumUtils.delay(2000);
		
		report.log(LogStatus.INFO, "Step 30. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(2000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
				
		report.log(LogStatus.INFO, "Step 26. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
		
	}
}
