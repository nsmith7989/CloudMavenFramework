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
public class MyDetailsPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Edit')]")
	private WebElement btnEdit;
	
	//@FindBy(how=How.XPATH, using = "//h1[contains(.,'My Details')]")
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:_FOTr0:0:pt1:sp1:SPph::_afrTtxt']/div/h1")
	private WebElement txtMyDetails;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'panelLabelAndMessage18')]/td[2]")
	private WebElement txtMartialStartus;
	
	@FindBy(how=How.XPATH, using = "//span[contains(@id,'FOTr0:0:pt1:soc1::content')]")
	private WebElement txtBloodType;
	////*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:_FOTr0:0:pt1:soc1::content']

	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:sdi3::icon']")
	private WebElement imgContacts;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:_FOTsdiPER_DOR_INFO::icon']")
	private WebElement imgMyDocuments;
	
	
	
	 public MyDetailsPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtMyDetails));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* MyDetails Page *****************************");
	     this.getScreenDetails();
	 }

	 public boolean isMyDetailsPageDisplayed(){
		 return txtMyDetails.isDisplayed();
	    }
	 
	 public String getMartialStartus()
	 {
	 SeleniumUtils.delay(5000);
		 return txtMartialStartus.getText();
	 }
	 
	 public String getBloodType()
	 {
	 SeleniumUtils.delay(5000);
		 return txtBloodType.getText();
	 }

	 public PersonalInformationPage clickEditButton() throws TestException{
		btnEdit.click();
	    report.log(LogStatus.PASS, "Clicked on Edit button");
	    return new PersonalInformationPage(driver,report);
	 }
	 
	 public MyDetailsContactsPage clickImageContacts() throws TestException{
		imgContacts.click();
	    report.log(LogStatus.PASS, "Clicked on Contacts image");
	    return new MyDetailsContactsPage(driver,report);
	 }
	 
	 
	 public MyDocumentsPage clickMyDocuments() throws TestException
	 {
		 	imgMyDocuments.click();
		    report.log(LogStatus.PASS, "Clicked on My Documents image");
		    return new MyDocumentsPage(driver,report);
	 }
	
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "My Details Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtMyDetails, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryMyDetails", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>MyDetails Page</span></a>");
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
