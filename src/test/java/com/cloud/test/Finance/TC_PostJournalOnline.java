/**
 Test Name: TC_PostJournalOnline
 Created By: Ciber
 Creation Date:May 4,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Post Journal Online
 Prerequisite: Test data should be proper before running this script(Invoice number should not be posted)
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
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.pageobjects.Finance.ManageJournalsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_PostJournalOnline extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Post Journal Online")
	public void Cloud_Post_Journal_Online(String UserName,String Password,String Journal,String JournalBatch,String AccountingPeriod)throws TestException,InterruptedException, TestException {
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
		objMngJournal.clickJournalCellLink();
		
		report.log(LogStatus.INFO, "Step 18. Click on Edit Pencil Icon");
		objMngJournal.clickIconEdit();
		
		report.log(LogStatus.INFO, "Step 19. Click on Save button");
		objMngJournal.isSaveButtonDisplayed();
		objMngJournal.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 20. Click on Post button");
		objMngJournal.isPostButtonDisplayed();
		objMngJournal.clickPostButton();
				
		report.log(LogStatus.INFO, "Step 21. Click on Conformation Ok button");
		objMngJournal.isConfOkButtonDisplayed();
		objMngJournal.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 22. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(5000);
		objHome.clickUserIcon();
		SeleniumUtils.delay(5000);
		objHome.clickSignOut();

		report.log(LogStatus.INFO, "Step 23. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		SeleniumUtils.delay(5000);
		objSignOff.clickConfirm();
				
		sAssert.assertAll();
	}	

}
