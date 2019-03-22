package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.BasicOptionsPage;
import com.cloud.pageobjects.Finance.Overview_BankStatementPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class TC_AutoReconcialiation extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is to Apply Missing Conversion Rates")
	public void Cloud_Auto_Reconcialiation(String UserName,String Password,String BankAccount,String StatementID,String FromStatementEndDate,String ToStatementEndDate)throws TestException,InterruptedException, TestException {
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
		if(objOverview.isTasksBtnDisplayed()) 
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Submit Autoreconciliation Link and verify its navigated to Basic Options screen or not");
		//objAssets.isAddAssetLinkDisplayed();
		BasicOptionsPage objBskOptions=objOverview.clickSubmitAutoreconciliationLink();
		
		if(objBskOptions.isSelectBankAccountDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options screen  is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options screen  is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Bank Account from list");
		if(BankAccount != "")
		{
			objBskOptions.SelectBankAccount(BankAccount);
			report.log(LogStatus.PASS, "Step 8.1.Selected Bank Account from the list is "+BankAccount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Bank Account from the list is not selected");
		}
		
		
		report.log(LogStatus.INFO, "Step 9. Select Statement ID from list");
		if(StatementID != "")
		{
			objBskOptions.selectStatementID(StatementID);
			objBskOptions.selectEvent(StatementID);
			objBskOptions.clickStatementIDOkButton();
			objBskOptions.clickSubmissionNotesText();
			report.log(LogStatus.PASS, "Step 9.1.Selected given Statement ID from the list is "+StatementID);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Given Statement ID from the list is not selected");
		}
		
		String fromDateParts[] = FromStatementEndDate.split("-");
		String fromMonth  = fromDateParts[0];
		String fromDay  = fromDateParts[1];
		String fromYear = fromDateParts[2];
		report.log(LogStatus.INFO, "Step 10. Click the From Statement End Date button");
		objBskOptions.clickFromStatementEndDateButton();
		report.log(LogStatus.INFO, "Step 10.1. Select From Statement End Date Month");
		objBskOptions.selectFromStatementEndDtMonth(fromMonth);
		report.log(LogStatus.INFO, "Step 10.2. Select From Statement End Date");
		objBskOptions.selectFromStatementEndDate(fromDay);
		
		String toDateParts[] = ToStatementEndDate.split("-");
		String toMonth  = toDateParts[0];
		String toDay  = toDateParts[1];
		String toYear = toDateParts[2];
		report.log(LogStatus.INFO, "Step 11. Click the To Statement End Date button");
		objBskOptions.clickToStatementEndDateButton();
		report.log(LogStatus.INFO, "Step 11.1. Select To Statement End Date Month");
		objBskOptions.selectToStatementEndDtMonth(toMonth);
		report.log(LogStatus.INFO, "Step 11.2. Select To Statement End Date");
		objBskOptions.selectToStatementEndDate(toDay);
		
		report.log(LogStatus.INFO, "Step 12. Click the Submit button");
		objBskOptions.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 13. Click the Confirmation Ok button");
		objBskOptions.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 14. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		//SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 15. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
		
	}

}
