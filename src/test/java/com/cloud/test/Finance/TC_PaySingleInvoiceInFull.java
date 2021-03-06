
/**
Test Name: TC_PaySingleInvoiceInFull
Created By: Ciber
Creation Date:May 14,2018
Modified By:
Modified Date:
Test Description: This script is used for to Pay Single Invoice in Full
Prerequisite: Test data should be proper before running this script(Invoice number should be validated but not posted and not paid)
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
import com.cloud.pageobjects.Finance.EditInvoicePage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.ManageInvoicesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_PaySingleInvoiceInFull extends BaseWebTest  {
SoftAssert sAssert;
public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Pay Single Invoice in Full")

	public void Cloud_Pay_Single_Inv_Full(String UserName,String Password,String BusinessUnit,String InvoiceNumber,String PartyName,String PaymentProcessProfile)throws TestException,InterruptedException, TestException {
	
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
		
		report.log(LogStatus.INFO, "Step 6. Click on Manage Invoices link");
		objInvoices.isManageInvoiceLinkDisplayed(); 
		ManageInvoicesPage objMngInvoice=objInvoices.clickManageInvoiceLink();
		
		report.log(LogStatus.INFO, "Step 7. Select Bussiness Unit");
		objMngInvoice.isSelectBusinessUnitDisplayed();
		objMngInvoice.SelectBusinessUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 8. Enter Invoice Number");
		objMngInvoice.isInvoiceNumberDisplayed();
		objMngInvoice.enterInvoiceNumber(InvoiceNumber);
		
		report.log(LogStatus.INFO, "Step 9. Click on Supplier or Party Search Icon");
		objMngInvoice.isSearchSupplierOrPartyIconDisplayed();
		objMngInvoice.clickSearchSupplierOrPartyIcon();
		
		report.log(LogStatus.INFO, "Step 10. Enter Party Name");
		objMngInvoice.isPartyNameDisplayed();
		objMngInvoice.enterPartyName(PartyName);
		objMngInvoice.clickSupplierNumber();
		
		report.log(LogStatus.INFO, "Step 11. Click on Supplier Search Button");
		objMngInvoice.isSupplierSearchBtnDisplayed();
		objMngInvoice.clickSupplierSearchButton();
		
		
		report.log(LogStatus.INFO, "Step 12. Select Supplier Cell");
		objMngInvoice.selectEvent(PartyName);
		
		report.log(LogStatus.INFO, "Step 13. Click on Supplier Ok Button");
		objMngInvoice.isSupplierOkBtnDisplayed();
		objMngInvoice.clickSupplierOkButton();
		SeleniumUtils.delay(1000);
		objMngInvoice.clickInvoiceAmountField();
		
		report.log(LogStatus.INFO, "Step 14. Click on Invoice Search Button");
		objMngInvoice.isInvoiceSearchBtnDisplayed();
		objMngInvoice.clickInvoiceSearchButton(InvoiceNumber);
	
		report.log(LogStatus.INFO, "Step 15. Select Invoice link Cell");
		objMngInvoice.selectInvoiceEvent(InvoiceNumber);
		
		report.log(LogStatus.INFO, "Step 16. Click on Invoice Actions Menu");
		objMngInvoice.isActionsMenuDisplayed();
		objMngInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 17. Select Edit item from Actions Menu");
		objMngInvoice.isEditMenuDisplayed(); 
		EditInvoicePage objEditInvoice=objMngInvoice.selectEditMenu();
	
		report.log(LogStatus.INFO, "Step 18. Click on Invoice Actions Menu");
		objEditInvoice.isActionsMenuDisplayed();
		objEditInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 19. Select Pay In Full item from Actions Menu");
		objEditInvoice.isPayInFullActionsMenuDisplayed();
		objEditInvoice.selectPayInFullActionsMenu();
		
		report.log(LogStatus.INFO, "Step 20. Select Payment Process Profile");
		objEditInvoice.isSelectPaymentProcessProfileDisplayed();
		objEditInvoice.SelectPaymentProcessProfile(PaymentProcessProfile);
		objEditInvoice.clickPaymentNumber();
		
		report.log(LogStatus.INFO, "Step 21. Click on Submit button");
		objEditInvoice.isSubmitBtnDisplayed();
		objEditInvoice.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 22. Click on Confirmation Ok button");
		objEditInvoice.isConfOkBtnDisplayed();
		objEditInvoice.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 23. Click on Save And Close button");
		objEditInvoice.isSaveAndCloseButtonDisplayed();
		objEditInvoice.clickSaveAndCloseButton();
		SeleniumUtils.delay(2000);
		
		report.log(LogStatus.INFO, "Step 24. Click on Done button");
		objMngInvoice.isDoneButtonDisplayed();
		objMngInvoice.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 25. Click on Sign Out link to sign out from application");
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
