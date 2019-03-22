package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class BasicOptionsPage  extends BasePageObject{
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:basicReqBody:paramDynForm_ATTRIBUTE1::content')]")
	    private WebElement selectBankAccount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:basicReqBody:paramDynForm_ATTRIBUTE2::content')]")
	    private WebElement txtStatementID;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE2::lovDialogId::ok')]")
	    private WebElement btnStatementIDOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:basicReqBody:paramDynForm_ATTRIBUTE4::glyph')]")
	    private WebElement btnFromStatementEndDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ATTRIBUTE4::pop::cd::mSel::content')]")
	    private WebElement selectFromStatementEndMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE4::pop::cd::cg')]")
	    private WebElement tbleFromStatementEndDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE5::glyph')]")
	    private WebElement btnToStatementEndDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ATTRIBUTE5::pop::cd::mSel::content')]")
	    private WebElement selectToStatementEndMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE5::pop::cd::cg')]")
	    private WebElement tbleToStatementEndDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	
	
	 public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	 public BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(selectBankAccount));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Basic Options Page *****************************");
	       this.getScreenDetails();
	    }
    
 // Bank  Account
	   public void SelectBankAccount(String strBankAccount) throws InterruptedException{
		   this.getScreenDetails();
		   selectBankAccount.click();
		   selectBankAccount.sendKeys(strBankAccount);
		  // txtMajor.sendKeys(Keys.ARROW_DOWN);
		   selectBankAccount.sendKeys(Keys.ENTER);
		  // wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
	    	SeleniumUtils.delay(3000);
	   }
	   
	   public boolean isSelectBankAccountDisplayed(){
		   return selectBankAccount.isDisplayed();
		   } 
	 //Statement ID
	   
	   public void selectStatementID(String strStatementID){
		   SeleniumUtils.delay(2000);
		   txtStatementID.clear();
		   //txtStatementID.click();
		   txtStatementID.sendKeys(strStatementID);
		   txtStatementID.sendKeys(Keys.ENTER);
		   wdwait.until(ExpectedConditions.visibilityOf(btnStatementIDOk));
		   //report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
	   }
	   
	   public boolean isDescriptionDisplayed(){
		   return txtStatementID.isDisplayed();
		   }
	   
	   public void selectEvent(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = driver.findElement(By.xpath("//*[contains(@id,'paramDynForm_ATTRIBUTE2_afrLovInternalTableId::db')]//span[text()= '"+eventName+"']"));
		   SeleniumUtils.isDisplayed(driver, eventLink, context.getReactTimeout());  
		   eventLink.click(); 
		   //Thread.sleep(5000);
		   report.log(LogStatus.PASS, "Select Category Category is: "+eventName);
		   }
	   
	   // Click on StatementID Ok Button
	   
   
	   public void clickStatementIDOkButton(){
		   btnStatementIDOk.click();
		  // report.log(LogStatus.PASS, "Clicked on Stetement ID Ok Button"); 
	   }  
	   //txtSubmissionNotes
	   public void clickSubmissionNotesText(){
		   txtSubmissionNotes.click();
		  // report.log(LogStatus.PASS, "Clicked on Stetement ID Ok Button"); 
	   }  
	   
	// click on From Statement End Date button
	      
	   public boolean isFromStatementEndDateBtnDisplayed(){
		   return btnFromStatementEndDt.isDisplayed();
	    	
	    }
	    public void clickFromStatementEndDateButton(){	    	
	    	btnFromStatementEndDt.click();
	    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromStatementEndMonth));
	    	report.log(LogStatus.PASS, "Clicked on From Statement End Date Button");
	    }
	   
	   // Select From Statement End Month from Calander
	    public void selectFromStatementEndDtMonth(String fromMonth){
	    	Select objSelect = new Select(selectFromStatementEndMonth);
	    	objSelect.selectByVisibleText(fromMonth);
	    	 wdwait.until(ExpectedConditions.visibilityOf(tbleFromStatementEndDt));
	    	//SeleniumUtils.delay(5000);
	    	report.log(LogStatus.PASS, "Selected From Statement End Date Month  is: "+fromMonth);
	    } 
	   
	   public boolean isFromStatementEndDtMonthDisplayed(){
		   return selectFromStatementEndMonth.isDisplayed();
		   
	   }
	   
	   // Select From Statement End Date
	   public void selectFromStatementEndDate(String fromDate)
		{
			List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'paramDynForm_ATTRIBUTE4::pop::cd::cg')]//td"));  
			for (WebElement cell:dates)
			  {
				String date=cell.getText();
			   if (date.equalsIgnoreCase(fromDate))
			   {
			     cell.click();
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Selected From Statement End Date is "+fromDate);
				   break;
				   
			   }
			  } 
			   
		  }
	   
	// click on To Statement End Date button
	      
	   public boolean isToStatementEndDateBtnDisplayed(){
		   return btnToStatementEndDt.isDisplayed();
	    	
	    }
	    public void clickToStatementEndDateButton(){	    	
	    	btnToStatementEndDt.click();
	    	 wdwait.until(ExpectedConditions.visibilityOf(selectToStatementEndMonth));
	    	report.log(LogStatus.PASS, "Clicked on To Statement End Date Button");
	    }
	   
	   // Select To Statement End Month from Calander
	    public void selectToStatementEndDtMonth(String toMonth){
	    	Select objSelect = new Select(selectToStatementEndMonth);
	    	objSelect.selectByVisibleText(toMonth);
	    	 wdwait.until(ExpectedConditions.visibilityOf(tbleToStatementEndDt));
	    	//SeleniumUtils.delay(5000);
	    	report.log(LogStatus.PASS, "Selected To Statement End Date Month  is: "+toMonth);
	    } 
	   
	   public boolean isToStatementEndDtMonthDisplayed(){
		   return selectToStatementEndMonth.isDisplayed();
		   
	   }
	   
	   // Select To Statement End Date
	   public void selectToStatementEndDate(String toDate)
		{
			List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'paramDynForm_ATTRIBUTE5::pop::cd::cg')]//td"));  
			for (WebElement cell:dates)
			  {
				String date=cell.getText();
			   if (date.equalsIgnoreCase(toDate))
			   {
			     cell.click();
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Selected To Statement End Date is "+toDate);
				   break;
				   
			   }
			  } 
			   
		  }
	   
	   
			// Submit Button
			   public boolean isSubmitButtonDisplayed(){
				   return btnSubmit.isDisplayed();  	
			   }  
		   
			   public void clickSubmitButton(){
				   btnSubmit.click();
				   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
				   report.log(LogStatus.PASS, "Clicked on Submit Button"); 
			   } 
			 
			   
			   // Confirmation Ok Button
			   public boolean isConfOkBtnDisplayed(){
				   return btnConfOk.isDisplayed();  	
			   }  
		   
			   public void clickConfOkButton(){
				   btnConfOk.click();
				   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button"); 
			   }  
		   
		    @Override
			public boolean isDisplayed() {
				// TODO Auto-generated method stub
				//return  btnTasks.isDisplayed();
				
				 report.log(LogStatus.PASS, "Basic Options page is Loaded Successfully");
		    	 if(selectBankAccount.isDisplayed())
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
			   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Basic Options Page</span></a>");
			   	return new Item(xyz);
		   
			}
}
