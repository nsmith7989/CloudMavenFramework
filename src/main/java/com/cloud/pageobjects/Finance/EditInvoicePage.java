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

public class EditInvoicePage extends BasePageObject{
	
	public WebDriver driver;
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:me1']")
	    private WebElement menuInvActionsEdit;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:cmi2']")
	    private WebElement menuPayFullEdit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:_ATp:ta2:0:pgl8')]")
	    private WebElement cell1Invoice;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:_ATp:ctb2')]")
	    private WebElement btnCancelLine;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pm1:r1:1:ap1:r9:1:paymentProfileNameId::content')]")
	    private WebElement selectPaymentProProfile;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:1:ap1:r9:1:paymentDocumentNameId::content')]")
	    private WebElement selectPaymentDocument;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:1:ap1:r9:1:it1::content')]")
	    private WebElement txtPaymentNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:1:ap1:pifbtn1')]")
	    private WebElement btnSubmit;
	 
	 
	 @FindBy(how=How.XPATH, using = "//button[@id='_FOd1::msgDlg::cancel']")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cb14')]")
	    private WebElement btnSaveClose;
	 
	
	
	
	
	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/

public EditInvoicePage(WebDriver driver, ExtentTest report) throws TestException {
     super(report);
	 this.driver=driver; 
	 wdwait=new WebDriverWait(driver, 60);
     PageFactory.initElements(driver, this);
     
     wdwait.until(ExpectedConditions.visibilityOf(menuInvActionsEdit));
     if (!isDisplayed()) 
     {
        throw new TestException(this.getClass().getName() + " is not loaded");
     }
     
        System.out.println("******************************* Edit Invoice Page *****************************");
       this.getScreenDetails();
    }
	
	//Invoice Actions menu
	public void clickActionsMenu(){	
			menuInvActionsEdit.click();
			 wdwait.until(ExpectedConditions.visibilityOf(menuPayFullEdit));
		   SeleniumUtils.delay(8000);
		   report.log(LogStatus.PASS, "Clicked on Invoice Actions Menu");
	}
	
	public boolean isActionsMenuDisplayed(){
		  // return SeleniumUtils.isDisplayed(driver, menuInvActionsEdit, context.getReactTimeout());
		   return menuInvActionsEdit.isDisplayed();
		
	}

	// Pay in Full Actions Menu
	
	public void selectPayInFullActionsMenu(){	
			menuPayFullEdit.click();
			 wdwait.until(ExpectedConditions.visibilityOf(selectPaymentProProfile));
		   //SeleniumUtils.delay(8000);
		   report.log(LogStatus.PASS, "Clicked on Invoice Actions Menu");
	}
	
	public boolean isPayInFullActionsMenuDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, menuPayFullEdit, context.getReactTimeout());
		   return menuPayFullEdit.isDisplayed();
		
	}

	// Select Payment Process Profile
	
	   public void SelectPaymentProcessProfile(String strPmtProcProfile) throws InterruptedException{
	   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
		   selectPaymentProProfile.click();
	   //	SeleniumUtils.isDisplayed(driver, selectPaymentProProfile, context.getReactTimeout());
	   	selectPaymentProProfile.sendKeys(strPmtProcProfile);
	   	//selectPaymentProProfile.sendKeys(Keys.ARROW_DOWN);
	   	selectPaymentProProfile.sendKeys(Keys.ENTER);
	   	SeleniumUtils.delay(3000);
	    report.log(LogStatus.PASS, "Selected Payment Process Profile  is: "+strPmtProcProfile);
	   }
	   
	   public boolean isSelectPaymentProcessProfileDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, selectPaymentProProfile, context.getReactTimeout());
		   return selectPaymentProProfile.isDisplayed();
		   
		   } 
	   
	   
	   // Click on Payment Number Text field
	   
	   public void clickPaymentNumber(){
		   SeleniumUtils.delay(3000);
		   txtPaymentNumber.click();
		  
		  // report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button"); 
	   }
	   
	 // Submit button  
	   public void clickSubmitButton(){	
		   btnSubmit.click();
		   report.log(LogStatus.PASS, "Clicked on Submit Button");
	   }
	   
	   public boolean isSubmitBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());		 
	   }
	   
	// Invoice Cell 1 click 
	   public void clickCell1Invoice(){
		   //this.getScreenDetails();
		   cell1Invoice.click();
		   report.log(LogStatus.PASS, "Clicked on cell 1");
	   }
	   
	   public boolean isCell1InvoiceDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, cell1Invoice, context.getReactTimeout());		 
	   }
	   
	   
	   // Cancel Line button
	   public void clickCancelLineButton(){	
		   btnCancelLine.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Cance lLine Button");
	   }
	   
	   public boolean isCancelLineBtnDisplayed() throws InterruptedException{
		  // return SeleniumUtils.isDisplayed(driver, btnCancelLine, context.getReactTimeout());	
		   return btnCancelLine.isDisplayed();
	   }
	   
	   
	   // Confirmation Ok Button
	   
	   public void clickConfOkButton(){	
		   btnConfOk.click();
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	   }
	   
	   public boolean isConfOkBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());		 
	   }
	     
	   
		
	// Save and Close button
		   
		   public void clickSaveAndCloseButton(){	
			   btnSaveClose.click();
			   SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
		   }
		   
		   public boolean isSaveAndCloseButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnSaveClose, context.getReactTimeout());
		   	
		   }

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Edit Invoice page is Loaded Successfully");
    	 if(menuInvActionsEdit.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Invoice Page</span></a>");
	   	return new Item(xyz);
   }

}
