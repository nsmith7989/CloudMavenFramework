package com.cloud.pageobjects.HCM;

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

/**
 * Contains object properties and methods for MyDetails Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class PersonalInformationPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:APscl2']/a")
	private WebElement btnSaveAndClose;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:SP1:SPc')]")
	private WebElement btnCancel;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Edit My Details: Contact Information')]")
	private WebElement txtContactInformation;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r1:0:r1:0:i5:0:cil1::icon']")
	private WebElement iconEdit;
	
	//@FindBy(how=How.XPATH, using = " //input[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r1:0:r1:0:i5:1:ei3:0:einputText17::content']")
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'1:ei3:0:einputText17::content')]")
	private WebElement txtAddressLine1;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'INFO:0:MAnt2:1:SP1:r4:1:i4:0:i7:0:soc4::content')]")
	//@FindBy(how=How.XPATH, using = "//select[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r4:1:i4:0:i7:0:soc4::content']")
	private WebElement selectMartialStatus;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'INFO:0:MAnt2:1:SP1:r4:1:socBloodType::content')]")
	private WebElement selectBloodType;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,'INFO:0:MAnt2:1:SP1:r1:0:cb2::popEl')]")
	private WebElement listNewContacts;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:SP1:sdi2::icon')]")
	private WebElement imgBioGraphicalInformation;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'INFO:0:MAnt2:1:SP1:r1:0:a1:1:phoneType1::content')]")
	private WebElement selectPhoneType;

	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r1:0:pgl18']")
	private WebElement tableContacts;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:SP1:r1:0:a1:1:countryNameId::lovIconId')]")
	private WebElement selectCountryCode;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'it1::content')]")
	private WebElement txtPhoneNumber;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'countryNameId::dropdownPopup::popupsearch')]")
	private WebElement lnkSearch;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value10::content')]")
	private WebElement txtCountry;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'countryNameId_afrLovInternalTableId')]")
	private WebElement countryTable;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'countryNameId::lovDialogId::ok')]")
	private WebElement btnOK;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'it3::content')]")
	private WebElement txtAreaCode;
	
	private List<WebElement> rowcount;
	private List<WebElement> colcount;
	
	 public PersonalInformationPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtContactInformation));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* PersonalInformation Page *****************************");
	     this.getScreenDetails();
	 }
	 
	 
	 @SuppressWarnings("unchecked")
		public void selectWebtableElement(String strCountry)
		{	
			rowcount=(List<WebElement>) countryTable.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=1;row<=rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,'countryNameId_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
			
				if(actualText.contains(strCountry))
				{
					System.out.println("found proper country name");
					report.log(LogStatus.INFO, "Selected Person Name is "+strCountry);
					//driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:1:r1:0:pt1:r4:0:ls1:AT1::db']/table/tbody/tr["+row+"]/td[2]")).click();
					cellNametext.click();
					SeleniumUtils.delay(5000);
					btnOK.click();
					SeleniumUtils.delay(5000);
					this.getScreenDetails();
					break;
				}
			}
		}		
		
	 
	
		public void selectPhoneType(String strPhoneType)
		{	
						
		/*	List<WebElement> parentdiv=driver.findElements(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r1:0:pgl10']/div"));
			WebElement parenttabletag=parentdiv.get(0).findElement(By.xpath("//table/tbody/tr"));
			List<WebElement> parenttabletdtag=parenttabletag.findElements(By.tagName("td"));
			WebElement tabletdspan=parenttabletdtag.get(1).findElement(By.xpath("//table/tbody/tr/td/span"));*/
			WebElement tabletdspan= driver.findElement(By.xpath("//span[@class='xtu x1z']"));
			WebElement selectPhoneType=tabletdspan.findElement(By.xpath("//select"));
			Select sel=new Select(selectPhoneType);
			sel.selectByVisibleText(strPhoneType);
			SeleniumUtils.delay(2000);
		}		
	
		 public void clickCountryCode()
		 {
				/*List<WebElement> parentdiv=driver.findElements(By.xpath("//div[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r1:0:pgl10']/div"));
				WebElement parenttabletag=parentdiv.get(0).findElement(By.xpath("//table/tbody/tr"));
				List<WebElement> parenttabletdtag=parenttabletag.findElements(By.tagName("td"));
				List<WebElement> childtabletdtag=parenttabletdtag.get(2).findElements(By.xpath("//table/tbody/tr/td"));
				WebElement anchortag=childtabletdtag.get(0).findElement(By.xpath("//span/span/span/span"));
				anchortag.click();
				SeleniumUtils.delay(5000);*/
			 //	WebElement countryCodeLink=driver.findElement(By.xpath("//a[@class='x1lx']"));
			 WebElement countryCodeLink=driver.findElement(By.xpath("//*[@class='x1pu']"));
			 	
			 countryCodeLink.click();
				SeleniumUtils.delay(5000);
			
		 }
		
		public void selectCountryCode(String strCountryCode)
		{	
						
			WebElement countryCodeInput=driver.findElement(By.xpath("//input[@class='xv6']"));
			countryCodeInput.sendKeys(strCountryCode);
			countryCodeInput.sendKeys(Keys.TAB);
			SeleniumUtils.delay(5000);
		}		
		
		
	 
	 public void selectNewContactsList(String strType)
	 {
		 listNewContacts.click();
		 SeleniumUtils.delay(3000);
		 
		 if(strType.equalsIgnoreCase("Phone"))
		 {
			driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r1:0:cb3']/td[2]")).click();
		 }
		 else if(strType.equalsIgnoreCase("E-Mail"))
		 {
			driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r1:0:cb4']/td[2]")).click();
		 }
		 else if(strType.equalsIgnoreCase("Other Communication Accounts"))
		 {
			driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAnt2:1:SP1:r1:0:cb5']/td[2]")).click();
		 }
		 else
		 {
			 report.log(LogStatus.FAIL, "Invalid choice...try with new value");
		 }
		 SeleniumUtils.delay(5000);
	 }
	 

	 public void enterPhoneNumber(String strPhoneNumber)
	 {
		 txtPhoneNumber.sendKeys(strPhoneNumber);
		 SeleniumUtils.delay(5000);
	 }
	 
	 	 
	 public void enterAreaCode(String strAreaCode)
	 {
		 txtAreaCode.sendKeys(strAreaCode);
		 SeleniumUtils.delay(5000);
	 }
	 
	 public void enterCountry(String strCountry)
	 {
		 txtCountry.sendKeys(strCountry);
		 SeleniumUtils.delay(2000);
	 }
	 
/*	 public void selectType(String strType)
	 {
	    	report.log(LogStatus.PASS, "Select any Phone Type from Type dropdown");
	    	
	    	Select objSelect = new Select();
	    	objSelect.selectByVisibleText(strType);
	    	SeleniumUtils.delay(2000);
	 }*/
	 
	 
	 public void selectCountryCode1(String strCountryCode)
	 {
	    	report.log(LogStatus.PASS, "Select any CountryCode Type from CountryCode dropdown");
	    	Select objSelect = new Select(selectCountryCode);
	    	objSelect.selectByVisibleText(strCountryCode);
	    	SeleniumUtils.delay(2000);
	 }
	 
	 public void clickSearchLink()
	 {
		 lnkSearch.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails();
	 }
	 
	 public void clickSearchButton()
	 {
		 btnSearch.click();
		 SeleniumUtils.delay(5000);
	 }
	 
	 
	 public boolean isPersonalInformationePageDisplayed(){
		 report.log(LogStatus.PASS, "Personal InformationePage is Displayed");
		 return txtContactInformation.isDisplayed();
		}
	 
	 public void clickBGInformation() throws TestException{
		 	imgBioGraphicalInformation.click();
		 	SeleniumUtils.delay(5000);
		    report.log(LogStatus.PASS, "Clicked on BioGraphicalInformation image");
		  }
	
	 
	 public void setAddressLine1(String AddressLine1)
	 {
		 txtAddressLine1.clear();
		 txtAddressLine1.sendKeys(AddressLine1);
		 report.log(LogStatus.PASS, "Entered address is: "+AddressLine1);
		
	 }
	
	 public void clickSaveAndCloseButton(){
		 btnSaveAndClose.click();
		 SeleniumUtils.delay(8000);
		 this.getScreenDetails();
	     report.log(LogStatus.PASS, "Clicked on Save and Close button");
	 }
	 
	 public void selectMartialStatus(String strMartialStaus){
	    	report.log(LogStatus.PASS, "Select any MartialStatus from MartialStatus dropdown");
	    	Select objSelect = new Select(selectMartialStatus);
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].scrollIntoView();", selectMartialStatus);
	    	objSelect.selectByVisibleText(strMartialStaus);
	    	SeleniumUtils.delay(5000);
	    }
	 
	 public void selectBloodType(String strBloodType){
	    	report.log(LogStatus.PASS, "Select any blood group from Blood TYpe dropdown");
	    	Select objSelect = new Select(selectBloodType);
	    	//JavascriptExecutor js=(JavascriptExecutor)driver;
	    	//js.executeScript("arguments[0].scrollIntoView();", selectBloodType);
	    	objSelect.selectByVisibleText(strBloodType);
	    	SeleniumUtils.delay(5000);
	    }
	 
	 public void clickCancelButton(){
		 btnCancel.click();
		 SeleniumUtils.delay(10000);
		 report.log(LogStatus.PASS, "Clicked on Cancel button and waiting to enter Yes button on confirmation dialog");
		 driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAyes']")).click();
	
		 SeleniumUtils.delay(5000);
/*		 Alert alert=driver.switchTo().alert();
		 alert.accept();*/
//		 String parentwindow=driver.getWindowHandle();
//		 String alertText=alert.getText();
		
//		 if(alertText.equalsIgnoreCase("You have not saved your changes. If you close this flow, then your changes will be lost. Do you want to continue?"))
//		 {
//	
//			 driver.findElement(By.xpath(".//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:MAyes']")).click();
//		 }
/*		 Set<String> childwindows=driver.getWindowHandles();
		 System.out.println(childwindows.size());
		 System.out.println(childwindows.toString());
		 for(String e:childwindows)
		 {
			 System.out.println("Window is "+e.toString());
			 if(!parentwindow.equalsIgnoreCase(e))
			 {
//				 driver.switchTo().window(e);
//				 driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
			 }
		 }*/
		 
		
	 }
	 
	 
	 public void clickIconEdit(){
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", iconEdit);
		//iconEdit.click();
		wdwait.until(ExpectedConditions.visibilityOf(txtAddressLine1));
	    report.log(LogStatus.PASS, "Clicked on Edit Pencil Icon ");
	 }
	
 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "Edit My Details Personal Information Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtContactInformation, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryPersonalInformation", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>PersonalInformation Page</span></a>");
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
