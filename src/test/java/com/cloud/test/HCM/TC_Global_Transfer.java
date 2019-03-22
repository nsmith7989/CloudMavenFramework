/**
 Test Name: TC_Global_Transfer
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Global Transfer
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
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class TC_Global_Transfer extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Global Transfer_")	
public void Global_Transfer(String UserName,String Password,String SearchName,String FullName,String ActionType,String StartDate,String LegalEmpoyer,String BusinessUnit) throws TestException,InterruptedException, TestException
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
	
	report.log(LogStatus.INFO, "Step 7. Click the Search button");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 8. Scroll down to see the results ");
	SeleniumUtils.scroll(driver, 0, 1000);

	report.log(LogStatus.INFO, "Step 9. Click the Name link. ");
	objPMP.selectPersonName(FullName);
	
	report.log(LogStatus.INFO, "Step 10. Click the Edit button.");
	objPMP.clickEditButton();
	
	report.log(LogStatus.INFO, "Step 11. Click the Update list item.");
	objPMP.clickUpdateList();
	
	report.log(LogStatus.INFO, "Step 12. Select the StartDate");
	objPMP.enterEffectiveStartDate(StartDate);
	
	report.log(LogStatus.INFO, "Step 12. Click the Action list and Click the Global Transfer list item");
	objPMP.selectAction(ActionType);
	
	report.log(LogStatus.INFO, "Step 13. Click the Destination Legal Employer list.");
	objPMP.clickDestLegEmpButton();
	
	report.log(LogStatus.INFO, "Step 14. Click the Search... link.");
	objPMP.clickSearchFromDestLegEmpList();
	
	report.log(LogStatus.INFO, "Step 15. Enter the desired information into the Legal Employer field. Enter a valid value");
	objPMP.enterLegalEmployer("ciber");
	
	report.log(LogStatus.INFO, "Step 16. Click the Search button.");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 17. Click the Ciber India cell");
	objPMP.selectLegEmployer(LegalEmpoyer);
	
	report.log(LogStatus.INFO, "Step 18. Click the OK button");
	objPMP.clickLegEmpOKButton();
	
	report.log(LogStatus.INFO, "Step 19. Click the OK button");
	objPMP.clickUpdateOKButton();
	
	report.log(LogStatus.INFO, "Step 20. Click the OK button");
	objPMP.clickASOKButton();
	
	report.log(LogStatus.INFO, "Step 21. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 22. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 23. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 24. Click the Next button");
	objPMP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 25. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 26. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 27. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 28. Click the Next button");
	objPMP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 29. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 30. Click the Business Unit list");
	objPMP.clickBusinessUnitLink();
	
	report.log(LogStatus.INFO, "Step 31. Click the Search... link.");
	objPMP.clickSearchLink();
	
	report.log(LogStatus.INFO, "Step 32. Enter the desired information into the Business Unit field");
	objPMP.enterBusinessUnit("ciber");
	
	report.log(LogStatus.INFO, "Step 33. Click the Search button.");
	objPMP.clickSearchButton();
	
	report.log(LogStatus.INFO, "Step 34. Click the Ciber BU cell.");
	objPMP.selectBusinessUnit(BusinessUnit);
	
	report.log(LogStatus.INFO, "Step 35. Click the OK button.");
	objPMP.clickBUOKButton();
	
	report.log(LogStatus.INFO, "Step 36. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 37. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 500);
	
	report.log(LogStatus.INFO, "Step 38. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 39. Click the Next button");
	objPMP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 40. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 41. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, -1000);
	
	report.log(LogStatus.INFO, "Step 42. Click the Next button");
	objPMP.clickNextButton();
	
	report.log(LogStatus.INFO, "Step 43. Verify that Global Transfer: Review page is displayed or not");
	sAssert.assertTrue(objPMP.isGlobalTransferReviewPageDisplayed());
	
	report.log(LogStatus.INFO, "Step 44. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 45. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 46. Verify ActionType is updated with expected one or not");
	sAssert.assertEquals(objPMP.getActionText(),ActionType,"Actaul and Exepced ActionType is not matching ");
	
	report.log(LogStatus.INFO, "Step 44. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 45. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 46. Verify LegalEmpoyer is updated with expected one or not");
	sAssert.assertEquals(objPMP.getLegalEmpoyerText(),LegalEmpoyer,"Actaul and Exepced LegalEmpoyer is not matching ");
	
	report.log(LogStatus.INFO, "Step 47. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 48. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 49. Click the vertical scrollbar");
	SeleniumUtils.scroll(driver, 0, 1000);
	
	report.log(LogStatus.INFO, "Step 50. Verify BusinessUnit is updated with expected one or not");
	sAssert.assertEquals(objPMP.getBusinessUnitText(),BusinessUnit,"Actaul and Exepced BusinessUnit is not matching ");
	
	report.log(LogStatus.INFO, "Step 51. Click the scroll up to click on submit button ");
	SeleniumUtils.scroll(driver, 0, -2000);
	
	report.log(LogStatus.INFO, "Step 52. Click the Submit button.");
	objPMP.clickReviewSubmitButton();;
	
	report.log(LogStatus.INFO, "Step 53. Click the Yes button on confirmation dailog");
	objPMP.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 54. Click the OK button.");
	objPMP.clickOKButton();
	
	sAssert.assertAll();

}

}
