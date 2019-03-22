package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.BillingPage;
import com.cloud.pageobjects.Finance.CreateTransactionPage;
import com.cloud.pageobjects.Finance.EditTransactionPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class TC_CreateRegularTransaction extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Standard Invoice with Attachment")
	public void Cloud_CreateRegular_Transaction(String UserName,String Password,String BusinessUnit,String TransactionSource,String BilltoName,String CustomerCell,String Description,String Quantity,String UnitPrice)throws TestException,InterruptedException, TestException {
		
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
	
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");

		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 4. Click on Billing link");
		BillingPage objBilling=objHome.clickBilling();
				
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		sAssert.assertTrue(objBilling.isTasksBtnDisplayed());
		objBilling.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Create Transaction link");
		objBilling.isCreateTransactionLinkDisplayed();
		CreateTransactionPage objCrtTransaction=objBilling.clickCreateTransactionLink();
		
		
		report.log(LogStatus.INFO, "Step 7. Select Bussiness Unit");
		objCrtTransaction.isSelectBusinessUnitDisplayed();
		objCrtTransaction.SelectBusinessUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 8. Select Transaction Source");
		objCrtTransaction.isSelectTransactionSourceDisplayed();
		objCrtTransaction.SelectTransactionSource(TransactionSource);
		
		report.log(LogStatus.INFO, "Step 9. Click on Search: Bill-to Name Icon");
		objCrtTransaction.isSearchSupplierIconDisplayed();
		objCrtTransaction.clickSearchSupplierIcon();
		
		report.log(LogStatus.INFO, "Step 10. Enter Bill-to Name");
		objCrtTransaction.isSupplierDisplayed();
		objCrtTransaction.enterSupplier(BilltoName);
		objCrtTransaction.clickSupplierNumber();
		
		report.log(LogStatus.INFO, "Step 11. Click on Bill-to Name Search Button");
		objCrtTransaction.isSupplierSearchBtnDisplayed();
		objCrtTransaction.clickSupplierSearchButton();
		
		report.log(LogStatus.INFO, "Step 12. Select Supplier Cell");
		objCrtTransaction.selectEvent(CustomerCell);
		
		report.log(LogStatus.INFO, "Step 13. Click on Bill-to Name Ok Button");
		objCrtTransaction.isSupplierOkBtnDisplayed();
		objCrtTransaction.clickSupplierOkButton();
		
		report.log(LogStatus.INFO, "Step 14. Enter value in Description field");
		objCrtTransaction.isDescriptionDisplayed();
		objCrtTransaction.enterDescription(Description);
		
		report.log(LogStatus.INFO, "Step 15. Enter value in Quantity field");
		objCrtTransaction.isQuantityDisplayed();
		objCrtTransaction.enterQuantity(Quantity);
		
		report.log(LogStatus.INFO, "Step 16. Enter value in Unit Price field");
		objCrtTransaction.isUnitPriceDisplayed();
		objCrtTransaction.enterUnitPrice(UnitPrice);
		objCrtTransaction.clickTransectionNumber();
		
		report.log(LogStatus.INFO, "Step 17. Click on Save button");
		objCrtTransaction.isSaveBtnDisplayed();
		objCrtTransaction.clickSaveMenuButton();
		
		EditTransactionPage  objEdtTransaction= objCrtTransaction.clickSaveButton();

		report.log(LogStatus.INFO, "Step 18. Click on Complete and Create Another Menu");
		objEdtTransaction.isCompleteAndCreateAnotherMenuDisplayed();
		objEdtTransaction.clickCompleteAndCreateAnotherMenu();
		
		report.log(LogStatus.INFO, "Step 19. Select on Complete and Review from Complete and Create Another menu");
		objEdtTransaction.isCompleteAndReviewLstDisplayed();
		objEdtTransaction.clickCompleteAndReviewList();
		
		report.log(LogStatus.INFO, "Step 20. Click on Action Menu");
		objEdtTransaction.isActionsMenuDisplayed();
		objEdtTransaction.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 21. Click on Post to Ladger in Action Menu");
		objEdtTransaction.isPostLedgerMenuDisplayed();
		objEdtTransaction.selectPostLedgerMenu();
		
		report.log(LogStatus.INFO, "Step 22. Click on Ok Button in Confirmation Pop-up");
		objEdtTransaction.isConfOkButtonDisplayed();
		objEdtTransaction.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 23. Click on Save Menu");
		objEdtTransaction.isSaveMenuDisplayed();
		objEdtTransaction.clickSaveMenu();
		
		report.log(LogStatus.INFO, "Step 24. Click on Save and Close in Save Menu");
		objEdtTransaction.isSaveAndCloseDisplayed();
		objEdtTransaction.clickSaveAndCloseList();
		
		report.log(LogStatus.INFO, "Step 25. Click on Ok Button in Information Pop-up");
		objEdtTransaction.isInfoOkButtonDisplayed();
		objEdtTransaction.clickInfoOkButton();
		
		report.log(LogStatus.INFO, "Step 26. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		objHome.clickUserIcon();
		objHome.clickSignOut();

		report.log(LogStatus.INFO, "Step 27. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();

		
	}
}
