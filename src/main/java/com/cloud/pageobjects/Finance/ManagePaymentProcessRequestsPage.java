package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
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

public class ManagePaymentProcessRequestsPage extends BasePageObject{
		 
	public WebDriver driver;
	
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1:value00::content')]")
 		private WebElement txtName;
 	
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1:value50::glyph')]")
    private WebElement btnCreationDate;
 
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pop::cd::mSel::content')]")
    private WebElement calCreationDtMonth;
 
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pop::cd::cg')]//td")
    private WebElement calendarCreationDate;
 
 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1::search')]")
    private WebElement btnSearch;
 	
 	@FindBy(how=How.XPATH, using = "//img[contains(@id,'commandImageLink2_1::icon')]")
    private WebElement imgAction; 	
 	
 	
 	public WebDriverWait wdwait; 
 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	public ManagePaymentProcessRequestsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(txtName));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Manage Payment Process Request Page *****************************");
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
    
	
	// click on Creation Date Calendar button
	      
	   public boolean isCreationDateBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnCreationDate, context.getReactTimeout());
	    	
	    }
	    public void clickCreationDateButton(){	    	
	    	btnCreationDate.click();
	    	SeleniumUtils.delay(3000);
	    	report.log(LogStatus.PASS, "Clicked on Creation Date Button");
	    }
	    
	    
	 // Select Creation Date Month from Calendar
	    public void selectCreationDateMonth(String toMonth){
	    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
	    	Select objSelect = new Select(calCreationDtMonth);
	    	objSelect.selectByVisibleText(toMonth);
	    	SeleniumUtils.delay(2000);
	    	report.log(LogStatus.PASS, "Selected Creation Date Month  is: "+toMonth);
	    } 
	   
	   public boolean isCreationDateMonthDisplayed(){
		   return SeleniumUtils.isDisplayed(driver,calCreationDtMonth, context.getReactTimeout());
	   }
	
	// Select Pay Through Date
	   public void selectCreationDate(String toDate)
		{
			List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'pop::cd::cg')]//td"));
		  
			for (WebElement cell:dates)
			  {
				String date=cell.getText();
			   if (date.equalsIgnoreCase(toDate))
			   {
			     cell.click();
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Selected date is "+toDate);
				   break;
				   
			   }
			  } 
			  
		  }
	   
	// Search button
	   
	   public void clickSearchButton() throws InterruptedException{ 
		   btnSearch.click();
		   SeleniumUtils.delay(3000);
		   //wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
		   report.log(LogStatus.PASS, "Clicked on Search button");
	   }
	   
	   public boolean isSearchBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSearch, context.getReactTimeout());
	   }
	
	
	// Action Image
	    
	    public boolean isActionImageDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, imgAction, context.getReactTimeout());
	    }
	    
	    public ReviewInstallmentsPage clickActionImage()throws TestException{
	    	imgAction.click();
	    	report.log(LogStatus.PASS, "Clicked on Action Image");
	    	return new ReviewInstallmentsPage(driver,report);
	    }
	   
   
	 @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Manage Payment Process Request page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Payment Process Request Page</span></a>");
		   	return new Item(xyz);
	   }
     
}
