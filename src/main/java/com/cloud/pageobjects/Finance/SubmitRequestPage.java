package com.cloud.pageobjects.Finance;

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

public class SubmitRequestPage extends BasePageObject{
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'SubledgerApplicationAttr::content')]")
	    private WebElement selectSubledgerApplicn;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'LedgerAttr::content')]")
	    private WebElement selectLedger;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ATTRIBUTE13_ATTRIBUTE13::content')]")
	    private WebElement txtJournalBatch	;
	
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'ATTRIBUTE5_ATTRIBUTE5::content')]")
	    private WebElement selectProcCatagory;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfText;
	 
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmationPopup:confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	
	 public WebDriverWait wdwait; 
	
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    	    
	    public SubmitRequestPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(selectSubledgerApplicn));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Submit Request Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    // Select Subledger Application 
		   public void selectSubledgerApplication(String strSubAppl){
			  
		    	//report.log(LogStatus.PASS, "Select File type from SelectFile dropdown");
		    	Select objSelect = new Select(selectSubledgerApplicn);
		    	objSelect.selectByVisibleText(strSubAppl);
		    	//objSelect.selectByIndex(strFile);
		    	//SeleniumUtils.delay(15000);
		    	report.log(LogStatus.PASS, "Selected Subledger Application  is: "+strSubAppl);
		    }
		   
		   public boolean isSubledgerApplicationDisplayed(){
			   //return SeleniumUtils.isDisplayed(driver, selectSubledgerApplicn, context.getReactTimeout());
			   return selectSubledgerApplicn.isDisplayed();
		   }
	    
	   //Ledger 
		   
		   public void SelectLedger(String strLedger) throws InterruptedException{
			   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
			   SeleniumUtils.delay(2000);
			   selectLedger.click();
			   	//SeleniumUtils.isDisplayed(driver, selectCategory, context.getReactTimeout());
			   selectLedger.sendKeys(strLedger);
			   	//selectCategory.sendKeys(Keys.ARROW_DOWN);
			   selectLedger.sendKeys(Keys.ENTER);
			   	SeleniumUtils.delay(3000);
			    report.log(LogStatus.PASS, "Selected Category  is: "+strLedger);
			   }
			  
			   public boolean isSelectLedgerDisplayed(){
				  // return SeleniumUtils.isDisplayed(driver, selectLedger, context.getReactTimeout());
				   return selectLedger.isDisplayed();
				   } 
		   
		   public void enterLedger(String strSupplier){
			   selectLedger.clear();
			   selectLedger.click();
			   selectLedger.sendKeys(strSupplier);
			   report.log(LogStatus.PASS, "Selected Ledger is: "+strSupplier);
		   }
		   
	   // Journal Batch
		   
		   public void clickJournalBatch(){
			   txtJournalBatch.click();  
			  // report.log(LogStatus.PASS, "Selected Ledger is: "+strSupplier);
		   }
		   
		   
	    
		// Select Process Category	 
		   public void selectProcessCategory(String strPrcCatagory){
			  
		    	//report.log(LogStatus.PASS, "Select File type from SelectFile dropdown");
		    	Select objSelect = new Select(selectProcCatagory);
		    	objSelect.selectByVisibleText(strPrcCatagory);
		    	//objSelect.selectByIndex(strFile);
		    	//SeleniumUtils.delay(15000);
		    	report.log(LogStatus.PASS, "Selected Process Category  is: "+strPrcCatagory);
		    }
		   
		   public boolean isProcessCategoryDisplayed(){
			  // return SeleniumUtils.isDisplayed(driver, selectProcCatagory, context.getReactTimeout());
			   return selectProcCatagory.isDisplayed();
		   }
		   
		   
		// Submit button
		   
		   public boolean isSubmitButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());  	
		   }  
		   
		   public void clickSubmitButton(){	
			   btnSubmit.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   //SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
		   }
		   
		// Confirmation Ok Button   
		   public boolean isConfOkButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  
			   //return btnConfOk.isDisplayed();
		   }  
	   
		   public void clickConfOkButton(){
			   String strProcess =lblConfText.getText();
			   btnConfOk.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, ""+strProcess+" and Clicked on Confirmation Ok Button");
			  
		   }
	    
		@Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Submit Request page is Loaded Successfully");
	    	 if(selectSubledgerApplicn.isDisplayed())
	    	 {
	    		 return true;
	    		 
	    	 } else {
	    		 return false;
	    	 }     	
		}
	   
		public Item getScreenDetails(){
		   	String xyz = Screenshot.takeScreenshotX(driver, "EntryLogin", context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Submit Request Page</span></a>");
		   	return new Item(xyz);
	   }
		
	 
	

}
