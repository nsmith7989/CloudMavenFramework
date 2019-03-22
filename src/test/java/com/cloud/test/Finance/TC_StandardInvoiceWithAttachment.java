
/**
 Test Name: TC_StandardInvoiceWithAttachment
 Created By: Ciber
 Creation Date:May 4,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Create Standard Invoice with Attachment
 Prerequisite: Test data should be proper before running this script(unique Invoice number)
 */

package com.cloud.test.Finance;
import java.io.File;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.CreateInvoicePage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_StandardInvoiceWithAttachment extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Standard Invoice with Attachment")
	public void Cloud_Standard_Inv_Attachment(String UserName,String Password,String BusinessUnit,String Supplier,String Number,String Amount,String FileType,String CategoryType,String FileName,String TextArea,String URL,String AmountCell,String Company,String Region,String Country,String Service,String Location,String Department,String NaturalAccount,String Intercompany,String FundSource,String Future1)throws TestException,InterruptedException, TestException {
		
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
		objCrtInvoice.enterNumber(Number);
		
		report.log(LogStatus.INFO, "Step 14. Enter the Amount in Amount text field");
		objCrtInvoice.isAmountDisplayed();
		objCrtInvoice.enterAmount(Amount);
		
		report.log(LogStatus.INFO, "Step 15. Click on Attachments Button");
		objCrtInvoice.isAttachmentsBtnDisplayed();
		objCrtInvoice.clickAttachmentsButton();
		
		if (FileType.equalsIgnoreCase("File")) {
			
			report.log(LogStatus.INFO, "Step 16. Select File Type from dropdown");
			objCrtInvoice.isfileTypeDisplayed();
			objCrtInvoice.selectfileType(FileType);
						
			report.log(LogStatus.INFO, "Step 17. Select Catagory from dropdown");
			objCrtInvoice.isCatagoryDisplayed();
			objCrtInvoice.selectCatagory(CategoryType);
			
			report.log(LogStatus.INFO, "Step 18. Click on Browse button and upload the file");
			objCrtInvoice.isBrowseBtnDisplayed();
			objCrtInvoice.clickBrowseWithFile(System.getProperty("user.dir")+File.separator+"Cloud_TestData\\Update Address_SPD.pdf");
			objCrtInvoice.isFileUploaded(FileName);
				
		}else if(FileType.equalsIgnoreCase("Text")){
			
			report.log(LogStatus.INFO, "Step 16. Select File Type from dropdown");
			objCrtInvoice.isfileTypeDisplayed();
			objCrtInvoice.selectfileType(FileType);
			
			report.log(LogStatus.INFO, "Step 17. Select Catagory from dropdown");
			objCrtInvoice.isCatagoryDisplayed();
			objCrtInvoice.selectCatagory(CategoryType);
			
			report.log(LogStatus.INFO, "Step 18. Enter Text in File Name or URL field");
			objCrtInvoice.isTypeTextAreaDisplayed();
			objCrtInvoice.enterTypeTextArea(TextArea);
			
			
		}else if(FileType.equalsIgnoreCase("URL")) {
			
			report.log(LogStatus.INFO, "Step 16. Select File Type from dropdown");
			objCrtInvoice.isfileTypeDisplayed();
			objCrtInvoice.selectfileType(FileType);

			report.log(LogStatus.INFO, "Step 17. Select Catagory from dropdown");
			objCrtInvoice.isCatagoryDisplayed();
			objCrtInvoice.selectCatagory(CategoryType);
			
			report.log(LogStatus.INFO, "Step 18. Enter Text in File Name or URL field");
			objCrtInvoice.isURLTextAreaDisplayed();
			objCrtInvoice.enterURLTextArea(URL);			
			
		}
		
		report.log(LogStatus.INFO, "Step 19. Click on Ok button");
		objCrtInvoice.isAttachmentsOkBtnDisplayed();
		objCrtInvoice.clickAttachmentsOkButton();

		report.log(LogStatus.INFO, "Step 20. Enter Amount in Amount Cell");
		objCrtInvoice.isAmountCellDisplayed();
		objCrtInvoice.enterAmountCell(AmountCell);
		
		report.log(LogStatus.INFO, "Step 21. Click on Distribution Combination button");
		objCrtInvoice.isDistCombinationBtnDisplayed();
		objCrtInvoice.clickDistCombinationButton();
				
		report.log(LogStatus.INFO, "Step 22. Click on Company Search Icon");
		objCrtInvoice.isCompanySearchIconDisplayed();
		objCrtInvoice.clickCompanySearchIcon();
		objCrtInvoice.verifySearchEvent(Company);
		report.log(LogStatus.INFO, "Step 23. Select Company from dropdown");
		objCrtInvoice.selectEvent(Company);
		//objCrtInvoice.verifyEvent(Company);
		
		report.log(LogStatus.INFO, "Step 24. Click on  Region Search Icon");
		objCrtInvoice.isRegionSearchIconDisplayed();
		objCrtInvoice.clickRegionSearchIcon();
		objCrtInvoice.verifySearchEvent(Region);
		report.log(LogStatus.INFO, "Step 25. Select Region from dropdown");
		objCrtInvoice.selectEvent(Region);
		//objCrtInvoice.verifyEvent(Region);
		
		report.log(LogStatus.INFO, "Step 26. Click on Country Search Icon");
		objCrtInvoice.isCountrySearchIconDisplayed();
		objCrtInvoice.clickCountrySearchIcon();
		objCrtInvoice.verifySearchEvent(Country);
		report.log(LogStatus.INFO, "Step 27. Select Country from dropdown");
		objCrtInvoice.selectEvent(Country);
		//objCrtInvoice.verifyEvent(Country);
		
		report.log(LogStatus.INFO, "Step 28. Click on Service Search Icon");
		objCrtInvoice.isServiceSearchIconDisplayed();
		objCrtInvoice.clickServiceSearchIcon();
		objCrtInvoice.verifySearchEvent(Service);
		report.log(LogStatus.INFO, "Step 29. Select Service from dropdown");
		objCrtInvoice.selectEvent(Service);
		//objCrtInvoice.verifyEvent(Service);
		
		report.log(LogStatus.INFO, "Step 30. Click on Location Search Icon");
		objCrtInvoice.isLocationSearchIconDisplayed();
		objCrtInvoice.clickLocationSearchIcon();
		objCrtInvoice.verifySearchEvent(Location);
		report.log(LogStatus.INFO, "Step 31. Select Location from dropdown");
		//SeleniumUtils.delay(5000);
		objCrtInvoice.selectEvent(Location);
		SeleniumUtils.delay(3000);
		//objCrtInvoice.verifyEvent(Location);
		
		report.log(LogStatus.INFO, "Step 32. Click on Department Search Icon");
		objCrtInvoice.isDepartmentSearchIconDisplayed();
		objCrtInvoice.clickDepartmentSearchIcon();
		objCrtInvoice.verifySearchEvent(Department);
		report.log(LogStatus.INFO, "Step 33. Select Department from dropdown");
		objCrtInvoice.selectEvent(Department);
		//objCrtInvoice.verifyEvent(Department);
		SeleniumUtils.delay(3000);
		
		report.log(LogStatus.INFO, "Step 34. Click on Natural Account Search Icon");
		objCrtInvoice.clickNaturalAccountSearchIcon();
		report.log(LogStatus.INFO, "Step 35. Verify that Natural Account Search link");
		objCrtInvoice.isAccountSearchLinkDisplayed();
		report.log(LogStatus.INFO, "Step 36. Click on Natural Account Search link");
		objCrtInvoice.clickAccountSearchLink();
		report.log(LogStatus.INFO, "Step 37. Enter the Natural Account Value in Value text field");
		objCrtInvoice.enterAccountValue(NaturalAccount);
		report.log(LogStatus.INFO, "Step 38. Click on Natural Account Search button");
		objCrtInvoice.clickAccountSearchButton();
		report.log(LogStatus.INFO, "Step 39. Select Department from dropdown");
		objCrtInvoice.selectEvent(NaturalAccount);
		report.log(LogStatus.INFO, "Step 40. Click on Natural Account Ok button");
		objCrtInvoice.isAccountOkButtonDisplayed();
		objCrtInvoice.clickAccountOkButton();
		
		report.log(LogStatus.INFO, "Step 41. Click on Intercompany Search Icon");
		objCrtInvoice.isIntercompanySearchIconDisplayed();
		objCrtInvoice.clickIntercompanySearchIcon();
		report.log(LogStatus.INFO, "Step 42. Select Intercompany from dropdown");
		objCrtInvoice.selectEvent(Intercompany);
		SeleniumUtils.delay(5000);
		//objCrtInvoice.verifyEvent(Intercompany);

		report.log(LogStatus.INFO, "Step 43. Click on FundSource Search Icon");
		objCrtInvoice.isFundSourceSearchIconDisplayed();
		objCrtInvoice.clickFundSourceSearchIcon();
		report.log(LogStatus.INFO, "Step 44. Select FundSource from dropdown");
		objCrtInvoice.selectEvent(FundSource);
		//objCrtInvoice.verifyEvent(FundSource);
		
		report.log(LogStatus.INFO, "Step 45. Click on Future1 Search Icon");
		objCrtInvoice.isFuture1SearchIconDisplayed();
		objCrtInvoice.clickFuture1SearchIcon();
		report.log(LogStatus.INFO, "Step 46. Select Future1 from dropdown");
		objCrtInvoice.selectEvent(Future1);
		//objCrtInvoice.verifyEvent(Future1);
		//SeleniumUtils.delay(3000);
				
		report.log(LogStatus.INFO, "Step 47. Click on Account pop up Ok button");
		//objCrtInvoice.isAccountPopOkButtonDisplayed();
		objCrtInvoice.clickAccountPopOkButton();
		
		report.log(LogStatus.INFO, "Step 48. Click on Save button");
		objCrtInvoice.isSaveButtonDisplayed();
		objCrtInvoice.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 49. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 50. Select on Validate item from Invoice Actions Menu");
		objCrtInvoice.isValidateMenuDisplayed();
		objCrtInvoice.selectValidateMenu();
		
		report.log(LogStatus.INFO, "Step 51. Click on Information pop-up Ok button");
		objCrtInvoice.isInformationOkBtnDisplayed();
		objCrtInvoice.clickInformationOkButton();
		
		report.log(LogStatus.INFO, "Step 52. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 53. Select on Post to Ledger item from Invoice Actions Menu");
		objCrtInvoice.isPostLedgerMenuDisplayed();
		objCrtInvoice.selectPostLedgerMenu();
		
		report.log(LogStatus.INFO, "Step 54. Click on Confirmation Ok button");
		objCrtInvoice.isConfOkButtonDisplayed();
		String message="You have successfully created standard invoice with attachment.";
		objCrtInvoice.clickConfOkButton(message);
		
	/*	report.log(LogStatus.INFO, "Step 55. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		
		report.log(LogStatus.INFO, "Step 56. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();*/
		
		sAssert.assertAll();
		
	}
}
