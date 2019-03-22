package com.cloud.pageobjects.HCM;


import java.util.List;

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
 * Contains object properties and methods for SearchProfilesPage Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class SearchProfilesPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Profiles')]")
	private WebElement txtProfiles;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Manage Educational Establishments')]")
	private WebElement txtManEduEst;
	
	@FindBy(how=How.XPATH, using = "//*[contains(.,'Create ')]")
	private WebElement txtAfterCreateButtonClick;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:cil1::icon']")
	private WebElement searchIcon;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:MAnt2:1:AP1:SPb']")
	private WebElement btnDone;
	
	@FindBy(xpath = "//button[contains(.,'Save and Close')]")
	private WebElement btnSaveAndClose;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:_FOTsdi__ProfileHome_itemNode__FndTasksList::icon']")
	private WebElement btnTasks;
	
	//@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:MAnt2:1:AP1:findByContentItemQueryResultId:_ATp:createButton']")
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:MAnt2:1:AP1:findByContentItemQueryResultId:_ATp:createButton']|//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:MAnt2:1:AP1:fat1:_ATp:newCT::icon']|//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:MAnt2:1:AP1:AT1:_ATp:ctb1']")
	private WebElement btnCreate;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:_FOTRaT:0:RAtl6']")
	private WebElement lnkManageContentItems;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:_FOTRaT:0:RAtl4']")
	private WebElement lnkManageContentType;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_profiles:0:_FOTRaT:0:RAtl2']")
	private WebElement lnkManageEduEst;
	
	@FindBy(xpath = "//select[contains(@name,'profiles:0:MAnt2:1:AP1:findByContentItemQueryResultId:soc1')]")
	private WebElement selectName;
	
	@FindBy(xpath = "//input[contains(@name,'profiles:0:MAnt2:1:AP1:findByContentItemQueryResultId:ciName')]")
	private WebElement textContentItem;
	
	@FindBy(xpath = "//input[contains(@name,'profiles:0:MAnt2:2:AP1:inputText3')]")
	private WebElement textItemCode;
	
	@FindBy(xpath = "//button[contains(.,'Continue')]")
	private WebElement btnContinue;
	
	@FindBy(xpath = "//input[contains(@name,'profiles:0:MAnt2:2:AP2:inputText1')]")
	private WebElement textContextName;
	
	@FindBy(xpath = "//input[contains(@name,'profiles:0:MAnt2:2:AP2:inputText2')]")
	private WebElement textName;
	
	@FindBy(xpath = "//textarea[contains(@name,'profiles:0:MAnt2:2:AP2:inputText3')]")
	private WebElement textDescription;
	
	@FindBy(xpath = "//input[contains(@name,'profiles:0:MAnt2:2:AP1:inputText4')]")
	private WebElement textCode;
	
	@FindBy(xpath = "//input[contains(@name,'profiles:0:MAnt2:2:AP1:inputText1')]")
	private WebElement textEduEstName;
	
	@FindBy(xpath = "//input[contains(@name,'profiles:0:MAnt2:2:AP1:inputText2')]")
	private WebElement textEDuEstDescription;
	
	@FindBy(xpath = "//select[contains(@name,'profiles:0:MAnt2:2:AP1:CountryId')]")
	private WebElement selectCountry;
	
	@FindBy(xpath = "//select[contains(@name,'profiles:0:MAnt2:2:AP1:selectOneChoice1')]")
	private WebElement selectStateOfProv;
	
	
	 public SearchProfilesPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtProfiles));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Profiles Page *****************************");
	     this.getScreenDetails();
	 }

	 public boolean isDirectoryPageDisplayed(){
		 report.log(LogStatus.PASS, "Directory page is Displayed");
		 return txtProfiles.isDisplayed();
		}
	 
	  
	 public void setContentItem(String strContentItem)
	 {
		 textContentItem.click();
		 textContentItem.sendKeys(strContentItem);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Content Item is: "+strContentItem);
	 }
	
	 
	 public void setItemCode(String strItemCode)
	 {
		 textItemCode.click();
		 textItemCode.sendKeys(strItemCode);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Item Code is: "+strItemCode);
	 }
	 
	 
	 public void setContextName(String strContextName)
	 {
		 textContextName.click();
		 textContextName.sendKeys(strContextName);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Context Name is: "+strContextName);
	 }
	 
	 
	 public void setDescription(String strDescription)
	 {
		 textDescription.click();
		 textDescription.sendKeys(strDescription);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
	 }
	 
	 
	 public void setEDuEstDescription(String strDescription)
	 {
		 textEDuEstDescription.click();
		 textEDuEstDescription.sendKeys(strDescription);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
	 }
	 
	 public void setCode(String strCode)
	 {
		 textCode.click();
		 textCode.sendKeys(strCode);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Code is: "+strCode);
	 }
	 
	 public void setName(String strName)
	 {
		 textName.click();
		 textName.sendKeys(strName);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Name is: "+strName);
	 }
	 
	 
	 public void setEducEstName(String strName)
	 {
		 textEduEstName.click();
		 textEduEstName.sendKeys(strName);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Name is: "+strName);
	 }
	 
	 public void clickSearchIcon()
	 {
		 searchIcon.click();
		 SeleniumUtils.delay(5000);
	 }
	
	 public void clickDoneButton()
	 {
		 btnDone.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("After Done button Click");
	 }
	 
	 
	 public void clickSaveAndCloseButton()
	 {
		 btnSaveAndClose.click();
		 wdwait.until(ExpectedConditions.visibilityOf(btnDone));
		 this.getScreenDetails("After Save and Close button Click");
		 
	 }
	 
	 public void clickCreateButton()
	 {
		 btnCreate.click();
		 wdwait.until(ExpectedConditions.visibilityOf(txtAfterCreateButtonClick));
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("After Create button Click");
	 }
	 
	 
	 public void clickContinueButton()
	 {
		 btnContinue.click();
		 wdwait.until(ExpectedConditions.visibilityOf(textItemCode));
		 this.getScreenDetails("After Continue button Click");
	 }
	 
	 public void clickTasksButton()
	 {
		 btnTasks.click();
		 wdwait.until(ExpectedConditions.visibilityOf(lnkManageContentItems));
		 this.getScreenDetails("After Tasks button Click");
	 }
	 
	 
	 public void selectName(String strName)
	 {
		 selectName.click();
		 SeleniumUtils.delay(2000);
		 Select objSelect = new Select(selectName);
	     objSelect.selectByVisibleText(strName);
	     SeleniumUtils.delay(2000);
	     this.getScreenDetails("Select Name");
	 }
	 
	 
	 public void selectCountry(String strCountry)
	 {
		 selectCountry.click();
		 SeleniumUtils.delay(2000);
		 Select objSelect = new Select(selectCountry);
	     objSelect.selectByVisibleText(strCountry);
	     SeleniumUtils.delay(2000);
	     this.getScreenDetails("Select Country");
	 }
	 
	 
	 public void selectStateOfProv(String strStateOfProv)
	 {
		 selectStateOfProv.click();
		 SeleniumUtils.delay(2000);
		 Select objSelect = new Select(selectStateOfProv);
	     objSelect.selectByVisibleText(strStateOfProv);
	     SeleniumUtils.delay(2000);
	     this.getScreenDetails("Select State Of Providence");
	 }
	
	 public void clickManageContentItemsLink()
	 {
		 lnkManageContentItems.click();
		  wdwait.until(ExpectedConditions.visibilityOf(btnCreate));
		 this.getScreenDetails("After Manage Content Items Click");
	 }
	 
	 
	 public void clickManageContentTypesLink()
	 {
		 lnkManageContentType.click();
		 wdwait.until(ExpectedConditions.visibilityOf(btnCreate));
		 this.getScreenDetails("After Manage Content Types Click");
	 }
	 
	 
	 public void clickManageEducEstabLink()
	 {
		 lnkManageEduEst.click();
		 wdwait.until(ExpectedConditions.visibilityOf(txtManEduEst));
		 this.getScreenDetails("After Manage Educational Establishments Click");
	 }
	 
	 public boolean isManageContentItemsLinkDisplayed()
	 { 
		 if(lnkManageContentItems.isDisplayed()) 
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public boolean isManageContentTypesLinkDisplayed()
	 { 
		 if(lnkManageContentType.isDisplayed()) 
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public boolean isManageEducEstabLinkDisplayed()
	 { 
		 if(lnkManageEduEst.isDisplayed()) 
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 
	 
	 public boolean isManagEduEstabTextDisplayed()
	 { 
		 if(txtManEduEst.isDisplayed()) 
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 
	 public boolean isCreateButtonDisplayed()
	 { 
		 if(btnCreate.isDisplayed()) 
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 
	 public boolean isDoneButtonDisplayed()
	 { 
		 if(btnDone.isDisplayed()) 
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public boolean isNameListDisplayed()
	 { 
		 if(selectName.isDisplayed()) 
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 
	 public boolean isCreateTextDisplayed()
	 { 
		 if(txtAfterCreateButtonClick.isDisplayed()) 
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "Search Profiles Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtProfiles, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryProfilesInformation", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>ProfilesInformation Page</span></a>");
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
