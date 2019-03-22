package com.cloud.pageobjects.Finance;

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

public class MissingConversion_SubmitRequestPage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'BUSINESSUNIT::content')]")
    private WebElement selectBusinessUnit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'reqDesc::content')]")
    private WebElement txtSubmissionNotes;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:submitButton')]")
    private WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmationPopup:pt_ol1')]")
    private WebElement lblConfOk;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmationPopup:confirmSubmitDialog::ok')]")
    private WebElement btnConfOk;
	
	
	public WebDriverWait wdwait;
	
	
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/

    
    public MissingConversion_SubmitRequestPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Submit Request Page *****************************");
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
		   return SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
		   } 
	   // Submissions Note
	   
	   public void clickSubmissionNotes() throws InterruptedException{
		   txtSubmissionNotes.click();
	   }
	   // submit Button
	   
	   public void clickSubmitButton() throws InterruptedException{ 
		   this.getScreenDetails();
		   btnSubmit.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Submit button");
	   }
	   
	   public boolean isSubmitBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());
	   }
	   
	   //Confirmation Ok Button
	   public void clickConfOkButton() throws InterruptedException{
		   String ConfMassege=lblConfOk.getText();
		   this.getScreenDetails("Confirmation pop-up");
		   btnConfOk.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, ""+ConfMassege+" and Clicked on Confirmation Ok button");
	   }
	   
	   public boolean isConfOkBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());
	   }
	   
	   
    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Submit Request page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Submit Request Page</span></a>");
	   	return new Item(xyz);
   }
    
}
