/**
 Test Name: Create Adjustment Journal
 Created By: Ciber
 Creation Date:May 4,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Create Adjustment Journal
 Prerequisite: Test data should be proper before running this script(unique Journal number)
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
import com.cloud.pageobjects.Finance.CreateJournalPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_CreateAdjustmentJournal extends BaseWebTest{

	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Adjustment Journal")
	public void Cloud_Create_Adjustment_Journal(String UserName,String Password,String JournalBatch,String Description,String Journal,String JournalDescription,String Category,String D_Company,String D_Region,String D_Country,String D_Service,String D_Location,String D_Department,String D_NaturalAccount_Search,String D_NaturalAccount,String D_Intercompany,String D_FundSource,String D_Future1,String Debit,String C_Company,String C_Region,String C_Country,String C_Service,String C_Location,String C_Department,String C_NaturalAccount_Search,String C_NaturalAccount,String C_Intercompany,String C_FundSource,String C_Future1,String Credit)throws TestException,InterruptedException, TestException {
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
		sAssert.assertTrue(objJournals.isTasksBtnDisplayed());
		objJournals.clickTasksButton();
	
		report.log(LogStatus.INFO, "Step 7. Click on Create Journal link");
		objJournals.isCreateJournalLinkDisplayed(); 
		CreateJournalPage objCrtJournal=objJournals.clickCreateJournalLink();
		
		report.log(LogStatus.INFO, "Step 8. Enter the Journal Batch in Journal Batch text filed");
		objCrtJournal.isJournalBatchDisplayed();
		objCrtJournal.enterJournalBatch(JournalBatch);
		
		report.log(LogStatus.INFO, "Step 9. Enter the Journal Batch Description in Description text area filed");
		objCrtJournal.isBatchDescriptionDisplayed();
		objCrtJournal.enterBatchDescription(Description);
	
		report.log(LogStatus.INFO, "Step 10. Enter the Journal in Journal text filed");
		objCrtJournal.isJournalDisplayed();
		objCrtJournal.enterJournal(Journal);
		
		report.log(LogStatus.INFO, "Step 11. Enter the Journal Description in Description text area filed");
		objCrtJournal.isJournalDescriptionDisplayed();
		objCrtJournal.enterJournalDescription(JournalDescription);
		
		report.log(LogStatus.INFO, "Step 12. Select category from Category dropdown");
		objCrtJournal.isSelectCategoryDisplayed();
		objCrtJournal.SelectCategory(Category);
		
		// Debit Account
		report.log(LogStatus.INFO, "Step 13. Click on Accounts button");
		objCrtJournal.isAccountBtnDisplayed();
		objCrtJournal.clickAccountButton();
		
		report.log(LogStatus.INFO, "Step 14. Click on Accounts Company Search Icon");
		objCrtJournal.isCompanySearchIconDisplayed();
		objCrtJournal.clickCompanySearchIcon();
		objCrtJournal.verifySearchEvent(D_Company);
		report.log(LogStatus.INFO, "Step 15. Select Company from dropdown");
		objCrtJournal.selectEvent(D_Company);
		objCrtJournal.verifyEvent(D_Company);
		
		report.log(LogStatus.INFO, "Step 16. Click on Accounts Region Search Icon");
		objCrtJournal.isRegionSearchIconDisplayed();
		objCrtJournal.clickRegionSearchIcon();
		objCrtJournal.verifySearchEvent(D_Region);
		report.log(LogStatus.INFO, "Step 17. Select Region from dropdown");
		objCrtJournal.selectEvent(D_Region);
		objCrtJournal.verifyEvent(D_Region);
		
		report.log(LogStatus.INFO, "Step 18. Click on Accounts Country Search Icon");
		objCrtJournal.isCountrySearchIconDisplayed();
		objCrtJournal.clickCountrySearchIcon();
		report.log(LogStatus.INFO, "Step 19. Select Country from dropdown");
		objCrtJournal.selectEvent(D_Country);
		objCrtJournal.verifyEvent(D_Country);
		
		report.log(LogStatus.INFO, "Step 20. Click on Accounts Service Search Icon");
		objCrtJournal.isServiceSearchIconDisplayed();
		objCrtJournal.clickServiceSearchIcon();
		report.log(LogStatus.INFO, "Step 21. Select Service from dropdown");
		objCrtJournal.selectEvent(D_Service);
		objCrtJournal.verifyEvent(D_Service);
		
		report.log(LogStatus.INFO, "Step 22. Click on Accounts Location Search Icon");
		objCrtJournal.isLocationSearchIconDisplayed();
		objCrtJournal.clickLocationSearchIcon();
		report.log(LogStatus.INFO, "Step 23. Select Location from dropdown");
		SeleniumUtils.delay(5000);
		objCrtJournal.selectEvent(D_Location);
		SeleniumUtils.delay(3000);
		objCrtJournal.verifyEvent(D_Location);
		
		report.log(LogStatus.INFO, "Step 24. Click on Accounts Department Search Icon");
		objCrtJournal.clickDepartmentSearchIcon();
		report.log(LogStatus.INFO, "Step 25. Select Department from dropdown");
		objCrtJournal.selectEvent(D_Department);
		objCrtJournal.verifyEvent(D_Department);
		SeleniumUtils.delay(3000);
		
		report.log(LogStatus.INFO, "Step 26. Click on Natural Account Search Icon");
		objCrtJournal.clickNaturalAccountSearchIcon();
		report.log(LogStatus.INFO, "Step 27. Verify that Natural Account Search link");
		objCrtJournal.isAccountSearchLinkDisplayed();
		report.log(LogStatus.INFO, "Step 28. Click on Natural Account Search link");
		objCrtJournal.clickAccountSearchLink();
		report.log(LogStatus.INFO, "Step 29. Enter the Natural Account Value in Value text field");
		objCrtJournal.enterAccountValue(D_NaturalAccount_Search);
		report.log(LogStatus.INFO, "Step 30. Click on Natural Account Search button");
		objCrtJournal.clickAccountSearchButton();
		report.log(LogStatus.INFO, "Step 31. Select Department from dropdown");
		objCrtJournal.selectEvent(D_NaturalAccount);
		report.log(LogStatus.INFO, "Step 32. Click on Natural Account Ok button");
		objCrtJournal.isAccountOkButtonDisplayed();
		objCrtJournal.clickAccountOkButton();
		
		report.log(LogStatus.INFO, "Step 33. Click on Intercompany Search Icon");
		objCrtJournal.clickIntercompanySearchIcon();
		report.log(LogStatus.INFO, "Step 34. Select Intercompany from dropdown");
		objCrtJournal.selectEvent(D_Intercompany);
		SeleniumUtils.delay(5000);
		objCrtJournal.verifyEvent(D_Intercompany);

		report.log(LogStatus.INFO, "Step 35. Click on FundSource Search Icon");
		objCrtJournal.clickFundSourceSearchIcon();
		report.log(LogStatus.INFO, "Step 36. Select FundSource from dropdown");
		objCrtJournal.selectEvent(D_FundSource);
		objCrtJournal.verifyEvent(D_FundSource);
		
		report.log(LogStatus.INFO, "Step 37. Click on Future1 Search Icon");
		objCrtJournal.clickFuture1SearchIcon();
		report.log(LogStatus.INFO, "Step 38. Select Future1 from dropdown");
		objCrtJournal.selectEvent(D_Future1);
		objCrtJournal.verifyEvent(D_Future1);
		SeleniumUtils.delay(5000);
		
		report.log(LogStatus.INFO, "Step 39. Click on Ok button on Account pop up");
		objCrtJournal.clickAccountPopOkButton();
		
		report.log(LogStatus.INFO, "Step 40. Enter the Debit in Debit text filed");
		objCrtJournal.isJournalDisplayed();
		objCrtJournal.enterDebit(Debit);
		
		// Credit Account
		
		report.log(LogStatus.INFO, "Step 41. click on Account Tab");
		objCrtJournal.clickAccountTab();
		
		report.log(LogStatus.INFO, "Step 42. Click on Accounts button");
		objCrtJournal.isAccountBtnDisplayed();
		objCrtJournal.clickAccountButton();
		
		report.log(LogStatus.INFO, "Step 43. Click on Accounts Company Search Icon");
		objCrtJournal.isCompanySearchIconDisplayed();
		objCrtJournal.clickCompanySearchIcon();
		objCrtJournal.verifySearchEvent(C_Company);
		report.log(LogStatus.INFO, "Step 44. Select Company from dropdown");
		objCrtJournal.selectEvent(C_Company);
		objCrtJournal.verifyEvent(C_Company);
		
		report.log(LogStatus.INFO, "Step 45. Click on Accounts Region Search Icon");
		objCrtJournal.isRegionSearchIconDisplayed();
		objCrtJournal.clickRegionSearchIcon();
		objCrtJournal.verifySearchEvent(C_Region);
		report.log(LogStatus.INFO, "Step 46. Select Region from dropdown");
		objCrtJournal.selectEvent(C_Region);
		objCrtJournal.verifyEvent(C_Region);
		
		report.log(LogStatus.INFO, "Step 47. Click on Accounts Country Search Icon");
		objCrtJournal.isCountrySearchIconDisplayed();
		objCrtJournal.clickCountrySearchIcon();
		report.log(LogStatus.INFO, "Step 48. Select Country from dropdown");
		objCrtJournal.selectEvent(C_Country);
		objCrtJournal.verifyEvent(C_Country);
		
		report.log(LogStatus.INFO, "Step 49. Click on Accounts Service Search Icon");
		objCrtJournal.isServiceSearchIconDisplayed();
		objCrtJournal.clickServiceSearchIcon();
		report.log(LogStatus.INFO, "Step 50. Select Service from dropdown");
		objCrtJournal.selectEvent(C_Service);
		objCrtJournal.verifyEvent(C_Service);
		
		report.log(LogStatus.INFO, "Step 51. Click on Accounts Location Search Icon");
		objCrtJournal.isLocationSearchIconDisplayed();
		objCrtJournal.clickLocationSearchIcon();
		report.log(LogStatus.INFO, "Step 52. Select Location from dropdown");
		SeleniumUtils.delay(5000);
		objCrtJournal.selectEvent(C_Location);
		SeleniumUtils.delay(5000);
		objCrtJournal.verifyEvent(C_Location);
		
		report.log(LogStatus.INFO, "Step 53. Click on Accounts Department Search Icon");
		objCrtJournal.clickDepartmentSearchIcon();
		report.log(LogStatus.INFO, "Step 54. Select Department from dropdown");
		objCrtJournal.selectEvent(C_Department);
		objCrtJournal.verifyEvent(C_Department);
		
		report.log(LogStatus.INFO, "Step 55. Click on Natural Account Search Icon");
		objCrtJournal.clickNaturalAccountSearchIcon();
		report.log(LogStatus.INFO, "Step 56. Verify that Natural Account Search link");
		objCrtJournal.isAccountSearchLinkDisplayed();
		report.log(LogStatus.INFO, "Step 57. Click on Natural Account Search link");
		objCrtJournal.clickAccountSearchLink();
		report.log(LogStatus.INFO, "Step 58. Enter the Natural Account Value in Value text field");
		objCrtJournal.enterAccountValue(C_NaturalAccount_Search);
		report.log(LogStatus.INFO, "Step 59. Click on Natural Account Search button");
		objCrtJournal.clickAccountSearchButton();
		SeleniumUtils.delay(3000);
		report.log(LogStatus.INFO, "Step 60. Select Natural Account from dropdown");
		objCrtJournal.selectNaturalAccountvalueFromTable(C_NaturalAccount);
  		
		report.log(LogStatus.INFO, "Step 61. Click on Natural Account Ok button");
		SeleniumUtils.delay(3000);
		objCrtJournal.isAccountOkButtonDisplayed();
		objCrtJournal.clickAccountOkButton();
		SeleniumUtils.delay(5000);
		
		report.log(LogStatus.INFO, "Step 62. Click on Intercompany Search Icon");
		objCrtJournal.clickIntercompanySearchIcon();
		report.log(LogStatus.INFO, "Step 63. Select Intercompany from dropdown");
		objCrtJournal.selectEvent(C_Intercompany);
		SeleniumUtils.delay(5000);
		objCrtJournal.verifyEvent(C_Intercompany);

		report.log(LogStatus.INFO, "Step 64. Click on FundSource Search Icon");
		objCrtJournal.clickFundSourceSearchIcon();
		report.log(LogStatus.INFO, "Step 65. Select FundSource from dropdown");
		objCrtJournal.selectEvent(C_FundSource);
		SeleniumUtils.delay(5000);
		objCrtJournal.verifyEvent(C_FundSource);
		
		report.log(LogStatus.INFO, "Step 66. Click on Future1 Search Icon");
		objCrtJournal.clickFuture1SearchIcon();
		report.log(LogStatus.INFO, "Step 67. Select Future1 from dropdown");
		objCrtJournal.selectEvent(C_Future1);
		objCrtJournal.verifyEvent(C_Future1);
		SeleniumUtils.delay(5000);

		report.log(LogStatus.INFO, "Step 68. Click on Ok button on Account pop up");
		objCrtJournal.clickAccountPop2OkButton();
		
		report.log(LogStatus.INFO, "Step 69. Enter the Credit in Credit text filed");
		objCrtJournal.isCreditDisplayed();
		objCrtJournal.enterCredit(Credit);
	
		report.log(LogStatus.INFO, "Step 70. Click on Save button");
		objCrtJournal.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 71. Click on Complete button");
		objCrtJournal.clickCompleteButton();
		
		report.log(LogStatus.INFO, "Step 72. Click on Post button");
		objCrtJournal.clickPostButton();
		
		report.log(LogStatus.INFO, "Step 73. Click on Conformation Ok button");
		String strConfmessage;
		strConfmessage = "You have successfully adjusted a journal";
		objCrtJournal.clickConfOkButton(strConfmessage);
	
		report.log(LogStatus.INFO, "Step 74. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		
		report.log(LogStatus.INFO, "Step 75. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
	}
}
