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

public class CreateBankStatementPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:bankaccountnameId::content')]")
	    private WebElement selectBankAccount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:periodStartDateId::glyph')]")
	    private WebElement btnPeriodStartDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:periodStartDateId::pop::cd::mSel::content')]")
	    private WebElement selectPeriodStartMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:periodStartDateId::pop::cd::cg')]")
	    private WebElement tblePeriodStartDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:periodEndDateId::glyph')]")
	    private WebElement btnPeriodEndDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:periodEndDateId::pop::cd::mSel::content')]")
	    private WebElement selectPeriodEndMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:periodEndDateId::pop::cd::ys::content')]")
	    private WebElement selectPeriodEndYear;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:periodEndDateId::pop::cd::cg')]")
	    private WebElement tblePeriodEndDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:periodEndDateId::content')]")
	    private WebElement txtPeriodEndDt;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:cbsinputText1::content')]")
	    private WebElement txtStatementID;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:bankBalanceAppTable:_ATp:t1:0:balanceAmountId::content')]")
	    private WebElement txtOpeningAmount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:bankBalanceAppTable:_ATp:t1:1:balanceAmountId::content')]")
	    private WebElement txtClosingAmount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:cbsshowDetailItem2::ti')]")
	    private WebElement lnkStatementLines;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'cbsap1:AT1:_ATp:create::icon')]")
	    private WebElement btnCreate_StatLines;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'inputDate1::glyph')]")
	    private WebElement btnBookingDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'inputDate1::pop::cd::mSel::content')]")
	    private WebElement selectBookingMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'inputDate1::pop::cd::cg')]")
	    private WebElement tbleBookingDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'transactioncodedispId::content')]")
	    private WebElement selectTransactionCode;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'soc1::content')]")
	    private WebElement lblTransactionType;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'selectOneChoice3::content')]")
	    private WebElement selectFlowIndicator;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'amountId::content')]")
	    private WebElement txtBnkAccAmount;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:commandButton1')]")
	    private WebElement btnOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:cbscommandButton2')]")
	    private WebElement btnSaveAndClose;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cbsap1:cb5')]")
	    private WebElement btnWarningOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOd1::msgDlg::cancel']")
	    private WebElement btnConfOk;
		 
	 public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	    public CreateBankStatementPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(selectBankAccount));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Create Bank Statement Page *****************************");
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
		   
		// click on Period Start Date button
		      
		   public boolean isPeriodStartDateBtnDisplayed(){
			   return btnPeriodStartDt.isDisplayed();
		    	
		    }
		    public void clickPeriodStartDateButton(){	    	
		    	btnPeriodStartDt.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectPeriodStartMonth));
		    	 report.log(LogStatus.PASS, "Clicked on Period Start Date Button");
		    }
		   
		   // Select Period Start Date Month from Calander
		    public void selectPeriodStartDtMonth(String startMonth){
		    	Select objSelect = new Select(selectPeriodStartMonth);
		    	objSelect.selectByVisibleText(startMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tblePeriodStartDt));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected Period Start Date Month  is: "+startMonth);
		    } 
		   
		   public boolean isPeriodStartDtMonthDisplayed(){
			   return selectPeriodStartMonth.isDisplayed();
			   
		   }
		   
		   // Select Period Start Date
		   public void selectPeriodStartDate(String startDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'cbsap1:periodStartDateId::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(startDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected Period Start Date is "+startDate);
					   break;
					   
				   }
				  } 
				  
			  }
		   
		   //********************************
		// click on Period Start Date button
		      
		   public boolean isPeriodEndDateBtnDisplayed(){
			   return btnPeriodEndDt.isDisplayed();
		    	
		    }
		    public void clickPeriodEndDateButton(){	    	
		    	btnPeriodEndDt.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectPeriodEndMonth));
		    	report.log(LogStatus.PASS, "Clicked on Period End Date Button");
		    }
		   
		   // Select Period Start Date Month from Calander
		    public void selectPeriodEndDtMonth(String endMonth){
		    	Select objSelect = new Select(selectPeriodEndMonth);
		    	objSelect.selectByVisibleText(endMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tblePeriodEndDt));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected Period End Date Month  is: "+endMonth);
		    } 
		   
		   public boolean isPeriodEndDtMonthDisplayed(){
			   return selectPeriodEndMonth.isDisplayed();
			   
		   }
		   
		   // Select Period Start Date
		   public void selectPeriodEndDate(String endDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'cbsap1:periodEndDateId::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(endDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected Period End Date is "+endDate);
					   break;
					   
				   }
				  } 
				   
			  }
		   
		   // Select Year
		   public void selectPeriodEndYear(String endYear)
			{	
			   btnPeriodEndDt.click();
		       wdwait.until(ExpectedConditions.visibilityOf(selectPeriodEndMonth));
			   selectPeriodEndYear.clear();
			   selectPeriodEndYear.click();
			   selectPeriodEndYear.sendKeys(endYear);
				//String strYear = driver.findElement(By.xpath("//*[contains(@id,'cbsap1:periodEndDateId::pop::cd::ys::content')]")).getAttribute("title");  
				//System.out.println("selected year"+strYear);
				  
			  }
		   //txtPeriodEndDt
		   
		   public void enterPeriodEndDate(String strEndDate)
			{	
			   txtPeriodEndDt.clear();
			   txtPeriodEndDt.click();
			   txtPeriodEndDt.sendKeys(strEndDate);
				//String strYear = driver.findElement(By.xpath("//*[contains(@id,'cbsap1:periodEndDateId::pop::cd::ys::content')]")).getAttribute("title");  
				//System.out.println("selected year"+strYear);
				  
			  }
		   
		   //Statement ID
		   
		   public void enterStatementID(String strStatementID){
			   SeleniumUtils.delay(2000);
			   txtStatementID.clear();
			   txtStatementID.click();
			   txtStatementID.sendKeys(strStatementID);
			   //report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
		   }
		   
		   public boolean isDescriptionDisplayed(){
			   return txtStatementID.isDisplayed();
			   }
		   
		   //Opening Amount (USD) field
		   
		   public void enterOpeningAmount(String strOpeningAmount){
			   txtOpeningAmount.clear();
			   txtOpeningAmount.click();
			   txtOpeningAmount.sendKeys(strOpeningAmount);
			   //report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
		   }
		   
		   public boolean isOpeningAmountDisplayed(){
			   return txtOpeningAmount.isDisplayed();
			   }
		   //Closing Amount (USD) field
		   public void enterClosingAmount(String strClosingAmount){
			   txtClosingAmount.clear();
			   txtClosingAmount.click();
			   txtClosingAmount.sendKeys(strClosingAmount);
			   //report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
			   this.getScreenDetails();
		   }
		   
		   public boolean isClosingAmountDisplayed(){
			   return txtClosingAmount.isDisplayed();
			   }
		   //Statement Lines link
		   public boolean isStatementLinesLinkDisplayed(){
			   return lnkStatementLines.isDisplayed();
		    	
		    }
		    public void clickStatementLinesLink(){	    	
		    	lnkStatementLines.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(btnCreate_StatLines));
		    	 this.getScreenDetails();
		    	report.log(LogStatus.PASS, "Clicked on StatementLines link");
		    }

		   //Create button
		    
		    public boolean isCreateStatLinesBtnDisplayed(){
				   return btnCreate_StatLines.isDisplayed();
			    	
			    }
			    public void clickCreateStatLinesButton(){	    	
			    	btnCreate_StatLines.click();
			    	 wdwait.until(ExpectedConditions.visibilityOf(btnBookingDate));
			    	report.log(LogStatus.PASS, "Clicked on Create Button");
			    	this.getScreenDetails();
			    }
			    
			 // click on Booking Date button
			      
				   public boolean isBookingDateBtnDisplayed(){
					   return btnBookingDate.isDisplayed();
				    	
				    }
				    public void clickBookingDateButton(){	    	
				    	btnBookingDate.click();
				    	 wdwait.until(ExpectedConditions.visibilityOf(selectBookingMonth));
				    	//report.log(LogStatus.PASS, "Clicked on FromInvoiceDt Button");
				    }
				   
				   // Select Period Start Date Month from Calander
				    public void selectBookingMonth(String bookingMonth){
				    	Select objSelect = new Select(selectBookingMonth);
				    	objSelect.selectByVisibleText(bookingMonth);
				    	 wdwait.until(ExpectedConditions.visibilityOf(tbleBookingDate));
				    	//SeleniumUtils.delay(5000);
				    	report.log(LogStatus.PASS, "Selected booking Month  is: "+bookingMonth);
				    } 
				   
				   public boolean isBookingMonthDisplayed(){
					   return selectBookingMonth.isDisplayed();
					   
				   }
				   
				   // Select Period Start Date
				   public void selectBookingDate(String bookingDate)
					{
						List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'inputDate1::pop::cd::cg')]//td"));  
						for (WebElement cell:dates)
						  {
							String date=cell.getText();
						   if (date.equalsIgnoreCase(bookingDate))
						   {
						     cell.click();
							   SeleniumUtils.delay(2000);
							   report.log(LogStatus.PASS, "Selected date is "+bookingDate);
							   break;
							   
						   }
						  } 
						  
					  } 
				   
			   // Transaction Code
				   
				   public void SelectTransactionCode(String strTransCode) throws InterruptedException{
					   this.getScreenDetails();
					   selectTransactionCode.click();
					   selectTransactionCode.sendKeys(strTransCode);
					  // txtMajor.sendKeys(Keys.ARROW_DOWN);
					   selectTransactionCode.sendKeys(Keys.ENTER);
					  // wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
				    	//SeleniumUtils.delay(3000);
					   wdwait.until(ExpectedConditions.visibilityOf(lblTransactionType));
				   }
				   
				   public boolean isTransactionCodeDisplayed(){
					   return selectTransactionCode.isDisplayed();
					   } 
				// Flow Indicator
				   public void selectFlowIndicator(String bookingMonth){
				    	Select objSelect = new Select(selectFlowIndicator);
				    	objSelect.selectByVisibleText(bookingMonth);
				    	//report.log(LogStatus.PASS, "Selected Flow Indicator  is: "+bookingMonth);
				    } 
				   
				   public boolean isFlowIndicatorDisplayed(){
					   return selectFlowIndicator.isDisplayed();
					   
				   }
				   
			 //Amount field
				   
				   public void enterAmount(String strAmount){
					   txtBnkAccAmount.clear();
					   txtBnkAccAmount.click();
					   txtBnkAccAmount.sendKeys(strAmount);
					   //report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
					   this.getScreenDetails();
				   }
				   
				   public boolean isAmountDisplayed(){
					   return txtClosingAmount.isDisplayed();
					   
					   }
				   
			// Ok Button
				   public boolean isOkButtonDisplayed(){
					   return btnOk.isDisplayed();  	
				   }  
			   
				   public void clickOkButton(){
					   btnOk.click();
					   wdwait.until(ExpectedConditions.visibilityOf(btnSaveAndClose));
					   report.log(LogStatus.PASS, "Clicked on Ok Button"); 
				   } 
				   
			// Save and Close Button
				   public boolean isSaveAndCloseButtonDisplayed(){
					   return btnSaveAndClose.isDisplayed();  	
				   }  
			   
				   public void clickSaveAndCloseButton(){
					   btnSaveAndClose.click();
					   wdwait.until(ExpectedConditions.visibilityOf(btnWarningOk));
					   report.log(LogStatus.PASS, "Clicked on Save and Close Button"); 
					   this.getScreenDetails("Warning Pop-up");
				   }  
				   
		   // Warning Ok Button
				   public boolean isWarningOkBtnDisplayed(){
					   return btnWarningOk.isDisplayed();  	
				   }  
			   
				   public void clickWarningOkButton(){
					   btnWarningOk.click();
					   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
					   report.log(LogStatus.PASS, "Clicked on Warning Ok Button");
					   this.getScreenDetails("Confirmation Pop-up");
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
			
			 report.log(LogStatus.PASS, "Create Bank Statement page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Bank Statement Page</span></a>");
		   	return new Item(xyz);
	   }


}
