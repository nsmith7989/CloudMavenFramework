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

public class CreatePaymentPage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'OrgUiId::content')]")
    private WebElement selectBusinessUnit;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'payeeNameId::lovIconId')]")
	    private WebElement srchParty;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'payeeNameId::dropdownPopup::popupsearch')]")
	    private WebElement lnkPartySearch;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId:value00::content')]")
	    private WebElement txtParty;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId:value10::content')]")
	    private WebElement txtSupplierNumber;

		@FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId::search')]")
	    private WebElement btnPartySearch;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'payeeNameId::lovDialogId::ok')]")
	    private WebElement btnPartyOk;
	
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'bankAccountNameId::content')]")
	    private WebElement selectDisBankAccount;
	
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'paymentProfileUICompId::content')]")
	    private WebElement selectPaymentProcProfile;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'commandToolbarButton1::icon')]")
	    private WebElement btnSelectandAdd;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'coVOId:value00::content')]")
	    private WebElement txtInvoiceNumber;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'coVOId:value10::content')]")
	    private WebElement txtInvoiceAmount;

		@FindBy(how=How.XPATH, using = "//*[contains(@id,'coVOId::search')]")
	    private WebElement btnInvoiceSearch;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'cb1')]")
	    private WebElement btnInvoiceApply;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'dialog1::ok')]")
	    private WebElement btnInvoiceOk;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'msgDlg::cancel')]")
	    private WebElement btnWarningOk;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:cb5')]")
	    private WebElement btnSaveAndClose;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'_FOd1::msgDlg::cancel')]")
	    private WebElement btnconfOk;
		
		
		public WebDriverWait wdwait;
	
	
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/

    
    public CreatePaymentPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Create Payment Page *****************************");
	       this.getScreenDetails();
	    }
    
    //BusinessUnit list
	   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
	   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
	   	selectBusinessUnit.click();
	   	SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
	   	selectBusinessUnit.sendKeys(strBusinessUnit);
	   	selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
	   	selectBusinessUnit.sendKeys(Keys.ENTER);
	   	SeleniumUtils.delay(3000);
	    report.log(LogStatus.PASS, "Selected Business Unit  is: "+strBusinessUnit);
	   }
	   
	   public boolean isSelectBusinessUnitDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
		   } 
	   
	// Search Party Icon
	   
	   public void clickPartySearchIcon() throws InterruptedException{ 
		   srchParty.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Party Search Icon");
	   }
	   
	   public boolean isPartySearchIconDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, srchParty, context.getReactTimeout());
	   }
	   
	// Search Link for Party
	   
	   public void clickPartySearchLink() throws InterruptedException{	
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);	 
		   WebElement elementlnkAccountSearch = wait.until(ExpectedConditions.elementToBeClickable(lnkPartySearch));
		    elementlnkAccountSearch.click();
		    wdwait.until(ExpectedConditions.visibilityOf(txtParty));
		   report.log(LogStatus.PASS, "Clicked on Party Search link");
	   }
	   
	   public boolean isPartySearchLinkDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lnkPartySearch, context.getReactTimeout());
	   } 
	   
	   // Enter party value in Party field
	   
	   public void enterPartyValue(String value) throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtParty.clear();
		   txtParty.click();
		   txtParty.sendKeys(value);
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Entered value for Party is: "+value);
	   }
	   
	   
	   public boolean isPartyValueDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtParty, context.getReactTimeout());
		   } 
	   
	   
	// Search button in Party
	   public void clickPartySearchButton(){	
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", btnPartySearch);
				SeleniumUtils.delay(3000);
		   //btnAccSearch.click();
		   report.log(LogStatus.PASS, "Clicked on Party Search Button");
	   }
	   
	   public boolean isPartySearchButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnPartySearch, context.getReactTimeout());
	   } 
	   
	   // Click txtSupplierNumber
	   
	   public void clickSupplierNumber() throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtSupplierNumber.click();
		  
	   }
	   
	 //Select Event (select given text from dropdown)
	   public void selectEvent(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'AP1:payeeNameId_afrLovInternalTableId::db')]//td/span[contains(text(), '"+eventName+"')]")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	   
	   // Select Invoice from Table
	   
	 //Select Event (select given text from dropdown)
	   public void selectInvoice(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, '_ATp:t1::db')]//span[contains(text(), '"+eventName+"')]")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	// Party Ok button
	   
	   public boolean isPartyOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnPartyOk, context.getReactTimeout());
	   }
	   
	   public void clickPartyOkButton(){	
		   this.getScreenDetails();
		   WebDriverWait wait = new WebDriverWait(driver, 50);	 
		   WebElement elementbtnAccOk = wait.until(ExpectedConditions.elementToBeClickable(btnPartyOk));
		   elementbtnAccOk.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Party Ok Button");   
	   }
   
	   
	 //Disbursement Bank Account
	   public void SelectDisbursementBankAccount(String strDisBankAccount) throws InterruptedException{
	   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
	    selectDisBankAccount.click();
	   	SeleniumUtils.isDisplayed(driver, selectDisBankAccount, context.getReactTimeout());
	   	selectDisBankAccount.sendKeys(strDisBankAccount);
	   	selectDisBankAccount.sendKeys(Keys.ARROW_DOWN);
	   	selectDisBankAccount.sendKeys(Keys.ENTER);
	   	SeleniumUtils.delay(5000);
	    report.log(LogStatus.PASS, "Selected Disbursement Bank Account  is: "+strDisBankAccount);
	   }
	   
	   public boolean isDisbursementBankAccountDisplayed(){
		   return SeleniumUtils.isDisplayed(driver,selectDisBankAccount, context.getReactTimeout());
		   }    
	   
	 //Payment Process Profile
	   public void SelectPaymentProcessProfile(String strPProfile) throws InterruptedException{
	   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
		   selectPaymentProcProfile.click();
	   	SeleniumUtils.isDisplayed(driver, selectDisBankAccount, context.getReactTimeout());
	   	selectPaymentProcProfile.sendKeys(strPProfile);
	   	selectPaymentProcProfile.sendKeys(Keys.ARROW_DOWN);
	   	selectPaymentProcProfile.sendKeys(Keys.ENTER);
	   	SeleniumUtils.delay(5000);
	    report.log(LogStatus.PASS, "Selected Payment Process is: "+strPProfile);
	   }
	   
	   public boolean isPaymentProcessProfileDisplayed(){
		   return SeleniumUtils.isDisplayed(driver,selectPaymentProcProfile, context.getReactTimeout());
		   }    
	   
	   
	   // Select And Add button
	   
	   public void clickSelectAndAddButton(){	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnSelectandAdd);
			//SeleniumUtils.delay(3000);
			wdwait.until(ExpectedConditions.visibilityOf(txtInvoiceNumber));
	   report.log(LogStatus.PASS, "Clicked on Select and Add Button");
	  }
	  
	  public boolean isSelectAndAddButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSelectandAdd, context.getReactTimeout());
	  } 
		   
	   // Invoice Number Field in Pop-up
	  
	  public void enterInvoiceNumber(String value) throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtInvoiceNumber.clear();
		   txtInvoiceNumber.click();
		   txtInvoiceNumber.sendKeys(value);
		 
		   report.log(LogStatus.PASS, "Entered value in Invoice Number is: "+value);
	   }
	   
	   
	   public boolean isInvoiceNumberDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtInvoiceNumber, context.getReactTimeout());
		   } 
	   
	   // Click on Invoice Amount
	   
	   public void clickInvoiceAmount() throws InterruptedException{		  
		   txtInvoiceAmount.click();  
	   }
	  
	  //  Clear txtInvoiceNumber field
	   public void clearInvoiceNumber() throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtInvoiceNumber.clear();
		   report.log(LogStatus.PASS, "Invoice Number is cleared");
	   }
	   
	   // Search Button for Invoice Number
	   
	   public void clickInvoiceSearchButton(){	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",  btnInvoiceSearch);
			SeleniumUtils.delay(3000);
	   //btnAccSearch.click();
	   report.log(LogStatus.PASS, "Clicked on Party Search Button");
	  }
	  
	  public boolean isInvoiceSearchButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver,  btnInvoiceSearch, context.getReactTimeout());
	  } 
	  
	   // Aplly button in Invoice Number
	  public void clickInvoiceApplyhButton(){	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",  btnInvoiceApply);
			SeleniumUtils.delay(3000);
	   //btnAccSearch.click();
	   report.log(LogStatus.PASS, "Clicked on Apply Button");
	  }
	  
	  public boolean isInvoiceApplyButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver,  btnInvoiceApply, context.getReactTimeout());
	  } 
	  
	  // Invoice Ok Button
	  public void clickInvoiceOkButton(){	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",  btnInvoiceOk);
			SeleniumUtils.delay(3000);
	   
		   report.log(LogStatus.PASS, "Clicked on Ok Button");
		  }
		  
		  public boolean isInvoiceOkButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver,  btnInvoiceOk, context.getReactTimeout());
		  } 
	  
		// Save And Close Button
		  
		  public void clickSaveAndCloseButton(){
			  		 
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();",  btnSaveAndClose);
				//SeleniumUtils.delay(3000);
			    wdwait.until(ExpectedConditions.visibilityOf(btnconfOk));
		   
			   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
			  }
			  
			  public boolean isSaveAndCloseButtonDisplayed(){
				   return SeleniumUtils.isDisplayed(driver,  btnSaveAndClose, context.getReactTimeout());
			  } 
			  
			  
		  // Confirmation Ok Button
			  
			  public boolean isConfOkButtonDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, btnconfOk, context.getReactTimeout());
			   }
			   
			   public void clickConfOkButton(){	
				   this.getScreenDetails("Confirmation Pop-up");
				   btnconfOk.click();
				   SeleniumUtils.delay(3000);
				   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");   
			   }
	   
	   @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Create Payment Page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Payment Page</span></a>");
		   	return new Item(xyz);
	   }

}
