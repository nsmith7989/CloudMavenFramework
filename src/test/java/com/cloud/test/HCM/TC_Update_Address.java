/**
 Test Name: TC_UpdateAddress
 Created By: Ciber
 Creation Date:April 10,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to update the address and martial status for any user
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.HCM;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.HCM.MyDetailsPage;
import com.cloud.pageobjects.HCM.PersonalInformationPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_Update_Address extends BaseWebTest  {
SoftAssert sAssert;

public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to update the address")	
public void Cloud_Personal_Inforamtion(String UserName,String Password,String FirstName,String LastName,String PhoneNumber,String AddressLine1,String MartialStatus,String BloodType,String SearchText,String Department) throws TestException,InterruptedException, TestException
{
	sAssert=new SoftAssert();
	report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
	LoginPage objLogin = new LoginPage(driver, report);
	sAssert.assertTrue(objLogin.isUserNameDisplayed());
	
	report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
	HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
	//HomePage objHome =objLogin.loginToCloudApplication("Cole.Ross","Welcome123");
	//sAssert.assertEquals(UserName, objHome.getUserName(), "Expected UserName is: "+UserName);
	
	report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
	sAssert.assertTrue(objHome.isHomeImageDisplayed());
	
	report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
	objHome.clickNavigatorIcon();
	
	report.log(LogStatus.INFO, "Step 4. Click on Personal Information link");
	MyDetailsPage objMyDetails=objHome.clickPersonalInformation();
	
	report.log(LogStatus.INFO, "Step 5. Verify that navigated to My Details page or not");
	sAssert.assertTrue(objMyDetails.isMyDetailsPageDisplayed());
	
	report.log(LogStatus.INFO, "Step 6. Click on Edit button to update Personal Inforamtion");
	PersonalInformationPage objPIPage=objMyDetails.clickEditButton();
	
	report.log(LogStatus.INFO, "Step 7. Click on Contacts button");
	objPIPage.clickIconEdit();
	
	report.log(LogStatus.INFO, "Step 8. Enter the address in Address Line1 text filed");
	objPIPage.setAddressLine1("Apartment 9");
	
	report.log(LogStatus.INFO, "Step 9. Click on Save and Close button to save the information");
	objPIPage.clickSaveAndCloseButton();
	//objPIPage.clickCancelButton();
	
	/*report.log(LogStatus.INFO, "Step 10. Click on Sign Out link to sign out from application");
	objHome.clickImgHome();
	objHome.clickUserIcon();
	objHome.clickSignOut();
	
	report.log(LogStatus.INFO, "Step 11. Click on Confirm button to sign out from application");
	SignOffPage objSignOff = new SignOffPage(driver,report);
	objSignOff.clickConfirm();*/
		
	sAssert.assertAll();
			
}

}
