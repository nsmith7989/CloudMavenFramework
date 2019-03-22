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
 * Contains object properties and methods for ChangeLocation Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class ChangeLocationPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Change Location:')]")
	private WebElement txtChangeLocation;	
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Edit Employment: Review')]")
	private WebElement txtEditEmpReview;
	
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'locationId_afrLovInternalTableId::db')]")
	private WebElement tableLocationNames;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':ManagerNameId_afrLovInternalTableId::db')]")
	private WebElement tableManagerNames;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':positionId_afrLovInternalTableId')]")
	private WebElement tablePositionNames;
	
	
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Review')]")
	private WebElement buttonReview;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':r1:0:pt1:ap1:tt1:review')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:tt1:review"]
	private WebElement locationReviewButton;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,': Review Terminate Work Relationship')]")
	private WebElement txtReview;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@accesskey,'K')]")
	//@FindBy(how=How.XPATH, using = "//button[contains(@id,':tt1:okConfirmationDialog')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':AP1:legalEnt::lovDialogId::ok')]")
	private WebElement buttonLegEmpOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'::lovDialogId::ok')]")
	private WebElement buttonBUOK;
	
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
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtLocationName;
	
	@FindBy(how=How.XPATH, using = "//a[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat1:0:locationId::lovIconId']")
	//@FindBy(how=How.XPATH, using = "//a[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:r:JobDe2:0:locationId::lovIconId')]")
	private WebElement listLocation;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@title,'Search Positions')]")
	private WebElement listSearchPosition;
	
	
	@FindBy(how=How.XPATH, using = "//select[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat1:0:soc1::content']")
	private WebElement selectWAH;
	
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat1:0:building::content"]
	@FindBy(how=How.ID, using = "_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat1:0:building::content")
	private WebElement txtBuilding;
	
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat1:0:inputText1::content"]
	@FindBy(how=How.ID, using = "_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat1:0:inputText1::content")
	private WebElement txtFloor;
	
	private List<WebElement> rowcount;
	
		 public ChangeLocationPage(WebDriver driver, ExtentTest report) throws TestException 
		 {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 30);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(txtChangeLocation));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     System.out.println("******************************* Change Location Page *****************************");
		     this.getScreenDetails();
		 }
		 
		 
			public void selectLocationName(String strLocationName)
		{	
			rowcount=(List<WebElement>) tableLocationNames.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=1;row<rownum;row++)
			{	
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':locationId_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				
				if(actualText.equalsIgnoreCase(strLocationName))
				{
					report.log(LogStatus.INFO, "Selected Location Name is "+strLocationName);
					cellNametext.click();
					SeleniumUtils.delay(5000);
					this.getScreenDetails("Location Screen");
					break;
				}
			}
		}		
		
		
		public void selectWorkAtHome(String strWorkAtHome)
		{
			selectWAH.click();
			Select objSelect = new Select(selectWAH);
	    	objSelect.selectByVisibleText(strWorkAtHome);
	    	SeleniumUtils.delay(2000);
	    	this.getScreenDetails("Select WorkAtHome");
		}
		
		
		 public void clickSearchLink()
		 {
			 lnkSearch.click();
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("SearchLink Screen");
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
		
		
		public void clickLocationList()
		 {
			 listLocation.click();
			 SeleniumUtils.delay(5000);
			 //wdwait.until(ExpectedConditions.visibilityOf(selectAction));
			 this.getScreenDetails("Locations Screen");
		 }
		
		 
		 
		 public void enterBuildingInfo(String strBuilding)
		 {
			 txtBuilding.click();
			 txtBuilding.clear();
			 txtBuilding.sendKeys(strBuilding);
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Entered Building info");
		 }
		 
		 
		 public void enterFloor(String strFloor)
		 {
			 txtFloor.click();
			 txtFloor.clear();
			 txtFloor.sendKeys(strFloor);
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Entered Floor info");
			 
			 if (driver.findElement(By.xpath("//*[contains(@id,':r1:0:pt1:ap1:Locat1:0:d1::yes')]")).isDisplayed())
			 {
				 driver.findElement(By.xpath("//*[contains(@id,':r1:0:pt1:ap1:Locat1:0:d1::yes')]")).click();
			 }
			 
			 
		 }
		 
		
		 
		 public void enterLocationName(String strLocationName)
		 {
			 txtLocationName.clear();
			 txtLocationName.sendKeys(strLocationName);
			 SeleniumUtils.delay(2000);
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
		 
		 
		 public void clickLegEmpOKButton() throws TestException
		 {
			buttonLegEmpOK.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("AfterClickOkButton");
		    
		 }
		 
		 public void clickBUOKButton() throws TestException
		 {
			 buttonBUOK.click();
			SeleniumUtils.delay(3000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("After clicking OK");
		    
		 }
		 
		 public void clickUpdateOKButton() throws TestException
		 {
			buttonGenOK.click();
			SeleniumUtils.delay(10000);
			//wdwait.until(ExpectedConditions.visibilityOf(buttonStatusOK));
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("AfterClickOkButton");
		 }
		 
		 public void clickASOKButton() throws TestException
		 {
			buttonStatusOK.click();
			SeleniumUtils.delay(8000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("AfterClickOkButton");
		    
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
	    	 report.log(LogStatus.PASS, "Change Location Page is Loaded Successfully");
	    	 return SeleniumUtils.isDisplayed(driver, txtChangeLocation, context.getFindTimeout());
		 }
		 
		 
		  public Item getScreenDetails()
		  {
		    	String xyz = Screenshot.takeScreenshotX(driver, "Change Location", context);
		    	report.addScreenCapture(xyz);
		    	String projectPath = System.getProperty("user.dir");   	
		    	String sShotPath = projectPath+"/report/"+xyz;
		    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Change Location Page</span></a>");
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
