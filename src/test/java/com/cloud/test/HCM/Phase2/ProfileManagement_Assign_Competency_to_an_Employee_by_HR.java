/**
 Test Name: ProfileManagement_Assign_Competency_to_an_Employee_by_HR
 Created By: Ciber
 Creation Date:July 17,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to assign competency to an employee
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
import com.cloud.pageobjects.HCM.PersonManagementPage;
import com.cloud.pageobjects.HCM.SearchProfilesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class ProfileManagement_Assign_Competency_to_an_Employee_by_HR extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to assign competency to an employee")	
	public void PM_Assign_Competency_Employee(String UserName,String Password,String SearchName,String FullName,String AddContent,String Name,String Proficiency,String EvaluationType) throws TestException,InterruptedException
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
		
		report.log(LogStatus.INFO, "Step 11. Click the Manage Employment link");
		objPMP.clickManageTalentProfileLink();
		if(objPMP.isManageTalentProfileLinkClicked()) 
		{
			report.log(LogStatus.PASS, "Step 11.1.ManageTalentProfileLink is clicked successfully");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.ManageTalentProfileLink is not clicked");	
		}
		
		report.log(LogStatus.INFO, "Step 12. Click the Edit button.");
		objPMP.clickMTPEditButton();
		
		report.log(LogStatus.INFO, "Step 13. Click the Add Content menu");
		report.log(LogStatus.INFO, "Step 14. Click the Duties and Competencies list item.");
		if(AddContent != "")
		{
			objPMP.selectAddContentMenu(AddContent);
			report.log(LogStatus.PASS, "Step 14.1.Add Content menu value is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Add Content menu value is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 15. Click the *Name list");
		report.log(LogStatus.INFO, "Step 16. Click the Oral Communication list item");
		if(Name != "")
		{
			objPMP.selectName(Name);
			report.log(LogStatus.PASS, "Step 16.1.Name value is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 16.1.Name value is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click the *Proficiency list");
		report.log(LogStatus.INFO, "Step 18. Click the Exceeds expectations list item.");
		if(Proficiency != "")
		{
			objPMP.selectProficiency(Proficiency);
			report.log(LogStatus.PASS, "Step 18.1.Proficiency value is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 18.1.Proficiency value is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 19. Click the *Evaluation Type list");
		report.log(LogStatus.INFO, "Step 20. Click the Supervisor list item");
		if(EvaluationType != "")
		{
			objPMP.selectEvaluationType(EvaluationType);
			report.log(LogStatus.PASS, "Step 20.1.EvaluationType value is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 20.1.EvaluationType value is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 21. Click the Submit button.");
		objPMP.clickReviewSubmitButton();
		
		report.log(LogStatus.INFO, "Step 22. Click the OK button.");
		objPMP.clickOKButton();
		
		report.log(LogStatus.INFO, "Step 23. Click the Done button");
		objPMP.clickDoneButton();
		
		sAssert.assertAll();
				
	}

}