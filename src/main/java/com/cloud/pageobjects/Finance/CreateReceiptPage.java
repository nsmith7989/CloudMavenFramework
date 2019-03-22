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

public class CreateReceiptPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:businessUnitId::content')]")
	    private WebElement selectBusinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:receiptMethodId::content')]")
	    private WebElement selectReceiptMethod;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:remittanceBankNameId::content')]")
	    private WebElement selectBankName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:remittanceBankBranchId::content')]")
	    private WebElement selectBankBranch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:remitBankAcctNumberId::content')]")
	    private WebElement selectBankAccount;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:receiptNumberId::content')]")
	    private WebElement txtReceiptNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:amountId::content')]")
	    private WebElement txtEnteredAmount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:customerAccountId::lovIconId')]")
	    private WebElement iconSearchAccountNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Id:value10::content')]")
	    private WebElement txtAccountNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnAccountNumberSearch;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:customerAccountId::lovDialogId::ok')]")
	    private WebElement btnAccountNumberOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:locationId::content')]")
	    private WebElement selectSite;
	 
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton2::popEl')]")
	    private WebElement menuSubmitAndCreateAnother;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cmi2')]")
	    private WebElement lstSubmitApplyManually;
	 
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public CreateReceiptPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Create  Transaction Page *****************************");
		       this.getScreenDetails();
		    }

	    
	  //BusinessUnit list
		   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
		   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
		   	selectBusinessUnit.click();
		   	//SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
		   	selectBusinessUnit.sendKeys(strBusinessUnit);
		   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
		   	selectBusinessUnit.sendKeys(Keys.ENTER);
		   	SeleniumUtils.delay(3000);
		    report.log(LogStatus.PASS, "Selected Business Unit  is: "+strBusinessUnit);
		   }
		   
		   public boolean isSelectBusinessUnitDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
			   } 
		   
		 // Receipt Method
		   
		   public void SelectReceiptMethod(String strReceiptMethod) throws InterruptedException{
			   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
			   selectReceiptMethod.click();
			   //	SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
			   selectReceiptMethod.sendKeys(strReceiptMethod);
			   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
			   selectReceiptMethod.sendKeys(Keys.ENTER);
			   	SeleniumUtils.delay(8000);
			    report.log(LogStatus.PASS, "Selected Receipt Method  is: "+strReceiptMethod);
			   }
			   
			   public boolean isReceiptMethodDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, selectReceiptMethod, context.getReactTimeout());
				   } 
			   
	   // Bank Name
			   public void SelectBankName(String strBankName) throws InterruptedException{
				   String BankName=selectBankName.getText();
				   if(BankName.isEmpty()== true) {
					   selectBankName.click();
					   selectBankName.sendKeys(strBankName);
					   selectBankName.sendKeys(Keys.ENTER);
					   	SeleniumUtils.delay(8000);
					    report.log(LogStatus.PASS, "Selected Bank Name  is: "+strBankName); 
				   }else {
					   report.log(LogStatus.PASS, "Selected Bank Name  is: "+BankName);  
				   }
				  
				   }
			   
		   // Branch Name
			   public void SelectBankBranch(String strBankBranch) throws InterruptedException{
				   String BankBranch=selectBankBranch.getText();
				   if(BankBranch.isEmpty()== true) {
					   selectBankBranch.click();
					   selectBankBranch.sendKeys(strBankBranch);
					   selectBankBranch.sendKeys(Keys.ENTER);
					   	SeleniumUtils.delay(8000);
					    report.log(LogStatus.PASS, "Selected Bank Branch  is: "+strBankBranch); 
				   }else {
					   report.log(LogStatus.PASS, "Selected Bank Branch  is: "+BankBranch);  
				   }
				  
				   }
		//selectBankAccount
			   
			   public void SelectBankAccount(String strBankAccount) throws InterruptedException{
				   String BankAccount=selectBankAccount.getText();
				   if(BankAccount.isEmpty()== true) {
					   selectBankAccount.click();
					   selectBankAccount.sendKeys(strBankAccount);
					   selectBankAccount.sendKeys(Keys.ENTER);
					   	SeleniumUtils.delay(8000);
					    report.log(LogStatus.PASS, "Selected Bank Account  is: "+strBankAccount); 
				   }else {
					   report.log(LogStatus.PASS, "Selected Bank Account  is: "+BankAccount);  
				   }
				  
				   }   
			   
		// Receipt Number field
			   
			   
			   public void enterReceiptNumber(String strReceiptNumber){
				   txtReceiptNumber.clear();
				   txtReceiptNumber.click();
				   txtReceiptNumber.sendKeys(strReceiptNumber);
				   report.log(LogStatus.PASS, "Entered Receipt Number is: "+strReceiptNumber);
			   }
			   
			   public boolean isReceiptNumberDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, txtReceiptNumber, context.getReactTimeout());
				   }
			   
	   // Entered Amount field
			   public void enterEnteredAmount(String strEnteredAmount){
				   txtEnteredAmount.clear();
				   txtEnteredAmount.click();
				   txtEnteredAmount.sendKeys(strEnteredAmount);
				   report.log(LogStatus.PASS, "Entered Entered Amount is: "+strEnteredAmount);
			   }
			   
			   public boolean isEnteredAmountDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, txtEnteredAmount, context.getReactTimeout());
				   }
			   
			// Search: Supplier Icon
			   
			   public void clickSearchAccountNumberIcon(){	
				   iconSearchAccountNumber.click();
				   wdwait.until(ExpectedConditions.visibilityOf(txtName));
				   report.log(LogStatus.PASS, "Clicked on Account Number Search icon");  
				   
			   }
			   
			   public boolean isSearchAccountNumberIconDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, iconSearchAccountNumber, context.getReactTimeout());
			   }
			   
			   // Search :
			   
			 //Enter text into AccountNumber field
			   public void enterAccountNumber(String strAccountNumber){
				   txtAccountNumber.clear();
				   txtAccountNumber.click();
				   txtAccountNumber.sendKeys(strAccountNumber);
				   report.log(LogStatus.PASS, "Entered Account Number is: "+strAccountNumber);
			   }
			   
			   public boolean isAccountNumberDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, txtAccountNumber, context.getReactTimeout());
				   }
			  // Name Field
			   
			   public void clickName(){
				   txtName.click();
				   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
			   }
			   
			   
			// Supplier Search Button 
			   public void clickAccountNumberSearchButton(String eventName){
				   btnAccountNumberSearch.click();
				  // WebDriverWait wait = new WebDriverWait(driver, 50);
				   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
				   report.log(LogStatus.PASS, "Clicked on Account Number Search Button");
			   }
			   
			   public boolean isAccountNumberSearchBtnDisplayed() throws InterruptedException{
				   return SeleniumUtils.isDisplayed(driver, btnAccountNumberSearch, context.getReactTimeout());		 
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
			   public void clickAccountNumberOkButton(){	
				   this.getScreenDetails();
				   btnAccountNumberOk.click();
				   SeleniumUtils.delay(5000);
				   report.log(LogStatus.PASS, "Clicked on Account Number Ok Button");
			   }
			   
			   public boolean isAccountNumberOkBtnDisplayed() throws InterruptedException{
				   return SeleniumUtils.isDisplayed(driver,  btnAccountNumberOk, context.getReactTimeout());		 
			   }  
			 //Site list
			   public void SelectSite(String strSite) throws InterruptedException{
			   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
				   selectSite.click();
			   	//SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
				   selectSite.sendKeys(strSite);
			   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
				   selectSite.sendKeys(Keys.ENTER);
			   	SeleniumUtils.delay(3000);
			    report.log(LogStatus.PASS, "Selected site is: "+strSite);
			   }
			   
			   public boolean isSelectSiteDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, selectSite, context.getReactTimeout());
				   }   	   
			   
		   // Submit and Create Another Menu
			   public void clickSubmitAndCreateAnotherMenu(){	
				   menuSubmitAndCreateAnother.click();
				   //SeleniumUtils.delay(8000);
				   wdwait.until(ExpectedConditions.visibilityOf(lstSubmitApplyManually));
				   report.log(LogStatus.PASS, "Clicked on Submit and Create Another Menu");
			   }
			  
			   public boolean isSubmitAndCreateAnotherMenuDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, menuSubmitAndCreateAnother, context.getReactTimeout());
			   }
			   
		   // Submit and Apply Manually list  
			   public EditReceiptPage selectSubmitAndApplyManuallyList()throws TestException{	
				   lstSubmitApplyManually.click();
				   //SeleniumUtils.delay(8000);
				  // wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
				   report.log(LogStatus.PASS, "Selected Submit and Apply Manually list");
			    	return new EditReceiptPage(driver,report);
				   
			   }
			   
			   public boolean isSubmitAndApplyManuallyListDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, lstSubmitApplyManually, context.getReactTimeout());
			   }
			   
		   @Override
			public boolean isDisplayed() {
				// TODO Auto-generated method stub
				//return  btnTasks.isDisplayed();
				
				 report.log(LogStatus.PASS, "Create Transaction page is Loaded Successfully");
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
			   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Transaction Page</span></a>");
			   	return new Item(xyz);
		   } 

}
