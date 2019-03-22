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

public class EditReceiptPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:REF:0:ap1:AT1:_ATp:ATm')]/div/table/tbody/tr/td[3]/div")
	    private WebElement menuActionRcpDetails;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:cmi7')]")
	    private WebElement lstAddOpenReceivables;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:q1:value50::lovIconId')]")
	    private WebElement iconSearchTransactionCustomerName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtCustomerName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value10::content')]")
	    private WebElement txtAccountNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnTransCustomerNameSearch;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnTransCustomerNameOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:q1:value80::content')]")
	    private WebElement txtAmount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:q1::search')]")
	    private WebElement btnReceivableSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':pt1:REF:0:ap1:AT1:_ATp:AT7:_ATp:t3::db')]")
	    private WebElement tableReceivableTransSearch;
	
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:2:pt1:REF:0:ap1:AT1:_ATp:cb2']")
	    private WebElement btnTransAdd;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:2:pt1:REF:0:ap1:AT1:_ATp:cb3']")
	    private WebElement btnTransDone;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table3::db')]/table/tbody/tr/td[4]")
	    private WebElement tablRcptDetails;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:menu1')]/div/table/tbody/tr/td[3]")
	    private WebElement menuActions;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:2:pt1:REF:0:ap1:commandMenuItem2']")
	    private WebElement lstPostLadger;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cb110')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton122')]")
	    private WebElement btnSaveAndClose;
	 
	
	
	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public EditReceiptPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(menuActionRcpDetails));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }

	        System.out.println("******************************* Edit Receipt Page *****************************");
	       this.getScreenDetails();
	    }
    
    // Invoice Actions menu
	   public void clickReceiptDetailsActionsMenu(){	
		   menuActionRcpDetails.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(lstAddOpenReceivables));
		   report.log(LogStatus.PASS, "Clicked on Receipt Details Actions Menu");
	   }
	  
	   public boolean isReceiptDetailsActionMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuActionRcpDetails, context.getReactTimeout());
	   	
	   }
// Add Open Receivables list item from Actions menu
	   
	   public void selectAddOpenReceivablesList(){	
		   lstAddOpenReceivables.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(iconSearchTransactionCustomerName));
		   report.log(LogStatus.PASS, "Selected Validate item Invoice Actions Menu");
		   this.getScreenDetails();
	   }
	   
	   public boolean isAddOpenReceivablesListDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lstAddOpenReceivables, context.getReactTimeout());
	   	
	   }
	   
	// Search: Supplier Icon
	   
	   public void clickSrchTransactionCustomerNameIcon(){	
		   iconSearchTransactionCustomerName.click();
		   wdwait.until(ExpectedConditions.visibilityOf(txtCustomerName));
		   report.log(LogStatus.PASS, "Clicked on Account Number Search icon");  
		   
	   }
	   
	   public boolean isSearchTransactionCustomerNameIconDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, iconSearchTransactionCustomerName, context.getReactTimeout());
	   }
	   
	   // Search :
	   
	 //Enter text into Customer Name field
	   public void enterTransactionCustomerName(String strCustomerName){
		   txtCustomerName.clear();
		   txtCustomerName.click();
		   txtCustomerName.sendKeys(strCustomerName);
		   report.log(LogStatus.PASS, "Entered Customer Name is: "+strCustomerName);
	   }
	   
	   public boolean isCustomerNameDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtCustomerName, context.getReactTimeout());
		   }
	  // Account Number Field
	   
	   public void clickAccountNumber(){
		   txtAccountNumber.click();
		   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
	   }
	   
	   
	// Supplier Search Button 
	   public void clickCustomerNameSearchButton(String eventName){
		   btnTransCustomerNameSearch.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		   report.log(LogStatus.PASS, "Clicked on Customer NameSearch Button");
	   }
	   
	   public boolean isCustomerNameSearchBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, btnTransCustomerNameSearch, context.getReactTimeout());		 
	   }
	   
	 //Select Event (select given text from dropdown)
	   public void selectEvent(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	   
	// Supplier Search Ok Button 
	   public void clickCustomerNameOkButton(){	
		   this.getScreenDetails();
		   btnTransCustomerNameOk.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Customer Name Ok Button");
	   }
	   
	   public boolean isCustomerNameOkBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver,  btnTransCustomerNameOk, context.getReactTimeout());		 
	   } 
	   
	  //
	   
	   public void clickAmountField(){	
		   txtAmount.click();
	   }
	   
	// Add Open Receivable Search Button 
	   public void clickReceivableSearchButton(){
		   btnReceivableSearch.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   wdwait.until(ExpectedConditions.visibilityOf(btnTransAdd));
		   report.log(LogStatus.PASS, "Clicked on Receivable Search Button");
		  
	   }
	   
	   public boolean isReceivableSearchBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnReceivableSearch, context.getReactTimeout());		 
	   }
	   
   // Select Receivables Cell
	   
	   public void selectReceivablesCell(String ReceivablesCell)
		{
		   WebDriverWait wait = new WebDriverWait(driver, 50);
			  
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,':pt1:REF:0:ap1:AT1:_ATp:AT7:_ATp:t3::db')]//td[2]/div//td[1]//span[contains(text(), '"+ReceivablesCell+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected Receivables Cell is: "+ReceivablesCell);
		   
			
		  }  
	   
	//     Add Open Receivable Add Button
	   
	   public void clickReceivableAddButton(){
		   btnTransAdd.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		  // wdwait.until(ExpectedConditions.visibilityOf(btnTransAdd));
		   report.log(LogStatus.PASS, "Clicked on Add Button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isReceivableAddBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnTransAdd, context.getReactTimeout());		 
	   }
	   
	   // Done button
	   
	   public void clickReceivableDoneButton(){
		   btnTransDone.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   wdwait.until(ExpectedConditions.visibilityOf(tablRcptDetails));
		   report.log(LogStatus.PASS, "Clicked on Done Button");
	   }
	   
	   public boolean isReceivableDoneBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnTransDone, context.getReactTimeout());		 
	   }
	   
	   // Actions menu
	   public void clickActionsMenu(){
		   SeleniumUtils.delay(3000);
		   menuActions.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(lstPostLadger));
		   report.log(LogStatus.PASS, "Clicked on Actions Menu");
		   
	   }
	  
	   public boolean isActionsMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuActions, context.getReactTimeout());
	   }
// Post  Ledger list item from  Actions menu 
	   
	   public void selectPostLedgerMenu(){	
		   lstPostLadger.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Selected Validate item Invoice Actions Menu");
		   this.getScreenDetails();
	   }
	   
	   public boolean isPostLedgerMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lstPostLadger, context.getReactTimeout());
	   	
	   }
	   
	   // Conf Ok button
	   
	   public boolean isConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	   }  
	   
	   public void clickConfOkButton(){	
		   this.getScreenDetails("Confirmation Pop-up");
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
		   
	   }
	   
	   //Save and Close button
	   
	   public boolean isSaveAndCloseButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSaveAndClose, context.getReactTimeout());  	
	   }  
	   
	   public void clickSaveAndCloseButton(){	
		   //this.getScreenDetails("Confirmation Pop-up");
		   btnSaveAndClose.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Save and Close Button");
		   
	   }
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Edit Receipt page is Loaded Successfully");
    	 if(menuActionRcpDetails.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Receipt Page</span></a>");
	   	return new Item(xyz);
   } 


}
