package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.AccountsReceivablePage;
import com.cloud.pageobjects.Finance.CreateReceiptPage;
import com.cloud.pageobjects.Finance.EditAccountingPeriodStatusesPage;
import com.cloud.pageobjects.Finance.EditReceiptPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TC_StandardReceipt extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Standard Receipt")
	public void Cloud_Standard_Receipt(String UserName,String Password,String BusinessUnit,String ReceiptMethod,String ReceiptNumber,String EnteredAmount,String AccountNumber,String Site,String CustomerName,String CustomerCell,String ReceivablesCell,String BankName,String BranchName,String BankAccount)throws TestException,InterruptedException, TestException {
		
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
	
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");

		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 4. Click on Accounts Receivable link");
		AccountsReceivablePage objAcReceivable=objHome.clickAccountsReceivable();
		
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		sAssert.assertTrue(objAcReceivable.isTasksBtnDisplayed());
		objAcReceivable.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Create Receipt link");
		objAcReceivable.isCreateReceiptLinkDisplayed();
		CreateReceiptPage objCrtReceipt=objAcReceivable.clickCreateReceiptLink();
		
		report.log(LogStatus.INFO, "Step 7. Select Bussiness Unit");
		objCrtReceipt.isSelectBusinessUnitDisplayed();
		objCrtReceipt.SelectBusinessUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 8. Receipt Method Unit");
		objCrtReceipt.isReceiptMethodDisplayed();
		objCrtReceipt.SelectReceiptMethod(ReceiptMethod);
		objCrtReceipt.SelectBankName(BankName);
		objCrtReceipt.SelectBankBranch(BranchName);
		objCrtReceipt.SelectBankAccount(BankAccount);
		
		report.log(LogStatus.INFO, "Step 9. Enter Receipt Number in field");
		objCrtReceipt.isReceiptNumberDisplayed();
		objCrtReceipt.enterReceiptNumber(ReceiptNumber);
		
		report.log(LogStatus.INFO, "Step 10. Enter Entered Amount in field");
		objCrtReceipt.isEnteredAmountDisplayed();
		objCrtReceipt.enterEnteredAmount(EnteredAmount);
		
		report.log(LogStatus.INFO, "Step 11. Click on Account Number Search Icon");
		objCrtReceipt.isSearchAccountNumberIconDisplayed();
		objCrtReceipt.clickSearchAccountNumberIcon();
		
		report.log(LogStatus.INFO, "Step 12. Enter Account Number in field");
		objCrtReceipt.isAccountNumberDisplayed();
		objCrtReceipt.enterAccountNumber(AccountNumber);
		objCrtReceipt.clickName();
	
		report.log(LogStatus.INFO, "Step 13. Click on Account Number Search Button");
		objCrtReceipt.isAccountNumberSearchBtnDisplayed();
		objCrtReceipt.clickAccountNumberSearchButton(AccountNumber);
		
		report.log(LogStatus.INFO, "Step 14. Select Account Number Cell");
		objCrtReceipt.selectEvent(AccountNumber);
		
		report.log(LogStatus.INFO, "Step 15. Click on Account Number Ok Button");
		objCrtReceipt.isAccountNumberOkBtnDisplayed();
		objCrtReceipt.clickAccountNumberOkButton();
		
		report.log(LogStatus.INFO, "Step 16. Select Site list");
		objCrtReceipt.isSelectSiteDisplayed();
		objCrtReceipt.SelectSite(Site);
		
		report.log(LogStatus.INFO, "Step 17. Click on Submit and Create Another menu");
		objCrtReceipt.isSubmitAndCreateAnotherMenuDisplayed();
		objCrtReceipt.clickSubmitAndCreateAnotherMenu();
		
		report.log(LogStatus.INFO, "Step 18. Select  Submit and Apply Manually list from Submit and Create Another menu");
		objCrtReceipt.isSubmitAndApplyManuallyListDisplayed();
		EditReceiptPage objEditRcpt=objCrtReceipt.selectSubmitAndApplyManuallyList();
		
		report.log(LogStatus.INFO, "Step 19. Click on Actions menu");
		objEditRcpt.isReceiptDetailsActionMenuDisplayed();
		objEditRcpt.clickReceiptDetailsActionsMenu();
		
		report.log(LogStatus.INFO, "Step 20. Select Add Open Receivables list from Actions menu");
		objEditRcpt.isAddOpenReceivablesListDisplayed();
		objEditRcpt.selectAddOpenReceivablesList();
		
		report.log(LogStatus.INFO, "Step 21. Click on Transaction Customer Name Search Icon");
		objEditRcpt.isSearchTransactionCustomerNameIconDisplayed();
		objEditRcpt.clickSrchTransactionCustomerNameIcon();
		
		report.log(LogStatus.INFO, "Step 22. Enter Customer Name in field");
		objEditRcpt.isCustomerNameDisplayed();
		objEditRcpt.enterTransactionCustomerName(CustomerName);
		objEditRcpt.clickAccountNumber();
	
		report.log(LogStatus.INFO, "Step 23. Click on Customer Name Search Button");
		objEditRcpt.isCustomerNameSearchBtnDisplayed();
		objEditRcpt.clickCustomerNameSearchButton(CustomerCell);
		
		report.log(LogStatus.INFO, "Step 24. Select Customer Name Cell");
		objEditRcpt.selectEvent(CustomerCell);
		
		report.log(LogStatus.INFO, "Step 25. Click on Customer Name Ok Button");
		objEditRcpt.isCustomerNameOkBtnDisplayed();
		objEditRcpt.clickCustomerNameOkButton();
		
		report.log(LogStatus.INFO, "Step 26. Click on Search Button");
		objEditRcpt.clickAmountField();
		objEditRcpt.isReceivableSearchBtnDisplayed();
		objEditRcpt.clickReceivableSearchButton();
		
		report.log(LogStatus.INFO, "Step 27. click on Receivables Cell");
		objEditRcpt.selectReceivablesCell(ReceivablesCell);
		
		report.log(LogStatus.INFO, "Step 28. Click on Add Button");
		objEditRcpt.isReceivableAddBtnDisplayed();
		objEditRcpt.clickReceivableAddButton();
		
		report.log(LogStatus.INFO, "Step 29. Click on Done Button");
		objEditRcpt.isReceivableDoneBtnDisplayed();
		objEditRcpt.clickReceivableDoneButton();
		
		report.log(LogStatus.INFO, "Step 30. Click on Actions menu");
		objEditRcpt.isActionsMenuDisplayed();
		objEditRcpt.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 31. Select Post to Ledger from Actions menu");
		objEditRcpt.isPostLedgerMenuDisplayed();
		objEditRcpt.selectPostLedgerMenu();
		
		report.log(LogStatus.INFO, "Step 32. Click on Confirmation Ok button");
		objEditRcpt.isConfOkButtonDisplayed();
		objEditRcpt.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 33. Click on Save and Close button");
		objEditRcpt.isSaveAndCloseButtonDisplayed();
		objEditRcpt.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 34. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 35. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
			
		
	}

}
