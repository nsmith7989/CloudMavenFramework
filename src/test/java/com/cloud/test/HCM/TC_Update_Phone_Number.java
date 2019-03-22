/**
 Test Name: TC_Update_Personal_Information
 Created By: Ciber
 Creation Date:April 20,2018
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
public class TC_Update_Phone_Number extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Update the phone number")	
public void NewContacts_Information(String UserName,String Password,String StartDate,String EmergencyContact,String Relationship,String FirstName,String LastName,String Title,String Gender,String DateOfBirth,String NumberType,String CountryCode,String PhoneNumber,String SearchText,String CountryName,String AreaCode) throws TestException,InterruptedException, TestException
{
	sAssert=new SoftAssert();
	report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
	LoginPage objLogin = new LoginPage(driver, report);
	sAssert.assertTrue(objLogin.isUserNameDisplayed());
	
	report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
	HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
	//HomePage objHome =objLogin.loginToCloudApplication("Cole.Ross","Welcome123");
		
	report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
	sAssert.assertTrue(objHome.isHomeImageDisplayed());
	
	report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
	objHome.clickNavigatorIcon();
	
	report.log(LogStatus.INFO, "Step 5. Click on Personal Information link");
	MyDetailsPage objMyDetails=objHome.clickPersonalInformation();
	
	report.log(LogStatus.INFO, "Step 6. Verify that navigated to My Details page or not");
	sAssert.assertTrue(objMyDetails.isMyDetailsPageDisplayed());
	
	report.log(LogStatus.INFO, "Step 7. Click on Edit button to update Personal Inforamtion");
	PersonalInformationPage objPIPage=objMyDetails.clickEditButton();
	
	report.log(LogStatus.INFO, "Step 8. Click on Add button and Select Phone from the list");
	objPIPage.selectNewContactsList("Phone");
	
	report.log(LogStatus.INFO, "Step 9. Click the Number Type list and select any value");
	objPIPage.selectPhoneType(NumberType);
	
	report.log(LogStatus.INFO, "Step 10. Click the Country Code list and select any value");
	objPIPage.clickCountryCode();
	
	report.log(LogStatus.INFO, "Step 11. Click the Search link");
	objPIPage.clickSearchLink();
	
	report.log(LogStatus.INFO, "Step 12. Enter Country name to search");
	objPIPage.enterCountry(SearchText);
	//objPIPage.selectCountryCode(SearchText);//This method also working fine
	
	report.log(LogStatus.INFO, "Step 13. Click on Search button");
	objPIPage.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 14. Select the valid country name from the displayed list and Click on OK button");
	objPIPage.selectWebtableElement(CountryName);
	
	report.log(LogStatus.INFO, "Step 15. Enter Area code");
	objPIPage.enterAreaCode(AreaCode);
	
	report.log(LogStatus.INFO, "Step 16. Enter PhoneNumber");
	objPIPage.enterPhoneNumber(PhoneNumber);
	
	report.log(LogStatus.INFO, "Step 17. Click on Save and Close button to save the information");
	objPIPage.clickSaveAndCloseButton();
		
	/*report.log(LogStatus.INFO, "Step 18. Click on Sign Out link to sign out from application");
	objHome.clickImgHome();
	objHome.clickUserIcon();
	objHome.clickSignOut();
	
	report.log(LogStatus.INFO, "Step 19. Click on Confirm button to sign out from application");
	SignOffPage objSignOff = new SignOffPage(driver,report);
	objSignOff.clickConfirm();*/
		
	sAssert.assertAll();

}

}
