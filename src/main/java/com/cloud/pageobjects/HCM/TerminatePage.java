package com.cloud.pageobjects.HCM;

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
 * Contains object properties and methods for Terminate Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class TerminatePage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Terminate')]")
	private WebElement txtTerminate;	
	
	@FindBy(xpath = "//button[contains(@id,'TEAM:0:MAnt2:1:r1:0:pt1:ap1:tt1:cb1')]")
	private WebElement btnReview;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,': Review Terminate Work Relationship')]")
	private WebElement txtReview;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@accesskey,'K')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Yes')]")
	private WebElement buttonYes;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:submit')]")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//select[contains(@id,'TEAM:0:MAnt2:1:r1:0:pt1:ap1:Termi1:0:Action::content')]")
	private WebElement selectTerminateAction;
	
	@FindBy(xpath = "//select[contains(@id,'TEAM:0:MAnt2:1:r1:0:pt1:ap1:Rehir1:0:RehireRecom::content')]")
	private WebElement selectRecForRehire;
	
	@FindBy(xpath = "//select[contains(@id,'TEAM:0:MAnt2:1:r1:0:pt1:ap1:Rehir1:0:selectOneChoice1::content')]")
	private WebElement selectReason;
	
		 public TerminatePage(WebDriver driver, ExtentTest report) throws TestException 
		 {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 30);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(txtTerminate));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     System.out.println("******************************* Terminate Page *****************************");
		     this.getScreenDetails();
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

		
		 public boolean isReviewDetailsDisplayed()
		 {
			 return txtReview.isDisplayed();
		 }
		 
		 public void clickOKButton() throws TestException
		 {
			this.getScreenDetails("After Confirmation"); 
			buttonOK.click();
			SeleniumUtils.delay(8000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("After Clicking Ok button");
		    
		 }
	
		 public void selectTerminateAction(String strAction)
		 {
			 	selectTerminateAction.click();
			 	report.log(LogStatus.PASS, "Select any Action from Action dropdown");
		    	Select objSelect = new Select(selectTerminateAction);
		    	objSelect.selectByVisibleText(strAction);
		    	SeleniumUtils.delay(6000);
		 }
		 
		 
		 public void selectRecommendedforRehire(String strYesOrNo)
		 {
			 	selectRecForRehire.click();
			 	report.log(LogStatus.PASS, "Select any Yes/No value from Recommended for Rehire list");
		    	Select objSelect = new Select(selectRecForRehire);
		    	objSelect.selectByVisibleText(strYesOrNo);
		    	SeleniumUtils.delay(3000);
		 }
		 
		 
		 public void selectReason(String strReason)
		 {
			 	selectReason.click();
			 	report.log(LogStatus.PASS, "Select any value from Reason list");
		    	Select objSelect = new Select(selectReason);
		    	objSelect.selectByVisibleText(strReason);
		    	SeleniumUtils.delay(3000);
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
			btnReview.click();
			wdwait.until(ExpectedConditions.visibilityOf(buttonSubmit));
			this.getScreenDetails("Review Screen");
		    report.log(LogStatus.PASS, "Clicked on Review button");
		 }
	 
		
		 public boolean isDisplayed()
		 {
	    	 report.log(LogStatus.PASS, "Promotion Page is Loaded Successfully");
	    	 return SeleniumUtils.isDisplayed(driver, txtTerminate, context.getFindTimeout());
		 }
		 
		 
		  public Item getScreenDetails()
		  {
		    	String xyz = Screenshot.takeScreenshotX(driver, "Terminate", context);
		    	report.addScreenCapture(xyz);
		    	String projectPath = System.getProperty("user.dir");   	
		    	String sShotPath = projectPath+"/report/"+xyz;
		    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Terminate Page</span></a>");
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
