package com.cloud.pageobjects.Finance;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class CreateTransactionPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:orgNameId::content')]")
	    private WebElement selectBusinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//tbody/tr/td/ul[contains(@id,'ap1:orgNameId::_afrautosuggestpopup')]")
	    private WebElement PopUpBusinessUnit;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:batchSourceId::content')]")
	    private WebElement selectTransactionSource;
	 
	 @FindBy(how=How.XPATH, using = "//tbody/tr/td/ul[contains(@id,'ap1:batchSourceId::_afrautosuggestpopup')]")
	    private WebElement popUpTransactionSource;
	 
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:billToNameId::lovIconId')]")
	    private WebElement iconSearchBillToName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtBillToName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Id:value10::content')]")
	    private WebElement txtAccNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:billToNameId::_afrLovInternalQueryId::search')]")
	    private WebElement btnBillToNameSearch;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:billToNameId::lovDialogId::ok')]")
	    private WebElement btnBillToNameOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table1:0:descriptionId::content')]")
	    private WebElement txtDescriptionCell1;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table1:0:quantity::content')]")
	    private WebElement txtQuantityCell1;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table1:0:sellingPrice::content')]")
	    private WebElement txtUnitPriceCell1;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:salesPersonId::content')]")
	    private WebElement txtTransectionNum;

	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:saveMenu')]/table/tbody/tr/td[1]/a/span")
	 //*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_billing:0:MAnt2:2:pt1:Trans1:0:ap110:saveMenu']/table/tbody/tr/td[1]/a
	 	//@FindBy(how=How.XPATH, using = "//tbody//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_billing:0:MAnt2:1:pt1:TCF:0:ap1:saveMenu']//td[@class='af_commandToolbarButton_link-cell']/a[@class='xu0']/span[@class='xu3']")
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,':saveMenu')]/table/tbody/tr/td[1]/a")
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_billing:0:MAnt2:1:pt1:TCF:0:ap1:saveMenu']/table/tbody/tr/td[1]/a")
	    private WebElement btnSave;
	
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public CreateTransactionPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Create  Transaction Page *****************************");
		       this.getScreenDetails();
		    }

	    
	  //BusinessUnit list
		   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
		   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
		   	selectBusinessUnit.click();
		   	SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
		   	selectBusinessUnit.sendKeys(strBusinessUnit);
		   	wdwait.until(ExpectedConditions.visibilityOf(PopUpBusinessUnit));
		   	selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
		   	selectBusinessUnit.sendKeys(Keys.ENTER);
		   	SeleniumUtils.delay(2000);
		    report.log(LogStatus.PASS, "Selected Business Unit  is: "+strBusinessUnit);
		   }
		  
		   public boolean isSelectBusinessUnitDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
			   } 
		 //Transaction Source list
		   public void SelectTransactionSource(String strTransaction) throws InterruptedException{
			  
			   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
			   selectTransactionSource.click();
			   	SeleniumUtils.isDisplayed(driver, selectTransactionSource, context.getReactTimeout());
			   	selectTransactionSource.sendKeys(strTransaction);
			   	wdwait.until(ExpectedConditions.visibilityOf(popUpTransactionSource));
			   	selectTransactionSource.sendKeys(Keys.ARROW_DOWN);
			   	selectTransactionSource.sendKeys(Keys.ENTER);
			   	SeleniumUtils.delay(2000);
			    report.log(LogStatus.PASS, "Selected Transaction Source is: "+strTransaction);
			   }
		   
		   public boolean isSelectTransactionSourceDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, selectTransactionSource, context.getReactTimeout());
			   } 
		   
		   // Search: Supplier Icon
		   
		   public void clickSearchSupplierIcon(){	
			   iconSearchBillToName.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtBillToName));
			   report.log(LogStatus.PASS, "Clicked on Search: Bill-to Name icon");  
			   
		   }
		   
		   public boolean isSearchSupplierIconDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, iconSearchBillToName, context.getReactTimeout());
		   }
		   
		   // Search :
		   
		 //Enter text into Supplier field
		   public void enterSupplier(String strBillToName){
			   txtBillToName.clear();
			   txtBillToName.click();
			   txtBillToName.sendKeys(strBillToName);
			   report.log(LogStatus.PASS, "Entered Name is: "+strBillToName);
		   }
		   
		   public boolean isSupplierDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, txtBillToName, context.getReactTimeout());
			   }
		  // Supplier Number Field
		   
		   public void clickSupplierNumber(){
			   txtAccNumber.click();
			   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
		   }   
		   
		// Supplier Search Button 
		   public void clickSupplierSearchButton(){	
			   btnBillToNameSearch.click();
			   report.log(LogStatus.PASS, "Clicked on Search: Bill-to Name icon");
		   }
		   
		   public boolean isSupplierSearchBtnDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver, btnBillToNameSearch, context.getReactTimeout());		 
		   }
		   
		// Supplier Search Ok Button 
		   public void clickSupplierOkButton(){	
			   this.getScreenDetails();
			   btnBillToNameOk.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Bill-to Name Ok Button");
		   }
		   
		   public boolean isSupplierOkBtnDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver,  btnBillToNameOk, context.getReactTimeout());		 
		   }  
		   
		 //Select Event (select given text from dropdown)
		   public void selectEvent(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		  
		 //Enter text into Description field
		   public void enterDescription(String strDescription){
			   txtDescriptionCell1.clear();
			   txtDescriptionCell1.click();
			   txtDescriptionCell1.sendKeys(strDescription);
			   report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
		   }
		   
		   
		   public boolean isDescriptionDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver,  txtDescriptionCell1, context.getReactTimeout());		 
		   }  
		 //Enter text into Quantity field
		   public void enterQuantity(String strQuantity){
			   txtQuantityCell1.clear();
			   txtQuantityCell1.click();
			   txtQuantityCell1.sendKeys(strQuantity);
			   report.log(LogStatus.PASS, "Entered Quantity is: "+strQuantity);
		   }
		   
		   public boolean isQuantityDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver,  txtQuantityCell1, context.getReactTimeout());		 
		   }  
		   
		 //Enter text into Unit Price field
		   public void enterUnitPrice(String strUnitPrice){
			   txtUnitPriceCell1.clear();
			   txtUnitPriceCell1.click();
			   txtUnitPriceCell1.sendKeys(strUnitPrice);
			   report.log(LogStatus.PASS, "Entered Quantity is: "+strUnitPrice);
		   } 
		   
		   public boolean isUnitPriceDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver,  txtUnitPriceCell1, context.getReactTimeout());		 
		   } 
		   
		   // Click on Transection Number
		   public void clickTransectionNumber(){
			  
			   txtTransectionNum.click();
			   
		   } 
		   
		   
		   
		   
		 // Save Button
		   
		    
		   public void clickSaveMenuButton(){
			   SeleniumUtils.delay(5000);
			   Actions hover=new Actions(driver);
			   hover.moveToElement(btnSave);
			   btnSave.click();
			 /* JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", btnSave);
			   	//btnSave.click();*/
			    SeleniumUtils.delay(10000);
			  
			   report.log(LogStatus.PASS, "Clicked on Save Button");
		   }
		   
		   public EditTransactionPage clickSaveButton()throws TestException{
			     SeleniumUtils.delay(5000);
			   //Actions ob = new Actions(driver);
		        //ob.click(btnSave);
			  // btnSave.click();
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  js.executeScript("arguments[0].click();", btnSave);
			   	//btnSave.click();
			   // SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Clicked on Save button");
		    	return new EditTransactionPage(driver,report);
		    }
		  
		   public boolean isSaveBtnDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnSave, context.getReactTimeout());
		   } 
		   
		  
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Create Transaction page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Transaction Page</span></a>");
		   	return new Item(xyz);
	   }


}
