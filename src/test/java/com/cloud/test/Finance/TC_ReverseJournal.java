/**
 Test Name: TC_ReverseJournal
 Created By: Ciber
 Creation Date:May 4,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Reverse the unreversed Journal
 Prerequisite: Test data should be proper before running this script(Journal number should be posted but not reversed)
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
import com.cloud.pageobjects.Finance.EditJournalPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.pageobjects.Finance.ManageJournalsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_ReverseJournal extends BaseWebTest{

	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Reverse the unreversed Journal")
	public void Cloud_Reverse_Journal(String UserName,String Password,String Journal,String JournalBatch,String AccountingPeriod,String ReversalPeriod)throws TestException,InterruptedException, TestException {
		
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
		objMngJournal.isPeriodNameValueDisplayed();
		objMngJournal.clickPeriodNameValue();
		
		report.log(LogStatus.INFO, "Step 15. Click on Accounting Period Ok button");
		objMngJournal.isPeriodOkButtonDisplayed();
		objMngJournal.clickPeriodOkButton();
		
		report.log(LogStatus.INFO, "Step 16. Click on Search button");
		objMngJournal.isJournalsSearchButtonDisplayed();
		objMngJournal.clickJournalsSearchButton();
		
		report.log(LogStatus.INFO, "Step 17. Select on Journal Cell");
		objMngJournal.isclickJournalCellLinkDisplayed();
		objMngJournal.selectJournalCellLink();
		
		// Click Show more link 		
		EditJournalPage objeditJournal = new EditJournalPage(driver, report);
		
		report.log(LogStatus.INFO, "Step 18. Click on Show More link on Journal Section");
		objeditJournal.isshowMoreLinkDisplayed();
		objeditJournal.clickshowMoreLink();
		
		report.log(LogStatus.INFO, "Step 19. Click on Reversal link on Journal Section");
		objeditJournal.isReversalLinkDisplayed();
		objeditJournal.clickReversalLink();
		
		/*
		report.log(LogStatus.INFO, "Step 21. Click on Reversal period Search icon");
		objeditJournal.isRvrsPeriodSearchIconDisplayed();
		objeditJournal.clickReversalPeriodSearchIcon();
		
		report.log(LogStatus.INFO, "Step 21. Click on Reversal period Search link");
		objeditJournal.isRvrsPeriodSearchLinkDisplayed();
		objeditJournal.clickReversalPeriodSearchLink();
		
		String RvPeriodName = ex.getCellData("Cloud_Reverse_Journal",1,5);
		report.log(LogStatus.INFO, "Step 21. Enter Reversal period value");
		objeditJournal.isReversalPeriodNameDisplayed();
		objeditJournal.enterReversalPeriodName(RvPeriodName);
		
		report.log(LogStatus.INFO, "Step 21. Click on Reversal period Search Button");
		objeditJournal.isPeriodSearchButtonDisplayed();
		objeditJournal.clickPeriodSearchButton();
		
		report.log(LogStatus.INFO, "Step 21. Select on Reversal period value");
		objeditJournal.isReversalPeriodNameValueDisplayed();
		objeditJournal.clickReversalPeriodNameValue();
		
		report.log(LogStatus.INFO, "Step 21. Click on Reversal period Ok Button");
		objeditJournal.isReversalPeriodOkButtonDisplayed();
		objeditJournal.clickReversalPeriodOkButton();
		*/
		// Reversal Period functionality not working so the above code commented
				
		report.log(LogStatus.INFO, "Step 20. Enter Reversal period value");
		objeditJournal.isRvrsPeriodSearchIconDisplayed();
		objeditJournal.enterReversalPeriodTextbox(ReversalPeriod);
				
		report.log(LogStatus.INFO, "Step 21. Click on Save Button");
		objMngJournal.isSaveButtonDisplayed();
		objMngJournal.clickSaveButton(); 
		
		
		report.log(LogStatus.INFO, "Step 22. Click on  Journal Actions Menu");
		objeditJournal.isJournalActionMenuDisplayed();
		objeditJournal.clickJournalActionMenu();
		
		report.log(LogStatus.INFO, "Step 23. Click on  Revers Link");
		objeditJournal.isReversalMenuLinkDisplayed();
		objeditJournal.clickReversalMenuLink();
		
		/*report.log(LogStatus.INFO, "Step 24. Click on Save Button");
		objeditJournal.isWarningPopUpOkButtonDisplayed(); 
		objeditJournal.clickWarningPopUpOkButton();*/
		
		report.log(LogStatus.INFO, "Step 25. Click on Conformation Ok button");
		objeditJournal.isConfOkButtonDisplayed();
		objeditJournal.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 26. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(5000);
		objHome.clickUserIcon();
		SeleniumUtils.delay(5000);
		objHome.clickSignOut();
		
		
		report.log(LogStatus.INFO, "Step 26. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		SeleniumUtils.delay(5000);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();	
	}
}
