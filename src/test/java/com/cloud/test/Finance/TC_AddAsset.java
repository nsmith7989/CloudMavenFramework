package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.AddAssetPage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class TC_AddAsset extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is to Apply Missing Conversion Rates")
	public void Cloud_Add_Asset(String UserName,String Password,String AssetType,String Major,String Minor,String Description,String Cost,String Location,String AssetNumber,String ClassCode,String EmployeeName)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Assets link and verify its navigated to Assets Page or not");
		AssetsPage objAssets =objHome.clickAssets();
		if(objAssets.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Assets Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Assets Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button");
		sAssert.assertTrue(objAssets.isTasksBtnDisplayed());
		objAssets.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Add Asset Link and verify its navigated to Add Asset Pop-up window or not");
		//objAssets.isAddAssetLinkDisplayed();
		objAssets.clickAddAssetLink();
		
		if(objAssets.isAssetTypeDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Add Asset Pop-up window  is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Add Asset Pop-up window  is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Asset Type from list");
		//objAssets.isAssetTypeDisplayed();
		
		if(AssetType != "")
		{
			objAssets.selectAssetType(AssetType);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Asset Type from the list is "+AssetType);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Asset Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click the Category button and verify its navigated to Category Pop-up window or not");
		objAssets.isCategoryButtonDisplayed();
		objAssets.clickCategoryButton();
		if(objAssets.isSelectMajorDisplayed())
		{
			objAssets.selectAssetType(AssetType);
			report.log(LogStatus.PASS, "Step 9.1.Navigation to Category Pop-up window  is success");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Navigation to Category Pop-up window  is failed");
		}
		
		
		report.log(LogStatus.INFO, "Step 10. Select Major type from list");
		//objAssets.isSelectMajorDisplayed();
		
		if(Major != "")
		{
			objAssets.SelectMajor(Major);
			report.log(LogStatus.PASS, "Step 10.1.Selected given Major type from the list is "+Major);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Given Major Type from the list is not selected");
		}
		
		
		report.log(LogStatus.INFO, "Step 11. Select Minor type from list");
		//objAssets.isSelectMinorDisplayed();
		
		if(Minor != "")
		{
			objAssets.SelectMinor(Minor);
			report.log(LogStatus.PASS, "Step 11.1.Selected given Minor type from the list is "+Minor);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Given Minor Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click on Category Ok button");
		objAssets.isCategoryOkButtonDisplayed();
		objAssets.clickCategoryOkButton();
		
		report.log(LogStatus.INFO, "Step 12. Click in the Description field. Enter the desired information into the Description field. Enter a valid value");
		//objAssets.isDescriptionDisplayed();
		
		if(Description != "")
		{
			objAssets.enterDescription(Description);
			report.log(LogStatus.PASS, "Step 12.1.Description is entered successfully: "+Description);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click in the Cost field. Enter the desired information into the Cost field. Enter a valid value");
		objAssets.isCostDisplayed();
		if(Cost != "")
		{
			objAssets.enterCost(Cost);
			report.log(LogStatus.PASS, "Step 13.1.Cost is entered successfully: "+Cost);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Cost is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click the Location button and verify its navigated to Location Pop-up window or not");
		objAssets.isLocationButtonDisplayed();
		objAssets.clickLocationButton();
		if(objAssets.isLocationDisplayed())
		{
			report.log(LogStatus.PASS, "Step 14.1.Navigation to Location Pop-up window  is success");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Navigation to Location Pop-up window  is failed");
		}
		
		report.log(LogStatus.INFO, "Step 15. Click in the Location field. Enter the desired information into the Location field. Enter a valid value");
		if(Location != "")
		{
			objAssets.enterLocation(Location);
			report.log(LogStatus.PASS, "Step 15.1.Location is entered successfully: "+Location);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Location is not entered");
		}
		
		
		report.log(LogStatus.INFO, "Step 16. Click on Location Ok button");
		objAssets.isLocationOkButtonDisplayed();
		objAssets.clickLocationOkButton();
		
		
		report.log(LogStatus.INFO, "Step 17. Click on Next button and verify its navigated to Add Asset Page or not");
		objAssets.isNextButtonDisplayed();
		AddAssetPage objAddAsset=objAssets.clickNextButton();
		if(objAddAsset.isAssetNumberDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 17.1.Navigation to Add Asset Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 17.1.Navigation to Add Asset  is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 18. Click in the Asset Number field. Enter the desired information into the Asset Number field. Enter a valid value");
		//objAddAsset.isAssetNumberDisplayed();
		if(AssetNumber != "")
		{
			objAddAsset.enterAssetNumber(AssetNumber);
			report.log(LogStatus.PASS, "Step 18.1.Asset Number is entered successfully: "+AssetNumber);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 18.1.Asset Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 19. Select Class Code from list");
		objAddAsset.isClassCodeDisplayed();
		
		if(ClassCode != "")
		{
			objAddAsset.SelectClassCode(ClassCode);
			report.log(LogStatus.PASS, "Step 19.1.Class Code is selected successfully: "+ClassCode);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 19.1.Selection of Class Code is failed");
		}
		
		report.log(LogStatus.INFO, "Step 20. Select Employee Name from list");
		objAddAsset.isEmployeeNameDisplayed();
		if(EmployeeName != "")
		{
			objAddAsset.SelectEmployeeName(EmployeeName);
			report.log(LogStatus.PASS, "Step 20.1.Employee Name is selected successfully: "+EmployeeName);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 20.1.Selection of Employee Name is failed");
		}
		
		report.log(LogStatus.INFO, "Step 21. Click on Submit button");
		objAddAsset.isSubmitButtonDisplayed();
		objAddAsset.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 22. Click on Sign Out link to sign out from application");
		objHome.clickImgHome();
		SeleniumUtils.delay(3000);
		objHome.clickUserIcon();
		objHome.clickSignOut();
		
		report.log(LogStatus.INFO, "Step 23. Click on Confirm button to sign out from application");
		SignOffPage objSignOff = new SignOffPage(driver,report);
		objSignOff.clickConfirm();
		
		sAssert.assertAll();
		
		
	}
	

}
