/**
 Test Name: GM_Add_goals_from_GoalLibrary_by_an_Employee
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to Add goals from Goal library by an Employee
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
import com.cloud.pageobjects.HCM.GoalsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class GM_Add_goals_from_GoalLibrary_by_an_Employee extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to Add goals from Goal library by an Employee")	
	public void GM_Add_Goals_from_GL_by_Emp(String UserName,String Password,String GoalType,String GoalName) throws TestException,InterruptedException
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
		
		report.log(LogStatus.INFO, "Step 5. Click the Goals Link");
		GoalsPage objgoal=objHome.clickGoals();
		if(objgoal.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Goals Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Goals Page is failed");	
		}
		
		
		report.log(LogStatus.INFO, "Step 6. Click the Add Goal button");
		objgoal.clickAddGoalButton();
		
		report.log(LogStatus.INFO, "Step 7. Click the Library Goal list item");
		objgoal.selectGoalType(GoalType);
		
		report.log(LogStatus.INFO, "Step 8. Click in the Goal Name List");
		objgoal.clickGoalNameList();
		report.log(LogStatus.INFO, "Step 9. Enter the desired information into the Goal Name field");
		if(GoalName != "")
		{
			objgoal.selectGoalName(GoalName);
			report.log(LogStatus.PASS, "Step 9.1.Goal Name is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Value of Goal Name is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click the Save and Close button.");
		objgoal.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 11. Click the OK button.");
		objgoal.clickGLOKButton();
				
		sAssert.assertAll();
				
	}

}