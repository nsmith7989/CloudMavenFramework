/**
 Test Name: TC_CoreHR_NewHire
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Hire a new Employee
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
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_CoreHR_NewHire_of_an_Employee extends BaseWebTest  {
SoftAssert sAssert;

public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Hire a new Employee")	
public void HCM_CoreHR_NewHire(String UserName,String Password,String HireDateDayNumber,String HireReason,String LegalEmployer,String LastName,
		String FirstName,String Title,String Gender,String DOBMonth,String DOBYear,String DOBDayNumber,String AddressLine1,
		String AddressLine2,String City,String State,String ZipCode,String PhoneType,String PhoneNumber,String MartialStatus,
		String BusinessUnit,String SearchJobText,String JobType) throws TestException,InterruptedException, TestException
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
	
	report.log(LogStatus.INFO, "Step 5. Click on New Person link and verify its navigated to New Workers Process Page or not");
	NewWorkersProcessPage objNWP=objHome.clickNewPersonLink();
	if(objNWP.isDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 5.1.Navigation to New Workers Process is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 5.1.Navigation to New Workers Process is failed");	
	}
	
	
	report.log(LogStatus.INFO, "Step 6. Click the Tasks button");
	objNWP.clickTasksButton();
	
	report.log(LogStatus.INFO, "Step 7. Click the Hire an Employee link and verify its navigated to Hire an Employee screen or not");
	objNWP.clickHireEmpLink();
	
	if(objNWP.isHireAnEmpIdentificationTxtDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 7.1.Navigation to Hire an Employee screen  is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 7.1.Navigation to Hire an Employee screen  is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 8. Click the Select Date button");
	objNWP.clickHireDatePicker();
	
	report.log(LogStatus.INFO, "Step 9. Click the 19 cell.");
	if(HireDateDayNumber != "")
	{
		objNWP.selectHireDayFromDate(HireDateDayNumber);
		report.log(LogStatus.PASS, "Step 9.1.Selected given day from the Hire Date Picker");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 9.1.Given day from the Hire Date Picker is not selected");
	}
	
	
	report.log(LogStatus.INFO, "Step 10. Click the Hire Reason list and select the Hire to fill vacant place list item.");
	if(HireReason != "")
	{
		objNWP.selectHireReason(HireReason);
		report.log(LogStatus.PASS, "Step 10.1.Hire Reason is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 10.1.Selection of Hire Reason is failed");
	}
	
	
	report.log(LogStatus.INFO, "Step 11. Click the Legal Employer list");
	//objNWP.selectLegalEmp(LegalEmployer);
	
	report.log(LogStatus.INFO, "Step 12. Click in the Last Name field. Enter the desired information into the Last Name field. Enter a valid value");
	if(LastName != "")
	{
		objNWP.enterLastName(LastName);
		report.log(LogStatus.PASS, "Step 12.1.LastName is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 12.1.LastName is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 13. Click in the First Name field. Enter the desired information into the First Name field. Enter a valid value");
	if(FirstName != "")
	{
		objNWP.enterFirstName(FirstName);
		report.log(LogStatus.PASS, "Step 13.1.FirstName is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 13.1.FirstName is not entered");
	}
	
	//Mr.,Ms.,Miss,Doctor
	report.log(LogStatus.INFO, "Step 14. Click the Title list and select the Mr. list item");
	if(Title != "")
	{
		objNWP.selectTitle(Title);
		report.log(LogStatus.PASS, "Step 14.1.Title is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 14.1.Selection of Title is failed");
	}
	
	report.log(LogStatus.INFO, "Step 15. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 16. Click the Gender list and select the Male list item");
	if(Gender != "")
	{
		objNWP.selectGender(Gender);
		report.log(LogStatus.PASS, "Step 16.1.Gender is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 16.1.Selection of Gender is failed");
	}
	
	report.log(LogStatus.INFO, "Step 17. Click the Date Of Birth picker");
	objNWP.clickDateOfBirthPicker();
	
	report.log(LogStatus.INFO, "Step 18. Click the Select Month list and Click the January list item.");
	if(DOBMonth != "")
	{
		objNWP.selectMonth(DOBMonth);
		report.log(LogStatus.PASS, "Step 18.1.Date Oof Birth Month is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 18.1.Selection of Date Oof Birth Month is failed");
	}
	
	report.log(LogStatus.INFO, "Step 19. Click in the Select Year field. Press [Delete]. ");
	report.log(LogStatus.INFO, "Step 20. Enter the desired information into the Select Year field. Enter a valid value");
	if(DOBYear != "")
	{
		objNWP.enterYear(DOBYear);
		report.log(LogStatus.PASS, "Step 20.1.Date Oof Birth Year is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 20.1.Selection of Date Oof Birth Year is failed");
	}
	
	report.log(LogStatus.INFO, "Step 21. Click the 1 cell.");
	if(DOBDayNumber != "")
	{
		objNWP.selectDOBDayFromDate(DOBDayNumber);
		report.log(LogStatus.PASS, "Step 21.1.Date Oof Birth day number is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 21.1.Selection of Date Oof Birth day number is failed");
	}
	
	report.log(LogStatus.INFO, "Step 22. Click the vertical scrollbar to scroll up.");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	//report.log(LogStatus.INFO, "Step 11. Click the Legal Employer list");
	if(LegalEmployer != "")
	{
		objNWP.selectLegalEmp(LegalEmployer);
		report.log(LogStatus.PASS, "Step 11.1.LegalEmployer is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 11.1.Selection of LegalEmployer is failed");
	}
	
	report.log(LogStatus.INFO, "Step 23. Click Next button");
	objNWP.clickNextButton();
	
	/*if(!(objNWP.isSameDataAlertDisplayed()))
	{
		report.log(LogStatus.PASS, "Step 24. Same mathcing data message popup is not displayed ");
	}
	else
	{
		objNWP.clickContinueButton();
	}*/
	
	report.log(LogStatus.INFO, "Step 25. Verify that Personal Information page is displayed or not");
	if(objNWP.isPIPageDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 25.1.Navigation to Personal Information page is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 25.1.Navigation to Personal Information page is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 26. Click in the Address Line 1 field. Enter the desired information into the Address Line 1 field. Enter a valid value ");
	if(AddressLine1 != "")
	{
		objNWP.enterAddressLine1(AddressLine1);
		report.log(LogStatus.PASS, "Step 26.1.AddressLine1 is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 26.1.AddressLine1 is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 27. Click in the Address Line 2 field. Enter the desired information into the Address Line 2 field. Enter a valid value ");
	if(AddressLine2 != "")
	{
		objNWP.enterAddressLine2(AddressLine2);
		report.log(LogStatus.PASS, "Step 27.1. AddressLine2 is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 27.1. AddressLine2 is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 28. Click in the City field. Enter the desired information into the City field. Enter a valid value");
	if(City != "")
	{
		objNWP.enterCity(City);
		report.log(LogStatus.PASS, "Step 28.1. City is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 28.1. City is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 29. Click in the State field. Enter the desired information into the State field. Enter a valid value");
	if(State != "")
	{
		objNWP.enterState(State);
		report.log(LogStatus.PASS, "Step 29.1. State is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 29.1. State is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 30. Click in the Postal Code field. Enter the desired information into the Postal Code field. Enter a valid value");
	if(ZipCode != "")
	{
		objNWP.enterPostalCode(ZipCode);
		report.log(LogStatus.PASS, "Step 30.1. ZipCode is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 30.1. ZipCode is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 31. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 700);
	
	report.log(LogStatus.INFO, "Step 32. Click the Add Row button");
	objNWP.clickPhoneAddNew();
	
	report.log(LogStatus.INFO, "Step 33. Click the *Type list. Click the Home Mobile Phone list item");
	if(PhoneType != "")
	{
		objNWP.selectPhoneType(PhoneType);
		report.log(LogStatus.PASS, "Step 33.1.PhoneType is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 33.1.Selection of PhoneType is failed");
	}
	
	report.log(LogStatus.INFO, "Step 34. Click in the *Number field.Enter the desired information into the *Number field. Enter a valid value");
	if(PhoneNumber != "")
	{
		objNWP.enterPhoneNumber(PhoneNumber);
		report.log(LogStatus.PASS, "Step 34.1. PhoneNumber is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 34.1. PhoneNumber is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 35. Click the Marital Status list.Click the Married list item");
	if(MartialStatus != "")
	{
		objNWP.selectMartialStatus(MartialStatus);
		report.log(LogStatus.PASS, "Step 35.1.MartialStatus is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 35.1.Selection of MartialStatus is failed");
	}
	
	report.log(LogStatus.INFO, "Step 36. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 37. Click Next button");
	objNWP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 38. Verify that Employee Information screen is displayed or not");
	if(objNWP.isEmployeeInforamtionTxtDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 38.1.Navigation to Personal Information screen is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 38.1.Navigation to Personal Information screen is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 39. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 40. Click the Business Unit list");
	report.log(LogStatus.INFO, "Step 41. Click the Ciber1 Business Unit object.");
	if(BusinessUnit != "")
	{
		objNWP.selectBusinessUnit(BusinessUnit);
		report.log(LogStatus.PASS, "Step 41.1.BusinessUnit is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 41.1.Selection of BusinessUnit is failed");
	}
	
	report.log(LogStatus.INFO, "Step 42. Click the Job list.");
	objNWP.clickJobDropdown();
	
	report.log(LogStatus.INFO, "Step 43. Click the Search... link.");
	objNWP.clickSearchLink();
	
	report.log(LogStatus.INFO, "Step 44. Click in the Name field.Enter the desired information into the Name field. Enter a valid value");
	if(SearchJobText != "")
	{
		objNWP.enterSearchName(SearchJobText);
		report.log(LogStatus.PASS, "Step 44.1. SearchJobText is entered successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 44.1. SearchJobText is not entered");
	}
	
	report.log(LogStatus.INFO, "Step 45. Click the Search button.");
	objNWP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 46. Click in the Analyst field.");
	if(JobType != "")
	{
		objNWP.selectJob(JobType);
		report.log(LogStatus.PASS, "Step 46.1.JobType is selected successfully");
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 46.1.Selection of JobType is failed");
	}
	
	report.log(LogStatus.INFO, "Step 47. Click the OK button.");
	objNWP.clickSearchOkButton();
	
	report.log(LogStatus.INFO, "Step 48. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -500);
	
	report.log(LogStatus.INFO, "Step 49. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -500);
	
	report.log(LogStatus.INFO, "Step 50. Click Next button");
	objNWP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 51. Verify that Compensation and Other Information screen is displayed or not");
	if(objNWP.isCompAndOtherInfoDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 51.1.Navigation to Compensation and Other Information screen is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 51.1.Navigation to Compensation and Other Information screen is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 52. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 53. Click the vertical scrollbar to scroll up");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 54. Click Next button");
	objNWP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 55. Verify that Review screen is displayed or not");
	if(objNWP.isEmployeeReviewPageDisplayed()) 
	{
		report.log(LogStatus.PASS, "Step 55.1.Navigation to Review screen is success");	
	}
	else
	{
		report.log(LogStatus.FAIL, "Step 55.1.Navigation to Review screen is failed");	
	}
	
	report.log(LogStatus.INFO, "Step 56. Actual Legal Employer is: "+objNWP.getLegEmpTxt()+" and Expected is: "+LegalEmployer);
	sAssert.assertEquals(objNWP.getLegEmpTxt(),LegalEmployer,"Actaul and Exepced Legal Employer is not matching ");
	
	report.log(LogStatus.INFO, "Step 57. Actual Hire Reason is: "+objNWP.getHireReason()+" and Expected is: "+HireReason);
	sAssert.assertEquals(objNWP.getHireReason(),HireReason,"Actaul and Exepced ActionReason is not matching ");
	
	report.log(LogStatus.INFO, "Step 58. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 100);
	
	report.log(LogStatus.INFO, "Step 59. Actual Last Name is: "+objNWP.getLastNameTxt()+" and Expected is: "+LastName);
	sAssert.assertEquals(objNWP.getLastNameTxt(),LastName,"Actaul and Exepced Last Name is not matching ");
	
	report.log(LogStatus.INFO, "Step 60. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 61. Actual Business Unit is: "+objNWP.getBusUnitTxt()+" and Expected is: "+BusinessUnit);
	sAssert.assertEquals(objNWP.getBusUnitTxt(),BusinessUnit,"Actaul and Exepced BusinessUnit is not matching ");
	
	report.log(LogStatus.INFO, "Step 62. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 300);
	
	report.log(LogStatus.INFO, "Step 63. Actual JobType is: "+objNWP.getJobTypeTxt()+" and Expected is: "+JobType);
	sAssert.assertEquals(objNWP.getJobTypeTxt(),JobType,"Actaul and Exepced Last Name is not matching ");
	
	report.log(LogStatus.INFO, "Step 64. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 65. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 66. Click the vertical scrollbar to scroll down");
	SeleniumUtils.scroll(driver, 0, 200);
	
	report.log(LogStatus.INFO, "Step 67. Click the vertical scrollbar to scroll Up");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 68. Click the Submit button.");
	objNWP.clickSubmitButton();
	
	report.log(LogStatus.INFO, "Step 69. Click the Yes button on confirmation dailog");
	objNWP.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 70. Click the OK button.");
	objNWP.clickOKButton();
	
	sAssert.assertAll();

}

}
