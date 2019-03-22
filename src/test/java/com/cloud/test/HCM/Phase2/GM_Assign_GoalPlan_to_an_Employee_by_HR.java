/**
 Test Name: GM_Assign_GoalPlan_to_an_Employee_by_HR
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to  Assign Goal Plan to an Employee by HR
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
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class GM_Assign_GoalPlan_to_an_Employee_by_HR extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to  Assign Goal Plan to an Employee by HR")	
	public void GM_Assign_Goal_to_Emp_by_HR(String UserName,String Password,String GoalPlanType,String GoalPlan,String GoalDescription,String ReviewPeriod,String GoalType,String GoalName,String SearchName,String WorkerName,String ModSearchName,String ModWorkerName,String ProcessName,String ToSelectGoalName) throws TestException,InterruptedException
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
		
		
		report.log(LogStatus.INFO, "Step 6. Click the My Team Goals Icon button");
		objgoal.clickMyTeamGoalsIcon();
		
		if(objgoal.isMyTeamGoalsPageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.Manage Content Types Link is displayed");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.Manage Content Types Link is not displayed");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Click Tasks button");
		objgoal.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 8. Click the Manage Goal Plans link");
		objgoal.clickMaassAssignGoalsLink();
		
		if(objgoal.isMassAssignTeamGoalsPageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 8.1.Clicked on Mass Assign Goals Link is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Clicked on Mass Assign Goals Link is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 9. Click the Create Mass Assignment button");
		objgoal.clickCreateMassAssignnButton();
		if(objgoal.isProcessNameDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 9.1.Clicked on Create Mass Assignment button is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Clicked on Create Mass Assignment button is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 10. Click in the Process Name field");
		report.log(LogStatus.INFO, "Step 11. Enter the desired information into the Process Name field");
		if(ProcessName != "")
		{
			objgoal.enterProcessName(ProcessName);
			report.log(LogStatus.PASS, "Step 11.1.Process Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Value of Process Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click the Select individuals to whom you want to assign this goal plan set button");
		objgoal.clickSelIndTWAGPButton();
		
		report.log(LogStatus.INFO, "Step 13. Click in the Worker Name field");
		report.log(LogStatus.INFO, "Step 14. Enter the desired information into the Worker Name field.");
		if(SearchName != "")
		{
			objgoal.enterWorkerName(SearchName);
			report.log(LogStatus.PASS, "Step 14.1.Worker Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Value of Worker Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 15. Click the Search button");
		objgoal.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 16. Click the Stone, Evangeline cell");
		if(WorkerName != "")
		{
			objgoal.selectWorkerName(WorkerName);
			report.log(LogStatus.PASS, "Step 16.1.Worker Name is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 16.1.Value of Worker Name is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click the Apply button");
		objgoal.clickApplyButton();
		
		report.log(LogStatus.INFO, "Step 18. Click the Done button.");
		objgoal.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 19. Click the Goal Plan Name list.");
		report.log(LogStatus.INFO, "Step 20. Click the 2018 Financial Year Goal Plan list item");
		if(GoalPlan != "")
		{
			objgoal.selectGoalPlanName(GoalPlan);
			report.log(LogStatus.PASS, "Step 20.1.Goal Plan Name is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 20.1.Value of Goal Plan Name is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 21. Click the Add Goal button");
		objgoal.clickAddGoalButton();
		
		report.log(LogStatus.INFO, "Step 22. Click the Library Goal list item");
		objgoal.selectGoalType(GoalType);
		
		report.log(LogStatus.INFO, "Step 23. Click in the Goal Name field");
		report.log(LogStatus.INFO, "Step 24. Enter the desired information into the Goal Name field");
		if(GoalName != "")
		{
			objgoal.enterGoalName(GoalName);
			report.log(LogStatus.PASS, "Step 24.1.Goal Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 24.1.Value of Goal Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 25. Click the Search button");
		objgoal.clickSearchResButton();
		
		report.log(LogStatus.INFO, "Step 26. Click the Gain upward feedback from team members before the end of the ... cell");
		objgoal.selectSearchGoalResult1(ToSelectGoalName);
		
		report.log(LogStatus.INFO, "Step 27. Click the OK button");
		objgoal.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 28. Scroll up to click Save and Close button");
		SeleniumUtils.scroll(driver, 0, -500);
		
		report.log(LogStatus.INFO, "Step 29. Click the Save and Close button.");
		objgoal.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 30. Click in the Process Name field");
		report.log(LogStatus.INFO, "Step 31. Enter the desired information into the Process Name field");
		if(ProcessName != "")
		{
			objgoal.enterProcessName(ProcessName);
			report.log(LogStatus.PASS, "Step 31.1.Process Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 31.1.Value of Process Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 32. Click the Search button.");
		objgoal.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 33. Click the Manage Scheduled Process button.");
		objgoal.clickManageScheduleProcessButton();
		
		report.log(LogStatus.INFO, "Step 34. Click the Submit button");
		objgoal.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 35. Note the Process number to view the process status.");
		String ProcessNum=objgoal.getProcessNum();
		
		report.log(LogStatus.INFO, "Step 36. Click the OK button");
		objgoal.clickGLOKButton();
		
		report.log(LogStatus.INFO, "Step 37. Click the Monitor Process button.");
		objgoal.clickMonitorProcessButton();
		
		report.log(LogStatus.INFO, "Step 38. Click Refresh button until status of the process is Succeeded");
		objgoal.clickRefreshIcon();
		
		report.log(LogStatus.INFO, "Step 39. The status of the scheduled process is Succeeded");
		objgoal.verifyProcessStatus(ProcessNum);
		
		sAssert.assertAll();
				
	}

}