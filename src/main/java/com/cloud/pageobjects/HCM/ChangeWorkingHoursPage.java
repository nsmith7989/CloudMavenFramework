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
 * Contains object properties and methods for ChangeManager Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class ChangeWorkingHoursPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Change Working Hours')]")
	private WebElement txtChangeWorkingHours;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,': Review')]")
	private WebElement txtEditEmpReview;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Review')]")
	private WebElement buttonReview;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:review')]")
	private WebElement locationReviewButton;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,': Review Terminate Work Relationship')]")
	private WebElement txtReview;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@accesskey,'K')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':AP1:ctb1')]")
	private WebElement buttonStatusOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':tt1:tbb1:1:_afrButtonStopNavItem')]")
	private WebElement buttonNext;

	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTsr2:0:SP1:SPb']/a")
	private WebElement buttonDone;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Yes')]")
	private WebElement buttonYes;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:submit')]")
	private WebElement buttonSubmit;

	@FindBy(how=How.XPATH, using = "//*[contains(@id,'::dropdownPopup::popupsearch')]")
	private WebElement lnkSearch;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':JobDe1:0:inputText2::content')]")
	private WebElement txtWorkingHrs;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':JobDe1:0:inputText4::content')]")
	private WebElement txtStartTime;
	
	private List<WebElement> rowcount;
	
		 public ChangeWorkingHoursPage(WebDriver driver, ExtentTest report) throws TestException 
		 {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 30);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(txtChangeWorkingHours));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     System.out.println("******************************* Change Working Hours Page *****************************");
		     this.getScreenDetails();
		 }
		 
			
		 public void enterWorkingHours(String strWorkinghrs)
		 {
			 txtWorkingHrs.clear();
			 txtWorkingHrs.sendKeys(strWorkinghrs);
			 SeleniumUtils.delay(5000);
		 }
		 
		 public void enterStartTime(String strStartime)
		 {
			 txtStartTime.click();
			 txtStartTime.clear();
			 txtStartTime.sendKeys(strStartime);
			 SeleniumUtils.delay(5000);
		 }
		
		 
		 public void clickNextButton()
		 {
			 	buttonNext.click();
				SeleniumUtils.delay(10000);
				this.getScreenDetails("After Next button Click");
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
			 this.getScreenDetails("Review Details Page");
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
		 
		 
		 public void clickDoneButton() throws TestException
		 {
			buttonDone.click();
			SeleniumUtils.delay(5000);
			//wdwait.until(ExpectedConditions.visibilityOf(buttonYes));
			this.getScreenDetails("After clicking Done button");
		    report.log(LogStatus.PASS, "Clicked on Done button");
		 }
		 
		 public void clickSubmitButton() throws TestException
		 {
			this.getScreenDetails();
			buttonSubmit.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on Submit button");
			this.getScreenDetails();
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
	    	 report.log(LogStatus.PASS, "Change Working Hours Page is Loaded Successfully");
	    	 return SeleniumUtils.isDisplayed(driver, txtChangeWorkingHours, context.getFindTimeout());
		 }
		 
		 
		  public Item getScreenDetails()
		  {
		    	String xyz = Screenshot.takeScreenshotX(driver, "Change Working Hours", context);
		    	report.addScreenCapture(xyz);
		    	String projectPath = System.getProperty("user.dir");   	
		    	String sShotPath = projectPath+"/report/"+xyz;
		    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Change Working Hours Page</span></a>");
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
