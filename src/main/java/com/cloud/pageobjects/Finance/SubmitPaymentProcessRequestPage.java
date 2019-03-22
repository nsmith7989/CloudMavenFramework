package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SubmitPaymentProcessRequestPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'inputText1::content')]")
	    private WebElement txtName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'inputDate2::glyph')]")
	    private WebElement btnPayThroughDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'inputDate2::pop::cd::mSel::content')]")
	    private WebElement calPayThroughDtMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'inputDate2::pop::cd::cg')]//td")
	    private WebElement calendarPayThroughDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'OuGroupRadio:_2')]")
	    private WebElement radioBUInvoice;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AT4:_ATp:create::icon')]")
	    private WebElement btnAddRow;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AT4:_ATp:table4:0:nameId::content')]")
	    private WebElement selectBusinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'partyNameId::lovIconId')]")
	    private WebElement srchParty;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'partyNameId::dropdownPopup::popupsearch')]")
	    private WebElement lnkPartySearch;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtParty;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId:value10::content')]")
	    private WebElement txtSupplierNumber;

		@FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId::search')]")
	    private WebElement btnPartySearch;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnPartyOk;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'showDetailItem2::disAcr')]")
	    private WebElement tabPmntAndProcOptions;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'bankAccountNameId::content')]")
	    private WebElement selectDisBankAccount;
			
		@FindBy(how=How.XPATH, using = "//select[contains(@id,'PaymentDocumentId::content')]")
	    private WebElement selectPaymentDocument;
		
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'paymentProfileNameId::content')]")
	    private WebElement selectPaymentProcProfile;
		
		//@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:APsb2')]")
		@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:SPsb2')]")
	    private WebElement btnSubmit;
		
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
    
	    
	    public SubmitPaymentProcessRequestPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(txtName));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Submit Payment Process Request Page *****************************");
		       this.getScreenDetails();
		    }
	    

	 // Enter  value in Name field
	    
	    public boolean isNameDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, txtName, context.getReactTimeout());
			   } 
		   
		   public void enterName(String name) throws InterruptedException{
			   SeleniumUtils.delay(2000);
			   txtName.clear();
			   txtName.click();
			   txtName.sendKeys(name);
			 
			   report.log(LogStatus.PASS, "Entered value for Name is: "+name);
		   }
	    
	    
		// click on To Invoice Date Calendar button
		      
		   public boolean isPayThroughDateBtnDisplayed(){
		    	return SeleniumUtils.isDisplayed(driver, btnPayThroughDate, context.getReactTimeout());
		    	
		    }
		    public void clickPayThroughDateButton(){	    	
		    	btnPayThroughDate.click();
		    	//SeleniumUtils.delay(3000);
		    	wdwait.until(ExpectedConditions.visibilityOf(calPayThroughDtMonth));
		    	report.log(LogStatus.PASS, "Clicked on Pay Through Date Button");
		    }
		    
		 // Select Pay Through Date Month from Calendar
		    public void selectPayThroughDateMonth(String toMonth){
		    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
		    	Select objSelect = new Select(calPayThroughDtMonth);
		    	objSelect.selectByVisibleText(toMonth);
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected Pay Through Date Month  is: "+toMonth);
		    } 
		   
		   public boolean isPayThroughDateMonthDisplayed(){
			   return SeleniumUtils.isDisplayed(driver,calPayThroughDtMonth, context.getReactTimeout());
		   }
		   
		   
		// Select Pay Through Date
		   public void selectPayThroughDate(String toDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'inputDate2::pop::cd::cg')]//td"));
			  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(toDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(3000);
					   report.log(LogStatus.PASS, "Selected date is "+toDate);
					   break;
					   
				   }
				  } 
				  
			  }
		   
		
		// click on Invoice Radio button of Business Units
		      
		   public boolean isBusinessUnitinvoiceRadioBtnDisplayed(){
		    	return SeleniumUtils.isDisplayed(driver, radioBUInvoice, context.getReactTimeout());
		    	
		    }
		    public void clickBusinessUnitinvoiceRadioButton(){	 
		    	boolean bValue = false;
		    	
		    	bValue = radioBUInvoice.isSelected();
		    	
		    	if(bValue == true){
		    		report.log(LogStatus.PASS, "Business Units Radio Button is already in selected state");
		    	}else {
		    		
		    		radioBUInvoice.click();
			    	//SeleniumUtils.delay(2000);
			    	wdwait.until(ExpectedConditions.visibilityOf(btnAddRow));
			    	report.log(LogStatus.PASS, "Selected Business Units invoice Radio Button");
		    	}
		    	
		    }
		   
		   
		 // Add Row button
			   
			   public void clickAddRowButton() throws InterruptedException{ 
				   btnAddRow.click();
				   SeleniumUtils.delay(3000);
				   wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
				   report.log(LogStatus.PASS, "Clicked on Add Row button");
			   }
			   
			   public boolean isAddRowBtnDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, btnAddRow, context.getReactTimeout());
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
				   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));	   
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
		   
			   // Payment and Processing Options tab
			   
			   public void clickPaymentAndProcessingOptionsTab(){	
				   		//this.getScreenDetails();
						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", tabPmntAndProcOptions);
						SeleniumUtils.delay(2000);
						wdwait.until(ExpectedConditions.visibilityOf(selectDisBankAccount));
				   report.log(LogStatus.PASS, "Clicked on Payment and Processing Options tab");
			   }
			   
			   public boolean isPaymentAndProcessingOptionsTabDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, tabPmntAndProcOptions, context.getReactTimeout());
			   } 
			   
			   
			 //Disbursement Bank Account
			   public void SelectDisbursementBankAccount(String strDisBankAccount) throws InterruptedException{
			   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
				   selectDisBankAccount.click();
			   	//SeleniumUtils.isDisplayed(driver, selectDisBankAccount, context.getReactTimeout());
			   	selectDisBankAccount.sendKeys(strDisBankAccount);
			   	selectDisBankAccount.sendKeys(Keys.ARROW_DOWN);
			   	selectDisBankAccount.sendKeys(Keys.ENTER);
			   	SeleniumUtils.delay(3000);
			    report.log(LogStatus.PASS, "Selected Disbursement Bank Account  is: "+strDisBankAccount);
			   }
			   
			   public boolean isDisbursementBankAccountDisplayed(){
				   return SeleniumUtils.isDisplayed(driver,selectDisBankAccount, context.getReactTimeout());
				   }    
			   
			// Select Pay PaymentDocument
			    public void selectPaymentDocument(String PmntDocument){
			    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
			    	Select objSelect = new Select(selectPaymentDocument);
			    	objSelect.selectByVisibleText(PmntDocument);
			    	SeleniumUtils.delay(5000);
			    	report.log(LogStatus.PASS, "Selected Payment Document  is: "+PmntDocument);
			    } 
			   
			   public boolean isPaymentDocumentDisplayed(){
				   return SeleniumUtils.isDisplayed(driver,selectPaymentDocument, context.getReactTimeout());
			   }  
			   
			   //Payment Process Profile
			   public void SelectPaymentProcessProfile(String strPProfile) throws InterruptedException{
			   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
				   selectPaymentProcProfile.click();
			   	//SeleniumUtils.isDisplayed(driver, selectDisBankAccount, context.getReactTimeout());
			   	selectPaymentProcProfile.sendKeys(strPProfile);
			   	selectPaymentProcProfile.sendKeys(Keys.ARROW_DOWN);
			   	selectPaymentProcProfile.sendKeys(Keys.ENTER);
			   	SeleniumUtils.delay(3000);
			    report.log(LogStatus.PASS, "Selected Payment Process is: "+strPProfile);
			   }
			   
			   public boolean isPaymentProcessProfileDisplayed(){
				   return SeleniumUtils.isDisplayed(driver,selectPaymentProcProfile, context.getReactTimeout());
				   }    
			   
			// Submit Button
			   
			   public boolean isSubmitButtonDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());
			   }
			   
			   public void clickSubmitButton(){	
				   this.getScreenDetails();
				   btnSubmit.click();
				   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
				   //SeleniumUtils.delay(3000);
				   report.log(LogStatus.PASS, "Clicked on Submit Button");   
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
			
			 report.log(LogStatus.PASS, "Submit Payment Process Request page is Loaded Successfully");
	    	 if(txtName.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Submit Payment Process Request Page</span></a>");
		   	return new Item(xyz);
	   }
}
