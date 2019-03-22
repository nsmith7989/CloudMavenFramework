/**
 Test Name: ProfileManagement_Creating_Content_Item
 Created By: Ciber
 Creation Date:July 17,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to Creating Content Item by HR_SPD
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.HCM.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.HCM.SearchProfilesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class ProfileManagement_Creating_Content_Item extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to create content item")	
	public void PM_Creating_Content_Item(String UserName,String Password,String NameList,String ContentItem,String ItemCode) throws TestException,InterruptedException
	{
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
		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
			
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
		
		report.log(LogStatus.INFO, "Step 5. Click the Profiles Link");
		SearchProfilesPage objProf=objHome.clickProfilesLink();
		if(objProf.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Profile Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Profile Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click the Tasks button");
		objProf.clickTasksButton();
		if(objProf.isManageContentItemsLinkDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.ManageContentItems Link is displayed");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.ManageContentItems Link is not displayed");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Click the Manage Content Items link.");
		objProf.clickManageContentItemsLink();
		if(objProf.isCreateButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Clicked on ManageContentItems Link is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Clicked on ManageContentItems Link is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Click the Create button.");
		objProf.clickCreateButton();
		if(objProf.isNameListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Clicked on Create button is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Clicked on Create button is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 9. Click the Name list.");
		report.log(LogStatus.INFO, "Step 10. Select the Product Category list item from Name dropdown");
		if(NameList != "")
		{
			objProf.selectName(NameList);
			report.log(LogStatus.PASS, "Step 10.1.Name is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Selection of Name is failed");
		}
		
		report.log(LogStatus.INFO, "Step 11. Click in the Content Item field and Enter the desired information into the Content Item field");
		if(ContentItem != "")
		{
			objProf.setContentItem(ContentItem);
			report.log(LogStatus.PASS, "Step 11.1.Content Item is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Value of Content Item is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click the Continue button");
		objProf.clickContinueButton();
		
		report.log(LogStatus.INFO, "Step 13. Click in the Item Code field and Enter the desired information into the Item Code field");
		if(ItemCode != "")
		{
			objProf.setItemCode(ItemCode);
			report.log(LogStatus.PASS, "Step 13.1.ItemCode is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Value of ItemCode is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click the Save and Close button.");
		objProf.clickSaveAndCloseButton();
		if(objProf.isDoneButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 14.1.Clicked on Save and Close button is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Clicked on Save and Close button is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 15. Click the Done button.");
		objProf.clickDoneButton();
			
		sAssert.assertAll();
				
	}

}