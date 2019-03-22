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
public class ScheduleAbsencePage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Schedule Absence')]")
	private WebElement btnScheduleAbsence;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'TIME:0:MAnt2:1:pt1:soc1::content')]")
	private WebElement selectType;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'TIME:0:MAnt2:1:pt1:soc2::content')]")
	private WebElement selectFrequency;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrHWM_HCMWFMWORKAREA_FUSE_TIME:0:MAnt2:1:pt1:id7::glyph']")
	private WebElement imageStartDatePicker;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'TIME:0:MAnt2:1:pt1:soc121::content')]")
	private WebElement selectReason;
	
	@FindBy(how=How.XPATH, using = "//textarea[contains(@id,'TIME:0:MAnt2:1:pt1:it5::content')]")
	private WebElement txtAreaComments;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrHWM_HCMWFMWORKAREA_FUSE_TIME:0:MAnt2:1:pt1:cil1::icon']")
	private WebElement iconCalculateAccruals;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Submit')]")
	private WebElement buttonSubmit;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'pt1:d6::ok')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'_FOpt1:_FOr1:0:_FOSrHWM_HCMWFMWORKAREA_FUSE_TIME:0:MAnt2:2:pt1:d6::_ttxt')]")
	private WebElement txtConfirmation;
	
	@FindBy(how=How.XPATH, using = "//td[contains(@id,'TIME:0:MAnt2:1:pt1:d9::contentContainer')]")
	private WebElement txtErrorMsg;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_FOpt1:_FOr1:0:_FOSrHWM_HCMWFMWORKAREA_FUSE_TIME:0:MAnt2:1:pt1:id7')]/tbody/tr/td/div/div[1]/div/div/table/tbody/tr[1]/td[2]")
	private WebElement txtDateErrorMsg;
	
	
	
	//button[contains(@id,'TIME:0:MAnt2:1:pt1:d6::ok')]
	 /*  public void selectArrivalDate(WebDriver driver,int arrival)
       {
         

       Calendar cal=Calendar.getInstance();
       Month month=Month.of(cal.get(Calendar.MONTH)+1);
       Year year=Year.of(cal.get(Calendar.YEAR));
       int intyear=year.getValue();
      int intmonth=month.getValue();
      String strmonth=month.toString();
      String stryear=year.toString();
     int  currentday=cal.get(Calendar.DAY_OF_MONTH);
     int  lastday=cal.getActualMaximum(Calendar.DATE);
     int  weekofmonth=cal.get(Calendar.WEEK_OF_MONTH);
       if(arrival!=0)
       {
       cal.add(Calendar.DAY_OF_MONTH, arrival);
       currentday=cal.get(Calendar.DAY_OF_MONTH);
       weekofmonth=cal.get(Calendar.DAY_OF_WEEK);
       strmonth=month.of(cal.get(Calendar.MONTH)+1).toString();
       stryear=year.of(cal.get(Calendar.YEAR)).toString();
         
       }
       strmonth=strmonth.substring(0, 1).toUpperCase()+strmonth.substring(1).toLowerCase();
       String strday=String.valueOf(currentday);
      // MobileDriver mbdriver=(MobileDriver)driver;
      // WebElement Arrivaldate=mbdriver.findElementByAccessibilityId(strmonth+" "+strday);
     //  WebElement Arrivaldate=driver.findElement(By.xpath(xpathExpression));
       
      // Arrivaldate.click();

       }*/

	public void selectStartDate(String noOfDays)
	{
		WebElement dateWidget = driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrHWM_HCMWFMWORKAREA_FUSE_TIME:0:MAnt2:1:pt1:id7::pop::cd']/tbody/tr[2]/td"));
		List<WebElement> rows=dateWidget.findElements(By.tagName("tr")); 
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
		  
		  for (WebElement cell:columns)
		  {
		   if (cell.getText().equals(noOfDays))
		   {
		     cell.click();
			   SeleniumUtils.delay(3000);
			   break;
		   }
		  } 
		  
		/*  if (txtDateErrorMsg.isDisplayed())
			 {
			  report.log(LogStatus.FAIL, "Step Fail. Try with different date to apply leave");
			 }
			 else
			 {
				 report.log(LogStatus.INFO, "Step Pass. Entered date is valid");
			 }*/
		}
	
	 public ScheduleAbsencePage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(btnScheduleAbsence));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Schedule Absence Page *****************************");
	     this.getScreenDetails();
	 }

	 public boolean isScheduleAbsenceDisplayed()
	 {
	    	return btnScheduleAbsence.isDisplayed();
	 }
	 
	 public void enterComments(String strComments)
	 {
		 txtAreaComments.sendKeys(strComments);
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("After Comments");
	 }
	
	 
	 public void clickScheduleAbsenceButton()
	 {
		 	btnScheduleAbsence.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("After Schedule Absence Button click");
		    report.log(LogStatus.PASS, "Clicked on Schedule Absence button");
	 }
	 
	 
	 public void clickCalculateAccruals()
	 {
		 iconCalculateAccruals.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("After Accrual click");
	 }
	 
	 
	 public void clickSubmitButton()
	 {
		 buttonSubmit.click();
		 SeleniumUtils.delay(10000);
		 this.getScreenDetails("After Submit click");
		/* if (buttonOK.isDisplayed())
		 {
			 buttonOK.click();
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("After Submit click");
		 }
		 else  if (txtErrorMsg.isDisplayed())
		 {
			 buttonOK.click();
			 report.log(LogStatus.FAIL, "Step Fail. Try with different date to apply leave");
		 }*/
		}
	 
	 public void clicOKButton()
	 {
			 buttonOK.click();
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("After Ok button click");
	 }
	
	 public void clickStartDatePicker()
	 {
		 	imageStartDatePicker.click();
			SeleniumUtils.delay(2000);
			report.log(LogStatus.PASS, "Clicked on Start Date icon");
			 this.getScreenDetails("Start Date Picker");
	 }
	 
	 public void selectType(String strType)
	 {
		 	selectType.click();
		 	report.log(LogStatus.PASS, "Select any leave type from Type dropdown");
	    	Select objSelect = new Select(selectType);
	    	objSelect.selectByVisibleText(strType);
	    	//SeleniumUtils.delay(5000);
	    	 wdwait.until(ExpectedConditions.visibilityOf(selectFrequency));
	    	this.getScreenDetails("LeaveType");
	 }
	 
	 public void selectFrequency(String strFrequency)
	 {
		 	selectFrequency.click();
		 	report.log(LogStatus.PASS, "Select any value from Frequency dropdown");
	    	Select objSelect = new Select(selectFrequency);
	    	objSelect.selectByVisibleText(strFrequency);
//	    	SeleniumUtils.delay(5000);
	    	wdwait.until(ExpectedConditions.visibilityOf(imageStartDatePicker));
	    	this.getScreenDetails("Frequency");
	 }
	 
	 public void selectReason(String strReason)
	 {
	    	report.log(LogStatus.PASS, "Select any value from Frequency dropdown");
	    	Select objSelect = new Select(selectReason);
	    	objSelect.selectByVisibleText(strReason);
	    	SeleniumUtils.delay(2000);
	 }
	 	 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "Schedule Absence Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, btnScheduleAbsence, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "Schedule Absence", context);
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
