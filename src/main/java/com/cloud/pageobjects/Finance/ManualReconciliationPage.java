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

public class ManualReconciliationPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrbankAccountNameId::content')]")
	    private WebElement selectBankAccount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrfromDate::glyph')]")
	    private WebElement btnFromDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrfromDate::pop::cd::mSel::content')]")
	    private WebElement selectFromMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrfromDate::pop::cd::cg')]")
	    private WebElement tbleFromDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrtoDate::glyph')]")
	    private WebElement btnToDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrtoDate::pop::cd::mSel::content')]")
	    private WebElement selectToMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrtoDate::pop::cd::cg')]")
	    private WebElement tbleToDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrsearchBtn')]")
	    private WebElement btnSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrstmtResultTable:_ATp:t1::db')]/table//tr[1]//td[1]")
	    private WebElement tbleTransection;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:mrreconBtn')]")
	    private WebElement btnReconcile;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mrpanel1:cb1')]")
	    private WebElement btnDone;
	  	 
	 public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	    public ManualReconciliationPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(selectBankAccount));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Overview Page *****************************");
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
		   
		// click on From  Date button
		      
		   public boolean isFromDateBtnDisplayed(){
			   return btnFromDate.isDisplayed();
		    	
		    }
		    public void clickFromDateButton(){	    	
		    	btnFromDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromMonth));
		    	report.log(LogStatus.PASS, "Clicked on From  Date Button");
		    }
		   
		   // Select From Statement End Month from Calander
		    public void selectFromDtMonth(String fromMonth){
		    	Select objSelect = new Select(selectFromMonth);
		    	objSelect.selectByVisibleText(fromMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tbleFromDate));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected From Date Month  is: "+fromMonth);
		    } 
		   
		   public boolean isFromStatementEndDtMonthDisplayed(){
			   return selectFromMonth.isDisplayed();
			   
		   }
		   
		// Select From  End Date
		   public void selectFromDate(String fromDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'mrpanel1:mrtoDate::glyph')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(fromDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Date is "+fromDate);
					   break;
					   
				   }
				  } 
				   
			  }
	    
		// click on To Date button
		      
		   public boolean isToDateBtnDisplayed(){
			   return btnToDate.isDisplayed();
		    	
		    }
		    public void clickToDateButton(){	    	
		    	btnToDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectToMonth));
		    	report.log(LogStatus.PASS, "Clicked on To Date Button");
		    }
		   
		   // Select To Month from Calander
		    public void selectToDateMonth(String toMonth){
		    	Select objSelect = new Select(selectFromMonth);
		    	objSelect.selectByVisibleText(toMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tbleToDate));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected From Date Month  is: "+toMonth);
		    } 
		   
		   public boolean isToDateMonthDisplayed(){
			   return selectToMonth.isDisplayed();
			   
		   }
		   
		// Select To Date
		   public void selectToDate(String toDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'mrpanel1:mrtoDate::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(toDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Date is "+toDate);
					   break;
					   
				   }
				  } 
				   
			  }
		   
		   // Click on Search Button
		   public boolean isSearchBtnDisplayed(){
			   return btnSearch.isDisplayed();
		    	
		    }
		    public void clickSearchButton(){	    	
		    	btnSearch.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(tbleTransection));
		    	 //SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Clicked on Search Button");
		    	this.getScreenDetails();
		    }
		    
		    // Select Bank Statement Line
		    
		    public void selectBankStatementLine()
			{
		    	List<WebElement> StatementRows = driver.findElements(By.xpath("//*[contains(@id,'mrpanel1:mrstmtResultTable:_ATp:t1::db')]/table//td[1]"));
		    	//System.out.println("Statement Rows are"+StatementRows.size());
				List<WebElement> StatementCols = driver.findElements(By.xpath("//*[contains(@id,'mrpanel1:mrstmtResultTable:_ATp:t1::db')]/table//td"));
				//System.out.println("StatementColomns are"+StatementCols.size());
				
				List<WebElement> TransactionsRows = driver.findElements(By.xpath("//*[contains(@id,'mrpanel1:mrapplicationsTable2:_ATp:t2::db')]/table//td[1]"));
				System.out.println("Transactions Rows are"+TransactionsRows.size());
				
				//for (WebElement StatementCell:StatementCols)
				int r;
				for (r=1;r<=StatementRows.size();r++)
				  {
					 String StatementDate = driver.findElement(By.xpath("//*[contains(@id,'mrpanel1:mrstmtResultTable:_ATp:t1::db')]/table//tr["+r+"]//td[3]")).getText();
					// System.out.println("Data is"+StatementDate);
					 String StatementAmount = driver.findElement(By.xpath("//*[contains(@id,'mrpanel1:mrstmtResultTable:_ATp:t1::db')]/table//tr["+r+"]//td[4]")).getText();
					// System.out.println("Amount is"+StatementAmount);
					 int i=r-1;
					 WebElement StatementCheckBox =driver.findElement(By.xpath("//*[contains(@id,'mrpanel1:mrstmtResultTable:_ATp:t1:"+i+":mrstmtCheckBox::content')]"));
					 StatementCheckBox.click();
					 
					 int j;
					 for(j=1;j<=TransactionsRows.size();j++) {
						 String TransactionsDate = driver.findElement(By.xpath("//*[contains(@id,'mrpanel1:mrapplicationsTable2:_ATp:t2::db')]/table//tr["+j+"]//td[3]")).getText();
						// System.out.println("Data is"+StatementDate);
						 String TransactionsAmount = driver.findElement(By.xpath("//*[contains(@id,'mrpanel1:mrapplicationsTable2:_ATp:t2::db')]/table//tr["+j+"]//td[4]")).getText();
						 //System.out.println("Amount is"+StatementAmount);
						 
						 if(StatementDate.equalsIgnoreCase(TransactionsDate)&&StatementAmount.equalsIgnoreCase(TransactionsAmount)){
							 int k=j-1;
							 WebElement TransactionsCheckBox =driver.findElement(By.xpath("//*[contains(@id,'mrpanel1:mrapplicationsTable2:_ATp:t2:"+k+":mrtrxCheckBox::content')]"));
							 TransactionsCheckBox.click();
							 report.log(LogStatus.PASS, "Selected Bank Statement Lines and System Transactions Date and Amount is "+TransactionsDate+" "+TransactionsAmount);
							 break;
						 }
						 
					 }
					
				  } 
				   
			  }
		  
		 // Click on Search Button
			   public boolean isReconcileBtnDisplayed(){
				   return btnReconcile.isDisplayed();
			    	
			    }
			    public void clickReconcileButton(){	
			    	if(btnReconcile.isEnabled()) {
			    		btnReconcile.click();
			    		SeleniumUtils.delay(2000);
					    report.log(LogStatus.PASS, "Clicked on Reconcile Button");
					    this.getScreenDetails();
			    	}else {
			    		report.log(LogStatus.FAIL, "Reconcile Button is in disabled State");
			    		this.getScreenDetails();
			    	}
			    		
			    }
			    
		    // Click on Done
		   
			    public boolean isdoneBtnDisplayed(){
					   return btnDone.isDisplayed();
				    	
				    }
			    
				    public void clickDoneButton(){	    	
				    	btnDone.click();
				    	SeleniumUtils.delay(2000);
				    	report.log(LogStatus.PASS, "Clicked on done Button");
				    	
				    } 
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Overview page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Overview Page</span></a>");
		   	return new Item(xyz);
	   }


}
