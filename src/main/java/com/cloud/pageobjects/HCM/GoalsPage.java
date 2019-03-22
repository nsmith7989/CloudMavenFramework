package com.cloud.pageobjects.HCM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Contains object properties and methods for Goals Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class GoalsPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(xpath = "//h1[contains(.,'My Goals:')]")
	private WebElement txtGoals;
	
	@FindBy(xpath = "//h1[contains(.,'My Team Goals')]")
	private WebElement txtMyTeamGoals;
	
	@FindBy(xpath = "//h1[contains(.,'Mass Assign Goals')]")
	private WebElement txtMassAssGoals;
	
	@FindBy(xpath = "//h1[contains(.,'Create Goal Plan: Details')]")
	private WebElement txtCGP;
	
	@FindBy(xpath = "//h1[contains(.,'Create Goal Plan: Goals')]")
	private WebElement txtCGPG;
	
	@FindBy(xpath = "//h1[contains(.,'Create Goal Plan: Population')]")
	private WebElement txtCGPP;
	
	@FindBy(xpath = "//h1[contains(.,'Manage Goal Library')]")
	private WebElement txtMGL;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:cil1::icon']")
	private WebElement searchIcon;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Done')]|//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:1:AP9:ctb4']|//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:1:AP1:ctb4']")
	private WebElement btnDone;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:_FOTsdiHRG_GOALS_MANAGER::icon']")
	private WebElement btnMyTeamGoals;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:_FOTsdiHRG_GOALS_TaskList_itemNode::icon']")
	private WebElement btnTasks;
	
	@FindBy(xpath = "//a[contains(.,'Manage Goal Plans')]")
	private WebElement lnkMGP;
	
	@FindBy(xpath = "//a[contains(.,'Mass Assign Goals')]")
	private WebElement lnkMAG;
	
	@FindBy(xpath = "//a[contains(.,'Manage Goal Library')]")
	private WebElement lnkMGL;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:1:AP9:AT3:_ATp:ctb1::icon']")
	private WebElement btnCGP;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:1:AP1:AT1:_ATp:ctb1::icon']")
	private WebElement btnCMA;
	
	
	//@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:1:AP1:AT1:_ATp:commandImageLink1::icon']")
	@FindBy(xpath = "//*[contains(@id,':AP1:AT1:_ATp:commandImageLink1::icon')]")
	private WebElement btnAdd;
	
	@FindBy(xpath = "//select[contains(@name,'goals:0:MAnt2:1:AP9:AT3:soc2')]")
	private WebElement selGoalPlanType;
	
	@FindBy(xpath = "//a[contains(@title,'Search: Goal Plan Name')]")
	private WebElement selGoalPlanName;
	
	
	@FindBy(xpath = "//input[contains(@name,'goals:0:MAnt2:1:AP9:AT3:it1')]")
	private WebElement txtGoalPlan;
	
	@FindBy(xpath = "//input[contains(@name,'goals:0:MAnt2:2:AP8:it1')]|//input[contains(@name,'goals:0:MAnt2:1:AP1:q1:value00')]")
	private WebElement txtProcessName;
	//@FindBy(xpath = "//input[contains(@name,'goals:0:MAnt2:1:AP1:q1:value00')]")
	
	@FindBy(xpath = "//textarea[contains(@name,'goals:0:MAnt2:2:AP2:it3')]")
	private WebElement txtDescription;
	
	@FindBy(xpath = "//textarea[contains(@name,'goals:0:MAnt2:2:AP2:inputText4')]")
	private WebElement txtGLDescription;
	
	@FindBy(xpath = "//button[contains(@accesskey,'K')]")
	private WebElement btnOK;
	
	@FindBy(xpath = "//a[contains(@title,'Search: Review Period')]")
	private WebElement lnkReviewPeriod;
	
	@FindBy(xpath = "(//input[contains(@name,'goals:0:MAnt2:2:AP2:sml1')])[1]")
	private WebElement chkPerDocType;
	
	@FindBy(xpath = "//button[contains(.,'Next')]")
	private WebElement btnNext;
	
	@FindBy(xpath = "//a[contains(@title,'Add Goal')]")
	private WebElement btnAddGoal;
	
	@FindBy(xpath = "//input[contains(@name,'r1:1:q4:value00')]")
	private WebElement txtGoalName;
	
	@FindBy(xpath = "//input[contains(@name,'goals:0:MAnt2:2:AP2:inputText3')]")
	private WebElement txtGLGoalName;
	
	@FindBy(xpath = "//button[contains(@id,'r1:1:q4::search')]")
	private WebElement btnSearch1;
	
	@FindBy(xpath = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_goals:0:MAnt2:1:AP1:AT1:_ATp:ctb2"]
	@FindBy(xpath = "//*[contains(@id,':MAnt2:1:AP1:AT1:_ATp:ctb2')]")
	private WebElement btnMSP;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_goals:0:MAnt2:3:AP1:r1:requestBtns:submitButton']")
	private WebElement btnSubmit;
	
	//@FindBy(xpath = "//label[contains(.,'Process 62146 was submitted.')]")
	@FindBy(xpath = "//label[contains(.,'was submitted.')]")
	private WebElement lblProcessNum;
	
	
	@FindBy(xpath = "//span[contains(.,'Improve presentation skills')]")
	private WebElement txtSearchGoalResult;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:4:AP2:r3:0:AT2:_ATp:cil2::icon']| //*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:2:AP8:r1:0:AT2:_ATp:cil2::icon']")
	private WebElement btnSelInd;
					
	//@FindBy(xpath = "//input[contains(@name,'goals:0:MAnt2:4:AP2:r3:0:qryId2:value00')]")
	@FindBy(xpath = "//input[contains(@name,':0:qryId2:value00')]")
	private WebElement txtWorkerName;
	
	
	@FindBy(xpath = "//button[contains(.,'Apply')]")
	private WebElement btnApply;
	
	@FindBy(xpath = "//button[contains(.,'Save and Close')]")
	private WebElement btnSaveandClose;
	
	//@FindBy(xpath = "(//button[contains(.,'OK')])[1]")
	@FindBy(xpath = "(//button[contains(.,'OK')])")
	private WebElement btnGLOK;
	
	@FindBy(xpath = "//button[contains(.,'Monitor Process')]")
	private WebElement btnMonProc;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_goals:0:MAnt2:4:AP1:r1:0:pt1:panel:processRefreshId::icon']")
	private WebElement iconRefresh;
	
	@FindBy(xpath = "//a[@title='Search: Goal Name']")
	private WebElement lnkGoalName;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_goals:0:MAnt2:4:AP1:r1:0:pt1:panel:result::db']")
	private WebElement tableProcess;
	
	private List<WebElement> rowcount;
	 public GoalsPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtGoals));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Goals Page *****************************");
	     this.getScreenDetails();
	 }
	 
	
	 public void verifyProcessStatus(String strProcessNum)
		{	
			rowcount=(List<WebElement>) tableProcess.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			int found=0;
			for (int row=0;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//span[contains(.,'"+strProcessNum+"')])"));
				String actualProcessNum=cellNametext.getText();
				System.out.println("actual Process Number is "+actualProcessNum);
				if(actualProcessNum.contains(strProcessNum))
				{
					//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_goals:0:MAnt2:4:AP1:r1:0:pt1:panel:result:0:j_id__ctru109pc9']
					report.log(LogStatus.INFO, "Selected Process NUmber is "+strProcessNum);
					String processStatus=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_goals:0:MAnt2:4:AP1:r1:0:pt1:panel:result:"+row+":j_id__ctru109pc9']")).getText();
					if(processStatus.contains("Succeeded"))
					{
						report.log(LogStatus.PASS, "Step Process.Process status is Succeeded ");
						this.getScreenDetails("Process Status");
						found=1;
						break;
					}
					else
					{
						clickRefreshIcon();
					}
					
				}
			}
			if (found==0)
			{
				report.log(LogStatus.FAIL, "Selected Legal Employer Name is "+strProcessNum+" is not listed in the search list");
			}
		}
		
	 
	 

	 public boolean isGoalsPageDisplayed(){
		 report.log(LogStatus.PASS, "Goals page is Displayed");
		 return txtGoals.isDisplayed();
		}
	 
	 
	 public boolean isCreateGoalPlanButtonDisplayed(){
		 return btnCGP.isDisplayed();
		}
	 
	 
	 public boolean isMyTeamGoalsPageDisplayed(){
		 return txtMyTeamGoals.isDisplayed();
		}
	 
	 public boolean isMassAssignTeamGoalsPageDisplayed(){
		 return txtMassAssGoals.isDisplayed();
		}
	 
	 public boolean isCreateGoalPlanPageDisplayed(){
		 return txtCGP.isDisplayed();
		}
	 
	 
	 public boolean isCreateGoalPlanGoalsPageDisplayed(){
		 return txtCGPG.isDisplayed();
		}
	 
	 
	 public boolean isProcessNameDisplayed(){
		 return txtProcessName.isDisplayed();
		}
	 
	 
	 public boolean isCreateGoalPlanPopulationPageDisplayed(){
		 return txtCGPP.isDisplayed();
		}
	 
	 
	 public boolean isManageGoalLibraryPageDisplayed(){
		 return txtMGL.isDisplayed();
		}
	 
	 public boolean isGoalPlanTypeListDisplayed(){
		 return selGoalPlanType.isDisplayed();
		}
	 
	 public void setGoalPlan(String strGoalPlan)
	 {
		 txtGoalPlan.click(); 
		 txtGoalPlan.sendKeys(strGoalPlan);
		 report.log(LogStatus.PASS, "Entered Goal Plan is: "+strGoalPlan);
	 }
	 
	 
	 public void enterGoalName(String strGoalName)
	 {
		 txtGoalName.click(); 
		 txtGoalName.sendKeys(strGoalName);
		 report.log(LogStatus.PASS, "Entered Goal Name is: "+strGoalName);
	 }
	 
	 
	 public void enterProcessName(String strProcessName)
	 {
		 txtProcessName.click(); 
		 txtProcessName.sendKeys(strProcessName);
		 report.log(LogStatus.PASS, "Entered Process Name is: "+strProcessName);
	 }
	 
	 public void enterGLGoalName(String strGoalName)
	 {
		 txtGLGoalName.click(); 
		 txtGLGoalName.sendKeys(strGoalName);
		 report.log(LogStatus.PASS, "Entered Goal Name is: "+strGoalName);
	 }
	 
	 public void enterWorkerName(String strWorkerName)
	 {
		 txtWorkerName.click(); 
		 txtWorkerName.clear();
		 txtWorkerName.sendKeys(strWorkerName);
		 report.log(LogStatus.PASS, "Entered Worker Name is: "+strWorkerName);
	 }
	 
	 public void enterDescription(String strDescription)
	 {
		 txtDescription.click();
		 txtDescription.sendKeys(strDescription);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
	 }
	 
	 //This is to enter description for Goal Library Goal Plan
	 public void enterGLDescription(String strDescription)
	 {
		 txtGLDescription.click();
		 txtGLDescription.sendKeys(strDescription);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
	 }
	 
	 public void clickSearchIcon()
	 {
		 searchIcon.click();
		 SeleniumUtils.delay(5000);
	 }
	
	 public void clickDoneButton()
	 {
		 btnDone.click();
		 SeleniumUtils.delay(3000);
	 }
	 
	 
	 public void clickMyTeamGoalsIcon()
	 {
		 btnMyTeamGoals.click();
		 wdwait.until(ExpectedConditions.visibilityOf(txtMyTeamGoals));
		 this.getScreenDetails("Clicked My Team Goals");
	 }
	 
	 
	 public void clickTasksButton()
	 {
		 btnTasks.click();
		 wdwait.until(ExpectedConditions.visibilityOf(lnkMGP));
		 this.getScreenDetails("Clicked Tasks button");
	 }
	 
	 
	 public void clickManageGoalPlansLink()
	 {
		 lnkMGP.click();
		 wdwait.until(ExpectedConditions.visibilityOf(btnCGP));
		 this.getScreenDetails("Clicked Manage Goal Plans Link");
	 }
	
	 
	 public void clickMaassAssignGoalsLink()
	 {
		 lnkMAG.click();
		 wdwait.until(ExpectedConditions.visibilityOf(txtMassAssGoals));
		 this.getScreenDetails("Clicked Mass Assign Goals Link");
	 }
	 
	 public void clickManageGoalLibraryLink()
	 {
		 lnkMGL.click();
		 wdwait.until(ExpectedConditions.visibilityOf(txtMGL));
		 this.getScreenDetails("Clicked Manage Goal Library Link");
	 }
	 
	 public void clickReviewPeriodLink()
	 {
		 lnkReviewPeriod.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked Review Period Link");
	 }
	 
	 
	 public void checkPerfDocType()
	 {
		 chkPerDocType.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Checked PerfDocType checkbox");
	 }
	 
	 public void selectReviewPeriod(String strReviewPeriod)
	 {
		 //driver.findElement(By.xpath("(//td[contains(.,'Ciber 2019 Review Period')])[2]")).click();
		 /*String s= driver.findElement(By.xpath("(//td[contains(.,'"+strReviewPeriod+"')])[2]")).getText();
		 System.out.println("cell text is "+s);*/
		 driver.findElement(By.xpath("(//td[contains(.,'"+strReviewPeriod+"')])[2]")).click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Selected Review Period List value");
	 }
	
	
	 public void selectGoalType(String strGoalType)
	 {
		 driver.findElement(By.xpath("(//td[contains(.,'"+strGoalType+"')])")).click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Selected GoalType value");
	 }
	 
	 //td[contains(.,'Gain upward feedback from team members before the end of the quarter to establish further what can be improved upon')])[2]
	 public void selectGoalName(String strGoalName)
	 {
		 driver.findElement(By.xpath("(//td[contains(.,'"+strGoalName+"')])[2]")).click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Selected GoalName value");
	 }
	 
	 //td[contains(.,'Stone, Evangeline')])[4]
	 public void selectWorkerName(String strWorkerName)
	 {
		 driver.findElement(By.xpath("(//td[contains(.,'"+strWorkerName+"')])[4]")).click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Selected Worker Name value");
	 } 
	 
	 
	 public void clickOkButton()
	 {
		 btnOK.click();
		 //wdwait.until(ExpectedConditions.visibilityOf(txtCGP));
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Clicked on OK button");
	 }
	 
	 
	 public void clickNextButton()
	 {
		 btnNext.click();
		// wdwait.until(ExpectedConditions.visibilityOf(txtCGPG));
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Clicked on Next button");
	 }
	 
	 
	 public void clickAddGoalButton()
	 {
		 btnAddGoal.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Add Goal button");
	 }
	 
	 
	 public void clickSearchResButton()
	 {
		 btnSearch1.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Search button");
	 }
	 
	 
	 public void clickManageScheduleProcessButton()
	 {
		 btnMSP.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on ManageScheduleProcess button");
	 }
	 
	 
	 public void clickSubmitButton()
	 {
		 btnSubmit.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Submit button");
	 }
	 
	 
	 public String getProcessNum()
	 {
		 //Process 62146 was submitted.
		 String MessageTxt=lblProcessNum.getText();
		 String ProcessNum=MessageTxt.subSequence(7, 14).toString().trim();
		 report.log(LogStatus.INFO, "Step ProcessNum. Created Process Number is: "+ProcessNum);
		return ProcessNum;
		 
	 }
	 
	 public void clickSearchButton()
	 {
		 btnSearch.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Search button");
	 }
	 
	 
	 public void clickSelIndTWAGPButton()
	 {
		 btnSelInd.click();
		 SeleniumUtils.delay(2000);
		 wdwait.until(ExpectedConditions.visibilityOf(txtWorkerName));
		 this.getScreenDetails("Clicked on SelIndTWAGP button");
	 }
	 
	 
	 public void clickApplyButton()
	 {
		 btnApply.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Apply button");
	 }
	 
	 
	 public void clickSaveAndCloseButton()
	 {
		 btnSaveandClose.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Save and Close button");
	 }
	 
	 
	 public void clickGLOKButton()
	 {
		 btnGLOK.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on OK button on confiramtion dailog");
	 }
	 
	 
	 public void clickMonitorProcessButton()
	 {
		 btnMonProc.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on MonitorProcess button");
	 }
	 
	 
	 public void clickRefreshIcon()
	 {
		 iconRefresh.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Refresh Icon");
	 }
	 
	 public void clickGoalNameList()
	 {
		 lnkGoalName.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Goal Name List");
	 }
	 
	 public void selectSearchGoalResult1(String strGoalName)
	 {
		driver.findElement(By.xpath("//span[contains(.,'"+strGoalName+"')]")).click();
		SeleniumUtils.delay(3000);
		 this.getScreenDetails("Clicked on SearchGoalResult cell");
	 }
	
	 public void selectSearchGoalResult()
	 {
		 txtSearchGoalResult.click();
		 this.getScreenDetails("Clicked on SearchGoalResult cell");
	 }
	 
	 public void clickCreateGoalPlanButton()
	 {
		 btnCGP.click();
		 wdwait.until(ExpectedConditions.visibilityOf(selGoalPlanType));
		 this.getScreenDetails("Clicked on Create Goal Plan Button");
	 }
	 
	 
	 public void clickCreateMassAssignnButton()
	 {
		 btnCMA.click();
		 wdwait.until(ExpectedConditions.visibilityOf(txtProcessName));
		 this.getScreenDetails("Clicked on Create Mass Assignment Button");
	 }
	 
	 
	 public void clickAddButton()
	 {
		 btnAdd.click();
		 wdwait.until(ExpectedConditions.visibilityOf(txtGLGoalName));
		 this.getScreenDetails("Clicked on Add Button");
	 }
	 
	 public void selectGoalPlanType(String strGoalPlanType)
	 {
	    	report.log(LogStatus.PASS, "Select any Goal Plan Type from list");
	    	selGoalPlanType.click();
	    	SeleniumUtils.delay(2000);
	    	Select objSelect = new Select(selGoalPlanType);
	    	objSelect.selectByVisibleText(strGoalPlanType);
	 }
	 
	 
	 public void selectGoalPlanName(String strGoalPlanName)
	 {
	    	report.log(LogStatus.PASS, "Select any Goal Plan Type from list");
	    	selGoalPlanName.click();
	    	SeleniumUtils.delay(2000);
	    	Select objSelect = new Select(selGoalPlanName);
	    	objSelect.selectByVisibleText(strGoalPlanName);
	 }
	 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "Edit My Details Personal Information Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtGoals, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryGoalsInformation", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>GoalsInformation Page</span></a>");
	    	return new Item(xyz);
	    }
	  
	  public Item getScreenDetails(String strTitle){
		   	String xyz = Screenshot.takeScreenshotX(driver, strTitle, context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>"+strTitle+"</span></a>");
		   	return new Item(xyz);
	   }
}
