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
import com.cloud.pageobjects.Finance.CreatePaymentPage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class TC_CreditMemoInvoice  extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Credit Memo Invoice")
	public void Cloud_Credit_Memo_Invoice(String UserName,String Password,String BusinessUnit,String Supplier,String Cr_Memo_Number,String Amount,String Type,String PaymentTerms,String Action,String Invoice_Number,String Amount_Cell,String BusinessUnit_Payment,String DisbursementBankAccount,String PaymentProcessProfile)throws TestException,InterruptedException, TestException {
		
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
		objCrtInvoice.enterNumber(Cr_Memo_Number);
		
		report.log(LogStatus.INFO, "Step 14. Enter the Amount in Amount text field");
		objCrtInvoice.isAmountDisplayed();
		objCrtInvoice.enterAmount(Amount);
		
		report.log(LogStatus.INFO, "Step 15. Select Type from dropdown");
		objCrtInvoice.isTypeDisplayed();
		objCrtInvoice.selectType(Type);
		
		report.log(LogStatus.INFO, "Step 17. Select Payment Terms from dropdown");
		objCrtInvoice.isPaymentTermsDisplayed();
		objCrtInvoice.SelectPaymentTerms(PaymentTerms);
		
		report.log(LogStatus.INFO, "Step 18. Select Action from dropdown");
		objCrtInvoice.isActionDisplayed();
		objCrtInvoice.selectAction(Action);
		objCrtInvoice.clickInvoiceGroup();
		
		report.log(LogStatus.INFO, "Step 19. Click on Go button");
		objCrtInvoice.isGoBtnDisplayed();
		objCrtInvoice.clickGoButton();
		
		report.log(LogStatus.INFO, "Step 20. Enter Invoice number");
		objCrtInvoice.isInvoiceDisplayed();
		objCrtInvoice.enterInvoice(Invoice_Number);
		
		report.log(LogStatus.INFO, "Step 21. Click on Search button");
		objCrtInvoice.isSearchBtnDisplayed();
		objCrtInvoice.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 22. Click on Correct Check-Box");
		objCrtInvoice.isCorrectChkBoxDisplayed();
		objCrtInvoice.clickCorrectChkBox();
		
		report.log(LogStatus.INFO, "Step 23. Enter Invoice Amount number");
		objCrtInvoice.isamountInInvoiceeDisplayed();
		objCrtInvoice.enterAmountInInvoice(Amount_Cell);
		
		report.log(LogStatus.INFO, "Step 24. Click on Apply button");
		objCrtInvoice.isAppyBtnDisplayed();
		objCrtInvoice.clickApplyButton();
		
		report.log(LogStatus.INFO, "Step 25. Click on Ok button");
		objCrtInvoice.isAccountOkButtonDisplayed();
		objCrtInvoice.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 26. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 27. Select on Validate Invoice Actions Menu");
		objCrtInvoice.isValidateMenuDisplayed();
		objCrtInvoice.selectValidateMenu();
		
		report.log(LogStatus.INFO, "Step 28. Click on Information Ok Button");
		objCrtInvoice.isInformationOkBtnDisplayed();
		objCrtInvoice.clickInformationOkButton();
		
		report.log(LogStatus.INFO, "Step 29. Click on Save And Close Button");
		objCrtInvoice.isSaveAndCloseBtnDisplayed();
		objCrtInvoice.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 28. Click on Information Ok Button");
		objCrtInvoice.isInformationOkBtnDisplayed();
		objCrtInvoice.clickInformationOkButton();
		
		
		report.log(LogStatus.INFO, "Step 30. Click on Home Image");
		objHome.clickImgHome();
		
		report.log(LogStatus.INFO, "Step 31. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 32. Click on Payments link");
		OverviewPage objOverview=objHome.clickPayments();

		report.log(LogStatus.INFO, "Step 33. Click on Taksks button ");
		sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 34. Click on Create Payment link");
		objInvoices.isCreateInvoiceLinkDisplayed(); 
		CreatePaymentPage objCrtPayment=objOverview.clickCreatePaymentLink();
		
		report.log(LogStatus.INFO, "Step 35. Select Bussines Unit");
		objCrtPayment.isSelectBusinessUnitDisplayed();
		objCrtPayment.SelectBusinessUnit(BusinessUnit_Payment);
		
		report.log(LogStatus.INFO, "Step 36. Click on Party Search Icon");
		objCrtPayment.isPartySearchIconDisplayed();
		objCrtPayment.clickPartySearchIcon();
		report.log(LogStatus.INFO, "Step 37. Click on Party Search link");
		objCrtPayment.isPartySearchLinkDisplayed();
		objCrtPayment.clickPartySearchLink();	
		report.log(LogStatus.INFO, "Step 38. Enter the Party Value in Suplier Or Party text field");
		objCrtPayment.isPartyValueDisplayed();
		objCrtPayment.enterPartyValue(Supplier);
		objCrtPayment.clickSupplierNumber();
		report.log(LogStatus.INFO, "Step 39. Click on Party Search button");
		objCrtPayment.isPartySearchButtonDisplayed();
		objCrtPayment.clickPartySearchButton();
		report.log(LogStatus.INFO, "Step 40. Select Party from dropdown");
		objCrtPayment.selectEvent(Supplier);
		report.log(LogStatus.INFO, "Step 41. Click on Party Ok button");
		objCrtPayment.isPartyOkButtonDisplayed();
		objCrtPayment.clickPartyOkButton();
		
		report.log(LogStatus.INFO, "Step 42. Select Disbursement Bank Account");
		objCrtPayment.isDisbursementBankAccountDisplayed();
		objCrtPayment.SelectDisbursementBankAccount(DisbursementBankAccount);
		
		report.log(LogStatus.INFO, "Step 43. Select Payment Process Profile Account");
		objCrtPayment.isPaymentProcessProfileDisplayed();
		objCrtPayment.SelectPaymentProcessProfile(PaymentProcessProfile);
		
		report.log(LogStatus.INFO, "Step 44. Click on Select and Add button");
		objCrtPayment.isSelectAndAddButtonDisplayed();
		objCrtPayment.clickSelectAndAddButton();
		
		report.log(LogStatus.INFO, "Step 45. Enter Invoice Number in Invoice Field");
		objCrtPayment.isInvoiceNumberDisplayed();
		objCrtPayment.enterInvoiceNumber(Invoice_Number);
		objCrtPayment.clickInvoiceAmount();
		
		report.log(LogStatus.INFO, "Step 46. click on Invoice number Search button");
		objCrtPayment.isInvoiceSearchButtonDisplayed();
		objCrtPayment.clickInvoiceSearchButton();
		
		report.log(LogStatus.INFO, "Step 47. Select Invoice number Cell");
		objCrtPayment.selectInvoice(Invoice_Number);
		
		report.log(LogStatus.INFO, "Step 48. click Apply Button");
		objCrtPayment.isInvoiceApplyButtonDisplayed();
		objCrtPayment.clickInvoiceApplyhButton();
		
		
		report.log(LogStatus.INFO, "Step 49. Clear Invoice Number field");
		objCrtPayment.isInvoiceNumberDisplayed();
		objCrtPayment.clearInvoiceNumber();
		
		
		report.log(LogStatus.INFO, "Step 50. Enter Credit Memo Number in Invoice Field");
		objCrtPayment.isInvoiceNumberDisplayed();
		objCrtPayment.enterInvoiceNumber(Cr_Memo_Number);
		objCrtPayment.clickInvoiceAmount();
		
		report.log(LogStatus.INFO, "Step 46. click on Invoice number Search button");
		objCrtPayment.isInvoiceSearchButtonDisplayed();
		objCrtPayment.clickInvoiceSearchButton();
		
		report.log(LogStatus.INFO, "Step 47. Select Invoice number Cell");
		objCrtPayment.selectInvoice(Cr_Memo_Number);
		
		report.log(LogStatus.INFO, "Step 48. click Apply Button");
		objCrtPayment.isInvoiceApplyButtonDisplayed();
		objCrtPayment.clickInvoiceApplyhButton();
		
		report.log(LogStatus.INFO, "Step 49. click Ok Button");
		objCrtPayment.isInvoiceOkButtonDisplayed();
		objCrtPayment.clickInvoiceOkButton();
		
		report.log(LogStatus.INFO, "Step 50. click Save and Close Button");
		objCrtPayment.isSaveAndCloseButtonDisplayed();
		objCrtPayment.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 50. click confirmation Ok Button");
		objCrtPayment.isConfOkButtonDisplayed();
		objCrtPayment.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 51. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		
		report.log(LogStatus.INFO, "Step 52. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
		
		
		
	}

}
