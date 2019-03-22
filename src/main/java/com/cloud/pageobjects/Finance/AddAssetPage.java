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

public class AddAssetPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:inputText4::content')]")
	    private WebElement txtAssetNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:df2_AdditionCatDFFVOIteratorclassCode__FLEX_EMPTY::content')]")
	    private WebElement selectClassCode;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table1:0:employeeNameId::content')]")
	    private WebElement selectEmpName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table1:0:employeeNumberId::content')]")
	    private WebElement selectEmpNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton15')]")
	    private WebElement btnSubmit;
	  
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public AddAssetPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(txtAssetNumber));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Add Asset Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    //Asset Number field
	    
	    public void enterAssetNumber(String strAssetNumber){
	    	txtAssetNumber.clear();
	    	txtAssetNumber.click();
	    	txtAssetNumber.sendKeys(strAssetNumber);
			  // report.log(LogStatus.PASS, "Entered Location is: "+strAssetNumber);
		   }
		   
		   public boolean isAssetNumberDisplayed(){
			   return txtAssetNumber.isDisplayed();
			   }
		   
		   //Class Code list
		   public void SelectClassCode(String strClassCode) throws InterruptedException{
			   selectClassCode.click();
			   selectClassCode.sendKeys(strClassCode);
			   selectClassCode.sendKeys(Keys.ENTER);
		   		SeleniumUtils.delay(3000);
		   // report.log(LogStatus.PASS, "Selected Class Code  is: "+strClassCode);
		   }
		   
		   public boolean isClassCodeDisplayed(){
			   return selectClassCode.isDisplayed();
			   }  
		   
		   //Employee Name list
		   public void SelectEmployeeName(String strEmpName) throws InterruptedException{
			   selectEmpName.click();
			   selectEmpName.sendKeys(strEmpName);
			   selectEmpName.sendKeys(Keys.ENTER);
		   		SeleniumUtils.delay(3000);
		   		selectEmpNumber.click();
		   		this.getScreenDetails();
		    //report.log(LogStatus.PASS, "Selected Employee Name  is: "+strEmpName);
		   }
		   
		   public boolean isEmployeeNameDisplayed(){
			   return selectEmpName.isDisplayed();
			   }  
		   
		// Submit Button   
		   public boolean isSubmitButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());  	
		   }  
	   
		   public void clickSubmitButton(){
			   this.getScreenDetails();
			   btnSubmit.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
			  
		   } 
	 
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Add Asset page is Loaded Successfully");
	    	 if(txtAssetNumber.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Add Asset Page</span></a>");
		   	return new Item(xyz);
	   }

}
