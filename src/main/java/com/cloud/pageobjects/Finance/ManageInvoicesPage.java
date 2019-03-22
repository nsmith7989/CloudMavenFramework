package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
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

public class ManageInvoicesPage extends BasePageObject{
	public WebDriver driver;
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1:value00::content')]")
	    private WebElement selectBusinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1:value10::content')]")
	    private WebElement txtInvNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1:value20::content')]")
	    private WebElement txtInvAmount;
	
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1:value40::lovIconId')]")
	    private WebElement iconSrchSupplier;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1:value40::_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtPartyName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1:value40::_afrLovInternalQueryId:value10::content')]")
	    private WebElement txtSupplierNumber;
	
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1:value40::_afrLovInternalQueryId::search')]")
	    private WebElement btnSrchSupplier;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1:value40::lovDialogId::ok')]")
	    private WebElement btnSupplierOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:q1::search')]")
	    private WebElement btnSearchInvoice;
	 
	 
	 
	////*[contains(text(), '101012')]
	
	// menu invoice Action
	   @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r7:1:me1']")
	   private WebElement menuInvoiceActions;
	   
	   @FindBy(how=How.XPATH, using = " //*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r7:1:cm1']")
	   private WebElement menuEditActions;
	   
	   @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r7:1:cm2']")
	   private WebElement menuValidate;
	   
	   @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r7:1:cm10']")
	   private WebElement menuAccInDraft;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'invoices:0:MAnt2:1:pm1:r1:0:ap1:r7:1:cb43')]")
	   private WebElement btnConfOk;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'invoices:0:MAnt2:1:pm1:r1:0:ap1:r7:1:ct2')]")
	    private WebElement btnSaveClose;	
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'invoices:0:MAnt2:1:pm1:r1:0:ap1:ctb2')]")
	    private WebElement btnDone;
	   
	 
	
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	
	public ManageInvoicesPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Manage Invoices Page *****************************");
	       this.getScreenDetails();
	    }
	

	//BusinessUnit list
	   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
	   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
	   	selectBusinessUnit.click();
	   	SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
	   	selectBusinessUnit.sendKeys(strBusinessUnit);
	   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
	   	selectBusinessUnit.sendKeys(Keys.ENTER);
	   	SeleniumUtils.delay(3000);
	    report.log(LogStatus.PASS, "Selected Business Unit  is: "+strBusinessUnit);
	   }
	   
	   
	   public boolean isSelectBusinessUnitDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
		   return selectBusinessUnit.isDisplayed();
		   } 
	   
	 //Enter text into Invoice Number field
	   public void enterInvoiceNumber(String invNumber){
		   txtInvNumber.clear();
		   txtInvNumber.click();
		   txtInvNumber.sendKeys(invNumber);
		   report.log(LogStatus.PASS, "Entered Invoice Number is: "+invNumber);
	   }
	   
	   public boolean isInvoiceNumberDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, txtInvNumber, context.getReactTimeout());
		   return txtInvNumber.isDisplayed();
		   }
	
	   // Search: Supplier or Party Icon
	   
	   public void clickSearchSupplierOrPartyIcon(){	
		   iconSrchSupplier.click();
		   wdwait.until(ExpectedConditions.visibilityOf(txtPartyName));
		   report.log(LogStatus.PASS, "Clicked on Supplier or Party Search icon");  
		   
	   }
	   
	   public boolean isSearchSupplierOrPartyIconDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, iconSrchSupplier, context.getReactTimeout()); 
		   return iconSrchSupplier.isDisplayed();
	   }
	   
	   
	 //Enter text into Party Name field
	   public void enterPartyName(String strPartyNAme){
		   txtPartyName.clear();
		   txtPartyName.click();
		   txtPartyName.sendKeys(strPartyNAme);
		   report.log(LogStatus.PASS, "Entered Party Name is: "+strPartyNAme);
	   }
	   
	   public boolean isPartyNameDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, txtPartyName, context.getReactTimeout());
		   return txtPartyName.isDisplayed();
		   }
	   
	   // Supplier Number Field
	   
	   public void clickSupplierNumber(){
		   txtSupplierNumber.click(); 
		   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
	   }
	   
	// Supplier Search Button 
	   public void clickSupplierSearchButton(){	
		   btnSrchSupplier.click();
		   report.log(LogStatus.PASS, "Clicked on Supplier Search Button");
	   }
	   
	   public boolean isSupplierSearchBtnDisplayed() throws InterruptedException{
		  // return SeleniumUtils.isDisplayed(driver, btnSrchSupplier, context.getReactTimeout());
		   return btnSrchSupplier.isDisplayed();
	   }
	   
	// Supplier Search Ok Button 
	   public void clickSupplierOkButton(){	
		   
		   this.getScreenDetails();
		   SeleniumUtils.delay(2000);
		   btnSupplierOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Supplier Ok Button");
	   }
	   
	   public boolean isSupplierOkBtnDisplayed() throws InterruptedException{
		  // return SeleniumUtils.isDisplayed(driver,  btnSupplierOk, context.getReactTimeout());	
		   return btnSupplierOk.isDisplayed();
	   }  
	   
	 // Invoice Amount Field
	   
	   public void clickInvoiceAmountField(){	
		   txtInvAmount.click();
		  // report.log(LogStatus.PASS, "Clicked on Invoice Search Button");
	   }
	   
	// Invoice Search Button 
	   public void clickInvoiceSearchButton(String eventName){
		   this.getScreenDetails();
		   btnSearchInvoice.click();
		   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		   //SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Invoice Search Button");
	   }
	   
	   public boolean isInvoiceSearchBtnDisplayed() throws InterruptedException{
		   //return SeleniumUtils.isDisplayed(driver, btnSearchInvoice, context.getReactTimeout());	
		   return btnSearchInvoice.isDisplayed();
	   }
	   
	  // Click on click cell1 of Invoice table
	   
	
	   
	   
	// Invoice Actions menu
	   public void clickActionsMenu(){	
		   menuInvoiceActions.click();
		   wdwait.until(ExpectedConditions.visibilityOf(menuEditActions));
		  // SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Invoice Actions Menu");
	   }
	   
	   public boolean isActionsMenuDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, menuInvoiceActions, context.getReactTimeout());
		   return menuInvoiceActions.isDisplayed();
	   	
	   }
	   
	  // Edit Option
	   
	   public  EditInvoicePage selectEditMenu()throws TestException{	
		   menuEditActions.click();
		   //SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected Edit item Invoice Actions Menu");
		   return new EditInvoicePage(driver,report);
	   }
	   
	   public boolean isEditMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuEditActions, context.getReactTimeout());
	   	
	   }
	   
	   
	   
// Validate list item from Invoice Actions menu
	   
	   public void selectValidateMenu(){	
		   menuValidate.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected Validate item Invoice Actions Menu");
	   }
	   
	   public boolean isValidateMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuValidate, context.getReactTimeout());
	   	
	   }
	   
// Account in Draft list item from Invoice Actions menu
	   
	   public void selectAccInDraftMenu(){	
		   menuAccInDraft.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected Account In Draft item Invoice Actions Menu");
	   }
	   
	   public boolean isAccountInDraftMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver,menuAccInDraft, context.getReactTimeout());
	   	
	   }   
	   
	   public boolean isConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	   }  
	   
	   public void clickConfOkButton(){	
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
		  
	   }
	     
	   
// Save and Close button
	   
	   public void clickSaveAndCloseButton(){	
		   btnSaveClose.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
	   }
	   
	   public boolean isSaveAndCloseButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSaveClose, context.getReactTimeout());
	   	
	   }
	   
	   // Done Button
	   
	   public void clickDoneButton(){	
		   btnDone.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Done Button");
	   }
	   
	   public boolean isDoneButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnDone, context.getReactTimeout());
	   	
	   }
	   
	   
	 //Select Event (select given text from dropdown)
	   public void selectEvent(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));
		  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	   
	   // Select Invoice link in table
	   
public void selectInvoiceEvent(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		   this.getScreenDetails();
		   SeleniumUtils.delay(2000);
		   eventLink.click();
		   wdwait.until(ExpectedConditions.visibilityOf(menuInvoiceActions));
		  
		   //SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }

public void selectPostInvoiceEvent(String eventName) throws InterruptedException { 
	   
	   WebDriverWait wait = new WebDriverWait(driver, 50);
	   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'ap1:at1:_ATp:ta1::db')]//*[contains(text(), '"+eventName+"')]")));
	  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
	   this.getScreenDetails();
	   SeleniumUtils.delay(2000);
	   eventLink.click();
	   wdwait.until(ExpectedConditions.visibilityOf(menuInvoiceActions));
	  
	   //SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
	   }

	// Select Invoice cell for clicking Edit Button

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Manage Invoices page is Loaded Successfully");
    	 if(selectBusinessUnit.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Invoices Page</span></a>");
	   	return new Item(xyz);
   }

}
