package com.cloud.pageobjects.Finance;

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

public class FileImportAndExportPage extends BasePageObject{
	public WebDriver driver;

	 @FindBy(how=How.XPATH, using = "//*[@id='pt1:USma:0:MAnt1:0:pt1:AP1:AT1:_ATp:create::icon']")
	    private WebElement btnUpload;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:AP1:AT1:if1::content')]")
	    private WebElement btnBrowse;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'pt1:AP1:AT1:soc4::content')]")
	    private WebElement selectAccount;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'pt1:AP1:AT1:FAsc1')]")
	    private WebElement btnSaveAndClose;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:AP1:AT1:_ATp:ATt1:1:soc2::content')]")
	    private WebElement cellAccountData;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public FileImportAndExportPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnUpload));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* File Import and Export Page *****************************");
		       this.getScreenDetails();
		    }
	    
	 // Upload button
	    public void clickUploadButton(){	
	    	   btnUpload.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnBrowse));
			   report.log(LogStatus.PASS, "Clicked on Upload Button");
		   }
		   
		   public boolean isUploadBtnDisplayed() throws InterruptedException{
			   return btnUpload.isDisplayed();		 
		   }  
	    
	 // Browse button
		   
		   public void clickBrowseWithFile(String filePath){
			   SeleniumUtils.delay(2000);
			   btnBrowse.sendKeys(filePath);
			  
			   report.log(LogStatus.PASS, "Clicked on Browse Button and folder attached successfully");
		   }
		   
		   public boolean isBrowseBtnDisplayed(){
			  return btnBrowse.isDisplayed();
		   }
		   
	    //Account list
		   public void selectAccount(String strAccount){
		    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
		    	Select objSelect = new Select(selectAccount);
		    	objSelect.selectByVisibleText(strAccount);
		    	//SeleniumUtils.delay(5000);
		    	//report.log(LogStatus.PASS, "Selected Account  is: "+strCatagory);
		    } 
		   
		   public boolean isAccountDisplayed(){
			   return selectAccount.isDisplayed();
		   }
		// Save and Close button   
		   public void clickSaveAndCloseButton(){	
			   btnSaveAndClose.click();
			   wdwait.until(ExpectedConditions.visibilityOf(cellAccountData));
			   report.log(LogStatus.PASS, "Clicked on Save and Close Button");
		   }
		   
		   public boolean isSaveAndCloseBtnDisplayed() throws InterruptedException{
			   return btnSaveAndClose.isDisplayed();		 
		   }  
		   
		   
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "File Import and Export page is Loaded Successfully");
	    	 if(btnUpload.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>File Import and Export Page</span></a>");
		   	return new Item(xyz);
	   }
	
	
	
	

}
