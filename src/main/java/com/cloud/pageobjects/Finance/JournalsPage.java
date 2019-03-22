package com.cloud.pageobjects.Finance;

import org.openqa.selenium.JavascriptExecutor;
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

public class JournalsPage extends BasePageObject {
	 
		public WebDriver driver;
		
		 @FindBy(how=How.XPATH, using = "//*[contains(@id,'general_accounting_journals:0:_FOTsr1:0:ap1:APph::_afrTtxt')]/div/h1")
		    private WebElement pageJournals;

		
	    @FindBy(how=How.XPATH, using = "//img[contains(@id,'itemNode_FndTasksList::icon')]")
	    //@FindBy(how=How.XPATH, using = "//img[contains(@id,'_FndTasksList::icon')]")
	    private WebElement btnTasks;
	    
	    
	    @FindBy(how=How.XPATH, using = "//a[contains(@id,'journals:0:_FOTRaT:0:RAtl2')]")
	    private WebElement lnkCreateJournal;
	    
	    @FindBy(how=How.XPATH,using="//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:_FOTRaT:0:RAtl1']")
		private WebElement lnkManageJournals;
	    
	    public WebDriverWait wdwait; 
	    
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public JournalsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(btnTasks));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Journal Page *****************************");
		       this.getScreenDetails();
		    }
    
	    public void clickTasksButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnTasks);
	    	//btnTasks.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkCreateJournal));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	    
	    public CreateJournalPage clickCreateJournalLink()throws TestException{
	    	lnkCreateJournal.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Journal Link");
	    	return new CreateJournalPage(driver,report);
	    }
	    
	    public ManageJournalsPage clickManageJournalLink()throws TestException{
	    	lnkManageJournals.click();
	    	report.log(LogStatus.PASS, "Clicked on Manage Journals Link");
	    	return new ManageJournalsPage(driver,report);
	    }
	    
	   
	    public boolean isTasksBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnTasks, context.getReactTimeout());
	    	
	    }
	    
	    public boolean isCreateJournalLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkCreateJournal, context.getReactTimeout());
	    }

	    public boolean isManageJournalLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkManageJournals, context.getReactTimeout());
	    }
	    
		@Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Journal page is Loaded Successfully");
	    	 if(btnTasks.isDisplayed())
	    	 {
	    		 return true;
	    		 
	    	 } else {
	    		 return false;
	    	 }     	
		}
	    
		public Item getScreenDetails(){
		   	String xyz = Screenshot.takeScreenshotX(driver, "EntryLogin", context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Journal Page</span></a>");
		   	return new Item(xyz);
	   }
	  
	}
