/**
 Test Name: GM_Create_New_Goal_Plan_by_HR
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to create a goal plan by HR
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
	public class GM_Create_New_Goal_Plan_by_HR extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to create a goal plan by HR")	
	public void GM_Create_New_Goal_by_HR(String UserName,String Password,String GoalPlanType,String GoalPlan,String GoalDescription,String ReviewPeriod,String GoalType,String GoalName,String SearchName,String WorkerName,String ModSearchName,String ModWorkerName) throws TestException,InterruptedException
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
		objgoal.clickManageGoalPlansLink();
		if(objgoal.isCreateGoalPlanButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 8.1.Clicked on Manage Goal Plans Link is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Clicked on Manage Goal Plans Link is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 9. Click the Create Goal Plan button");
		objgoal.clickCreateGoalPlanButton();
		if(objgoal.isGoalPlanTypeListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 9.1.Clicked on Create Goal Plan button is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Clicked on Create Goal Plan button is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 10. Click the Goal Plan Type list.");
		report.log(LogStatus.INFO, "Step 11. Select the Worker plan list item.");
		if(GoalPlanType != "")
		{
			objgoal.selectGoalPlanType(GoalPlanType);
			report.log(LogStatus.PASS, "Step 11.1.Worker plan is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Value of Worker plan is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click in the Goal Plan field");
		report.log(LogStatus.INFO, "Step 13. Enter the desired information into the Goal Plan field");
		if(GoalPlan != "")
		{
			objgoal.setGoalPlan(GoalPlan);
			report.log(LogStatus.PASS, "Step 13.1.Goal Plan is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Value of Goal Plan is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click the OK button");
		objgoal.clickOkButton();
		if(objgoal.isCreateGoalPlanPageDisplayed())
		{
			report.log(LogStatus.PASS, "Step 14.1.Clicked on OK button is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Clicked on OK button is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 15. Click in the Description field");
		report.log(LogStatus.INFO, "Step 16. Enter the desired information into the Description field");
		if(GoalDescription != "")
		{
			objgoal.enterDescription(GoalDescription);
			report.log(LogStatus.PASS, "Step 13.1.Goal Description is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Value of Goal Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click the Review Period list.");
		objgoal.clickReviewPeriodLink();
		
		report.log(LogStatus.INFO, "Step 18. Click the Ciber 2019 Review Period list item");
		if(ReviewPeriod != "")
		{
			objgoal.selectReviewPeriod(ReviewPeriod);
			report.log(LogStatus.PASS, "Step 18.1.Review Period is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 18.1.Value of Review Period is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 19. Click the Annual Evaluation list item");
		objgoal.checkPerfDocType();
		
		report.log(LogStatus.INFO, "Step 20. Click the Next button");
		objgoal.clickNextButton();
		if(objgoal.isCreateGoalPlanGoalsPageDisplayed())
		{
			report.log(LogStatus.PASS, "Step 20.1.Navigation to Create Goal Plan Goals Page successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 20.1.Navigation to Create Goal Plan Goals Page is failed");	
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
		
		report.log(LogStatus.INFO, "Step 26. Click the Improve presentation skills by enlisting help from a capable co-w cell.");
		objgoal.selectSearchGoalResult();
		
		report.log(LogStatus.INFO, "Step 27. Click the OK button");
		objgoal.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 28. Click the Next button");
		objgoal.clickNextButton();
		if(objgoal.isCreateGoalPlanPopulationPageDisplayed())
		{
			report.log(LogStatus.PASS, "Step 28.1.Navigation to Create Goal Plan Population Page successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 28.1.Navigation to Create Goal Plan Population Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 29. Click the Select individuals to whom you want to assign this goal plan set button");
		objgoal.clickSelIndTWAGPButton();
		
		report.log(LogStatus.INFO, "Step 30. Click in the Worker Name field");
		report.log(LogStatus.INFO, "Step 31. Enter the desired information into the Worker Name field.");
		if(SearchName != "")
		{
			objgoal.enterWorkerName(SearchName);
			report.log(LogStatus.PASS, "Step 31.1.Worker Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 31.1.Value of Worker Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 32. Click the Search button");
		objgoal.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 33. Click the Stone, Evangeline cell");
		if(WorkerName != "")
		{
			objgoal.selectWorkerName(WorkerName);
			report.log(LogStatus.PASS, "Step 33.1.Worker Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 33.1.Value of Worker Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 34. Click the Apply button");
		objgoal.clickApplyButton();
		
		report.log(LogStatus.INFO, "Step 35. Click in the Worker Name field");
		report.log(LogStatus.INFO, "Step 36. Press [Delete].");
		report.log(LogStatus.INFO, "Step 37. Enter the desired information into the Worker Name field.");
		objgoal.enterWorkerName(ModSearchName);
		
		report.log(LogStatus.INFO, "Step 38. Click the Search button");
		objgoal.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 39. Click the Stone, Evangeline cell");
		objgoal.selectWorkerName(ModWorkerName);
		
		report.log(LogStatus.INFO, "Step 40. Click the Apply button");
		objgoal.clickApplyButton();
		
		report.log(LogStatus.INFO, "Step 41. Click the Done button.");
		objgoal.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 42. Click the Save and Close button.");
		objgoal.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 43. Click the Done button.");
		objgoal.clickDoneButton();
		
		sAssert.assertAll();
				
	}

}