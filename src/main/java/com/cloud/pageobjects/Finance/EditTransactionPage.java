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

public class EditTransactionPage extends BasePageObject{
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:m1')]/div//td[3]")
	    private WebElement menuAction;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'newTrx::popEl')]")
	    private WebElement menuCompCreateAnother;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'reviewBTN')]")
	    private WebElement lstCompleteandReview;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:onLineAccounting')]")
	    private WebElement menuPostToLadger;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:cb110')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:saveMenu::popEl')]")
	    private WebElement menuSave;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:cmi10')]")
	    private WebElement lstSaveAndClose;
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOd1::msgDlg::cancel']")
	    private WebElement btnInfOk;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public EditTransactionPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(menuAction));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Edit Transaction Page *****************************");
		       this.getScreenDetails();
		    }


	    // Complete and Create Another Menu
		   public void clickCompleteAndCreateAnotherMenu(){
			   menuCompCreateAnother.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lstCompleteandReview));
			   report.log(LogStatus.PASS, "Clicked on Complete And Create Another Button");
		   }
		  
		   public boolean isCompleteAndCreateAnotherMenuDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, menuCompCreateAnother, context.getReactTimeout());
		   } 
		   
		  // click Complete And Review list
		   public void clickCompleteAndReviewList(){
			   lstCompleteandReview.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(lstCompleteandReview));
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Complete And Review List");
		   }
		  
		   public boolean isCompleteAndReviewLstDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, lstCompleteandReview, context.getReactTimeout());
		   }
		   
		   // Invoice Actions menu
		   public void clickActionsMenu(){	
			   menuAction.click();
			   wdwait.until(ExpectedConditions.visibilityOf(menuPostToLadger));
			   report.log(LogStatus.PASS, "Clicked on  Actions Menu");
		   }
		  
		   public boolean isActionsMenuDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, menuAction, context.getReactTimeout());
		   	
		   }
		
		   
		   // Post to Ledger list item from  Actions menu 
		   
		   public void selectPostLedgerMenu(){	
			   menuPostToLadger.click();
			   //SeleniumUtils.delay(8000);
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   report.log(LogStatus.PASS, "Selected Validate item Invoice Actions Menu");
		   }
		   
		   public boolean isPostLedgerMenuDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, menuPostToLadger, context.getReactTimeout());
		   	
		   }
		   
		// Confirmation Ok button
		   
		   public boolean isConfOkButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
		   }  
		   
		   public void clickConfOkButton(){	
			   this.getScreenDetails("Confirmation Pop-up");
			   btnConfOk.click();
			   SeleniumUtils.delay(1000);
			   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
			 
		   }
		   
		   // Save Menu
		   public void clickSaveMenu(){	
			   menuSave.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lstSaveAndClose));
			   report.log(LogStatus.PASS, "Clicked on Save Menu");
		   }
		  
		   public boolean isSaveMenuDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, menuSave, context.getReactTimeout());
		   	
		   }
		   
		   // Save and Close Button
		   
		   public void clickSaveAndCloseList(){	
			   lstSaveAndClose.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnInfOk));
			   report.log(LogStatus.PASS, "Clicked on Save and Close list");
		   }
		  
		   public boolean isSaveAndCloseDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, lstSaveAndClose, context.getReactTimeout());
		   	
		   }
		   
		   // Confirmation Ok button
		   
		   public boolean isInfoOkButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnInfOk, context.getReactTimeout());  	
		   }  
		   
		   public void clickInfoOkButton(){	
			   this.getScreenDetails("Information Pop-up");
			   btnInfOk.click();
			   SeleniumUtils.delay(1000);
			   report.log(LogStatus.PASS, "Clicked on Information Ok Button");
			  
		   }
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Edit Transaction Page is Loaded Successfully");
	    	 if(menuAction.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Transaction Page</span></a>");
		   	return new Item(xyz);
	   }

}
