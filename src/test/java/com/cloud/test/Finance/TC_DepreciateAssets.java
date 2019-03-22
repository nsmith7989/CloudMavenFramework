package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class TC_DepreciateAssets extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is to Apply Missing Conversion Rates")
	public void Cloud_Depreciate_Assets(String UserName,String Password)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 5. Click on New Assets link and verify its navigated to Assets Page or not");
		AssetsPage objAssets =objHome.clickAssets();
		if(objAssets.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Assets  is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Assets  is failed");	
		}
		
		
		report.log(LogStatus.INFO, "Step 6. Click the Depreciation Select Tile button");
		objAssets.isDeprSelectTileButtonDisplayed();
		objAssets.clickDeprSelectTileButton();
		
		report.log(LogStatus.INFO, "Step 7. Click the Calculate Depreciation button");
		objAssets.isCalculateDepreciationButtonDisplayed();
		objAssets.clickCalculateDepreciationButton();
		
		report.log(LogStatus.INFO, "Step 8. Click the Confirmation Ok button");
		objAssets.isConfOkButtonDisplayed();
		objAssets.clickConfOkButton();
		
		
		sAssert.assertAll();
		
		
	}

}
