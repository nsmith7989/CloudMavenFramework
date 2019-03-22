package com.cloud.pageobjects.Finance;

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

public class PaymentPage extends BasePageObject{
	public WebDriver driver;
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:menu1')]")
    private WebElement menuActions;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandMenuItem1')]")
    private WebElement lstVoid;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:dialog1::ok')]")
    private WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandMenuItem5')]")
    private WebElement lstReissue;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:dialog5::ok')]")
    private WebElement btnSubmit_Reissue;
	
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOd1::msgDlg::cancel']")
	   private WebElement btnConfOk;

	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:SPb')]")
    private WebElement btnDone;
	
public WebDriverWait wdwait; 
	
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public PaymentPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(menuActions));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Payment Page *****************************");
	       this.getScreenDetails();
	    }
    
    
    	//Actions menu
	   
	   public void clickActionsMenu() throws InterruptedException{ 
		   //this.getScreenDetails();
		   menuActions.click();
		   //SeleniumUtils.delay(3000);
		   wdwait.until(ExpectedConditions.visibilityOf(lstVoid));
		   report.log(LogStatus.PASS, "Clicked on Actions Menu");
	   }
	   
	   public boolean iskActionsMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuActions, context.getReactTimeout());
	   }
	   //Select Void list
	   
	   public void selectVoidList() throws InterruptedException{ 
		   lstVoid.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Selected Void list from Actions Menu");
	   }
	   
	   public boolean isVoidListDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lstVoid, context.getReactTimeout());
	   }
	   // Reissue List
	   
	   public void selectReissueList() throws InterruptedException{ 
		   lstReissue.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Selected Reissue list from Actions Menu");
	   }
	   
	   public boolean isReissueListDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lstReissue, context.getReactTimeout());
	   }
	   // submit Button
	   
	   public void clickSubmitButton() throws InterruptedException{ 
		   this.getScreenDetails("Void Payment Pop-Up");
		   btnSubmit.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Submit button");
	   }
	   
	   public boolean isSubmitBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());
	   }
	   //submit Button in Reissue Pop-up
	   
	   public void clickReissueSubmitButton() throws InterruptedException{ 
		   this.getScreenDetails("Reissue Payments Pop-Up");
		   btnSubmit_Reissue.click();
		   //SeleniumUtils.delay(3000);
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Submit button");
	   }
	   
	   public boolean isReissueSubmitBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSubmit_Reissue, context.getReactTimeout());
	   }
	   
	// Confirmation OK button
	   
	   public void clickConfOkButton(){	
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	   }
	  
	   
	   public boolean isConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	   }  
	   
	   // Done Button
	   public void clickDoneButton() throws InterruptedException{ 
		   this.getScreenDetails();
		   btnDone.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Done button");
	   }
	   
	   public boolean isDoneBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnDone, context.getReactTimeout());
	   }
	     
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Payment Page is Loaded Successfully");
    	 if(menuActions.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Payment Page</span></a>");
	   	return new Item(xyz);
   }


}
