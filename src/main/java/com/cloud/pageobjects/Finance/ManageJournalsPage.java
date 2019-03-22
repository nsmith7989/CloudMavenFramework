package com.cloud.pageobjects.Finance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ManageJournalsPage extends BasePageObject{
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:value00::content')]")
	    private WebElement txtJournals;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'accounting_journals:0:MAnt2:1:pt1:ap1:queryP:value10::content')]")
	    private WebElement txtJournalBatch;
	 
	
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'general_accounting_journals:0:MAnt2:1:pt1:ap1:queryP:value20::lovIconId')]")
	    private WebElement srchAccountingPeriod;
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'Popup::popupsearch')]")
	   private WebElement lnkAcPeriodSearch;
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId:value00::content')]")
	   private WebElement txtPeriodName;
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId::search')]")
	   private WebElement btnPrdNameSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'queryP:value20_afrLovInternalTableId::db')]/table/tbody")
	   private WebElement strPeriodName;
	
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'lovDialogId::ok')]")
	   private WebElement btnAccPeriodOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'accounting_journals:0:MAnt2:1:pt1:ap1:queryP::search')]")
	   private WebElement btnJournalsSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'accounting_journals:0:MAnt2:1:pt1:ap1:AT1:_ATp:t1::db')]/table/tbody/tr/td[3]")
	   private WebElement linkCellJournal;
	 
	 @FindBy(how=How.XPATH, using = " .//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:AT1:_ATp:t1:0:commandLink3']")
	   private WebElement linkCell;
	
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:AT1:_ATp:edit::icon']")
	   private WebElement iconEdit;

	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:2:pt1:ap1:APph::_afrTtxt']/div/h1")
	   private WebElement pageEditJournal;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':saveBatch')]/table/tbody/tr/td[1]/a/span")
	   private WebElement btnSave;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'postBatch')]/table/tbody/tr/td[1]/a")
	   private WebElement btnPost;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'serResponsePopupDialogButtonOk')]")
	   private WebElement btnConfOk;
	
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:SPb']/a")
	   private WebElement btnDone;
		
	 public WebDriverWait wdwait; 
	    
		/**
		* Initializing page objects for Manage Journals Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public ManageJournalsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		        System.out.println("******************************* Manage Journals Page *****************************");
		       this.getScreenDetails();
		    }
	 
	  //Verify  Journal  field
	    public boolean isJournalDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, txtJournals, context.getReactTimeout());
	    }
	    
	  //Enter text into Journal  field
	    public void enterJournal(String journal){
	    	txtJournals.clear();
	    	txtJournals.click();
	    	txtJournals.sendKeys(journal);
	 	   report.log(LogStatus.PASS, "Entered journal  is: "+journal);
	    }
	    
	  //Enter text into Journal Batch  field
	    public void enterJournalBatch(String journalBatch){
	    	 txtJournalBatch.clear();
	    	 txtJournalBatch.click();
	    	 txtJournalBatch.sendKeys(journalBatch);
	 	   report.log(LogStatus.PASS, "Entered journal Batch  is: "+journalBatch);
	    }
	    
	    public boolean isJournalBatchDisplayed(){
		 	   return SeleniumUtils.isDisplayed(driver, txtJournalBatch, context.getReactTimeout());
		    }
	   
	    
	 // search Accounting Period 
	    
	    public void clickAccountingPeriodSearchIcon() throws InterruptedException{
	 	   
	    	SeleniumUtils.delay(2000);
	 		JavascriptExecutor js = (JavascriptExecutor)driver;
	     	js.executeScript("arguments[0].click();", srchAccountingPeriod);
	     	SeleniumUtils.delay(3000);
	  
	 	   report.log(LogStatus.PASS, "Clicked on Accounting Period Search Icon");
	    }
	    
	    public boolean isAccPeriodSearchIconDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, srchAccountingPeriod, context.getReactTimeout());
	    } 

	    // Search link Accounting Period
	    
	    public void clickAccPeriodSearchLink(){	
	    	lnkAcPeriodSearch.click();
	    	SeleniumUtils.delay(5000);
	 	   report.log(LogStatus.PASS, "Clicked on Accounting Period Search link");
	    }
	    
	    public boolean isAccPeriodSearchLinkDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, lnkAcPeriodSearch, context.getReactTimeout());
	    } 
	   
	    //Verify  Period Name  field
	    public boolean isPeriodNameDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, txtPeriodName, context.getReactTimeout());
	    }
	    
	  //Enter text into Period Name  field
	    public void enterPeriodName(String Period){
	    	txtPeriodName.clear();
	    	txtPeriodName.click();
	    	txtPeriodName.sendKeys(Period);
	    	SeleniumUtils.delay(3000);
	 	   report.log(LogStatus.PASS, "Entered Period Name  is: "+Period);
	    } 
	    
 // Search Button in Period Name
	    
	    public void clickPeriodSearchButton(){	
	    	btnPrdNameSearch.click();
	       	this.getScreenDetails();
	 	   report.log(LogStatus.PASS, "Clicked on Period Name Search Button");
	    }
	    
	    public boolean isPeriodSearchButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnPrdNameSearch, context.getReactTimeout());
	    } 
	    
	    // Value verification
	    public void clickPeriodNameValue() throws InterruptedException{	
	    	SeleniumUtils.delay(3000);
	    	strPeriodName.click();
	 
	 	   report.log(LogStatus.PASS, "Selected Accounting Period Name from list");
	    }
	    
	    public boolean isPeriodNameValueDisplayed(){
		 	   return strPeriodName.isDisplayed();
		    } 
	 // Value verification
	    public void clickPeriodNameValue(String eventName){	
	    	WebDriverWait wait = new WebDriverWait(driver, 50);
	 	   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'queryP:value20_afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));	   
	 	   //SeleniumUtils.delay(2000);
	 	   eventLink.click(); 
	 	   SeleniumUtils.delay(2000);
	    	
	    	//strPeriodName.click();
	 	   report.log(LogStatus.PASS, "Selected Accounting Period Name from list");
	    }
	    
	   
	    
	 // click Journal text field
	    public void clickJournals(){	
	    	txtJournals.click();
	 	  // report.log(LogStatus.PASS, "Clicked on Accounting Period Ok Button");
	    }
	    
	 // Search Ok button Accounting Period
	    
	    public void clickPeriodOkButton(){	
	    	btnAccPeriodOk.click();
	 	   report.log(LogStatus.PASS, "Clicked on Accounting Period Ok Button");
	    }
	    
	    public boolean isPeriodOkButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnAccPeriodOk, context.getReactTimeout());
	    }
	    
// Search  button in Manage Journal Page
	    
	    public void clickJournalsSearchButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	     	js.executeScript("arguments[0].click();", btnJournalsSearch);
	    	//btnJournalsSearch.click();
	 	   report.log(LogStatus.PASS, "Clicked on Search Button");
	    }
	    
	    public boolean isJournalsSearchButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnJournalsSearch, context.getReactTimeout());
	    }
	  // click on Journal Cell
	    
	    public void clickJournalCellLink() throws InterruptedException{
	    	SeleniumUtils.delay(3000);
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	     	js.executeScript("arguments[0].click();", linkCellJournal);
	    	 //linkCellJournal.click();
	    	// wdwait.until(ExpectedConditions.visibilityOf(pageEditJournal)); 
	 	   report.log(LogStatus.PASS, "Selected  Journal Cell link");
	    }
	    
	    public EditJournalPage selectJournalCellLink() throws TestException{
		       SeleniumUtils.delay(2000);
		       linkCell.click();
		 	   report.log(LogStatus.PASS, "Selected  Journal Cell link");
		 	  return new EditJournalPage(driver,report);

		    }
	   
	    public boolean isclickJournalCellLinkDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver,  linkCellJournal, context.getReactTimeout());
	    } 
	    
	    
	    
	    public void clickIconEdit() throws InterruptedException{
	    	SeleniumUtils.delay(3000);
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", iconEdit);
			//iconEdit.click();
			wdwait.until(ExpectedConditions.visibilityOf(pageEditJournal));
		    report.log(LogStatus.PASS, "Clicked on Edit Pencil Icon ");
		 }
	    
	 // Save  button
	    
	    public void clickSaveButton(){	
	 	   btnSave.click();
	 	  SeleniumUtils.delay(2000);
	 	   report.log(LogStatus.PASS, "Clicked on Save Button");
	    }
	    
	    
	    public boolean isSaveButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnSave, context.getReactTimeout());
	    	
	    }
	    
	 // Post button
	    
	    public void clickPostButton(){	
	    	if(btnPost.isEnabled()){
	    		btnPost.click();
	    		SeleniumUtils.delay(2000);
	 	 	   report.log(LogStatus.PASS, "Clicked on Post Button");
	    	} else {
	    		report.log(LogStatus.FAIL, "Post Button is disabled");
	    	}	
	 	   
	    }
	    
	    public boolean isPostButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnPost, context.getReactTimeout());  	
	    } 
	    
	 // Confirmation OK button
	    
	    public void clickConfOkButton(){	
	 	   btnConfOk.click();
	 	   SeleniumUtils.delay(5000);
	 	   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	 	  report.log(LogStatus.PASS, "Journal posted successfully");
	    }
	    
	    public boolean isConfOkButtonDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	    }  
	    
	 // Done Button
	    
	    public void clickDoneButton(){	
		 	   btnDone.click();
		 	   SeleniumUtils.delay(5000);
		 	   report.log(LogStatus.PASS, "Clicked on Done Button");
		    }
		    
		    public boolean isDoneButtonDisplayed(){
		 	   return btnDone.isDisplayed();	
		    }  
	       
	   
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Manage Journal Page is Loaded Successfully");
		 return SeleniumUtils.isDisplayed(driver, txtJournals, context.getFindTimeout());
    	/* if(txtJournals.isDisplayed())
    	 {
    		 return true;
    		 
    	 } else {
    		 return false;
    	 } */    	
	}
	public Item getScreenDetails(){
	   	String xyz = Screenshot.takeScreenshotX(driver, "EntryLogin", context);
	   	report.addScreenCapture(xyz);
	   	String projectPath = System.getProperty("user.dir");    	
	   	String fullprojectPath = projectPath+"/report/"+xyz;
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Journal Page</span></a>");
	   	return new Item(xyz);
   }

}
