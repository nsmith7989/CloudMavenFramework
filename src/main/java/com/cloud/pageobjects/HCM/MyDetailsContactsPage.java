package com.cloud.pageobjects.HCM;

import org.openqa.selenium.By;
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

/**
 * Contains object properties and methods for MyDetails Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class MyDetailsContactsPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Edit')]")
	private WebElement btnEdit;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:APscl2']/a")
	private WebElement btnSaveAndClose;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Contacts')]")
	private WebElement txtMyDetailsContacts;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r2:1:t1:cb3::icon']")
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:SP1:r2:1:t1:cb3::icon')]")
	private WebElement btnNewContacts;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:SP1:r2:1:t1:selectBooleanRadio1::content')]")
	private WebElement selectAddNewPerson;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:SP1:r2:1:t1:sbr2::content')]")
	private WebElement selectExistingPerson;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:SP1:r2:1:t1:commandButton3')]")
	private WebElement btnContinue;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'INFO:0:MAnt2:1:SP1:r2:1:id1::content')]")
	private WebElement txtStartDate;
	
	@FindBy(how=How.XPATH, using = "//input[@type='checkbox']")
	private WebElement checkEmergencyContact;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'INFO:0:MAnt2:1:SP1:r2:1:r1:0:i1:0:it20::content')]")
	private WebElement txtLastName;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@name,'INFO:0:MAnt2:1:SP1:r2:1:r1:0:i1:1:it60')]")
	private WebElement txtFirstName;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@name,'INFO:0:MAnt2:1:SP1:r2:1:soc3')]")
	private WebElement selectRelationship;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@name,'INFO:0:MAnt2:1:SP1:r2:1:r1:0:i1:2:selectOneChoice4')]")
	private WebElement selectTitle;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'INFO:0:MAnt2:1:SP1:r2:1:idtest1::content')]")
	private WebElement txtDateOfBirth;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r2:1:cb1::icon']")
	//.//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r2:1:cb1::icon']
	private WebElement btnNewPhoneNumber;
	
	//@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r2:1:t2:1:soc4::content']")
	@FindBy(how=How.XPATH, using = "//select[contains(@id,':soc4::content')]")
	private WebElement selectPhoneType;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@name,'INFO:0:MAnt2:1:SP1:r2:1:t2:1:countryId')]")
	private WebElement selectCountryCode;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'INFO:0:MAnt2:1:SP1:r2:1:soctest::content')]")
	private WebElement selectGender;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':it6::content')]")
	//input[contains(@id,'INFO:0:MAnt2:1:SP1:r2:1:t2:1:it6::content')]
	private WebElement txtPhoneNumber;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOd1::msgDlg::_cnt']/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/div")
	private WebElement errorRelationship;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOd1::msgDlg::_cnt']/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/div")
	private WebElement errorLastname;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOd1::msgDlg::_cnt']/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/div")
	private WebElement errorType;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOd1::msgDlg::_cnt']/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/div")
	private WebElement errorNumber;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r2:1:idtest1::1524153195793']/tbody/tr/td/div/div[1]/div/div/table/tbody/tr[1]/td[2]")
	private WebElement errorDOB;
	
	
	
	
	 public MyDetailsContactsPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 30);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtMyDetailsContacts));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* MyDetails Contacts Page *****************************");
	     this.getScreenDetails();
	 }

	 public boolean isMyDetailsPageDisplayed(){
	    	return txtMyDetailsContacts.isDisplayed();
	    }
	 
	 public void clickNewContactsButton()
	 {
		 btnNewContacts.click();
		 SeleniumUtils.delay(5000);
	 }
	 
	 public void checkEmergencyContact(String EmergencyContact)
	 {
		 if(EmergencyContact.equalsIgnoreCase("YES"))
		 {
		 checkEmergencyContact.click();
		 }
	 }
	
	 public void enterLastName(String strLastName)
	 {
		 txtLastName.sendKeys(strLastName);
	 }
	 
	 public void enterFirstName(String strFirstName)
	 {
		 txtFirstName.sendKeys(strFirstName);
	 }
	 
	 public void enterPhoneNumber(String strPhoneNumber)
	 {
		 txtPhoneNumber.sendKeys(strPhoneNumber);
		 SeleniumUtils.delay(5000);
	 }
	 
	 public void selectRelationship(String strRelationship){
	    	report.log(LogStatus.PASS, "Select any relationship from Relationship dropdown");
	    	Select objSelect = new Select(selectRelationship);
	    	objSelect.selectByVisibleText(strRelationship);
	    	SeleniumUtils.delay(2000);
	    }
	 
	 public void selectTitle(String strTitle){
	    	report.log(LogStatus.PASS, "Select any Title from Title dropdown");
	    	Select objSelect = new Select(selectTitle);
	    	objSelect.selectByVisibleText(strTitle);
	    	SeleniumUtils.delay(2000);
	    }
	 
	 
	 public void selectGender(String strGender)
	 {
	    	report.log(LogStatus.PASS, "Select any Gender from Gender dropdown");
	    	Select objSelect = new Select(selectGender);
	    	objSelect.selectByVisibleText(strGender);
	    	SeleniumUtils.delay(2000);
	 }
	 
	 public void selectType(String strType)
	 {
	    	report.log(LogStatus.PASS, "Select any Phone Type from Type dropdown");
	    	Select objSelect = new Select(selectPhoneType);
	    	objSelect.selectByVisibleText(strType);
	    	SeleniumUtils.delay(2000);
	 }
	 
	 public void selectCountryCode(String strCountryCode)
	 {
	    	report.log(LogStatus.PASS, "Select any CountryCode Type from CountryCode dropdown");
	    	Select objSelect = new Select(selectCountryCode);
	    	objSelect.selectByVisibleText(strCountryCode);
	    	SeleniumUtils.delay(2000);
	 }
	 
	 public void enterDateOfBirth(String strDateOfBirth)
	 {
		 txtDateOfBirth.sendKeys(strDateOfBirth);
		 SeleniumUtils.delay(2000);
		/* if(errorDOB.isDisplayed())
		 {
			 report.log(LogStatus.FAIL, "Enter valid date");
			 txtDateOfBirth.clear();
			 txtDateOfBirth.sendKeys(strDateOfBirth);
			 SeleniumUtils.delay(2000);
		 }
		 else
		 {
			 report.log(LogStatus.PASS, "Entered proper date");
		 }*/
		 
	 }
	 
	 public void selectNewPerson()
	 {
		 selectAddNewPerson.click();
		 SeleniumUtils.delay(3000);
		 btnContinue.click();
		 SeleniumUtils.delay(5000);
	 }
	 
	 public void clickSaveAndCloseButton(){
		 
		 if(errorRelationship.isDisplayed() || errorLastname.isDisplayed() || errorNumber.isDisplayed() || errorType.isDisplayed())
		 {
			driver.findElement(By.xpath("//*[@id='_FOd1::msgDlg::cancel']")).click();
			report.log(LogStatus.INFO, "Error Step. Enter proper data and click on save button");
		 }
		 else
		 {
			 btnSaveAndClose.click();
			 SeleniumUtils.delay(5000);
		 }
		 
	     report.log(LogStatus.PASS, "Clicked on Save and Close button");
	 }
	 
	 public void selectExistingPerson()
	 {
		 selectExistingPerson.click();
		 btnContinue.click();
		 SeleniumUtils.delay(5000);
	 }

	 public void clickNewPhoneNumber()
	 {
		 btnNewPhoneNumber.click();
		 SeleniumUtils.delay(5000);
	 }
	 
	
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "My Details Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtMyDetailsContacts, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryContacts", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>MyDetails Contacts Page</span></a>");
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
