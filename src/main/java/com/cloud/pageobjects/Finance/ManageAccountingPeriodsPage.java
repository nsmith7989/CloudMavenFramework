package com.cloud.pageobjects.Finance;

import java.util.Iterator;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class ManageAccountingPeriodsPage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:SPb')]")
    private WebElement btnDone;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table1::db')]//td")
    private WebElement tblLedger;
	
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public ManageAccountingPeriodsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnDone));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Manage Accounting Periods Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    
	 // Select Ledger from Table
		   public void selectTableLadger(String strLedger)
			{

				List<WebElement> anchors = driver.findElements(By.xpath("//a[contains(@id,'tableCommandLink')]"));
				
				Iterator<WebElement> i = anchors.iterator();

		        while(i.hasNext()) {
		        	
		            WebElement anchor = i.next();
		            if(anchor.getText().contains(strLedger)) {
		            	
		                anchor.click();
		                SeleniumUtils.delay(5000);
		                report.log(LogStatus.PASS, "Selected Ladger is: "+strLedger);
		                break;
		            }
		        }
				
			  }
		   
		// Done Button   
		   public boolean isDoneButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnDone, context.getReactTimeout());  	
		   }  
	   
		   public void clickDoneButton(){
			   this.getScreenDetails();
			   btnDone.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Done button Button");
			  
		   } 
		
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Manage Accounting Periods page is Loaded Successfully");
	    	 if(btnDone.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Accounting Periods Page</span></a>");
		   	return new Item(xyz);
	   }

}
