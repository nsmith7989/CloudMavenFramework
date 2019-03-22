/**
 Test Name: ProfileManagement_Creating_Content_Type_by_HR_SPD
 Created By: Ciber
 Creation Date:July 17,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to Creating Content Type by HR_SPD
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
	public class ProfileManagement_Creating_Content_Type_by_HR_SPD extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to create content type by HR")	
	public void PM_Creating_Content_Type(String UserName,String Password,String ContextName,String Name,String Description) throws TestException,InterruptedException
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
		if(objProf.isManageContentTypesLinkDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.Manage Content Types Link is displayed");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.Manage Content Types Link is not displayed");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Click the Manage Content Types link.");
		objProf.clickManageContentTypesLink();
		
		
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
		if(objProf.isCreateTextDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Clicked on Create button is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Clicked on Create button is failed");	
		}
		
		
		report.log(LogStatus.INFO, "Step 8. Click in the Context Name field and Enter the desired information into the Context Name field");
		if(ContextName != "")
		{
			objProf.setContextName(ContextName);
			report.log(LogStatus.PASS, "Step 8.1.Context Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Value of Context Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click in the Name field and Enter the desired information into the Name field");
		if(Name != "")
		{
			objProf.setName(Name);
			report.log(LogStatus.PASS, "Step 9.1.Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Value of Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click in the Description field and Enter the desired information into the Description field");
		if(Description != "")
		{
			objProf.setDescription(Description);
			report.log(LogStatus.PASS, "Step 10.1.Description is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Value of Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 11. Click the Save and Close button.");
		objProf.clickSaveAndCloseButton();
		if(objProf.isDoneButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 12.1.Clicked on Save and Close button is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Clicked on Save and Close button is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 13. Click the Done button.");
		objProf.clickDoneButton();
		
		sAssert.assertAll();
				
	}

}