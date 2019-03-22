package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EditAccountingPeriodStatusesPage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table1::db')]//div//td")
    private WebElement tblPeriodToClose;
 
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:ctb3')]")
    private WebElement btnClosePeriod;
 
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:ctb1')]")
    private WebElement btnOpenPeriod;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:d13::ok')]")
    private WebElement btnConfOk;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:SPb')]")
    private WebElement btnDone;
	
	
	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public EditAccountingPeriodStatusesPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(btnClosePeriod));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Edit Accounting Period Statuses Page *****************************");
	       this.getScreenDetails();
	    }
    
    
 // Select Edit Accounting Period Statuses
	   public void selectEditAccountingPeriodStatuses(String closePeriod)
		{

		  // List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'ap1:AT1:_ATp:table1::db')]//div//td"));  
		   
		   List<WebElement> Cols = driver.findElements(By.xpath("//*[contains(@id,'ap1:AT1:_ATp:table1::db')]/table/tbody/tr[1]//div//td")); 
		   System.out.println("Number of cols"+Cols.size());
		   
		   List<WebElement> Rows = driver.findElements(By.xpath("//*[contains(@id,'ap1:AT1:_ATp:table1::db')]//div//td[1]")); 
		   System.out.println("Number of rows "+Rows.size());
		  
		   int r;
		   for(r=1;r<=Rows.size();r++) {
			   
			  String AccPeriod = driver.findElement(By.xpath("//*[contains(@id,'ap1:AT1:_ATp:table1::db')]/table/tbody/tr["+r+"]//div//td[1]")).getText();
			  System.out.println(AccPeriod);
			  if (AccPeriod.equalsIgnoreCase(closePeriod))
			   {
				  SeleniumUtils.delay(2000);
				  WebElement imgStatus = driver.findElement(By.xpath("//*[contains(@id,'ap1:AT1:_ATp:table1::db')]/table/tbody/tr["+r+"]/td/div/table/tbody/tr/td[6]"));
				  //SeleniumUtils.delay(5000);
				  imgStatus.click();
				  SeleniumUtils.delay(5000);
				  //System.out.println("Value is "+btnStatus);
				  report.log(LogStatus.PASS, "Selected Period to close is: "+closePeriod);
				  break;
			   }
			   
		   } 
			
		  }  
	   
	   // Click Close Period Button
	   
	   public void clickClosePeriodButton(){
		   this.getScreenDetails();
		   SeleniumUtils.delay(2000);
		   btnClosePeriod.click();
		   report.log(LogStatus.PASS, "Clicked on Close Period Button");
		   /*String bValue = "false";
		   
		   bValue = btnClosePeriod.getAttribute("aria-disabled");
		   
		   if(bValue.equalsIgnoreCase("true")){
			   SeleniumUtils.delay(2000);
			   btnClosePeriod.click();
			   report.log(LogStatus.PASS, "Clicked on Close Period Button");
		   }else {
			   report.log(LogStatus.FAIL,"Close Period Button is not enabled");
			  //return bValue;
		   }*/
	
	    }
	   
	   
	   public boolean isClosePeriodButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnClosePeriod, context.getReactTimeout());  	
	   } 
	   
	   
	   // Open Period Button
	   
	   public void clickOpenPeriodButton(){
		   this.getScreenDetails();
		   SeleniumUtils.delay(2000);
		   btnOpenPeriod.click();
		   report.log(LogStatus.PASS, "Clicked on Open Period Button");
	    }
	   
	   
	   public boolean isOpenPeriodButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnOpenPeriod, context.getReactTimeout());  	
	   } 
	   
	// Confirmation Ok Button   
	   public boolean isConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	   }  
   
	   public void clickConfOkButton(){
		   this.getScreenDetails("Confirmation Pop-up");
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
		  
	   } 
	   
	   
	// Done Button   
	   public boolean isDoneButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnDone, context.getReactTimeout());  	
	   }  
   
	   public void clickDoneButton(){
		   this.getScreenDetails();
		   btnDone.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Done Button");
		  
	   } 
	   
	   
	   

    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Edit Accounting Period Statuses Page is Loaded Successfully");
    	 if(btnClosePeriod.isDisplayed())
    	 {
    		 return true;
    		 
    	 } else {
    		 return false;
    	 }     	
	}
    
    public Item getScreenDetails(String strTitle){
        String xyz = Screenshot.takeScreenshotX(driver, strTitle, context);
        report.addScreenCapture(xyz);
        String projectPath = System.getProperty("user.dir");          
        String fullprojectPath = projectPath+"/report/"+xyz;
        report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>"+strTitle+"</span></a>");
        return new Item(xyz);
    }
    
    
	public Item getScreenDetails(){
	   	String xyz = Screenshot.takeScreenshotX(driver, "EntryLogin", context);
	   	report.addScreenCapture(xyz);
	   	String projectPath = System.getProperty("user.dir");    	
	   	String fullprojectPath = projectPath+"/report/"+xyz;
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Accounting Period Statuses Page</span></a>");
	   	return new Item(xyz);
   }

    
}
