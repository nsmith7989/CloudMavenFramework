package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.EditJournalPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.pageobjects.Finance.ManageJournalsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class TC_DeleteJournalBatch extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Reverse the unreversed Journal")
	public void Cloud_Delete_Journal_Batch(String UserName,String Password,String Journal,String JournalBatch,String AccountingPeriod)throws TestException,InterruptedException, TestException {
		
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		
		report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 5. Click on Journals link");
		JournalsPage objJournals=objHome.clickJournals();
				
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		objJournals.isTasksBtnDisplayed();
		objJournals.clickTasksButton();
				
		report.log(LogStatus.INFO, "Step 7. Click on Manage Journal link");
		objJournals.isManageJournalLinkDisplayed(); 
		ManageJournalsPage objMngJournal=objJournals.clickManageJournalLink();
		
		report.log(LogStatus.INFO, "Step 8. Enter the Journal  in Journal text field");
		objMngJournal.isJournalDisplayed();
		objMngJournal.enterJournal(Journal);
		
		report.log(LogStatus.INFO, "Step 9. Enter the Journal Batch in Journal Batch text filed");
		objMngJournal.isJournalBatchDisplayed();
		objMngJournal.enterJournalBatch(JournalBatch);
		
		report.log(LogStatus.INFO, "Step 10. Click on Accounting Period Search Icon");
		objMngJournal.isAccPeriodSearchIconDisplayed();
		objMngJournal.clickAccountingPeriodSearchIcon();
				
		report.log(LogStatus.INFO, "Step 11. Click on Accounting Period Search link");
		objMngJournal.isAccPeriodSearchLinkDisplayed();
		objMngJournal.clickAccPeriodSearchLink();
		
		report.log(LogStatus.INFO, "Step 12. Enter the Period Name  in Period Name text field");
		objMngJournal.isPeriodNameDisplayed();
		objMngJournal.enterPeriodName(AccountingPeriod);
		
		report.log(LogStatus.INFO, "Step 13. Click on Period Name Search button");
		objMngJournal.isPeriodSearchButtonDisplayed();
		objMngJournal.clickPeriodSearchButton();
		
		report.log(LogStatus.INFO, "Step 14. Select Accounting Period Name from list");
		//objMngJournal.isPeriodNameValueDisplayed();
		objMngJournal.clickPeriodNameValue(AccountingPeriod);
		
		report.log(LogStatus.INFO, "Step 15. Click on Accounting Period Ok button");
		objMngJournal.isPeriodOkButtonDisplayed();
		objMngJournal.clickPeriodOkButton();
		objMngJournal.clickJournals();
		
		report.log(LogStatus.INFO, "Step 16. Click on Search button");
		objMngJournal.isJournalsSearchButtonDisplayed();
		objMngJournal.clickJournalsSearchButton();
		
		report.log(LogStatus.INFO, "Step 17. Select on Journal Cell");
		objMngJournal.isclickJournalCellLinkDisplayed();
		//objMngJournal.selectJournalCellLink();
		EditJournalPage objeditJournal = objMngJournal.selectJournalCellLink();
		
		report.log(LogStatus.INFO, "Step 18. Click on Journals Batch Action menu");
		objeditJournal.isJournalBatchActionMenuDisplayed();
		objeditJournal.clickJournalBatchActionMenu();
		
		report.log(LogStatus.INFO, "Step 19. Click on Delete from Journals Batch Action menu");
		objeditJournal.isJournalBatchDeleteListDisplayed();
		if(objeditJournal.isJournalBatchDeleteListEnabled()==true) {
			objeditJournal.clickJournalBatchDeleteList();
		}else {
			report.log(LogStatus.FAIL, "Delete option from Journal Batch Action Menu is not enabled state");
		}
		
		report.log(LogStatus.INFO, "Step 20. Click on Yes Button");
		objeditJournal.isWarningYesButtonDisplayed();
		objeditJournal.clickWarningYesButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on Done Button");
		objMngJournal.isDoneButtonDisplayed();
		objMngJournal.clickDoneButton();
			
		
	}

}
