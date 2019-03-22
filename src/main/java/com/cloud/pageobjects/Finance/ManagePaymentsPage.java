package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
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

public class ManagePaymentsPage extends BasePageObject{
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'value00::lovIconId')]")
    private WebElement srchParty;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'value00::dropdownPopup::popupsearch')]")
    private WebElement lnkPartySearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'value00::_afrLovInternalQueryId:value00::content')]")
    private WebElement txtParty;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'value00::_afrLovInternalQueryId:value10::content')]")
    private WebElement txtSupplyNumber;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'value00::_afrLovInternalQueryId::search')]")
    private WebElement btnPartySearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'value00::lovDialogId::ok')]")
    private WebElement btnPartyOk;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'value20::content')]")
    private WebElement txtPaymentNumber;
	
	//@FindBy(how=How.XPATH, using = "//table[@class='x1jf x1k3']//td[@class='xe9'][1]")
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'commandLink1')]")
    private WebElement lnkPaymentNumber;

	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1::search')]")
    private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:SPb')]")
    private WebElement btnDone;
	
	
public WebDriverWait wdwait; 
	
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public ManagePaymentsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(srchParty));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Manage  Payments Page *****************************");
	       this.getScreenDetails();
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
	  // Expand Search button in Party pop up
	   
	   public void clickSupplierNumber(){	
		   txtSupplyNumber.click();
		   SeleniumUtils.delay(2000);
		  // report.log(LogStatus.PASS, "Clicked on Party Search Button");
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
	   
	   
	 //Select Event (select given text from dropdown)
	   public void selectPaymentNumber(String eventName) throws InterruptedException { 
	   
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   //WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='x1jf x1k3']//td[@class='xe9'][1]")));
		   SeleniumUtils.delay(2000);
		   lnkPaymentNumber.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	   
	   // Select Party Name from Table
	   
	   public void selectPartyName(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'q1:value00_afrtablegridcell::c')]//td/span[contains(text(), '"+eventName+"')]")));
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
		   this.getScreenDetails("Search and Select: Supplier or Party pop-up");
		   WebDriverWait wait = new WebDriverWait(driver, 50);	 
		   WebElement elementbtnAccOk = wait.until(ExpectedConditions.elementToBeClickable(btnPartyOk));
		   elementbtnAccOk.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Party Ok Button");   
	   }
	   
    // Payment Number field
	   
	   public boolean isPaymentNumberDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtPaymentNumber, context.getReactTimeout());
		   } 
	   
	   public void enterPaymentNumber(String pmntNumber) throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtPaymentNumber.clear();
		   txtPaymentNumber.click();
		   txtPaymentNumber.sendKeys(pmntNumber);
		   report.log(LogStatus.PASS, "Entered value for Payment Number is: "+pmntNumber);
	   }
    
    // Search Button
	   public void clickSearchButton() throws InterruptedException{ 
		   btnSearch.click();
		   //SeleniumUtils.delay(3000);
		   wdwait.until(ExpectedConditions.visibilityOf(lnkPaymentNumber));
		   report.log(LogStatus.PASS, "Clicked on Search button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isSearchBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSearch, context.getReactTimeout());
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
		
		 report.log(LogStatus.PASS, "Manage  Payments page is Loaded Successfully");
    	 if(srchParty.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Payments Page</span></a>");
	   	return new Item(xyz);
   }

}
