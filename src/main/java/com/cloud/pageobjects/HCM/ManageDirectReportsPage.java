package com.cloud.pageobjects.HCM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
 * Contains object properties and methods for Manage Direct Reports Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class ManageDirectReportsPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Manage Direct Reports:')]")
	private WebElement txtManageDirectReports;	
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Edit Employment: Review')]")
	private WebElement txtEditEmpReview;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'locationId_afrLovInternalTableId::db')]")
	private WebElement tableLocationNames;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':AT1:resId1::db')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:AP1:r3:0:r1:0:AT1:resId1::db"]
	private WebElement tablePersonNames;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Review')]")
	private WebElement buttonReview;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:review')]")
	private WebElement locationReviewButton;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,': Review Terminate Work Relationship')]")
	private WebElement txtReview;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@accesskey,'K')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':AP1:legalEnt::lovDialogId::ok')]")
	private WebElement buttonLegEmpOK;
	
	@FindBy(xpath = "//button[contains(@id,':AP1:r3:0:r1:0:AT1:cb2')]")
	private WebElement buttonPersonOK;
	
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:AP1:r3:0:r1:0:AT1:cb1"]
	@FindBy(xpath = "//button[contains(@id,'TEAM:0:MAnt2:1:AP1:r3:0:r1:0:AT1:cb1')]")
	private WebElement buttonApply;
	
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:cb10')]|//button[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:ctb1')]|//button[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:d4::ok')]")
	private WebElement buttonGenOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':AP1:ctb1')]")
	private WebElement buttonStatusOK;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:next')]/a")
	private WebElement buttonNext;

	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTsr2:0:SP1:SPb']/a")
	private WebElement buttonDone;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Yes')]")
	private WebElement buttonYes;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:submit')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:1:pt1:ap1:tt1:submit"]
	private WebElement buttonSubmit;

	@FindBy(how=How.XPATH, using = "//*[contains(@id,'::dropdownPopup::popupsearch')]")
	private WebElement lnkSearch;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':AT1:qryId1:value00::content')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:AP1:r3:0:r1:0:AT1:qryId1:value00::content"]
	private WebElement txtPersonName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':MAnt2:1:AP1:r3:0:r1:0:AT1:_ATp:ctb1')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:AP1:r3:0:r1:0:AT1:_ATp:ctb1"]
	private WebElement btnSelectAdd;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,':ManagerNameId::lovIconId')]")
	private WebElement linkName;
	

	private List<WebElement> rowcount;
	
		 public ManageDirectReportsPage(WebDriver driver, ExtentTest report) throws TestException 
		 {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 30);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(txtManageDirectReports));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     System.out.println("******************************* Manage Direct Reports Page *****************************");
		     this.getScreenDetails();
		 }
		 
		
		 public boolean verifyDirectReportName(String strDirectReportName)
		 {
			String actaulName= driver.findElement(By.xpath("//*[contains(@id,':r1:0:AT1:_ATp:ATt1::db')]/table/tbody/tr/td[1]")).getText().trim();		 
			System.out.println("Actual Name is: "+actaulName);
			if(actaulName.contains(strDirectReportName))
			{
				return true;
			}
			else
			{
				return false;
			}
		 }
		 
		 public void clickNextButton()
		 {
			 	buttonNext.click();
				SeleniumUtils.delay(10000);
				this.getScreenDetails("Review Page");
		 }
		 
		 public void clicYesButton()
		 {
			 	buttonYes.click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails("After Yes button click");
		 }
		
		public void clicSubmitButton()
		 {
			 buttonSubmit.click();
			 SeleniumUtils.delay(10000);
			 this.getScreenDetails("After Submit Button Click");
		 }
		
		
		 public void clickSelectAndAddbutton()
		 {
			btnSelectAdd.click();
			SeleniumUtils.delay(3000);
			this.getScreenDetails("After Select&Add button click");
			
		 }
		 
		 public void enterPersonName(String strPersonName)
		 {
			 txtPersonName.clear();
			 txtPersonName.sendKeys(strPersonName);
			 SeleniumUtils.delay(2000);
		 }
		
		 public void selectPersonName(String strPersonName)
			{	
				rowcount=(List<WebElement>) tablePersonNames.findElements(By.tagName("tr"));
				int rownum=rowcount.size();
				for (int row=1;row<=rownum;row++)
				{	
					WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':MAnt2:1:AP1:r3:0:r1:0:AT1:resId1::db')]/table/tbody/tr["+row+"]/td[1]"));
					String actualText=cellNametext.getText();
					System.out.println("actual text is "+actualText);
					
					if(actualText.equalsIgnoreCase(strPersonName))
					{
						report.log(LogStatus.INFO, "Selected Person Name is "+strPersonName);
						cellNametext.click();
						SeleniumUtils.delay(5000);
						this.getScreenDetails("Select Direct Report Person");
						break;
					}
				}
			}		
		 
		 
		public void clickConfirmatioDialog(String strYesOrNO)
		{
			this.getScreenDetails("Confiramtion Screen");
			if(strYesOrNO.equalsIgnoreCase("Yes"))
			{
				driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//button[contains(.,'No')]")).click();	
			}
			
			 wdwait.until(ExpectedConditions.visibilityOf(buttonOK));
				
		}

		 public boolean isEditReviewPageDisplayed()
		 {
			 SeleniumUtils.scroll(driver, 0, 200);
			 this.getScreenDetails("Job Details");
			 return txtEditEmpReview.isDisplayed();
			 
		 }
		 
		 
		 public boolean isReviewDetailsDisplayed()
		 {
			 return txtReview.isDisplayed();
		 }
		 
		 public void clickSearchButton() throws TestException
		 {
			btnSearch.click();
			SeleniumUtils.delay(3000);
			SeleniumUtils.scroll(driver, 0, 1000);
			this.getScreenDetails("Search Results Screen");
		    report.log(LogStatus.PASS, "Clicked on Search button");
		 }
		 
		 public void clickOKButton() throws TestException
		 {
			this.getScreenDetails("After Confirmation"); 
			buttonOK.click();
			SeleniumUtils.delay(8000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("After Clicking Ok button");
		    
		 }
		 
		 public void clickNamesOKButton() throws TestException
		 {
			buttonPersonOK.click();
			SeleniumUtils.delay(3000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("After clicking OK");
		    
		 }
		 
		 public void clickApplyButton() throws TestException
		 {
			buttonApply.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on Apply button");
			this.getScreenDetails("After clicking Apply");
		    
		 }
		 
		 public void clickSubmitButton() throws TestException
		 {
			this.getScreenDetails();
			buttonSubmit.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on Submit button");
			this.getScreenDetails("After Submit button click");
		 }
		 
		 
		 public void clickReviewButton() throws TestException
		 {
			buttonReview.click();
			SeleniumUtils.delay(8000);
			this.getScreenDetails();
		    report.log(LogStatus.PASS, "Clicked on Review button");
		 }
		 
		 
		 
		 public void clickLocationReviewButton() throws TestException
		 {
			locationReviewButton.click();
			SeleniumUtils.delay(5000);
			wdwait.until(ExpectedConditions.visibilityOf(buttonSubmit));
			this.getScreenDetails("Review Screen");
		    report.log(LogStatus.PASS, "Clicked on Review button");
		 }
	 
		
		 public boolean isDisplayed()
		 {
	    	 report.log(LogStatus.PASS, "Manage Direct Reports Page is Loaded Successfully");
	    	 return SeleniumUtils.isDisplayed(driver, txtManageDirectReports, context.getFindTimeout());
		 }
		 
		 
		  public Item getScreenDetails()
		  {
		    	String xyz = Screenshot.takeScreenshotX(driver, "Manage Direct Reports", context);
		    	report.addScreenCapture(xyz);
		    	String projectPath = System.getProperty("user.dir");   	
		    	String sShotPath = projectPath+"/report/"+xyz;
		    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Manage Direct Reports Page</span></a>");
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
