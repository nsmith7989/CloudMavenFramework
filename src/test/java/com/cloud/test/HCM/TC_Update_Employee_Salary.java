/**
 Test Name: TC_Update_Employee_Salary
 Created By: Ciber
 Creation Date:April 20,2018
 Modified By:
 Modified Date:
 Test Description: 
•	Correct the current or previous salary proposals.
•	Enter a new salary proposal between two current salary proposals.
•	Delete the current or previous salary proposals.
•	Delete a salary proposal leaving a gap between two existing salary proposals.

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
public class TC_Update_Employee_Salary extends BaseWebTest  {
SoftAssert sAssert;


public WebDriverWait wdwait;

@Test(dataProvider = "CloudDataProviderUtil_HCM", dataProviderClass = DataProviderRepository.class, description = "This test is to Update an Employee Salary")	
public void Update_Employee_Salary(String UserName,String Password,String SearchName,String FullName,String ActionType,String SelectDate,String SalaryBasis,String SalaryAmount) throws TestException,InterruptedException, TestException
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

	report.log(LogStatus.INFO, "Step 10. Click the Tasks button.");
	objPMP.clickTasksButton();
	
	report.log(LogStatus.INFO, "Step 11. Click the Manage Salary link");
	objPMP.clickManageSalaryLink();
	
	/*report.log(LogStatus.INFO, "Step 11. Click the Manage Employment link");
	objPMP.clickManageEmployementLink();
	
	report.log(LogStatus.INFO, "Step 12. Click the Edit button.");
	objPMP.clickEditButton();
	
	report.log(LogStatus.INFO, "Step 13. Click the Correct list item.");
	objPMP.selectCorrectFromEditList();
	*/
	
	report.log(LogStatus.INFO, "Step 12. Click the Propose New Salary button.");
	objPMP.clickProposeNewSalButton();
	
	report.log(LogStatus.INFO, "Step 13. Enter the SelectDate date");
	objPMP.enterSelectDate(SelectDate);
	
	report.log(LogStatus.INFO, "Step 14. Click the Action list and Click the Change Salary list item.");
	objPMP.clickSalAction();
	objPMP.selectActionName(ActionType);
	
	report.log(LogStatus.INFO, "Step 15. Click the OK button");
	objPMP.clickOKButton();
	
	report.log(LogStatus.INFO, "Step 16. Click the Salary Basis list and enter Biweekly Basis value");
	objPMP.enterSalaryBasis(SalaryBasis);
	
	report.log(LogStatus.INFO, "Step 17. Click in the Salary Amount field.");
	report.log(LogStatus.INFO, "Step 18. Press [Delete].");
	report.log(LogStatus.INFO, "Step 19. Enter the desired information into the Salary Amount field.");
	objPMP.enterSalaryAmount(SalaryAmount);
	
	report.log(LogStatus.INFO, "Step 20. Scroll up to click the Review button");
	SeleniumUtils.scroll(driver, 0, -500);
	
	report.log(LogStatus.INFO, "Step 21. Click the Continue button.");
	objPMP.clickContinueButton();
	
	report.log(LogStatus.INFO, "Step 22. Click the Submit button.");
	objPMP.clickContinueSubmitButton();
	
	report.log(LogStatus.INFO, "Step 23. Click the Yes button on confirmation dailog");
	objPMP.clickConfirmatioDialog("Yes");
	
	report.log(LogStatus.INFO, "Step 24. Click the OK button.");
	objPMP.clickOKButton();
	
	report.log(LogStatus.INFO, "Step 25. Click the Done button");
	objPMP.clickDoneButton();
	
	sAssert.assertAll();

}

}
