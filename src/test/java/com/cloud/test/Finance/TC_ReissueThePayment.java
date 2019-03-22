package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.ManagePaymentsPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.PaymentPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TC_ReissueThePayment extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to ReIssue the Payment")
	public void Cloud_Reissue_The_Payment(String UserName,String Password,String PartyName,String PaymentNumber)throws TestException,InterruptedException, TestException {
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
		OverviewPage objOverview=objHome.clickPayments();
		
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Manage Payments link");
		objOverview.isManagePaymentProcessRequestsLinkDisplayed(); 
		ManagePaymentsPage objMngPayment=objOverview.clickManagePaymentsLink();
		
		report.log(LogStatus.INFO, "Step 7. Click on Party Search Icon");
		objMngPayment.isPartySearchIconDisplayed();
		objMngPayment.clickPartySearchIcon();
		report.log(LogStatus.INFO, "Step 8. Click on Party Search link");
		objMngPayment.isPartySearchLinkDisplayed();
		objMngPayment.clickPartySearchLink();	
		report.log(LogStatus.INFO, "Step 9. Enter the Party Value in Suplier Or Party text field");
		objMngPayment.isPartyValueDisplayed();
		objMngPayment.enterPartyValue(PartyName);
		objMngPayment.clickSupplierNumber();
		report.log(LogStatus.INFO, "Step 10. Click on Party Search button");
		objMngPayment.isPartySearchButtonDisplayed();
		objMngPayment.clickPartySearchButton();
		report.log(LogStatus.INFO, "Step 11. Select Party from dropdown");
		objMngPayment.selectPartyName(PartyName);
		report.log(LogStatus.INFO, "Step 12. Click on Party Ok button");
		objMngPayment.isPartyOkButtonDisplayed();
		objMngPayment.clickPartyOkButton();
		
		report.log(LogStatus.INFO, "Step 13. Enter the Payment Number in Payment Number text field");
		objMngPayment.isPaymentNumberDisplayed();
		objMngPayment.enterPaymentNumber(PaymentNumber);
		
		report.log(LogStatus.INFO, "Step 14. Click on Search button");
		objMngPayment.isSearchBtnDisplayed();
		objMngPayment.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 15. Select Payment Number link");
		objMngPayment.selectPaymentNumber(PaymentNumber);
		
		PaymentPage objPayment = new PaymentPage(driver, report);
		objPayment.iskActionsMenuDisplayed();
		report.log(LogStatus.INFO, "Step 16. Click on Actions Manu");
		objPayment.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 17. Select Reissue list from Actions Manu");
		objPayment.isReissueListDisplayed();
		objPayment.selectReissueList();
		
		report.log(LogStatus.INFO, "Step 18. Click on Submit button");
		objPayment.isReissueSubmitBtnDisplayed();
		objPayment.clickReissueSubmitButton();
		
		report.log(LogStatus.INFO, "Step 19. Click on Conformation Ok button");
		objPayment.isConfOkButtonDisplayed();
		objPayment.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 20. Click on Done button");
		objPayment.isDoneBtnDisplayed();
		objPayment.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on Done button");
		objMngPayment.isDoneBtnDisplayed();
		objMngPayment.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 22. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 23. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
		
	}
}
