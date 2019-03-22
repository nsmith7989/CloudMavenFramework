package com.cloud.pageobjects.Finance;

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

public class EditJournalPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'journals:0:MAnt2:2:pt1:ap1:showMoreHeader')]")
	    private WebElement lnkShowMore;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'journals:0:MAnt2:2:pt1:ap1:sdi7::disAcr')]")
	    private WebElement lnkReversal;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'journals:0:MAnt2:2:pt1:ap1:accrualRevPeriodName::lovIconId')]")
	    private WebElement srchReversalPeriod;
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'Popup::popupsearch')]")
	   private WebElement lnkRvsPeriodSearch;
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId:value00::content')]")
	   private WebElement txtPeriodName;
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId::search')]")
	   private WebElement btnPrdNameSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':accrualRevPeriodName_afrLovInternalTableId::db')]/table/tbody")
	   private WebElement strPeriodName;
	
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'lovDialogId::ok')]")
	   private WebElement btnAccPeriodOk;
	 
	 //****************************************** Reversal period Textbox
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'journals:0:MAnt2:2:pt1:ap1:accrualRevPeriodName::content')]")
	   private WebElement txtReversalPeriod;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:accrualRevPeriodName::lovIconId')]")
	   private WebElement SrchReversalPeriodIcon;
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:2:pt1:ap1:userResponsePopupDialogButtonYes']")
	   private WebElement warningPopUpOk;
 	
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'serResponsePopupDialogButtonOk')]")
	   private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':saveBatch')]/table/tbody/tr/td[1]/a/span")
	   private WebElement btnSave;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'journals:0:MAnt2:2:pt1:ap1:m1')]/div/table/tbody")
	   private WebElement menuJournalBatchAction;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:ap1:deleteBatch')]")
	   private WebElement lstJournalBatchDelete;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'journals:0:MAnt2:2:pt1:ap1:m2')]/div/table/tbody")
	   private WebElement menuJournalAction;
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:2:pt1:ap1:cmi2']/td[2]")
	   private WebElement menuReverse;
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:2:pt1:ap1:deleteHeader']/td[2]")
	   private WebElement lstJournalDelete;
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:2:pt1:ap1:userResponsePopupDialogButtonYes']")
	   private WebElement btnWarningYes;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'MAnt2:2:pt1:ap1:yesDeleteHeader')]")
	   private WebElement btnDeleteConfYes;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:2:pt1:ap1:saveBatch::popEl')]")
	   private WebElement menuSave;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:2:pt1:ap1:cmi4')]")
	   private WebElement lstSaveAndClose;
	 
	
	 
	 public WebDriverWait wdwait; 
	    
		/**
		* Initializing page objects for Manage Journals Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public EditJournalPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(lnkShowMore));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Edit Journal Page *****************************");
		       this.getScreenDetails();
		    }
	
	    
	    // ShowMore link in Journal Section
	    
	    public void clickshowMoreLink(){	
	    	lnkShowMore.click();
	    	//SeleniumUtils.delay(5000);
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkReversal));
	 	   report.log(LogStatus.PASS, "Clicked on Show More link");
	    }
	    
	    public boolean isshowMoreLinkDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, lnkShowMore, context.getReactTimeout());
	    } 
	    
	    // Reversal Link
	    
	    public void clickReversalLink(){	
	    	lnkReversal.click();
	    	//SeleniumUtils.delay(5000);
	    	wdwait.until(ExpectedConditions.visibilityOf(txtReversalPeriod));
	 	   report.log(LogStatus.PASS, "Clicked on Reversal link");
	    }
	    
	    public boolean isReversalLinkDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, lnkReversal, context.getReactTimeout());
	    } 
	    
	    // Reversal Period 
	    
// search Reversal Period 
	    
	    public void clickReversalPeriodSearchIcon() throws InterruptedException{
	 	   
	    	SeleniumUtils.delay(2000);
	 		JavascriptExecutor js = (JavascriptExecutor)driver;
	     	js.executeScript("arguments[0].click();", srchReversalPeriod);
	     	SeleniumUtils.delay(3000);
	 	   report.log(LogStatus.PASS, "Clicked on Reversal Period Search Icon");
	    }
	    
	    public boolean isRvrsPeriodSearchIconDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, srchReversalPeriod, context.getReactTimeout());
	    } 
	
	    
	    // Search link Reversal Period
	    
	    public void clickReversalPeriodSearchLink(){	
	    	lnkRvsPeriodSearch.click();
	    	SeleniumUtils.delay(5000);
	 	   report.log(LogStatus.PASS, "Clicked on Reversal Period Search link");
	    }
	    
	    public boolean isRvrsPeriodSearchLinkDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, lnkRvsPeriodSearch, context.getReactTimeout());
	    }   
	    
	  //Verify  Reversal Period Name  field
	    public boolean isReversalPeriodNameDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, txtPeriodName, context.getReactTimeout());
	    }
	    
	  //Enter text into Reversal Period Name  field
	    public void enterReversalPeriodName(String Period){
	    	txtPeriodName.clear();
	    	txtPeriodName.click();
	    	txtPeriodName.sendKeys(Period);
	    	SeleniumUtils.delay(3000);
	 	   report.log(LogStatus.PASS, "Entered Period Name  is: "+Period);
	    } 
	    
	    // Search Button in Reversal Period Name
	    
	    public void clickPeriodSearchButton(){	
	    	btnPrdNameSearch.click();
	 	   report.log(LogStatus.PASS, "Clicked on Period Name Search Button");
	    }
	    
	    public boolean isPeriodSearchButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnPrdNameSearch, context.getReactTimeout());
	    } 
	    
	 // Reversal Period Value verification
	    public void clickReversalPeriodNameValue() throws InterruptedException{	
	    	SeleniumUtils.delay(3000);
	    	strPeriodName.click();
	       	SeleniumUtils.delay(3000);
	 	   report.log(LogStatus.PASS, "Selected Accounting Period Name from list");
	    }
	    
	    public boolean isReversalPeriodNameValueDisplayed(){
		 	   return SeleniumUtils.isDisplayed(driver, strPeriodName, context.getReactTimeout());
		    }  
	
	    
	    // Search Ok button Reversal Period
	    
	    public void clickReversalPeriodOkButton(){	
	    	btnAccPeriodOk.click();
	       	SeleniumUtils.delay(2000);
	 	   report.log(LogStatus.PASS, "Clicked on Reversal Accounting Period Ok Button");
	    }
	    
	    public boolean isReversalPeriodOkButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnAccPeriodOk, context.getReactTimeout());
	    }
	    
	  //****************************************** Reversal period Textbox
	    
	  //Enter text into Reversal Period Name  field
	    public void enterReversalPeriodTextbox(String reversalPeriod){
	    	//txtReversalPeriod.clear();
	    	//txtReversalPeriod.click();
	    	//txtReversalPeriod.sendKeys(reversalPeriod);
	    	JavascriptExecutor jst= (JavascriptExecutor) driver;
	    	jst.executeScript("arguments[1].value = arguments[0]; ", reversalPeriod, txtReversalPeriod);
	    	SeleniumUtils.delay(5000);
	    	txtReversalPeriod.sendKeys(Keys.TAB);
	    	//txtReversalPeriod.sendKeys(Keys.TAB);
	    	SeleniumUtils.delay(3000);
	    	
	 	   report.log(LogStatus.PASS, "Entered Period Name  is: "+reversalPeriod);
	    } 
	    
	    
	    public void clickWarningPopUpOkButton(){	
	    	warningPopUpOk.click();
	    	SeleniumUtils.delay(5000);
	 	   report.log(LogStatus.PASS, "Clicked on Journal Action Menu");
	    }
	    
	    public boolean isWarningPopUpOkButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, warningPopUpOk, context.getReactTimeout());
	    }   
	   
// Confirmation OK button
	    
	    public void clickConfOkButton(){	
	 	   btnConfOk.click();
	 	   SeleniumUtils.delay(5000);
	 	   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	 	  report.log(LogStatus.PASS, "Journal reversed successfully");
	    }
	    
	    public boolean isConfOkButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	    }  
	
	    
	    // Journal Menu Action
	    
	    public void clickJournalActionMenu(){	
	    	menuJournalAction.click();
	    	SeleniumUtils.delay(5000);
	 	   report.log(LogStatus.PASS, "Clicked on Journal Action Menu");
	    }
	    
	    public boolean isJournalActionMenuDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, menuJournalAction, context.getReactTimeout());
	    }   
	    
	    // Reversal Link under Journal Menu Action
	    
	    public void clickReversalMenuLink(){	
	    	menuReverse.click();
	    	SeleniumUtils.delay(8000);
	       	this.getScreenDetails();
	 	   report.log(LogStatus.PASS, "Clicked on Reversal link under Journal Action");
	    }
	    
	    public boolean isReversalMenuLinkDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, menuReverse, context.getReactTimeout());
	    }   
	    
	    // Save Button
	    
	    public void clickSaveButton(){	
		 	   btnSave.click();
		 	  SeleniumUtils.delay(3000);
		 	   report.log(LogStatus.PASS, "Clicked on Save Button");
		    }
		    
		    public boolean isSaveButtonDisplayed(){
		 	   return SeleniumUtils.isDisplayed(driver, btnSave, context.getReactTimeout());
		    	
		    }
	    
		  //menuJournalBatchAction
		    public void clickJournalBatchActionMenu(){	
		    	menuJournalBatchAction.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(lstJournalBatchDelete));
		 	   report.log(LogStatus.PASS, "Clicked on Journal Batch Action Menu");
		    }
		    
		    public boolean isJournalBatchActionMenuDisplayed(){
		 	   return menuJournalBatchAction.isDisplayed();
		    } 
		    
		  //lstJournalBatchDelete
		    public void clickJournalBatchDeleteList(){	
		    	lstJournalBatchDelete.click();
		        wdwait.until(ExpectedConditions.visibilityOf(btnWarningYes));
		 	   report.log(LogStatus.PASS, "Clicked on Delete option from Journal Batch Action Menu");
		    }
		    
		    public boolean isJournalBatchDeleteListDisplayed(){
		 	   return lstJournalBatchDelete.isDisplayed();
		    }  
		    
		    public boolean isJournalBatchDeleteListEnabled(){
			 	   return lstJournalBatchDelete.isEnabled();
			    }  
		    
		    // Warning Yes button
		    public boolean isWarningYesButtonDisplayed(){
			 	   return btnWarningYes.isDisplayed();
			    }  
		    
		    public void clickWarningYesButton(){	
		    	btnWarningYes.click();
		    	SeleniumUtils.delay(3000);
		 	   report.log(LogStatus.PASS, "Clicked on Yes button");
		    }
		  //lstJournalDelete
		    public void clickJournalDeleteList(){	
		    	lstJournalDelete.click();
		        wdwait.until(ExpectedConditions.visibilityOf(btnDeleteConfYes));
		 	   report.log(LogStatus.PASS, "Clicked on Delete option from Journal Action Menu");
		    }
		    
		    public boolean isJournalDeleteListDisplayed(){
		 	   return lstJournalDelete.isDisplayed();
		    }  
		    
		    public boolean isJournalDeleteListEnabled(){
			 	   return lstJournalDelete.isEnabled();
			    } 
		    
		    //btnDeleteConfYes
		    public boolean isDeleteConfYesButtonDisplayed(){
			 	   return btnDeleteConfYes.isDisplayed();
			    }  
		    
		    public void clickDeleteConfYesButton(){	
		    	btnDeleteConfYes.click();
		    	SeleniumUtils.delay(2000);
		 	   report.log(LogStatus.PASS, "Clicked on Yes button");
		    }
		    
		    //menuSave
		    
		    public void clickSaveMenu(){
		    	SeleniumUtils.delay(2000);
		    	menuSave.click();
		        wdwait.until(ExpectedConditions.visibilityOf(lstSaveAndClose));
		 	   report.log(LogStatus.PASS, "Clicked on Save Menu");
		    }
		    
		    public boolean isSaveMenuDisplayed(){
		 	   return menuSave.isDisplayed();
		    }  
		   //lstSaveAndClose 
		    public void clickSaveAndCloseList(){	
		    	lstSaveAndClose.click();
		        
		 	   report.log(LogStatus.PASS, "Clicked on Save and Close option in Save Menu");
		    }
		    
		    public boolean isSaveAndCloseListDisplayed(){
		 	   return lstSaveAndClose.isDisplayed();
		    }  	 
		    
		 
	    
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Verify that ShowMore link is displayed or not");
    	 if(lnkShowMore.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Journal Page</span></a>");
	   	return new Item(xyz);
   }

}
