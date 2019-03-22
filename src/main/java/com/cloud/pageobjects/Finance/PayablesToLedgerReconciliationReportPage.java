package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class PayablesToLedgerReconciliationReportPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'8_1_dropdownIcon')]")
	    private WebElement selectLedger;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'9_1_dropdownIcon')]")
	    private WebElement selectRequestName;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='gobtn']")
	    private WebElement btnApply;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:SPb')]")
	    private WebElement btnDone;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public PayablesToLedgerReconciliationReportPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnDone));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Payables to Ledger Reconciliation Report Page *****************************");
		       this.getScreenDetails();
		    }
	    
	  //Ladger
	    
	    public boolean isLadgerDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver,  selectLedger, context.getReactTimeout());	
			   
		   } 
	    
	    public void clickLadgerButton(){
	    	SeleniumUtils.delay(5000);
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();",selectLedger);
	    	//btnTasks.click();
	    	//wdwait.until(ExpectedConditions.visibilityOf(lnkCreateinvoice));

			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Done Button");
		   }
		   
	    
		   public void SelectLadger(String strLadger) throws InterruptedException{
			   SeleniumUtils.delay(2000);
		   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
			   //selectLedger.click();
		   		//SeleniumUtils.isDisplayed(driver, selectLedger, context.getReactTimeout());
		   		WebDriverWait wait = new WebDriverWait(driver, 50);
		   		WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[contains(text(), '"+strLadger+"')]")));
		   		SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(3000);
		    report.log(LogStatus.PASS, "Selected Ladger  is: "+strLadger);
		   }
	    
		 //Request Name
		   public void SelectRequestName(String strReqName) throws InterruptedException{
			   SeleniumUtils.delay(5000);
		   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
			   selectRequestName.click();
			   WebDriverWait wait = new WebDriverWait(driver, 50);
		   		WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[contains(text(), '"+strReqName+"')]")));
		   		SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(3000);
		    report.log(LogStatus.PASS, "Selected Ladger  is: "+strReqName);
		   }
		   
		   //Apply button 
		   public void clickApplyButton(){	
			   this.getScreenDetails();
			   btnApply.click();
			   report.log(LogStatus.PASS, "Clicked on Apply Button");
		   }
		   
		   public boolean isApplyBtnDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver,  btnApply, context.getReactTimeout());		 
		   }  
		   
		   //Done button 
		   public void clickDoneButton(){	
			   this.getScreenDetails();
			   btnDone.click();
			   report.log(LogStatus.PASS, "Clicked on Done Button");
		   }
		   
		   public boolean isDoneBtnDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver,  btnDone, context.getReactTimeout());		 
		   }  
		   
		   
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Payables to Ledger Reconciliation Report is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Payables to Ledger Reconciliation Report Page</span></a>");
		   	return new Item(xyz);
	   }

}
