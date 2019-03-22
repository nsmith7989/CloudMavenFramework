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

public class Overview_BankStatementPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'_TasksList::icon')]")
	    private WebElement btnTasks;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_cash_management_bank_statements_and_reconciliation:0:_FOTRaT:0:RAtl1']")
	    private WebElement lnkCreateBankStatement;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_cash_management_bank_statements_and_reconciliation:0:_FOTRaT:0:RAtl6']")
	    private WebElement lnkSubmitAutoreconciliation;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_cash_management_bank_statements_and_reconciliation:0:_FOTRaT:0:RAtl7']")
	    private WebElement lnkManualReconciliation;
	 
	 public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	    public Overview_BankStatementPage(WebDriver driver, ExtentTest report) throws TestException {
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
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkCreateBankStatement));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	       
	    
 // Create Bank Statement link
	    
	    public boolean isCreateBankStatementLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkCreateBankStatement, context.getReactTimeout());
	    }
	    
	    public CreateBankStatementPage clickCreateBankStatementLink()throws TestException{
	    	lnkCreateBankStatement.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Bank Statement Link");
	    	return new CreateBankStatementPage(driver,report);
	    }
	    
// lnkSubmitAutoreconciliation
	    public boolean isSubmitAutoreconciliationLinkDisplayed(){ 
	    	return lnkSubmitAutoreconciliation.isDisplayed();
	    }
	    
	    public BasicOptionsPage clickSubmitAutoreconciliationLink()throws TestException{
	    	lnkSubmitAutoreconciliation.click();
	    	report.log(LogStatus.PASS, "Clicked on Submit Autoreconciliation Link");
	    	return new BasicOptionsPage(driver,report);
	    }
	    
	//lnkManualReconciliation    
	    public boolean isManualReconciliationLinkDisplayed(){ 
	    	return lnkManualReconciliation.isDisplayed();
	    }
	    
	    public ManualReconciliationPage clickManualReconciliationLink()throws TestException{
	    	lnkManualReconciliation.click();
	    	report.log(LogStatus.PASS, "Clicked on ManualReconciliation Link");
	    	return new ManualReconciliationPage(driver,report);
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Overview Page</span></a>");
		   	return new Item(xyz);
	   }


}
