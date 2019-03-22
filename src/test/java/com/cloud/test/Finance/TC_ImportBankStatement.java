package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.FileImportAndExportPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class TC_ImportBankStatement extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Standard Invoice with Attachment")
	public void Cloud_Import_Bank_Statement(String UserName,String Password,String FileName,String Account,String Name,String NameCell,String ImportProcess,String DataFile)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on File Import and Export link and verify its navigated to File Import and Export Page or not");
		FileImportAndExportPage objImport =objHome.clickFileImportExport();
		if(objImport.isUploadBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to File Import and Export Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to File Import and Export Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Upload button button and verify its navigated to Upload File pop-up or not");
		objImport.clickUploadButton();
		if(objImport.isBrowseBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.Navigation to Upload File pop-up is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.Navigation to Upload File pop-up is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Click on Browse button and verify its Uploaded Folder or not");
		objImport.clickBrowseWithFile(FileName);
		if(objImport.isBrowseBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Upload File is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.NUpload File pop-up is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Account from list");
		if(Account != "")
		{
			objImport.selectAccount(Account);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Account from the list is "+Account);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Account from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click on Save and Close button");
		objImport.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 10.Click on Home image and  Verify that Home Page is displayed or not");
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		objHome.clickImgHome();
		if(objHome.isHomeImageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 10.1.Navigation to Home Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Navigation to Home Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 11. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 12. Click on Schedule Process link and verify its navigated to Scheduled  Processes Page or not");
		ScheduledProcessesPage objScheduled =objHome.clickScheduledProcesses();
		if(objScheduled.isScheduleNewProcessBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 12.1.Navigation to Scheduled New Processes Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Navigation to Scheduled New Processes Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 13. Click on Schedule New Process button and verify its navigated to Scheduled New Processes Pop-up or not");
		objScheduled.clickScheduleNewProcessButton();
		if(objScheduled.isSearchScheduleNewProcessIconDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 13.1.Navigation to Scheduled New Processes Pop-up is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Navigation to Scheduled New Processes Pop-up is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 14. Click on Scheduled New Processes Name list icon ");
		objScheduled.clickSearchScheduleNewProcessIcon();
		
		report.log(LogStatus.INFO, "Step 15. Click on Scheduled New Processes Search link and verify its navigated to Search and Select: Name Pop-up or not");
		objScheduled.clickScheduleNewProcessSearchLink();
		if(objScheduled.isNameDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 15.1.Navigation to Search and Select: Name Pop-up is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Navigation to Search and Select: Name Pop-up is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 16. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
		if(Name != "")
		{
			objScheduled.enterName(Name);
			report.log(LogStatus.PASS, "Step 16.1.Name is entered successfully: "+Name);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 16.1.Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click on Search and Select: Name Search button");
		objScheduled.clickNameSearchButton();
		objScheduled.selectSearchAndSelectName(NameCell);
		
		
		
	}
		
}
