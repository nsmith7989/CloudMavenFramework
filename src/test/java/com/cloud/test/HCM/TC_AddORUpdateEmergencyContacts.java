/**
 Test Name: TC_AddORUpdateEmergencyContacts
 Created By: Ciber
 Creation Date:April 19,2018
 Modified By:
 Modified Date:
End Date:April 20,2018
 Test Description: This script is used for to update the Add OR Update EmergencyContacts for any user
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
import com.cloud.pageobjects.HCM.MyDetailsContactsPage;
import com.cloud.pageobjects.HCM.MyDetailsPage;
import com.cloud.pageobjects.HCM.PersonalInformationPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_AddORUpdateEmergencyContacts extends BaseWebTest  {
SoftAssert sAssert;
public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Add OR Update EmergencyContacts")	
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
		
	report.log(LogStatus.INFO, "Step 8. Click on Contacts button");
	MyDetailsContactsPage objContactcs=objMyDetails.clickImageContacts();
	
	report.log(LogStatus.INFO, "Step 9. Click on + Add button");
	objContactcs.clickNewContactsButton();
	
	report.log(LogStatus.INFO, "Step 10. Click the Add a new person option and Click the Continue button");
	objContactcs.selectNewPerson();
	
	report.log(LogStatus.INFO, "Step 11. Click the Add a new person option");
	objContactcs.checkEmergencyContact(EmergencyContact);
	
	report.log(LogStatus.INFO, "Step 12. Click the Relationship list and select any value");
	objContactcs.selectRelationship(Relationship);
	
	report.log(LogStatus.INFO, "Step 13. Enter the desired information into the Last Name field. Enter a valid value ");
	objContactcs.enterLastName(LastName);
	
	report.log(LogStatus.INFO, "Step 14. Enter the desired information into the First Name field. Enter a valid value ");
	objContactcs.enterFirstName(FirstName);
	
	report.log(LogStatus.INFO, "Step 15. Click the Title list and select any value");
	objContactcs.selectTitle(Title);
	
	report.log(LogStatus.INFO, "Step 16. Click the Gender list and select any value");
	objContactcs.selectGender(Gender);
	
	report.log(LogStatus.INFO, "Step 17. Scroll down to enter the phone number ");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 18. Enter the desired information into the Date Of Birth field. Enter a valid value ");
	objContactcs.enterDateOfBirth(DateOfBirth);
	
	report.log(LogStatus.INFO, "Step 19. Click on + Add button to enter phonenumber");
	objContactcs.clickNewPhoneNumber();
	
	report.log(LogStatus.INFO, "Step 20. Click the Number Type list and select any value");
	objContactcs.selectType(NumberType);
	
	report.log(LogStatus.INFO, "Step 21. Click the Country Code list and select any value");
	//objContactcs.selectCountryCode(CountryCode);
	
	report.log(LogStatus.INFO, "Step 22. Enter the desired information into the Number field. Enter a valid value ");
	objContactcs.enterPhoneNumber(PhoneNumber);
	
	report.log(LogStatus.INFO, "Step 23. Scroll up to save the information");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 24. Click on Save and Close button to save the information");
	objPIPage.clickSaveAndCloseButton();
	//objPIPage.clickCancelButton();
	
/*	report.log(LogStatus.INFO, "Step 25. Click on Sign Out link to sign out from application");
	objHome.clickImgHome();
	objHome.clickUserIcon();
	objHome.clickSignOut();
	
	report.log(LogStatus.INFO, "Step 26. Click on Confirm button to sign out from application");
	SignOffPage objSignOff = new SignOffPage(driver,report);
	objSignOff.clickConfirm();*/
		
	sAssert.assertAll();
			
}

}
