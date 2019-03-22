/**
 Test Name: TC_CoreHR_Rehire_of_an_Employee
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Re Hire an Employee
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
import com.cloud.pageobjects.HCM.NewWorkersProcessPage;
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_CoreHR_Rehire_of_an_Employee extends BaseWebTest  {
SoftAssert sAssert;

public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Re Hire an Employee",enabled=true)	
public void HCM_CoreHR_ReHire(String UserName,String Password,String SearchName,String PersonName,String ActionsList,String NotifacationsDateDayNumber,
		String RevokeUserAccess,String LegalEmployer,String LastName,String FirstName,String AddressLine1,String City,String State,String ZipCode,
		String BusinessUnit) throws TestException,InterruptedException, TestException
{

	sAssert=new SoftAssert();
	report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
	LoginPage objLogin = new LoginPage(driver, report);
	sAssert.assertTrue(objLogin.isUserNameDisplayed());
	
	report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
	HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
	
	report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
	sAssert.assertTrue(objHome.isHomeImageDisplayed());
	
	report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
	objHome.clickNavigatorIcon();
	
	report.log(LogStatus.INFO, "Step 5. Click on Person Management link");
	PersonManagementPage objPMP=objHome.clickPersonManagement();
	
	report.log(LogStatus.INFO, "Step 6. Enter the desired information into the Name field. Enter a valid value");
	objPMP.enterName(SearchName);
	//objPMP.enterName("bettina");
	
	report.log(LogStatus.INFO, "Step 7. Click the Search button");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 8. Scroll down to see the results ");
	SeleniumUtils.scroll(driver, 0, 1000);
		
	report.log(LogStatus.INFO, "Step 9. Click the Name link. ");
	objPMP.selectPersonName(PersonName);
	//objPMP.selectPersonName("Verlaine, Bettina");
	
	report.log(LogStatus.INFO, "Step 10. Click the Name link. ");
	objPMP.clickCloseTabButton();
	
	report.log(LogStatus.INFO, "Step 11. Click the Tasks button.");
	objPMP.clickTasksButton();
	
	report.log(LogStatus.INFO, "Step 12. Click the vertical scrollbar");
	//objPMP.scrollTasksTab();
	
	report.log(LogStatus.INFO, "Step 13. Click the Manage Work Relationship link");
	objPMP.clickManageWorkRelationshipLink();
	
	report.log(LogStatus.INFO, "Step 14. Click the Actions button and Click the Terminate list item.");
	objPMP.clickActionsList("Terminate");
	
	report.log(LogStatus.INFO, "Step 15. Select Resignation item from Action dropdown");
	objPMP.selectTerminateAction(ActionsList);
	
	report.log(LogStatus.INFO, "Step 16. Click the Select Notification  Date button");
	objPMP.clickNotificationDatePicker();
	
	report.log(LogStatus.INFO, "Step 17. Click the 20 cell.");
	if(NotifacationsDateDayNumber != "")
	{
		objPMP.selectNotifacationsDayFromDate(NotifacationsDateDayNumber);
		report.log(LogStatus.PASS, "Step 17.1.Selected given day from the Notifications Date Picker");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 17.1.Given day from the Notifications Date Picker is not selected");
	}
	
	report.log(LogStatus.INFO, "Step 18. Click the vertical scrollbar down");
	SeleniumUtils.scroll(driver, 0, 800);
	
	report.log(LogStatus.INFO, "Step 18. Click the Immediately option");
	if(RevokeUserAccess != "")
	{
		objPMP.selectRevokeUserAccess(RevokeUserAccess);
		report.log(LogStatus.PASS, "Step 18.1.Immediately option is selected");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 18.1.Immediately option is not selected");
	}
	
	report.log(LogStatus.INFO, "Step 19. Click the vertical scrollbar up");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 20. Click the Review button");
	objPMP.clickReviewButton();
	
	report.log(LogStatus.INFO, "Step 21. Use the Vijay Naik: Review Terminate Work Relationship page to verify the changes");
	sAssert.assertTrue(objPMP.isReviewDetailsDisplayed());
	
	report.log(LogStatus.INFO, "Step 22. Click the Submit button.");
	objPMP.clickReviewSubmitButton();
	
	report.log(LogStatus.INFO, "Step 23. Click the Yes button on confirmation dailog");
	objPMP.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 24. Click the OK button.");
	objPMP.clickOKButton();
	
	report.log(LogStatus.INFO, "Step 25. Click the Home button");
	objPMP.clickHomeButton();
	
	report.log(LogStatus.INFO, "Step 23. Click the Yes button on confirmation dailog");
	objPMP.clickConfirmatioDialog("Yes");
	SeleniumUtils.delay(5000);  //need to remove this and need to unblock the waitcode from this method
	
	
	report.log(LogStatus.INFO, "Step 26. Click on Navigator Icon");
	objHome.clickNavigatorIcon();
	
	report.log(LogStatus.INFO, "Step 27. Click on Person Management link");
	objHome.clickPersonManagement();
	
	report.log(LogStatus.INFO, "Step 28. Enter the desired information into the Name field. Enter a valid value");
	objPMP.enterName(SearchName);
	
	report.log(LogStatus.INFO, "Step 29. Click the Search button");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 30. Scroll down to see the results ");
	SeleniumUtils.scroll(driver, 0, 1000);
		
	report.log(LogStatus.INFO, "Step 31. Terminated employees should not be displayed in the search results");
	if (objPMP.verifyPersonNameExistsOrNot(PersonName)==false)
	{
		report.log(LogStatus.PASS, "Step 31.1.Terminated employees is not displayed in the search results");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 31.1.Terminated employees is displayed in the search results");
	}
	
	report.log(LogStatus.INFO, "Step 32. Click the Include terminated work relationships option.");
	objPMP.checkIncludeTerminateWorkRelationship();
	
	report.log(LogStatus.INFO, "Step 33. Click the Search button");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 34. Scroll down to see the results ");
	SeleniumUtils.scroll(driver, 0, 1000);
		
	report.log(LogStatus.INFO, "Step 35. Terminated employee shall now be displayed in the search results");
	if (objPMP.verifyPersonNameExistsOrNot(PersonName)==true)
	{
		report.log(LogStatus.PASS, "Step 35.1.Terminated employees is now displayed in the search results");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 35.1.Terminated employees is not displayed in the search results");
	}
	
	//Till above step termination process completed
	//From below step Rehire process for the same employee starts
	
	report.log(LogStatus.INFO, "Step 36. Click the Home button");
	objPMP.clickHomeButton();
	
	report.log(LogStatus.INFO, "Step 37. Click on Navigator Icon");
	objHome.clickNavigatorIcon();
	
	report.log(LogStatus.INFO, "Step 38. Click on New Person link and verify its navigated to New Workers Process Page or not");
	NewWorkersProcessPage objNWP=objHome.clickNewPersonLink();
	if(objNWP.isDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 39.1.Navigation to New Workers Process is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 39.1.Navigation to New Workers Process is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 40. Click the Tasks button");
	objNWP.clickTasksButton();
	
	report.log(LogStatus.INFO, "Step 41. Click the Hire an Employee link and verify its navigated to Hire an Employee screen or not\"");
	objNWP.clickHireEmpLink();
	
	if(objNWP.isHireAnEmpIdentificationTxtDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 41.1.Navigation to Hire an Employee screen  is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 41.1.Navigation to Hire an Employee screen  is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 42. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 300);
	
	
	report.log(LogStatus.INFO, "Step 43. Click in the Last Name field. Enter the desired information into the Last Name field. Enter a valid value");
	if(LastName != "")
	{
		objNWP.enterLastName(LastName);
		report.log(LogStatus.PASS, "Step 43.1.LastName is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 43.1.LastName is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 44. Click in the First Name field. Enter the desired information into the First Name field. Enter a valid value");
	if(FirstName != "")
	{
		objNWP.enterFirstName(FirstName);
		report.log(LogStatus.PASS, "Step 44.1.FirstName is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 44.1.FirstName is not entered");
	}
	
	
	String LegalEmployer1="Prospective US Legal entity";
	if(LegalEmployer1 != "")
	{
		report.log(LogStatus.INFO, "Step 45. Click the Legal Employer list");
		objNWP.clickDestLegEmpButton();
		
		report.log(LogStatus.INFO, "Step 46. Click the Search... link.");
		objNWP.clickSearchFromDestLegEmpList();
		
		report.log(LogStatus.INFO, "Step 47. Enter the desired information into the Legal Employer field. Enter a valid value");
		objNWP.enterLegalEmployer("prospective");
		
		report.log(LogStatus.INFO, "Step 48. Click the Search button.");
		objNWP.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 49. Click the Ciber India cell");
		objNWP.selectLegEmployer(LegalEmployer1);
		
		report.log(LogStatus.INFO, "Step 50. Click the OK button");
		objNWP.clickLegEmpOKButton();
		
//		objNWP.selectLegEmp(LegalEmployer1);
		
		report.log(LogStatus.PASS, "Step 50.1.LegalEmployer is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 50.1.Selection of LegalEmployer is failed");
	}
	
	
	report.log(LogStatus.INFO, "Step 51. Click the vertical scrollbar to scroll up.");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 52. Click Next button and As the employee work relationship already exists, system shows the matching record for that employee. ");
	objNWP.clickNextButton();
	
	if((objNWP.isSameDataAlertDisplayed()))
	{
		report.log(LogStatus.PASS, "Step 53. Same mathcing data message popup is displayed ");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 54. Same mathcing data message popup is not displayed");
	}
	
	report.log(LogStatus.INFO, "Step 55. Click the Select Person button");
	objNWP.clickSelectPerson();
	
	report.log(LogStatus.INFO, "Step 56. Click the OK button");
	objNWP.clickSelectPersonOK();
	
	report.log(LogStatus.INFO, "Step 57. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -500);
	
	report.log(LogStatus.INFO, "Step 58. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -500);
	
	report.log(LogStatus.INFO, "Step 59. Click Next button");
	objNWP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 60. Verify that Personal Information page is displayed or not");
	if(objNWP.isPIPageDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 60.1.Navigation to Personal Information page is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 60.1.Navigation to Personal Information page is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 61. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 62. Click in the City field. Enter the desired information into the City field. Enter a valid value");
	if(City != "")
	{
		objNWP.enterCity(City);
		report.log(LogStatus.PASS, "Step 62.1. City is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 62.1. City is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 63. Click in the State field. Enter the desired information into the State field. Enter a valid value");
	if(State != "")
	{
		objNWP.enterState(State);
		report.log(LogStatus.PASS, "Step 63.1. State is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 63.1. State is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 64. Click in the Postal Code field. Enter the desired information into the Postal Code field. Enter a valid value");
	if(ZipCode != "")
	{
		objNWP.enterPostalCode(ZipCode);
		report.log(LogStatus.PASS, "Step 64.1. ZipCode is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 64.1. ZipCode is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 65. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 66. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 67. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 68. Click Next button");
	objNWP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 69. Verify that Employee Information screen is displayed or not");
	if(objNWP.isEmployeeInforamtionTxtDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 69.1.Navigation to Personal Information screen is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 69.1.Navigation to Personal Information screen is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 70. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 400);
	
	report.log(LogStatus.INFO, "Step 71. Click the Business Unit list");
	report.log(LogStatus.INFO, "Step 72. Click the Ciber1 Business Unit object.");
	if(BusinessUnit != "")
	{
		objNWP.selectBusinessUnit(BusinessUnit);
		report.log(LogStatus.PASS, "Step 72.1.BusinessUnit is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 72.1.Selection of BusinessUnit is failed");
	}
	
	report.log(LogStatus.INFO, "Step 73. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 300);
	
	report.log(LogStatus.INFO, "Step 74. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 300);
	
	report.log(LogStatus.INFO, "Step 75. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 300);
	
	report.log(LogStatus.INFO, "Step 76. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 77. Click Next button");
	objNWP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 78. Verify that Compensation and Other Information screen is displayed or not");
	if(objNWP.isCompAndOtherInfoDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 78.1.Navigation to Compensation and Other Information screen is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 78.1.Navigation to Compensation and Other Information screen is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 79. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 80. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 81. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 82. Click Next button");
	objNWP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 83. Verify that Review screen is displayed or not");
	if(objNWP.isEmployeeReviewPageDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 83.1.Navigation to Review screen is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 83.1.Navigation to Review screen is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 84. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 100);
	
	report.log(LogStatus.INFO, "Step 85. Actual Last Name is: "+objNWP.getLastNameTxt()+" and Expected is: "+LastName);
	sAssert.assertEquals(objNWP.getLastNameTxt(),LastName,"Actaul and Exepced Last Name is not matching ");
	
	report.log(LogStatus.INFO, "Step 86. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	/*report.log(LogStatus.INFO, "Step 87. Actual Business Unit is: "+objNWP.getBusUnitTxt()+" and Expected is: "+BusinessUnit);
	sAssert.assertEquals(objNWP.getBusUnitTxt(),BusinessUnit,"Actaul and Exepced BusinessUnit is not matching ");
	*/
	
	report.log(LogStatus.INFO, "Step 88. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 300);
	
	report.log(LogStatus.INFO, "Step 89. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 90. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 91. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 92. Click the vertical scrollbar to scroll Up");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 93. Click the Submit button.");
	objNWP.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 94. Click the Yes button on confirmation dailog");
	objNWP.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 95. Click the OK button.");
	objNWP.clickOKButton();
	
	sAssert.assertAll();

}

}
