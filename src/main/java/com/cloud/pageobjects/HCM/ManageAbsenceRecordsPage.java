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
 * Contains object properties and methods for Schedule Absence Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class ManageAbsenceRecordsPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Maintain Absence Records')]")
	private WebElement txtMaintainAbsenceRecords;
	
	
	@FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:pt1:AP1:AT1:_ATp:actb1']")
	private WebElement btnAdd;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'TEAM:0:MAnt2:1:pt1:AP1:AT1:r1:1:soc1::content')]")
	private WebElement selectType;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:pt1:AP1:AT1:r1:1:r1:1:id1::glyph']")
	private WebElement imageStartDatePicker;
	
	@FindBy(how=How.XPATH, using = "//textarea[contains(@id,'TEAM:0:MAnt2:1:pt1:AP1:AT1:r1:1:r1:1:r3:0:it1::content')]")
	private WebElement txtAreaComments;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:pt1:AP1:AT1:FAsc11']/a")
	private WebElement buttonSubmit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ok')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:pt1:AP1:SPb']/a")
	private WebElement buttonDone;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:pt1:AP1:AT1:r1:1:r1:1:sbc2::content']")
	private WebElement checkSingleDay;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'TEAM:0:MAnt2:1:pt1:AP1:AT1:r1:1:r1:1:id1::content')]")
	private WebElement txtStartDate;
	
	
	
	
	
		public void selectStartDate(String noOfDays)
	{
		WebElement dateWidget = driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:pt1:AP1:AT1:r1:1:r1:1:id1::pop::cd::cg']"));
		List<WebElement> rows=dateWidget.findElements(By.tagName("tr")); 
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
		  
		  for (WebElement cell:columns){
		   if (cell.getText().equals(noOfDays)){
		     cell.click();
			   SeleniumUtils.delay(3000);
			   break;
		   }
		  } 
		 
		 
	}
	
	 public ManageAbsenceRecordsPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtMaintainAbsenceRecords));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Manage Absence RecordsPage Page *****************************");
	     this.getScreenDetails();
	 }

	 public boolean isAddButtonDisplayed()
	 {
	    	return btnAdd.isDisplayed();
	 }
	 
	 public void enterComments(String strComments)
	 {
		 txtAreaComments.sendKeys(strComments);
		 SeleniumUtils.delay(2000);
	 }
	 
	 
	 public void enterStartDate(String strStartDate)
	 {
		 txtStartDate.sendKeys(strStartDate);
		 SeleniumUtils.delay(2000);
	 }
	 
	 public void clickAddButton()
	 {
		 	btnAdd.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("After clicking Add button");
		    report.log(LogStatus.PASS, "Clicked on Add button");
	 }
	 
	 
	 public void checkSingleDay()
	 {
		 	checkSingleDay.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("SingleDay");
		    report.log(LogStatus.PASS, "Checked Single Day option");
	 }
	 
	 
	 public void clicSubmitButton()
	 {
		 buttonSubmit.click();
//		 SeleniumUtils.delay(5000);
		 wdwait.until(ExpectedConditions.visibilityOf(buttonOK));
		 this.getScreenDetails("After Submit Click");
		 
	 }
	 
	 public void clicOKButton()
	 {
		
		if (buttonOK.isDisplayed())
				 {
			 buttonOK.click();
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("After OK button click");
				 }
		 else
		 {
			 report.log(LogStatus.FAIL, "Step Fail. Try with different date to apply leave");
		 }
	 }
	 
	 
	 
	 public void clicDoneButton()
	 {
		
		 	buttonDone.click();
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("After Done button click");
	 }
	
	 public void clickStartDatePicker()
	 {
		 	imageStartDatePicker.click();
			SeleniumUtils.delay(2000);
			report.log(LogStatus.PASS, "Clicked on Start Date icon");
	 }
	 
	 public void selectType(String strType)
	 {
		 	//selectType.click();
		 	report.log(LogStatus.PASS, "Select any leave type from Type dropdown");
	    	Select objSelect = new Select(selectType);
	    	objSelect.selectByVisibleText(strType);
	    	SeleniumUtils.delay(5000);
	 }
	 
		 	 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "Schedule Absence Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtMaintainAbsenceRecords, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "Manage Absence Records", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Schedule Absence Page</span></a>");
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
