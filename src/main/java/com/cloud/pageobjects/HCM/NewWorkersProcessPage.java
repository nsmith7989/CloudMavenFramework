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
 * Contains object properties and methods for New Workers to Process Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class NewWorkersProcessPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:_FOTRaT:0:RAtl1']")
	private WebElement linkHireEmp;
	
	@FindBy(how=How.XPATH, using = "//h2[contains(.,'New Workers to Process')]")
	private WebElement txtNewWorkerstoProcess;
	
	//@FindBy(how=How.XPATH, using = "//h1[contains(.,'Hire an Employee: Compensation and Other Information')]")
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Compensation and Other Information')]")
	private WebElement txtCompAndOtherInfo;
	
	//@FindBy(how=How.XPATH, using = "//h1[contains(.,'Hire an Employee: Review')]")
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Employee: Review')]")
	private WebElement txtEmployeeReview;
	
	//@FindBy(how=How.XPATH, using = "//h1[contains(.,'Hire an Employee: Identification')]")
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Employee: Identification')]")
	private WebElement txtHireEmpIdentification;
	
	//@FindBy(how=How.XPATH, using = "//h1[contains(.,'Hire an Employee: Identification')]")
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Employee: Identification')]")
	private WebElement txtIdentification;
	
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:_FOTsdiAddCwkDefaultRegional::icon']")
	private WebElement imgTasks;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:pt_r1:0:pt1:SP1:inputDate1::glyph')]")
	//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:inputDate1::glyph']
	private WebElement imageHireDatePicker;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,'r1:0:id3::glyph')]")
	private WebElement imageDOBPicker;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'r1:0:pt1:SP1:selectOneChoice2::content')]")
	private WebElement selHireReason;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'r1:0:r1:0:i1:2:selectOneChoice4::content')]")
	private WebElement selTitle;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'r1:0:soc3::content')]")
	private WebElement selGender;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,'r1:0:pt1:SP1:selectOneChoice3::lovIconId')]")
	private WebElement selLegEmp;
	
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'r1:0:id3::pop::cd::mSel::content')]")
	private WebElement selMonth;
	
	
	//@FindBy(how=How.XPATH, using = "//*[@id=_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:0:it20::content]")
	@FindBy(how=How.ID, using = "_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:0:it20::content")
	private WebElement txtLastName;
	
	@FindBy(how=How.ID, using = "_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3::content")
	private WebElement txtLegalEmp;
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3::content"]
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':it60::content')]")
	private WebElement txtFirstName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3::dropdownPopup::')]/tbody/tr/td")
	private WebElement tableLegEmp;
	
	//@FindBy(how=How.XPATH, using = "//input[contains(@id,'r1:2:pt1:sP2:NewPe2:0:NewPe1:0:businessUnitId::content')]")
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':0:businessUnitId::content')]")
	private WebElement selectBusUnit;
	
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'r1:0:id3::pop::cd::ys::content')]")
	private WebElement txtYear;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:next')]")
	private WebElement buttonNext;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Continue')]")
	private WebElement buttonContinue;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':AT1:_ATp:DupTab1:0:DupCIL2::icon')]")
	private WebElement buttonSelectPerson;
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:r1:0:AT1:_ATp:DupTab1:0:DupCIL2::icon"]
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:d1::_ttxt']")
	private WebElement txtMatching;
	
	//@FindBy(how=How.XPATH, using = "//h1[contains(.,'Hire an Employee: Person Information')]")
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Employee: Person Information')]")
	private WebElement txtPersonalInformation;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:0:inputText17::content')]")
	private WebElement txtAddressLine1;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:1:inputText18::content')]")
	private WebElement txtAddressLine2;
	
	//@FindBy(how=How.XPATH, using = "//input[contains(@id,'r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:3:inputComboboxListOfValues27::content')]")
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':0:i1:3:inputComboboxListOfValues27::content')]")
	private WebElement txtCity;
	
	//@FindBy(how=How.XPATH, using = "//input[contains(@id,'r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:4:inputComboboxListOfValues25::content')]")
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':0:i1:4:inputComboboxListOfValues25::content')]")
	private WebElement txtState;
	
	//@FindBy(how=How.XPATH, using = "//input[contains(@id,'r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:i1:5:inputComboboxListOfValues28::content')]")
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':0:i1:5:inputComboboxListOfValues28::content')]")
	private WebElement txtPostalCode;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:pt_r1:0:AT1:_ATp:create::icon']")
	private WebElement btnPhoneAdd;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'r3:0:soc2::content')]")
	private WebElement selectMartialStatus;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'ATp:table1:0:soc1::content')]")
	private WebElement selectPhoneType;
		
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'ATp:table1:0:iclov1::content')]")
	private WebElement selectCountryCode;
		
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'ATp:table1:0:it3::content')]")
	private WebElement txtPhoneNumber;
	
	//@FindBy(how=How.XPATH, using = "//h1[contains(.,'Hire an Employee: Employment Information')]")
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Employee: Employment Information')]")
	private WebElement txtEMPInformation;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe2:0:r2:0:jobId_afrLovInternalTableId::db']")
	private WebElement tableJobDetails;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'::dropdownPopup::popupsearch')]")
	private WebElement lnkSearch;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,'r1:2:pt1:sP2:NewPe2:0:r2:0:jobId::lovIconId')]")
	private WebElement lnkJob;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtSearchName;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'r1:2:pt1:sP2:NewPe2:0:r2:0:jobId::lovDialogId::ok')]")
	private WebElement btnSearchOk;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:pt_r1:4:pt1:AP1:NewPe3:0:panelLabelAndMessage5')]/td[2]")
	private WebElement txtActionReason;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:pt_r1:4:pt1:AP1:NewPe3:0:panelLabelAndMessage7')]/td[2]")
	private WebElement txtLegEmp;
	
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:pt_r1:4:pt1:AP1:Perso2:0:r1:0:read_i5:0:read_plam2')]/td[2]/span")
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':0:r1:0:read_i5:0:read_plam2')]/td[2]/span")
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_m:MAnt2:1:pt1:r1:4:pt1:SP3:Perso1:0:r1:0:read_i5:0:read_plam2"]
	private WebElement verifyLastName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:pt_r1:4:pt1:AP1:NewPe2:0:JobDe1:0:plam2')]/td[2]")
	private WebElement verifyJobType;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:pt_r1:4:pt1:AP1:NewPe2:0:plam1')]/td[2]")
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,':SP3:AddWo3:0:panelLabelAndMessage3')]/td[2]")
	private WebElement verifyBusUnit;
	
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:pt_r1:4:pt1:AP1:tt1:submit')]/a")
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:submit')]/a")
	private WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Yes')]")
	private WebElement buttonYes;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':tt1:okConfirmationDialog')]")
	//button[contains(@id,'r1:4:pt1:AP1:tt1:okConfirmationDialog')]
	private WebElement buttonOK;
	
	//@FindBy(how=How.ID, using = "_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3::lovIconId")
						  //*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3::lovIconId"]
	@FindBy(how=How.XPATH, using = "//a[contains(@id,':pt1:pt_r1:0:pt1:SP1:selectOneChoice3::lovIconId')]")
	private WebElement listDestLegEmp;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtLegalEmployer;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'::lovDialogId::ok')]")
	private WebElement buttonLegEmpOK;
	
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3_afrLovInternalTableId::db"]
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3_afrLovInternalTableId::db')]")
	private WebElement tableLegalEmployer;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':MAnt2:1:pt1:pt_r1:0:pt1:SP1:r1:0:cb4')]")
	private WebElement selectPersonOK;
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:r1:0:cb4"]
	
	private List<WebElement> rowcount;
	
	 public NewWorkersProcessPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 30);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtNewWorkerstoProcess));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* New Workers to Process Page *****************************");
	     this.getScreenDetails();
	 }

	 public void clickDestLegEmpButton()
	 {
		 listDestLegEmp.click();
			SeleniumUtils.delay(5000);
	 }
	 
	 public void clickSearchFromDestLegEmpList()
	 {
		 driver.findElement(By.xpath("//*[contains(@id,'::dropdownPopup::popupsearch')]")).click();
		 wdwait.until(ExpectedConditions.visibilityOf(txtLegalEmployer));
		 this.getScreenDetails("Search");
	 }
	 
	 public void enterLegalEmployer(String strLegEmp)
	 {
		 txtLegalEmployer.sendKeys(strLegEmp);
		 SeleniumUtils.delay(2000);
	 }
	 
	 public String getHireReason()
	 {
		 System.out.println(txtActionReason.getText().trim());
		 return txtActionReason.getText().trim();
	 }
	 
		public void selectLegEmployer(String strLegEmployer)
		{	
			rowcount=(List<WebElement>) tableLegalEmployer.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			int found=0;
			for (int row=1;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
				
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				//if(actualText.contains(strLegEmployer))
				if(actualText.equalsIgnoreCase(strLegEmployer))
				{
					
					report.log(LogStatus.INFO, "Selected Legal Employer Name is "+strLegEmployer);
					cellNametext.click();
					SeleniumUtils.delay(2000);
					found=1;
					this.getScreenDetails("SelectLegEmp Page");
					break;
				}
			}
			/*if (found==0)
			{
				report.log(LogStatus.FAIL, "Selected Legal Employer Name is "+strLegEmployer+" is not listed in the search list");
			}*/
		}
	 
	 public void clickLegEmpOKButton() throws TestException
	 {
		buttonLegEmpOK.click();
		SeleniumUtils.delay(5000);
		report.log(LogStatus.PASS, "Clicked on OK button");
		this.getScreenDetails("AfterClickOkButton");
		
	 }
	 
	 public String getLegEmpTxt()
	 {
		 System.out.println(txtLegEmp.getText().trim());
		 return txtLegEmp.getText().trim();
	 }
	 
	 
	 public String getLastNameTxt()
	 {
		 System.out.println(verifyLastName.getText().trim());
		 return verifyLastName.getText().trim();
	 }
	 
	 
	 public String getJobTypeTxt()
	 {
		 System.out.println(verifyJobType.getText().trim());
		 return verifyJobType.getText().trim();
	 }
	 
	 public String getBusUnitTxt()
	 {
		 System.out.println(verifyBusUnit.getText().trim());
		 return verifyBusUnit.getText().trim();
	 }
	 
	 public void clickSubmitButton()
	 {
		 btnSubmit.click();
		//SeleniumUtils.delay(10000);
		 wdwait.until(ExpectedConditions.visibilityOf(buttonYes));
		 this.getScreenDetails("Submit Screen");
	 }
	 
		public void selectJob(String strJob)
		{	
			rowcount=(List<WebElement>) tableJobDetails.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=1;row<rownum;row++)
			{	
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':jobId_afrLovInternalTableId::db')]//table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
				//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_new_person:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe2:0:r2:0:jobId_afrLovInternalTableId::db']/table/tbody/tr/td[2]/div/table/tbody/tr/td[1]
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				
				if(actualText.equalsIgnoreCase(strJob))
				{
					report.log(LogStatus.INFO, "Selected Job Name is "+strJob);
					cellNametext.click();
					SeleniumUtils.delay(5000);
					this.getScreenDetails("Selection of Job");
					break;
				}
			}
		}		
	
	 public void clickTasksButton() throws TestException
	 {
			imgTasks.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("Tasks Screen");
		    report.log(LogStatus.PASS, "Clicked on Tasks button");
	 }
	 
	 
	 public void clickSearchLink()
	 {
		 lnkSearch.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("SearchLink Screen");
	 }
	 
	 
	 public void clickSearchButton()
	 {
		 btnSearch.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("SearchResults Screen");
	 }
	 
	 
	 public void clickSearchOkButton()
	 {
		 btnSearchOk.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("After Ok button Click");
	 }
	 
	 public void clickJobDropdown()
	 {
		 lnkJob.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Job List Screen");
	 }
	 
	 public void clickPhoneAddNew() throws TestException
	 {
		 	btnPhoneAdd.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("Phone Details");
		    report.log(LogStatus.PASS, "Clicked on + New button");
	 }
	 
	 
	 public void clickHireDatePicker()
	 {
		 	imageHireDatePicker.click();
			SeleniumUtils.delay(3000);
			report.log(LogStatus.PASS, "Clicked on Hire Date icon");
			 this.getScreenDetails("Hire Date Picker");
	 }
	 
	 public void selectMartialStatus(String strMartialStaus){
		 	selectMartialStatus.click();
	    	report.log(LogStatus.PASS, "Select any MartialStatus from MartialStatus dropdown");
	    	Select objSelect = new Select(selectMartialStatus);
	    	objSelect.selectByVisibleText(strMartialStaus);
	    	SeleniumUtils.delay(3000);
	    }
	 
	 public void clickNextButton()
	 {
		 	buttonNext.click();
			SeleniumUtils.delay(10000);
			this.getScreenDetails("Next Page");
	 }
	 
	 public void selectPhoneType(String strType)
	 {
		 	selectPhoneType.click();	
		 	report.log(LogStatus.PASS, "Select any Phone Type from Type dropdown");
	    	Select objSelect = new Select(selectPhoneType);
	    	objSelect.selectByVisibleText(strType);
	    	SeleniumUtils.delay(2000);
	    	this.getScreenDetails("PhoneType List");
	 }
	 
	 public void enterPhoneNumber(String strPhoneNumber)
	 {
		 txtPhoneNumber.click();
		 txtPhoneNumber.sendKeys(strPhoneNumber);
		 this.getScreenDetails("Entered Phonenumber");
		 SeleniumUtils.delay(5000);
	 }
	 
	 
	 public void enterSearchName(String strSearchName)
	 {
		 txtSearchName.click();
		 txtSearchName.sendKeys(strSearchName);
		 SeleniumUtils.delay(5000);
	 }
	 
	 public void clickContinueButton()
	 {
		 	buttonContinue.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("Continue Screen");
	 }
	 
	 
	 public void clickSelectPerson()
	 {
		 	buttonSelectPerson.click();
			SeleniumUtils.delay(3000);
			this.getScreenDetails("SelectPerson click");
	 }
	 
	 public void clickDateOfBirthPicker()
	 {
		 imageDOBPicker.click();
		 SeleniumUtils.delay(4000);
		 report.log(LogStatus.PASS, "Clicked on DOB icon");
		 this.getScreenDetails("DateOfBirth Picker");
	 }
	 
	 public void selectDOBDayFromDate(String noOfDays)
	 {
		WebElement dateWidget = driver.findElement(By.xpath("//table[contains(@id,'r1:0:id3::pop::cd::cg')]"));
			List<WebElement> rows=dateWidget.findElements(By.tagName("tr")); 
			List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
			  
			  for (WebElement cell:columns)
			  {
			   if (cell.getText().equals(noOfDays))
			   {
			     cell.click();
				   SeleniumUtils.delay(3000);
				   break;
			   }
			  } 
			  this.getScreenDetails("After Selecting Day from DOB");
			}
	
	 
	 public void selectHireDayFromDate(String noOfDays)
	 {
			WebElement dateWidget = driver.findElement(By.xpath("//table[contains(@id,'r1:0:pt1:SP1:inputDate1::pop::cd::cg')]"));
			List<WebElement> rows=dateWidget.findElements(By.tagName("tr")); 
			List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
			  
			  for (WebElement cell:columns)
			  {
			   if (cell.getText().equals(noOfDays))
			   {
			     cell.click();
				   SeleniumUtils.delay(3000);
				   break;
			   }
			  } 
			  this.getScreenDetails("Select Day from HireDate");
			}
	 
	 //This is to select Hire Reason from the Hire Reason dropdown
	 public void selectHireReason(String strReason)
	 {
		 selHireReason.click();
		 Select objSelect = new Select(selHireReason);
		 objSelect.selectByVisibleText(strReason);
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Hire Reason List");
	 }
	 
	 
	 public void selectTitle(String strTitle)
	 {
		 selTitle.click();
		 Select objSelect = new Select(selTitle);
		 objSelect.selectByVisibleText(strTitle);
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Title List");
	 }
	 
	 
	 
	 public void selectMonth(String strMonthName)
	 {
		 selMonth.click();
		 Select objSelect = new Select(selMonth);
		 objSelect.selectByVisibleText(strMonthName);
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Month List");
	 }
	 
	 
	 public void selectBusinessUnit(String strBusUnit)
	 {
		 selectBusUnit.click();
		 selectBusUnit.sendKeys(strBusUnit);
		 selectBusUnit.sendKeys(Keys.ENTER);
		 SeleniumUtils.delay(5000);
		 //driver.findElement(By.xpath("//li[@class='p_AFSelected AFAutoSuggestItem']")).click();
		 this.getScreenDetails("Business Unit List");
	 }
	 
	 public void selectGender(String strGender)
	 {
		 selGender.click();
		 Select objSelect = new Select(selGender);
		 objSelect.selectByVisibleText(strGender);
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Gender List");
	 }
	 
	 //This is to select Legal Employer from the Hire Reason dropdown
	 public void selectLegalEmp(String strLegEmployer)
	 {
		 selLegEmp.click();
		 SeleniumUtils.delay(5000);
		 rowcount=(List<WebElement>) tableLegEmp.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			int found=0;
			for (int row=1;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,'MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3::dropdownPopup::dropDownContent::db')]/table/tbody/tr["+row+"]/td[1]"));
				String actualText=cellNametext.getText().trim();
				System.out.println("actual text is "+actualText);
				//if(actualText.contains(strLegEmployer))
				if(actualText.equalsIgnoreCase(strLegEmployer))
				{
					
					report.log(LogStatus.INFO, "Selected Legal Employer Name is "+strLegEmployer);
					cellNametext.click();
					SeleniumUtils.delay(3000);
					found=1;
					this.getScreenDetails("SelectLegalEmployer");
					break;
				}
			}
			
			if (found==0)
			{
				report.log(LogStatus.FAIL, "Selected Legal Employer Name is "+strLegEmployer+" is not listed in the search list");
			}
		
	 }
	 
	 
	 public void enterCity(String strCity)
	 {
		 SeleniumUtils.delay(2000);
		 txtCity.click();
		 txtCity.sendKeys(strCity);
		 SeleniumUtils.delay(2000);
	 }
	 
	 public void clickOKButton() throws TestException
	 {
		this.getScreenDetails("After Confirmation"); 
		buttonOK.click();
		SeleniumUtils.delay(8000);
		report.log(LogStatus.PASS, "Clicked on OK button");
		this.getScreenDetails("After Clicking Ok button");
	    
	 }
	 
	 
	 public void clickSelectPersonOK() throws TestException
	 {
		this.getScreenDetails("After Confirmation"); 
		selectPersonOK.click();
		SeleniumUtils.delay(8000);
		report.log(LogStatus.PASS, "Clicked on OK button");
		this.getScreenDetails("After Clicking Ok button");
	    
	 }
	 
	 public void clickConfirmatioDialog(String strYesOrNO)
		{
			this.getScreenDetails("Confiramtion Screen");
			if(strYesOrNO.equalsIgnoreCase("Yes"))
			{
				buttonYes.click();
			}
			else
			{
				driver.findElement(By.xpath("//button[contains(.,'No')]")).click();	
			}
			
			 wdwait.until(ExpectedConditions.visibilityOf(buttonOK));
				
		}

	 
	 public void clicYesButton()
	 {
		 	buttonYes.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("After Yes button click");
	 }
	 
	 
	 public void enterState(String strState)
	 {
		 txtState.click();
		 txtState.sendKeys(strState);
		 SeleniumUtils.delay(2000);
	 }
	 
	 
	 public void enterPostalCode(String strZipCode)
	 {
		 txtPostalCode.click();
		 txtPostalCode.sendKeys(strZipCode);
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Personal Information Details");
	 }
	 
	 public void enterAddressLine2(String strAddressLine2)
	 {
		 txtAddressLine2.click();
		 txtAddressLine2.sendKeys(strAddressLine2);
		 SeleniumUtils.delay(2000);
	 }
	 
	 public void enterAddressLine1(String strAddressLine1)
	 {
		 txtAddressLine1.click();
		 txtAddressLine1.sendKeys(strAddressLine1);
		 SeleniumUtils.delay(2000);
	 }
	 
	 
	 public void enterLastName(String strLastName)
	 {
		 SeleniumUtils.delay(2000);
		 //txtLastName.click();
		 txtLastName.sendKeys(strLastName);
		 SeleniumUtils.delay(2000);
	 }
	 
	 public void selectLegEmp(String strLegEmp)
	 {
		 txtLegalEmp.click();
		 txtLegalEmp.sendKeys(strLegEmp);
		// txtLegalEmp.sendKeys(Keys.ENTER);
		 SeleniumUtils.delay(2000);
		 txtLegalEmp.sendKeys(Keys.DOWN);
		 SeleniumUtils.delay(4000);
		 //driver.findElement(By.xpath("//li[@class='p_AFSelected AFAutoSuggestItem']")).click();
		 this.getScreenDetails("Business Unit List");
	 }
	 
	 public void enterFirstName(String strFirstName)
	 {
		 SeleniumUtils.delay(2000);
		 txtFirstName.click();
		 txtFirstName.sendKeys(strFirstName);
		 SeleniumUtils.delay(2000);
	 }
	 
	 
	 public void enterYear(String strYear)
	 {
		 txtYear.click();
		 txtYear.clear();
		 txtYear.sendKeys(strYear);
		 txtYear.sendKeys(Keys.ENTER);
		 SeleniumUtils.delay(3000);
	 }
	 
	 public void clickHireEmpLink() throws TestException
	 {
		 	linkHireEmp.click();
		 	wdwait.until(ExpectedConditions.visibilityOf(txtIdentification));
			this.getScreenDetails("Identification Page");
		    report.log(LogStatus.PASS, "Clicked on Hire an Employee link");
	 } 
	 
	 public boolean isHireAnEmpIdentificationTxtDisplayed()
	 {
	    	return txtHireEmpIdentification.isDisplayed();
	 }
	 
	 
	 public boolean isEmployeeInforamtionTxtDisplayed()
	 {
	    	return txtEMPInformation.isDisplayed();
	 }
	 
	 public boolean isSameDataAlertDisplayed()
	 {
	    	return txtMatching.isDisplayed();
	 }
	 
	 
	 public boolean isPIPageDisplayed()
	 {
	    	return txtPersonalInformation.isDisplayed();
	 }
	 
	 
	 public boolean isCompAndOtherInfoDisplayed()
	 {
	    	return txtCompAndOtherInfo.isDisplayed();
	 }
	 
	 
	 public boolean isEmployeeReviewPageDisplayed()
	 {
	    	return txtEmployeeReview.isDisplayed();
	 }
	 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "New Workers to Process Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtNewWorkerstoProcess, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryNewWorkerstoProcess", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>New Workers to Process Page</span></a>");
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
