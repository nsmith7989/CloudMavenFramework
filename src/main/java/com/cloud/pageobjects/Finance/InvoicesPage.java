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

public class InvoicesPage extends BasePageObject{
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'_FndTasksList::icon')]")
	    private WebElement btnTasks;
	 
	// @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl1']")
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:_FOTRaT:0:RAtl1']|//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTRaT:0:RAtl1']")
	    private WebElement lnkCreateinvoice;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'FOTRaT:0:RAtl4')]")
	    private WebElement lnkManageinvoice;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'payables_invoices:0:_FOTRaT:0:RAtl11')]")
	    private WebElement lnkCreateAccouinting;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'FOTRaT:0:RAtl6')]")
	    private WebElement lnkValidateInvoice;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'RAtl14')]")
	    private WebElement lnkPayablesLedReconciliation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'FOTRaT:0:RAtl17')]")
	    private WebElement lnkManageAccountingPeriods;
	 
	 
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public InvoicesPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnTasks));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Invoices Page *****************************");
		       this.getScreenDetails();
		    }
 
	 
	    public boolean isTasksBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnTasks, context.getReactTimeout());
	    
	    }
	    public void clickTasksButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnTasks);
	    	//btnTasks.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkCreateinvoice));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	    
	    public boolean isCreateInvoiceLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkCreateinvoice, context.getReactTimeout());
	    }
	    public CreateInvoicePage clickCreateInvoiceLink()throws TestException{
	    	lnkCreateinvoice.click();
	    	report.log(LogStatus.PASS, "Clicked on Create invoice Link");
	    	return new CreateInvoicePage(driver,report);
	    }
	    
	    public boolean isManageInvoiceLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkManageinvoice, context.getReactTimeout());
	    }
	    
	    public ManageInvoicesPage clickManageInvoiceLink()throws TestException{
	    	lnkManageinvoice.click();
	    	report.log(LogStatus.PASS, "Clicked on Manage invoices Link");
	    	return new ManageInvoicesPage(driver,report);
	    }
	    // Accounting link
	    public boolean isCreateAccountingLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkCreateAccouinting, context.getReactTimeout());
	    }
	    
	    public SubmitRequestPage clickCreateAccountingLink()throws TestException{
	    	lnkCreateAccouinting.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Accounting Link");
	    	return new SubmitRequestPage(driver,report);
	    }
 
	    // Validate Invoices Link
	    public boolean isValidateInvoiceLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver,  lnkValidateInvoice, context.getReactTimeout());
	    }
	    
	    public Validate_SubmitRequestPage clickValidateInvoiceLink()throws TestException{
	    	 lnkValidateInvoice.click();
	    	report.log(LogStatus.PASS, "Clicked on Validate Invoices Link");
	    	return new Validate_SubmitRequestPage(driver,report);
	    }
	    
	    //Payables to Ledger Reconciliation link
	    
	    public boolean isPayablesLedgerReconciliationLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver,  lnkPayablesLedReconciliation, context.getReactTimeout());
	    }
	    
	    public PayablesToLedgerReconciliationReportPage clickPayablesLedgerReconciliationLink()throws TestException{
	    	lnkPayablesLedReconciliation.click();
	    	report.log(LogStatus.PASS, "Clicked on Payables To Ledger Reconciliation Link");
	    	return new PayablesToLedgerReconciliationReportPage(driver,report);
	    }
	    
	    
	   //
	    
	    public boolean isManageAccountingPeriodsLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver,  lnkManageAccountingPeriods, context.getReactTimeout());
	    }
	    
	    public ManageAccountingPeriodsPage clickManageAccountingPeriodsLink()throws TestException{
	    	lnkManageAccountingPeriods.click();
	    	report.log(LogStatus.PASS, "Clicked on Manage Accounting Periods Link");
	    	return new ManageAccountingPeriodsPage(driver,report);
	    }
	    
	    
	    
	    	   
	    
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Invoices page is Loaded Successfully");
    	 if(btnTasks.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Invoices Page</span></a>");
	   	return new Item(xyz);
   }
}
