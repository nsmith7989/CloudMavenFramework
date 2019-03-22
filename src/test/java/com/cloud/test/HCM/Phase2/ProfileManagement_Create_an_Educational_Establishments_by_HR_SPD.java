/**
 Test Name: ProfileManagement_Create_an_Educational_Establishments_by_HR_SPD
 Created By: Ciber
 Creation Date:July 17,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to create educational establishments
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
	public class ProfileManagement_Create_an_Educational_Establishments_by_HR_SPD extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to create educational establishments")	
	public void PM_Educational_Establishments(String UserName,String Password,String Code,String Name,String Description,String Country,String StateORProvince) throws TestException,InterruptedException
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
		if(objProf.isManageEducEstabLinkDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.Manage Educational Establishments Link is displayed");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.Manage Educational Establishments is not displayed");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Click the Manage Educational Establishments link.");
		objProf.clickManageEducEstabLink();
		
		if(objProf.isManagEduEstabTextDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Clicked on Manage Educational Establishments Link is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Clicked on Manage Educational Establishments Link is failed");	
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
		
		report.log(LogStatus.INFO, "Step 8. Click in the Code field and Enter the desired information into the Code field");
		if(Code != "")
		{
			objProf.setCode(Code);
			report.log(LogStatus.PASS, "Step 8.1.Code is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Value of Code is not entered");
		}

		report.log(LogStatus.INFO, "Step 9. Click in the Name field and Enter the desired information into the Name field");
		if(Name != "")
		{
			objProf.setEducEstName(Name);
			report.log(LogStatus.PASS, "Step 9.1.Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Value of Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click in the Description field and Enter the desired information into the Description field");
		if(Description != "")
		{
			objProf.setEDuEstDescription(Description);
			report.log(LogStatus.PASS, "Step 10.1.Description is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Value of Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 11. Click the Country list.Click the vertical scrollbar");
		report.log(LogStatus.INFO, "Step 12. Click the United States list item.");
		if(Country != "")
		{
			objProf.selectCountry(Country);
			report.log(LogStatus.PASS, "Step 12.1.Country is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Value of Country is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click the State or Province list.");
		report.log(LogStatus.INFO, "Step 14. Click the California list item.");
		if(StateORProvince != "")
		{
			objProf.selectStateOfProv(StateORProvince);
			report.log(LogStatus.PASS, "Step 14.1.State or Province is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Value of State or Province is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 15. Click the Save and Close button.");
		objProf.clickSaveAndCloseButton();
		if(objProf.isDoneButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 15.1.Clicked on Save and Close button is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Clicked on Save and Close button is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 16. Click the Done button.");
		objProf.clickDoneButton();
		
		sAssert.assertAll();
				
	}

}