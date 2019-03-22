package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.CreateBankStatementPage;
import com.cloud.pageobjects.Finance.Overview_BankStatementPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class TC_CreateBankStatement extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is to Apply Missing Conversion Rates")
	public void Cloud_Create_Bank_Statement(String UserName,String Password,String BankAccount,String PeriodStartDate,String PeriodEndDate,String StatementID,String OpeningAmount,String ClosingAmount,String BookingDate,String TransactionCode,String FlowIndicator,String Amount)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
		
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		if(objLogin.isUserNameDisplayed())
		{
			report.log(LogStatus.PASS, "Step 1.1.Cloud application is launched successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 1.1.Launching of Cloud application is  failed");
		}
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
		HomePage objHome=objLogin.loginToCloudApplication(UserName,Password);
		
		report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		if(objHome.isHomeImageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 3.1.Navigation to Home Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 3.1.Navigation to Home Page is failed");	
		}
			
		report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 5. Click on Bank Statements and Reconciliation link and verify its navigated to Overview Page or not");
		Overview_BankStatementPage objOverview =objHome.clickBankStatementsReconciliation();
		if(objOverview.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Overview Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Overview Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button");
		sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Bank Statement Link and verify its navigated to Create Bank Statement screen or not");
		//objAssets.isAddAssetLinkDisplayed();
		CreateBankStatementPage objCrtBankSt=objOverview.clickCreateBankStatementLink();
		
		if(objCrtBankSt.isSelectBankAccountDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Bank Statement screen  is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Bank Statement screen  is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Bank Account from list");
		if(BankAccount != "")
		{
			objCrtBankSt.SelectBankAccount(BankAccount);
			report.log(LogStatus.PASS, "Step 8.1.Selected Bank Account from the list is "+BankAccount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Bank Account from the list is not selected");
		}
		
		
		String startDateParts[] = PeriodStartDate.split("-");
		String startMonth  = startDateParts[0];
		String startDay  = startDateParts[1];
		String startYear = startDateParts[2];
		report.log(LogStatus.INFO, "Step 9. Click the Period Start Date button");
		objCrtBankSt.clickPeriodStartDateButton();
		report.log(LogStatus.INFO, "Step 9.1. Select Period Start Month");
		objCrtBankSt.selectPeriodStartDtMonth(startMonth);
		report.log(LogStatus.INFO, "Step 9.2. Select Period Start Date");
		objCrtBankSt.selectPeriodStartDate(startDay);
		
		String endDateParts[] = PeriodEndDate.split("-");
		String endMonth  = endDateParts[0];
		String endDay  = endDateParts[1];
		String endYear = endDateParts[2];
		report.log(LogStatus.INFO, "Step 10. Click the Period End Date button");
		objCrtBankSt.clickPeriodEndDateButton();
		report.log(LogStatus.INFO, "Step 10.1. Select Period End Month");
		objCrtBankSt.selectPeriodEndDtMonth(endMonth);
		
		report.log(LogStatus.INFO, "Step 10.2. Select Period End Date");
		objCrtBankSt.selectPeriodEndDate(endDay);
		//objCrtBankSt.selectPeriodEndYear(endYear);
		//objCrtBankSt.enterPeriodEndDate(strEndDate);
		
		report.log(LogStatus.INFO, "Step 11. Click in the Statement ID field. Enter the desired information into the Statement ID field. Enter a valid value");
		if(StatementID != "")
		{
			objCrtBankSt.enterStatementID(StatementID);
			report.log(LogStatus.PASS, "Step 11.1.Statement ID is entered successfully: "+StatementID);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Statement ID is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click in the Period Opening Amount (USD) field. Enter the desired information into the Period Opening Amount (USD) field. Enter a valid value");
		if(OpeningAmount != "")
		{
			objCrtBankSt.enterOpeningAmount(OpeningAmount);
			report.log(LogStatus.PASS, "Step 12.1.Period Opening Amount (USD) is entered successfully: "+OpeningAmount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Period Opening Amount (USD) is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click in the Period Closing Amount (USD) field. Enter the desired information into the Period Closing Amount (USD) field. Enter a valid value");
		if(ClosingAmount != "")
		{
			objCrtBankSt.enterClosingAmount(ClosingAmount);
			report.log(LogStatus.PASS, "Step 13.1.Period Closing Amount (USD) is entered successfully: "+ClosingAmount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Period Closing Amount (USD) is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click the Statement Lines link");
		objCrtBankSt.clickStatementLinesLink();
		
		report.log(LogStatus.INFO, "Step 15. Click the Create button");
		objCrtBankSt.clickCreateStatLinesButton();
		
		String bookingDateParts[] = BookingDate.split("-");
		String bookingMonth  = bookingDateParts[0];
		String bookingDay  = bookingDateParts[1];
		String bookingYear = bookingDateParts[2];
		report.log(LogStatus.INFO, "Step 16. Click the Booking Date button");
		objCrtBankSt.clickBookingDateButton();
		report.log(LogStatus.INFO, "Step 16.1. Select Booking Month");
		objCrtBankSt.selectBookingMonth(bookingMonth);
		report.log(LogStatus.INFO, "Step 16.2. Select Booking Date");
		objCrtBankSt.selectBookingDate(bookingDay);
		
		report.log(LogStatus.INFO, "Step 17. Select Transaction Code from list");
		if(TransactionCode != "")
		{
			objCrtBankSt.SelectTransactionCode(TransactionCode);  
			report.log(LogStatus.PASS, "Step 17.1.Selected given Transaction Code from the list is: "+TransactionCode);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 17.1.Given Transaction Code from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 18. Select Flow Indicator from list");
		if(FlowIndicator != "")
		{
			objCrtBankSt.selectFlowIndicator(FlowIndicator);  
			report.log(LogStatus.PASS, "Step 18.1.Selected given Flow Indicator from the list is: "+FlowIndicator);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 18.1.Given Flow Indicator from the list is not selected");
		}
		

		report.log(LogStatus.INFO, "Step 19. Click in the Amount (USD) field. Enter the desired information into the Amount (USD) field. Enter a valid value");
		if(Amount != "")
		{
			objCrtBankSt.enterAmount(Amount);
			report.log(LogStatus.PASS, "Step 19.1.Amount (USD) is entered successfully: "+Amount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 19.1.Amount (USD) is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 20. Click the Ok button");
		objCrtBankSt.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 21. Click the Save and Close button");
		objCrtBankSt.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 22. Click the Warning Ok button");
		objCrtBankSt.clickWarningOkButton();
		
		report.log(LogStatus.INFO, "Step 23. Click the Confirmation Ok button");
		objCrtBankSt.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 24. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		//SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 25. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
	}

}
