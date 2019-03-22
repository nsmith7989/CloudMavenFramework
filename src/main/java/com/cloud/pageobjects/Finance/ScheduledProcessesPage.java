package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ScheduledProcessesPage extends BasePageObject{
	
	public WebDriver driver;

	 @FindBy(how=How.XPATH, using = "//div[contains(@id,'pt1:panel:scheduleProcess')]/a[@class='xu0']")
	    private WebElement btnScheduleNewProcess;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::lovIconId')]")
	    private WebElement iconScdlProcessName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::dropdownPopup::popupsearch')]")
	    private WebElement lnkSrchScdlProcessName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::_afrLovInternalQueryId::search')]")
	    private WebElement btnSearchName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::lovDialogId::ok')]")
	    private WebElement btnOkName;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:snpokbtnid')]")
	    private WebElement btnOkScdlProcessName;
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:srspw1::_ttxt']")
	    private WebElement ttlProcessDetails; 
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'jobDisplayNameId::content')]")
	    private WebElement selectImportProcess;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ucmFileId::content')]")
	    private WebElement selectDataFile;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfirmation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_BusinessUnit::content')]")
	    private WebElement selectBussinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_SupplierName::lovIconId')]")
	    private WebElement iconSearchSupplierName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_SupplierName::dropdownPopup::popupsearch')]")
	    private WebElement lnkSearchSupplierName;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'SupplierName::_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtSupplierName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'SupplierName::_afrLovInternalQueryId:value10::content')]")
	    private WebElement txtSupplierNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'SupplierName::_afrLovInternalQueryId::search')]")
	    private WebElement btnSearchSuplName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'SupplierName::lovDialogId::ok')]")
	    private WebElement btnOkSuplName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_FromEnteredDate::glyph')]")
	    private WebElement btnFromEnteredDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_FromEnteredDate::pop::cd::mSel::content')]")
	    private WebElement selectFromEnteredMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_FromEnteredDate::pop::cd::cg')]")
	    private WebElement tbleFromEnteredDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ToEnteredDate::glyph')]")
	    private WebElement btnToEnteredDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ToEnteredDate::pop::cd::mSel::content')]")
	    private WebElement selectToEnteredMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ToEnteredDate::pop::cd::cg')]")
	    private WebElement tbleToEnteredDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE9_ATTRIBUTE9::content')]")
	    private WebElement selectAccPeriod;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:submitButton')]")
	    private WebElement btnSubmitPrcDetails;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'pt1:panel:processRefreshId::icon')]")
	    private WebElement btnRefresh;
	 
	 @FindBy(how=How.XPATH, using = " .//*[@id='templateTableBody']/tr[2]/td[1]/span")
	    private WebElement lnkDefaultDocument;
	 
	 @FindBy(xpath = "//span[contains(@class,'dataLink')]")
	  private WebElement lnkDafaultDocument;
	 
	 @FindBy(xpath = "//button[contains(.,'Republish')]")
	 private WebElement btnRepublish;
	 
	
	 @FindBy(xpath = "//*[@id='download']")
	  private WebElement btnDownload;
	
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public ScheduledProcessesPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnScheduleNewProcess));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Scheduled Processes Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    // Schedule New Process button
	    public void clickScheduleNewProcessButton(){	
	    	btnScheduleNewProcess.click();
			   wdwait.until(ExpectedConditions.visibilityOf(iconScdlProcessName));
			   report.log(LogStatus.PASS, "Clicked on Schedule New Process Button");
		   }
		   
		   public boolean isScheduleNewProcessBtnDisplayed() throws InterruptedException{
			   return btnScheduleNewProcess.isDisplayed();		 
		   } 
		// Click on icon Schedule New ProcessName   
		  		   
		   public void clickSearchScheduleNewProcessIcon(){	
			   iconScdlProcessName.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lnkSrchScdlProcessName));
			   report.log(LogStatus.PASS, "Clicked on Schedule New Process Search icon");  
			   
		   }
		   
		   public boolean isSearchScheduleNewProcessIconDisplayed(){
			   return iconScdlProcessName.isDisplayed();
		   }
		   
		 //Search link for Schedule New Process
		   
		   public void clickScheduleNewProcessSearchLink() throws InterruptedException{	

			   lnkSrchScdlProcessName.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtName));
			   report.log(LogStatus.PASS, "Clicked on Account Search link");
		   }
		   
		   public boolean isScheduleNewProcessSearchLinkDisplayed(){
			   return lnkSrchScdlProcessName.isDisplayed();
		   }  
		   
		 //Value for Name
		   
		   public void enterName(String value) throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   txtName.clear();
			   txtName.click();
			   txtName.sendKeys(value);
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isNameDisplayed(){
			   return txtName.isDisplayed();
			   } 
		   
		// Select From Statement End Date
		   public void selectSearchAndSelectName(String fromDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2_afrLovInternalTableId::db']//div//td[1]"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
					System.out.println("data is :"+date);
				   if (date.equalsIgnoreCase(fromDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Statement End Date is "+fromDate);
					   break;
					   
				   }
				  } 
				   
			  }
		   
		// Search button in Account
		   public void clickNameSearchButton(){	
			   		btnSearchName.click();
					SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on Search and Select: Name Search");
		   }
		   
		   public boolean isNameSearchButtonDisplayed(){
			   return btnSearchName.isDisplayed();
		   } 
		   
		   // Select From Statement End Date
		   
		   public void selectEvent(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			  WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'pt1:selectOneChoice2::lovDialogId::contentContainer')]//span[contains(text(), '"+eventName+"')]")));
			   eventLink.click(); 
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
// Select From Statement End Date
		   
		   public void selectSupplierName(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			  WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '"+eventName+"')]")));
			   eventLink.click(); 
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		//  Ok Button for Name
		   
		   public void clickNameOkButton(){	
			   btnOkName.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Name Ok Button");
			   
		   }
		   
		   public boolean isNameOkButtonDisplayed(){
			   return btnOkName.isDisplayed();
		   } 
		   
		   //  Ok Button for  Schedule New Process
		   
		   public void clickScheduleNewProcessOkButton(){	
			   btnOkScdlProcessName.click();
			   wdwait.until(ExpectedConditions.visibilityOf(selectImportProcess));
			   report.log(LogStatus.PASS, "Clicked on Schedule New Process Ok Button");
			   
		   }
		   
		   public boolean isScheduleNewProcessOkButtonDisplayed(){
			   return btnOkScdlProcessName.isDisplayed();
		   }  
		   
		   // select Import Process
		   
		   public void SelectImportProcess(String strImportProcess) throws InterruptedException{
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   selectImportProcess.click();
			   selectImportProcess.sendKeys(strImportProcess);
			   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
			   selectImportProcess.sendKeys(Keys.ENTER);
			    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectDataFile));
			    element.click();
			   	//SeleniumUtils.delay(3000);
			    report.log(LogStatus.PASS, "Selected Import Process  is: "+strImportProcess);
			   }
			   
			   public boolean isSelectImportProcessDisplayed(){
				   return selectImportProcess.isDisplayed();
				   } 
			   
			// select Import Process
			   
			   public void SelectDataFile(String strDataFile) throws InterruptedException{
				   selectDataFile.click();
				   selectDataFile.sendKeys(strDataFile);
				   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
				   	selectDataFile.sendKeys(Keys.ENTER);
				   	txtSubmissionNotes.click();
				    report.log(LogStatus.PASS, "Selected Data File  is: "+strDataFile);
				   }
				   
				   public boolean isSelectDataFileDisplayed(){
					   return selectDataFile.isDisplayed();
					   } 
				   
				 //txtSubmissionNotes
				   public void clickSubmissionNotes() {
					   txtSubmissionNotes.click();
					   SeleniumUtils.delay(2000);
					   }
				   
			   // submit button
				   
				   public void clickSubmitButton(){	
					   btnSubmit.click();
					   //SeleniumUtils.delay(8000);
					   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
					   report.log(LogStatus.PASS, "Clicked on Submit Button");
					   this.getScreenDetails("Confirmation Pop-up");
				   }
				   
				   public boolean isSubmitBtnDisplayed(){
					   return btnSubmit.isDisplayed();
				   	
				   }
				   
				   // Conf Massege 
				   public String ConfirmationProcessId() {
					   SeleniumUtils.delay(4000);
					   String ConfMessage=lblConfirmation.getText();
					   //System.out.println("String is "+ConfMessage);
					   return ConfMessage.substring(8,13);
				   }
				   
				
		   // Conf Ok Button
				   public boolean isConfOkButtonDisplayed(){
					   return btnConfOk.isDisplayed();  	
				   }  
				   
				   public void clickConfOkButton(){	
					   
					   btnConfOk.click();
					   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
				   }
//Select Bussiness Unit
				   
				   public void SelectBussinessUnit(String strBankAccount) throws InterruptedException{
					   this.getScreenDetails();
					   selectBussinessUnit.click();
					   selectBussinessUnit.sendKeys(strBankAccount);
					  // txtMajor.sendKeys(Keys.ARROW_DOWN);
					   selectBussinessUnit.sendKeys(Keys.ENTER);
					  // wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
				    	SeleniumUtils.delay(3000);
				   }
				   
				   public boolean isBussinessUnitDisplayed(){
					   return selectBussinessUnit.isDisplayed();
					   } 
				   
				// Click on icon Supplier Name   
		  		   
				   public void clickSearchSupplierNameIcon(){	
					   iconSearchSupplierName.click();
					   wdwait.until(ExpectedConditions.visibilityOf(lnkSearchSupplierName));
					   report.log(LogStatus.PASS, "Clicked on Schedule New Process Search icon");  
					   
				   }
				   
				   public boolean isSearchSupplierNameIconDisplayed(){
					   return iconSearchSupplierName.isDisplayed();
				   }
				   
				 //Search link for Schedule New Process
				   
				   public void clickSupplierNameSearchLink() throws InterruptedException{	

					   lnkSearchSupplierName.click();
					   wdwait.until(ExpectedConditions.visibilityOf(txtSupplierName));
					   report.log(LogStatus.PASS, "Clicked on Account Search link");
					   this.getScreenDetails();
				   }
				   
				   public boolean isSupplierNameSearchLinkDisplayed(){
					   return lnkSearchSupplierName.isDisplayed();
				   }  
				   
				 //Value for SupplierName
				   
				   public void enterSupplierName(String value) throws InterruptedException{
					   SeleniumUtils.delay(3000);
					   txtSupplierName.clear();
					   txtSupplierName.click();
					   txtSupplierName.sendKeys(value);
					  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
				   }
				   
				   public boolean isSupplierNameDisplayed(){
					   return txtSupplierName.isDisplayed();
					   } 
				   
				// Search button in Supplier
				   public void clickSupplierSearchButton(){	
					   		btnSearchSuplName.click();
							SeleniumUtils.delay(3000);
					   report.log(LogStatus.PASS, "Clicked on Search and Select: Name Search");
				   }
				   
				   public boolean isSupplierSearchButtonDisplayed(){
					   return btnSearchSuplName.isDisplayed();
				   } 
				   
				//  Ok Button for Name
				   
				   public void clickSupplierOkButton(){	
					   btnOkSuplName.click();
					   SeleniumUtils.delay(5000);
					   report.log(LogStatus.PASS, "Clicked on Name Ok Button");
					   this.getScreenDetails(); 
					   
				   }
				   
				   public boolean isSupplierOkButtonDisplayed(){
					   return btnOkSuplName.isDisplayed();
				   } 
				   
				// click on From Entered Date button
				      
				   public boolean isFromEnteredDateBtnDisplayed(){
					   return btnFromEnteredDt.isDisplayed();
				    	
				    }
				    public void clickFromEnteredDateButton(){	    	
				    	btnFromEnteredDt.click();
				    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromEnteredMonth));
				    	report.log(LogStatus.PASS, "Clicked on From Entered Date Button");
				    }
				   
				   // Select From Entered Month from Calander
				    public void selectFromEnteredDtMonth(String fromMonth){
				    	Select objSelect = new Select(selectFromEnteredMonth);
				    	objSelect.selectByVisibleText(fromMonth);
				    	 wdwait.until(ExpectedConditions.visibilityOf(tbleFromEnteredDt));
				    	//SeleniumUtils.delay(5000);
				    	report.log(LogStatus.PASS, "Selected From Entered Date Month  is: "+fromMonth);
				    } 
				   
				   public boolean isFromEnteredDtMonthDisplayed(){
					   return selectFromEnteredMonth.isDisplayed();
					   
				   }   
			   
				// Select From Statement End Date
				   public void selectFromEnteredDate(String fromDate)
					{
						List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'paramDynForm_FromEnteredDate::pop::cd::cg')]//td"));  
						for (WebElement cell:dates)
						  {
							String date=cell.getText();
						   if (date.equalsIgnoreCase(fromDate))
						   {
						     cell.click();
							   SeleniumUtils.delay(2000);
							   report.log(LogStatus.PASS, "Selected From Entered Date is "+fromDate);
							   break;
							   
						   }
						  } 
						   
					  }
				   
				// click on To Entered Date button
				      
				   public boolean isToEnteredDateBtnDisplayed(){
					   return btnToEnteredDt.isDisplayed();
				    	
				    }
				    public void clickToEnteredDateButton(){	    	
				    	btnToEnteredDt.click();
				    	 wdwait.until(ExpectedConditions.visibilityOf(selectToEnteredMonth));
				    	report.log(LogStatus.PASS, "Clicked on To Entered Date Button");
				    }
				   
				   // Select To Entered Month from Calander
				    public void selectToEnteredDtMonth(String toMonth){
				    	Select objSelect = new Select(selectToEnteredMonth);
				    	objSelect.selectByVisibleText(toMonth);
				    	 wdwait.until(ExpectedConditions.visibilityOf(tbleToEnteredDt));
				    	//SeleniumUtils.delay(5000);
				    	report.log(LogStatus.PASS, "Selected To Entered Date Month  is: "+toMonth);
				    } 
				   
				   public boolean isToEnteredDtMonthDisplayed(){
					   return selectToEnteredMonth.isDisplayed();
					   
				   }   
			   
				// Select From Statement End Date
				   public void selectToEnteredDate(String toDate)
					{
						List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'paramDynForm_ToEnteredDate::pop::cd::cg')]//td"));  
						for (WebElement cell:dates)
						  {
							String date=cell.getText();
						   if (date.equalsIgnoreCase(toDate))
						   {
						     cell.click();
							   SeleniumUtils.delay(2000);
							   report.log(LogStatus.PASS, "Selected To Entered End Date is "+toDate);
							   break;
							   
						   }
						  } 
						   
					  }  
				   
				   
				   //Select Accounting Period
				   
				   public void SelectAccountingPeriod(String strAccPeriod) throws InterruptedException{
					   this.getScreenDetails();
					   selectAccPeriod.clear();
					   selectAccPeriod.click();
					   selectAccPeriod.sendKeys(strAccPeriod);
					  // txtMajor.sendKeys(Keys.ARROW_DOWN);
					   //selectAccPeriod.sendKeys(Keys.ENTER);
					  // wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
				    	SeleniumUtils.delay(3000);
				   }
				   
				   public boolean isAccountingPeriodDisplayed(){
					   return selectAccPeriod.isDisplayed();
					   }    
				   
				// Title displayed
				   public boolean isProcessDetailsTitleDisplayed(){
					   return ttlProcessDetails.isDisplayed();
					   } 
				   
				   //btnRefresh
				   public boolean isRefreshButtonDisplayed(){
					   return btnRefresh.isDisplayed();
					   } 
				   
				   public void clickRefreshButton(){	    	
					   btnRefresh.click();
					   SeleniumUtils.delay(2000);
					   btnRefresh.click();
					   SeleniumUtils.delay(5000);
					   btnRefresh.click();
					   SeleniumUtils.delay(3000);
					   btnRefresh.click();
				    	// wdwait.until(ExpectedConditions.visibilityOf(selectToEnteredMonth));
				    	report.log(LogStatus.PASS, "Clicked on Refresh Button");
				    }
				   
				   
				   public void selectScheduleNewProcessCell(String ProcessID)
					{
				    	List<WebElement> ScheduleProcessRows = driver.findElements(By.xpath("//table[@class='x1jf x1k3']//div//td[1]"));
				    	System.out.println("Statement Rows are"+ScheduleProcessRows.size());
						int r;
						int t=1;
						for (r=1;r<=ScheduleProcessRows.size();r++)
						  {
							 String strProcessId = driver.findElement(By.xpath("//table[@class='x1jf x1k3']//tr["+r+"]//div//td[1]")).getText();
							System.out.println("Data is"+strProcessId);
							if(strProcessId.equalsIgnoreCase(ProcessID)) {
								int k=r-t;
								/*String Status = driver.findElement(By.xpath("//table[@class='x1jf x1k3']//tr["+r+"]//div//td[2]")).getText();
								int j=1;
								while(j<10){
						              if((Status.equalsIgnoreCase("Succeeded"))!= true) {
						            	  btnRefresh.click();  
						              }else {
						            	  break;
						              }
						              j++;
						         }*/
								SeleniumUtils.delay(5000);
								WebElement ProcessName = driver.findElement(By.xpath("//table[@class='x1jf x1k3']//tr["+r+"]//div//td[3]"));
								//WebElement ProcessName = driver.findElement(By.xpath(" .//*[@id='pt1:USma:0:MAnt1:0:pt1:panel:result:"+k+":pgl1']"));
								ProcessName.click();
								SeleniumUtils.delay(5000);
								report.log(LogStatus.PASS, "Clicked on Payables Invoice Register Cell");
								 //wdwait.until(ExpectedConditions.visibilityOf(lnkDefaultDocument));
								
							
								break;
							}
 
						  } 
						   
					  }
				   
				   public void clickDefaultDocumnetLink()
		           {
					   
					   SeleniumUtils.delay(5000);
		              WebElement frame=driver.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:r61:0:if1::f']"));
		              driver.switchTo().frame(frame);
		              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnkDafaultDocument);
		              this.getScreenDetails("after switching to frame");
		              SeleniumUtils.delay(5000);
		              lnkDafaultDocument.click();
		              SeleniumUtils.delay(5000);
		              this.getScreenDetails("after clicking DafaultDocument link");
		           }
				    
				    
				    public void clickDownloadButton()
				    {
				    	  SeleniumUtils.delay(5000);
			              WebElement frame=driver.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:r61:0:if1::f']"));
			              driver.switchTo().frame(frame);
			              WebElement element = driver.findElement(By.xpath(".//*[@id='pt1:USma:0:MAnt1:0:pt1:panelgrp378']"));
			              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			              this.getScreenDetails("after switching to frame");
				    	SeleniumUtils.delay(5000);
				    	btnDownload.click();
				    	SeleniumUtils.delay(5000);
				    }
				   //lnkDefaultDocument
				   public boolean isDefaultDocumentDisplayed(){
					   return lnkDefaultDocument.isDisplayed();
					   } 
				   
				  /* public void clickDefaultDocumentLink(){	
					   SeleniumUtils.delay(10000);
					   WebElement frame= driver.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:r61:0:if1::f']"));
				    	driver.switchTo().frame(frame);
					   lnkDefaultDocument.click();
					   SeleniumUtils.delay(2000);
				    	// wdwait.until(ExpectedConditions.visibilityOf(selectToEnteredMonth));
				    	report.log(LogStatus.PASS, "Clicked on Default Document link");
				    }*/
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Scheduled Processes page is Loaded Successfully");
	    	 if(btnScheduleNewProcess.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Scheduled Processes Page</span></a>");
		   	return new Item(xyz);
	   }
}
