package com.cloud.pageobjects.HCM;

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

/**
 * Contains object properties and methods for MyDetails Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class ApproveOrRejectPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//*[@id='ctb1']/a")
	private WebElement btnApprove;
	
	@FindBy(how=How.XPATH, using = "//*[@id='ctb2']/a")
	private WebElement btnReject;
	
		
	 public ApproveOrRejectPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(btnApprove));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Approve Or RejectPage Page *****************************");
	     this.getScreenDetails();
	 }

	 public void clickApproveButton()
	 {
		 btnApprove.click();
		 SeleniumUtils.delay(5000);
	 }
	 
	 public void clickRejectButton()
	 {
		 btnReject.click();
		 SeleniumUtils.delay(5000);
	 }
	
	
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "My Details Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, btnApprove, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "ApproveOrRejectPageDetails", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Approve OR Reject Page</span></a>");
	    	return new Item(xyz);
	    }
	  public Item getScreenDetails(String strTitle){
		   	String xyz = Screenshot.takeScreenshotX(driver, strTitle, context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>"+strTitle+"</span></a>");
		   	return new Item(xyz);
	   }
	  
}
