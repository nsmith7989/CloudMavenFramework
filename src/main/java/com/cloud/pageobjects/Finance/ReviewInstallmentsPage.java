package com.cloud.pageobjects.Finance;

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

public class ReviewInstallmentsPage extends BasePageObject{
	
	public WebDriver driver;
	
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:APsv2::popEl')]")
 		private WebElement lstSave;
 	
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:commandMenuItem2')]")
		private WebElement lstTerminateRequest;
 	
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'terminatePprRevDialog::ok')]")
 		private WebElement btnTerminateOk;
	
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'msgDlg::cancel')]")
		private WebElement btnConfOk;
 	
 	
 	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
 	public ReviewInstallmentsPage(WebDriver driver, ExtentTest report) throws TestException {
     super(report);
	 this.driver=driver; 
	 wdwait=new WebDriverWait(driver, 60);
     PageFactory.initElements(driver, this);
     
     wdwait.until(ExpectedConditions.visibilityOf(lstSave));
     if (!isDisplayed()) 
     {
        throw new TestException(this.getClass().getName() + " is not loaded");
     }
     
        System.out.println("******************************* Review Installments Page *****************************");
       this.getScreenDetails();
    }

 // Save list
	   
	   public void clickSaveList() throws InterruptedException{ 
		   lstSave.click();
		   SeleniumUtils.delay(2000);
		   //wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
		   report.log(LogStatus.PASS, "Clicked on Save list");
	   }
	   
	   public boolean isSaveListDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lstSave, context.getReactTimeout());
	   }
 	
// TerminateRequest list
	   
	   public void clickTerminateRequestist() throws InterruptedException{ 
		   lstTerminateRequest.click();
		   SeleniumUtils.delay(2000);
		   //wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
		   report.log(LogStatus.PASS, "Clicked on Terminate Request list");
	   }
	   
	   public boolean isTerminateRequestListDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lstTerminateRequest, context.getReactTimeout());
	   }
 	
// TerminateRequest warning Ok button
	   
	   public void clickTerminateOkButton() throws InterruptedException{ 
		   btnTerminateOk.click();
		   SeleniumUtils.delay(2000);
		   //wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
		   report.log(LogStatus.PASS, "Clicked on Tarminated Warning Ok Button");
	   }
	   
	   public boolean isTerminateOkBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnTerminateOk, context.getReactTimeout());
	   }  
	   
	// Confirmation Ok Button   
	   public boolean isConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	   }  
   
	   public void clickConfOkButton(){
		  // String strProcess =lblConfText.getText();
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
		  
	   } 
	   
 	
 	
 	 @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Review Installments page is Loaded Successfully");
	    	 if(lstSave.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Review Installments Page</span></a>");
		   	return new Item(xyz);
	   }
}
