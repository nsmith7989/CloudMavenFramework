package com.cloud.pageobjects.HCM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
 * Contains object properties and methods for Transfer Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class TransferPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Transfer')]")
	private WebElement txtTransfer;	
	
	@FindBy(how=How.XPATH, using = "//button[contains(@accesskey,'K')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'::lovDialogId::ok')]")
	private WebElement buttonBUOK;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':next')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:tt2:next"]
	private WebElement buttonNext;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:tbb1:1:_afrButtonStopNavItem')]")
	private WebElement buttonDifferNext;

	@FindBy(how=How.XPATH, using = "//button[contains(.,'Yes')]")
	private WebElement buttonYes;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:submit')]")
	private WebElement buttonSubmit;

	@FindBy(how=How.XPATH, using = "//*[contains(@id,'::dropdownPopup::popupsearch')]")
	private WebElement lnkSearch;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtLocationName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':position1Id_afrLovInternalTableId::db')]")
	private WebElement tablePositionNames;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@title,'Search Positions')]")
	private WebElement listSearchPosition;
	
	@FindBy(xpath = "//select[contains(@id,':pt1:ap1:selectOneChoice2::content')]")
	private WebElement selectTransferReason;
	
	@FindBy(xpath = "//a[contains(@id,':ap1:Locat2:0:locationId::lovIconId')]")
	private WebElement listLocation;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'locationId_afrLovInternalTableId::db')]")
	private WebElement tableLocationNames;
	
	@FindBy(xpath = "//input[contains(@id,'TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat2:0:building::content')]")
	private WebElement txtBuilding;
	
	@FindBy(xpath = "//input[contains(@id,':r1:0:pt1:ap1:Locat2:0:inputText1::content')]")
	private WebElement txtFloor;
	
	@FindBy(xpath = "//select[contains(@id,'TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat2:0:soc1::content')]")
	private WebElement selectWAH;
	
	
	
	private List<WebElement> rowcount;
	
		 public TransferPage(WebDriver driver, ExtentTest report) throws TestException 
		 {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 30);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(txtTransfer));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     System.out.println("******************************* Transfer Page *****************************");
		     this.getScreenDetails();
		 }
		 
		
		 public void selectTransferReason(String strActionReason)
		 {
		    	report.log(LogStatus.PASS, "Select any Reason from Action Reason dropdown");
		    	selectTransferReason.click();
		    	Select objSelect = new Select(selectTransferReason);
		    	objSelect.selectByVisibleText(strActionReason);
		    	SeleniumUtils.delay(5000);
		    	this.getScreenDetails("Transfer Reason Selected");
		 }
		 
		 public void selectWorkAtHome(String strWorkAtHome)
			{
				selectWAH.click();
				Select objSelect = new Select(selectWAH);
		    	objSelect.selectByVisibleText(strWorkAtHome);
		    	SeleniumUtils.delay(2000);
		    	this.getScreenDetails("Select WorkAtHome");
			}
		
		 public void clickLocationList()
		 {
			 listLocation.click();
			 SeleniumUtils.delay(8000);
			 //wdwait.until(ExpectedConditions.visibilityOf(selectAction));
			 this.getScreenDetails("Locations Screen");
		 }
		 
		 public void enterLocationName(String strLocationName)
		 {
			 txtLocationName.clear();
			 txtLocationName.sendKeys(strLocationName);
			 SeleniumUtils.delay(2000);
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
		 
		 public void enterBuildingInfo(String strBuilding)
		 {
			 txtBuilding.clear();
			 txtBuilding.sendKeys(strBuilding);
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Entered Building Info");
			 
			 
			 if (driver.findElement(By.xpath("//*[contains(@id,':r1:0:pt1:ap1:Locat1:0:d1::yes')]")).isDisplayed())
			 {
				 driver.findElement(By.xpath("//*[contains(@id,':r1:0:pt1:ap1:Locat1:0:d1::yes')]")).click();
			 }
		 }
		 
		 
		 public void enterFloor(String strFloor)
		 {
			 txtFloor.clear();
			 txtFloor.sendKeys(strFloor);
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Entered floor number");
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
		 
	
		 public void clickSubmitButton() throws TestException
		 {
			buttonSubmit.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on Submit button");
			this.getScreenDetails("After Submit click");
		 }
		 
		 public boolean isDisplayed()
		 {
	    	 report.log(LogStatus.PASS, "Transfer Page is Loaded Successfully");
	    	 return SeleniumUtils.isDisplayed(driver, txtTransfer, context.getFindTimeout());
		 }
		 
		 
		  public Item getScreenDetails()
		  {
		    	String xyz = Screenshot.takeScreenshotX(driver, "Transfer", context);
		    	report.addScreenCapture(xyz);
		    	String projectPath = System.getProperty("user.dir");   	
		    	String sShotPath = projectPath+"/report/"+xyz;
		    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Transfer Page</span></a>");
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
