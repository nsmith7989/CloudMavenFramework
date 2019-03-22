package com.cloud.pageobjects.HCM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
 * Contains object properties and methods for Promotion Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class PromotionPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Promote')]")
	private WebElement txtPromote;	
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Edit Employment: Review')]")
	private WebElement txtEditEmpReview;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:review')]")
	private WebElement locationReviewButton;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,': Review Terminate Work Relationship')]")
	private WebElement txtReview;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@accesskey,'K')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'::lovDialogId::ok')]")
	private WebElement buttonBUOK;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':next')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:tt2:next"]
	private WebElement buttonNext;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:tbb1:1:_afrButtonStopNavItem')]")
	private WebElement buttonDifferNext;

	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTsr2:0:SP1:SPb']/a")
	private WebElement buttonDone;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Yes')]")
	private WebElement buttonYes;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':r1:3:pt5:ap1:tt1:submit')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:3:pt5:ap1:tt1:submit"]
	private WebElement buttonSubmit;

	@FindBy(how=How.XPATH, using = "//*[contains(@id,'::dropdownPopup::popupsearch')]")
	private WebElement lnkSearch;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtLocationName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':position1Id_afrLovInternalTableId::db')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:JobDe1:0:position1Id_afrLovInternalTableId::db"]
	private WebElement tablePositionNames;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@title,'Search Positions')]")
	private WebElement listSearchPosition;
	
	private List<WebElement> rowcount;
	
		 public PromotionPage(WebDriver driver, ExtentTest report) throws TestException 
		 {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 30);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(txtPromote));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     System.out.println("******************************* Promotion Page *****************************");
		     this.getScreenDetails();
		 }
		 
			
		
		 public void clickSearchLink()
		 {
			 lnkSearch.click();
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("SearchLink Screen");
		 }
		 
		 
		 public void clickFirstNextButton()
		 {
			 	buttonNext.click();
				SeleniumUtils.delay(8000);
				this.getScreenDetails("After Next button Click");
		 }
		 
		 
		 public void clickNextButton()
		 {
			 	buttonDifferNext.click();
				SeleniumUtils.delay(8000);
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
		
		
		
		 public void clickSearchPositionsList() throws AWTException
		 {
			// listSearchPosition.click();
			  Robot robot=new Robot();
			  listSearchPosition.click();
			  robot.keyPress(KeyEvent.VK_ENTER);
			  SeleniumUtils.delay(3000);
			 
			 this.getScreenDetails("Positions Screen");
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
			buttonOK.click();
			SeleniumUtils.delay(8000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("After Clicking Ok button");
		    
		 }
		 
		 
		 public void clickBUOKButton() throws TestException
		 {
			 buttonBUOK.click();
			SeleniumUtils.delay(3000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("After clicking OK");
		    
		 }
		 
		 public void enterPositionName(String strPositionName)
		 {
			 txtLocationName.clear();
			 txtLocationName.sendKeys(strPositionName);
			 SeleniumUtils.delay(2000);
		 }
		 
		 public void selectPositionName(String strPositionName)
			{	
				rowcount=(List<WebElement>) tablePositionNames.findElements(By.tagName("tr"));
				int rownum=rowcount.size();
				for (int row=1;row<rownum;row++)
				{	
					WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':position1Id_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
					String actualText=cellNametext.getText();
					System.out.println("actual text is "+actualText);
					
					if(actualText.equalsIgnoreCase(strPositionName))
					{
						report.log(LogStatus.INFO, "Selected Manager Name is "+strPositionName);
						cellNametext.click();
						SeleniumUtils.delay(5000);
						this.getScreenDetails("Selection of Position");
						break;
					}
				}
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
			buttonSubmit.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on Submit button");
			this.getScreenDetails("After Submit Click");
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
	    	 report.log(LogStatus.PASS, "Promotion Page is Loaded Successfully");
	    	 return SeleniumUtils.isDisplayed(driver, txtPromote, context.getFindTimeout());
		 }
		 
		 
		  public Item getScreenDetails()
		  {
		    	String xyz = Screenshot.takeScreenshotX(driver, "Promotion", context);
		    	report.addScreenCapture(xyz);
		    	String projectPath = System.getProperty("user.dir");   	
		    	String sShotPath = projectPath+"/report/"+xyz;
		    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Promotion Page</span></a>");
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
