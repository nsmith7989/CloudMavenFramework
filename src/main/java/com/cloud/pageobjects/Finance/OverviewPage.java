package com.cloud.pageobjects.Finance;

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

public class OverviewPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'_FndTasksList::icon')]")
	    private WebElement btnTasks;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'FOTRaT:0:RAtl14')]")
	    private WebElement lnkCreateAccouinting;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'FOTRaT:0:RAtl1')]")
	    private WebElement lnkSubmitPmentPrcRequest;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'FOTRaT:0:RAtl2')]")
	    private WebElement lnkManagePmentPrcRequest;
	 
	 @FindBy(xpath = "//a[contains(.,'Create Electronic Payment Files')]")
	 private WebElement lnkCEP;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'0:RAtl4')]")
	    private WebElement lnkCreatePayment;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'RAtl5')]")
	    private WebElement lnkManagePayments;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'FOTRaT:0:RAtl9')]")
	    private WebElement lnkApplMissConvRates;
	

	  
	 public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	    public OverviewPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(btnTasks));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Overview Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    public boolean isTasksBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnTasks, context.getReactTimeout());
	    	
	    }
	    public void clickTasksButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnTasks);
	    	//btnTasks.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkCreateAccouinting));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	    
	    public boolean isCreateAccountingLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkCreateAccouinting, context.getReactTimeout());
	    }
	    
	    public SubmitRequestPage clickCreateAccountingLink()throws TestException{
	    	lnkCreateAccouinting.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Accounting Link");
	    	return new SubmitRequestPage(driver,report);
	    }
	    
	    // Submit Payment Process RequestLink 
	    public boolean isSubmitPaymentProcessRequestLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkSubmitPmentPrcRequest, context.getReactTimeout());
	    }
	    
	    public SubmitPaymentProcessRequestPage clickSubmitPaymentProcessRequestLink()throws TestException{
	    	lnkSubmitPmentPrcRequest.click();
	    	report.log(LogStatus.PASS, "Clicked on SubmitPaymentProcessRequest Link");
	    	return new SubmitPaymentProcessRequestPage(driver,report);
	    }
	        
	   // Manage Payment Process Requests link
	    	    
	    public boolean isManagePaymentProcessRequestsLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkManagePmentPrcRequest, context.getReactTimeout());
	    }
	    
	    public ManagePaymentProcessRequestsPage clickManagePaymentProcessRequestsLink()throws TestException{
	    	lnkManagePmentPrcRequest.click();
	    	report.log(LogStatus.PASS, "Clicked on Manage Payment Process Requests Link");
	    	return new ManagePaymentProcessRequestsPage(driver,report);
	    }
	    
	    public void clickCreateElectronicPaymentFilesLink()throws TestException{
	    	lnkCEP.click();
	    	SeleniumUtils.delay(10000);
	    	report.log(LogStatus.PASS, "Clicked on Manage Payment Process Requests Link");
	    	
	    }
	    
	    // Create Payment Link
	    
	    public boolean isCreatePaymentLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkCreatePayment, context.getReactTimeout());
	    }
	    
	    public CreatePaymentPage clickCreatePaymentLink()throws TestException{
	    	lnkCreatePayment.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Payment Link");
	    	return new CreatePaymentPage(driver,report);
	    }
	    	     
	    
	    // Manage Payments Link
	    
	    public boolean isManagePaymentsLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkManagePayments, context.getReactTimeout());
	    }
	    
	    public ManagePaymentsPage clickManagePaymentsLink()throws TestException{
	    	lnkManagePayments.click();
	    	report.log(LogStatus.PASS, "Clicked on Manage Payments Link");
	    	return new ManagePaymentsPage(driver,report);
	    }
	    
	    // Apply Missing Conversion Rates Link
	    
	    public boolean isApplyMissingConversionRatesLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkApplMissConvRates, context.getReactTimeout());
	    }
	    
	    public MissingConversion_SubmitRequestPage clickApplyMissingConversionRatesLink()throws TestException{
	    	lnkApplMissConvRates.click();
	    	report.log(LogStatus.PASS, "Clicked on Apply Missing Conversion Rates Link");
	    	return new MissingConversion_SubmitRequestPage(driver,report);
	    }
	    
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Overview page is Loaded Successfully");
	    	 if(btnTasks.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Overview Page</span></a>");
		   	return new Item(xyz);
	   }

}
