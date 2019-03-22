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
 * Contains object properties and methods for Person Management Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class PersonManagementPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Edit Employment: Review')]")
	private WebElement txtEditEmpReview;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Global Transfer: Review')]")
	private WebElement txtGTReview;
	
	@FindBy(how=How.XPATH, using = "//span[contains(@id,'management:0:MAt1:0:pt1:Manag1:1:pt1:r1:4:pt1:SP3:AddWo1:0:soc1::content')]")
	private WebElement txtAction;
	
	//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:2:AP1:r1:0:Actio1:0:plam1']/td[2]
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAt1:0:pt1:Manag1:2:AP1:r1:0:Actio1:0:plam1')]/td[2]")
	private WebElement txtActionType;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAt1:0:pt1:Manag1:2:AP1:r1:0:Actio1:0:plam2')]/td[2]")
	private WebElement txtActionReason;
	
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'management:0:MAt1:0:pt1:Manag1:1:pt1:r1:4:pt1:SP3:AddWo1:0:plam5')]/td[2]")
	private WebElement txtLegalEmpl;
	
	@FindBy(how=How.XPATH, using = "//span[contains(@id,'management:0:MAt1:0:pt1:Manag1:1:pt1:r1:4:pt1:SP3:AddWo2:0:selectOneChoice1::content')]")
	private WebElement txtBusUnit;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:0:AP1:r1:0:AT2:_ATp:ctb1']/a")
									//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:0:AP1:r1:0:AT2:_ATp:ctb1']/a/span
									//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:0:AP1:r1:0:AT2:_ATp:ctb1']/a
	private WebElement btnAdd;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Person Management: Search')]")
	private WebElement txtPersonManagement;
	
	@FindBy(how=How.NAME, using = "_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:q1:value00")
	private WebElement txtName;
	
	@FindBy(how=How.ID, using = "_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:q1:value10::content")
	private WebElement txtPersonNumber;
	
//	@FindBy(how=How.XPATH, using = "//*[contains(@id,':SP3:table1:_ATp:table2')]")
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':SP3:table1:_ATp:table2::db')]")
	private WebElement tablePersonNames;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'locationId_afrLovInternalTableId::db')]")
	private WebElement tableLocationNames;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':ManagerNameId_afrLovInternalTableId::db')]")
	private WebElement tableManagerNames;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':positionId_afrLovInternalTableId')]")
	private WebElement tablePositionNames;
	
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:SP1:sdi3::icon')]")
	private WebElement imgContacts;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTsdiHcmIntWaTasksId::icon']")
	private WebElement imgTasks;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTRaT:0:RAtl17']")
	//@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTRaT:0:j_id58']/ul/li[3]")
	private WebElement lnkManageEmp;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTRaT:0:RAtl11']")
	private WebElement lnkManageSal;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTRaT:0:RAtl25']")
	private WebElement lnkManageTalentProfile;
	
	@FindBy(xpath = "//h1[contains(.,': Skills and Qualifications')]")
	private WebElement txtManageTalentProfile;
	
	@FindBy(xpath = "//button[contains(.,'Propose New Salary')]")
	private WebElement btnProposeNewSal;
	
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTpd1::tabbc']")
	private WebElement tabTasks;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTRaT:0:RAtl22']")
	private WebElement linkManageWorkRelationship;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTRaT:0:RAtl3']")
	private WebElement linkManageAbsenceRecord;
	
	@FindBy(how=How.XPATH, using = "//a[@title='Actions']")
	private WebElement buttonActions;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:actionsName1::content')]")
	private WebElement selectAction;
	
	@FindBy(xpath = "//a[contains(@title,'Search: Action')]")
	private WebElement linkSalAction;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:0:AP1:idNewAction::dropdownPopup::dropDownContent::db']")
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:0:AP1:idNewAction::content"]
	private WebElement selectSalAction;
	
	//@FindBy(how=How.XPATH, using = "//select[contains(@id,'management:0:MAt2:1:r1:0:r1:0:pt1:ap1:Termi1:0:Action::content')]")
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'management:0:MAt2:1:r1:0:r1:0:pt1:ap1:Termi1:0:Action::content')]")
	private WebElement selectTerminateAction;
	
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'AP1:actionReason::content')]")
	private WebElement selectActionReason;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:soc1::content')]")
	private WebElement selectCorrectAction;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:actionsName1::content')]")
	private WebElement listAction;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Review')]")
	private WebElement buttonReview;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:tt1:review']/a")
	private WebElement locationReviewButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:AP1:ctb1']")
	private WebElement btnContinue;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,': Review Terminate Work Relationship')]")
	private WebElement txtReview;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@accesskey,'K')]")
	//@FindBy(how=How.XPATH, using = "//button[contains(@id,':tt1:okConfirmationDialog')]")
	private WebElement buttonOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':AP1:legalEnt::lovDialogId::ok')]")
	private WebElement buttonLegEmpOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'::lovDialogId::ok')]")
	private WebElement buttonBUOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:cb10')]|//button[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:ctb1')]|//button[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:d4::ok')]")
	private WebElement buttonGenOK;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':AP1:ctb1')]")
	private WebElement buttonStatusOK;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:next')]/a")
	private WebElement buttonNext;

	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:_FOTsr2:0:SP1:SPb']/a")
	private WebElement buttonDone;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,':AP1:soc1::content')]")
	private WebElement selectType;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Yes')]")
	private WebElement buttonYes;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':AP1:sbc1::content')]")
	private WebElement checkSingleDay;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':AP1:id7::content')]")
	private WebElement txtStartDate;
	
	//a[contains(@id,'management:0:MAt2:1:r1:0:r1:0:pt1:ap1:Termi1:0:NotificationDate::glyph')]
	@FindBy(how=How.XPATH, using = "//a[contains(@id,':NotificationDate::glyph')]")
	private WebElement txtNotificationDate;
	
	@FindBy(xpath = "//input[contains(@name,'management:0:MAt1:0:pt1:Manag1:1:r:JobDe2:0:inputText2')]")
	private WebElement txtStartTime;
	
	@FindBy(xpath = "//input[contains(@name,'management:0:MAt1:0:pt1:Manag1:1:r:JobDe2:0:inputText5')]")
	private WebElement txtWorkingHrs;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:AP1:effectiveDate::content')]")
	private WebElement txtEffectiveStartDate;
	
	@FindBy(how=How.XPATH, using = "//textarea[contains(@id,':AP1:it5::content')]")
	private WebElement txtAreaComments;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':AP1:SPsb2')]/a")
//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:AP1:SPsb2']/a
	private WebElement buttonSubmit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':tt1:submit')]/a")
	private WebElement buttonReviewSubmit;

	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:2:AP1:tt1:submit']/a")
	private WebElement buttonLocationSubmit;
	
	@FindBy(how=How.ID, using = "_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:edit")
	//@FindBy(xpath = "//a[contains(@title,'Edit')]")
	private WebElement buttonEdit;
	
	@FindBy(xpath = "//button[contains(@title,'Edit')]")
	private WebElement btnMTPEdit;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt3:0:SP1:menu4']")
	private WebElement selAddContentMenu;
	
	@FindBy(xpath = "//a[contains(@title,'Search: Name')]")
	private WebElement selName;
	
	@FindBy(xpath = "//select[contains(@name,'management:0:MAt3:0:SP1:r1:1:t1:0:selectOneChoice8')]")
	private WebElement selProficiency;
	
	@FindBy(xpath = "//select[contains(@name,'management:0:MAt3:0:SP1:r1:1:t1:0:selectOneChoice4')]")
	private WebElement selEvaluationType;
	
	@FindBy(how=How.XPATH, using = ".//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:updBtn']/td[2]")
	//@FindBy(xpath = "//td[@class='x1ku'][contains(.,'Update')]")
	private WebElement listUpdate;
	
	//@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:crtBtn']/td[2]")
	@FindBy(xpath = "//td[@class='x1ku'][contains(.,'Correct')]")
	private WebElement listCorrect;
	
	//@FindBy(how=How.XPATH, using = "//a[contains(@title,'Search: Destination Legal Employer')]")
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':pt1:Manag1:0:AP1:legalEnt::lovIconId')]")
	//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:legalEnt::lovIconId']
	private WebElement listDestLegEmp;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtLegalEmployer;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:legalEnt_afrLovInternalTableId::db']")
	private WebElement tableLegalEmployer;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:pt1:r1:2:pt2:SP1:AddWo1:0:AddWo1:0:businessUnitId_afrLovInternalTableId::db']")
	private WebElement tableBusinessUnit;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@title,'Business Unit')]")
	private WebElement linkBusinessUnit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'::dropdownPopup::popupsearch')]")
	private WebElement lnkSearch;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtBusinessUnit;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:i1:0:showDetailItem3::disAcr']")
	private WebElement linkAssignment;
	
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtLocationName;
	
	
	@FindBy(how=How.XPATH, using = "//a[contains(@title,'Search: Location')]")
	//@FindBy(how=How.XPATH, using = "//a[contains(@id,'management:0:MAt1:0:pt1:Manag1:0:r:JobDe2:0:locationId::lovIconId')]")
	private WebElement listLocation;
	
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,':ManagerNameId::lovIconId')]")
	private WebElement linkName;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@title,'Search Positions')]")
	private WebElement listSearchPosition;
	
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AU2:insert::icon')]")
	private WebElement buttonAdd;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:i1:0:lmar1:0:grid1']")
	private WebElement tableManager;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':AP1:r1:0:i1:0:JobDe1:0:ct1:j_id244:0:j_id245:0:j_id248::db')]")
	private WebElement tableJobDetails;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MainAreaTab1::rmAbv']")
	private WebElement btnCloseTab;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':MAt1:0:pt1:Perso1:0:SP3:q1:value40::content')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:q1:value40::content"]
	private WebElement chkIncludeTerminateWorkRelationship;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_UIShome::icon']")
	private WebElement btnHome;
	
	@FindBy(how=How.XPATH, using = "//select[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:r1:0:pt1:ap1:Locat1:0:soc1::content']")
	private WebElement selectWAH;
	
	@FindBy(xpath = "//select[contains(@name,'management:0:MAt1:0:pt1:Manag1:1:r:i1:0:r3:0:selectOneChoice3')]")
	private WebElement selectAssignCat;
	
	@FindBy(xpath = "//select[contains(@name,'management:0:MAt1:0:pt1:Manag1:1:r:i1:0:r3:0:soc2')]")
	private WebElement selectRegOrTemp;
	
	//@FindBy(xpath = "//a[contains(@title,'Select Date')]")
	@FindBy(xpath = "//input[contains(@id,'management:0:MAt2:0:AP1:idNewStartDate::content')]")
	private WebElement txtSelectDate;
	
	@FindBy(xpath = "//input[contains(@name,'management:0:MAt2:1:AP1:icAsgLov')]")
	private WebElement txtSalaryBasis;
	
	//@FindBy(xpath = "//input[contains(@name,'management:0:MAt2:1:AP1:itSA')]")
	@FindBy(xpath = "//*[contains(@id,'management:0:MAt2:1:AP1:itSA::content')]")
	private WebElement txtSalaryAmount;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:2:AP1:txnt2:submit']")
	private WebElement btnContinueSubmit;
	
	
	private List<WebElement> rowcount;
	
		 public PersonManagementPage(WebDriver driver, ExtentTest report) throws TestException 
		 {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 20);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(txtPersonManagement));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     System.out.println("******************************* Person Management Page *****************************");
		     this.getScreenDetails();
		 }
		 
		 
			public boolean verifyPersonNameExistsOrNot(String strPersonName)
			{	
				rowcount=(List<WebElement>) tablePersonNames.findElements(By.tagName("tr"));
				int rownum=rowcount.size();
				System.out.println("row Number is"+rownum);
				int found=0;
				if (rownum>0)
				{
					for (int row=0;row<rownum;row++)
					{
						WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:table1:_ATp:table2:"+row+":gl1']"));
						//WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:table1:_ATp:table2::db']/table/tbody/tr/td["+row+"]/div/table/tbody/tr/td[1]"));
																			 
						String actualText=cellNametext.getText().trim();
						System.out.println("actual text is "+actualText);
						
						if(actualText.contains(strPersonName))
						{
							report.log(LogStatus.INFO, "Selected Person Name is "+strPersonName);
							found=1;
							this.getScreenDetails("Verify Person Name");
							break;
						}
					}
				}
				else
				{
					found=0;
				}
				if (found==0)
				{
					return false;
				}
				else
				{
					return true;
				}
			}		
		
	 
	 
		public void selectPersonName(String strPersonName)
			{	
				rowcount=(List<WebElement>) tablePersonNames.findElements(By.tagName("tr"));
				int rownum=rowcount.size();
				int found=0;
				for (int row=0;row<rownum;row++)
				{
					WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:table1:_ATp:table2:"+row+":gl1']"));
					//WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Perso1:0:SP3:table1:_ATp:table2::db']/table/tbody/tr/td["+row+"]/div/table/tbody/tr/td[1]"));
																		 
					String actualText=cellNametext.getText().trim();
					System.out.println("actual text is "+actualText);
					
					if(actualText.equalsIgnoreCase(strPersonName))
					{
						report.log(LogStatus.INFO, "Selected Person Name is "+strPersonName);
						cellNametext.click();
						SeleniumUtils.delay(8000);
						found=1;
						this.getScreenDetails("After Name link click");
						break;
					}
				}
				
				if (found==0)
				{
					report.log(LogStatus.PASS, "Selected Legal Employer Name is "+strPersonName+" is not listed in the search list");
				}
			}		
		
		
		/*public void checkJobDetails(String strWorkinhHours,String strStartTime)
		{	
			rowcount=(List<WebElement>) tableJobDetails.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=1;row<rownum;row++)
			{	
				WebElement workinghours=driver.findElement(By.xpath("//*[contains(@id,'Manag1:2:AP1:r1:0:i1:0:JobDe1:0:ct1:j_id244:0:j_id245:0:j_id248::db']/table/tbody/tr["+row+"]/td[1]"));
				String actualText=workinghours.getText().trim();
				System.out.println("actual text is "+actualText);
				
				if(actualText.equalsIgnoreCase(strWorkinhHours))
				{	
					
					this.getScreenDetails("Location Screen");
					break;
				}
			}
		}*/		
		
		public void selectLocationName(String strLocationName)
		{	
			rowcount=(List<WebElement>) tableLocationNames.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=1;row<rownum;row++)
			{	
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':locationId_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				
				if(actualText.equalsIgnoreCase(strLocationName))
				{
					report.log(LogStatus.INFO, "Selected Location Name is "+strLocationName);
					cellNametext.click();
					SeleniumUtils.delay(5000);
					this.getScreenDetails("Location Screen");
					break;
				}
			}
		}		
		
		public void removeManager()
		{	
			/*rowcount=(List<WebElement>) tableManager.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=0;row<rownum-1;row++)
			{	SeleniumUtils.delay(5000);
			System.out.println("inside loop");
				//driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:i1:0:lmar1:0:i1:"+row+":RemoveImage::icon']")).click();;
			*/	
			driver.findElement(By.xpath("//*[contains(@id,':i1:0:RemoveImage::icon')]")).click();
				
			/*	SeleniumUtils.delay(5000);
			}
			*/
			
		}		
		
		public void selectManagerType(String strManagerType)
		{
			Select objSelect = new Select(driver.findElement(By.xpath("//select[contains(@id,'management:0:MAt1:0:pt1:Manag1:1:r:i1:0:lmar1:0:i1:1:selectOneChoice1::content')]")));
	    	objSelect.selectByVisibleText(strManagerType);
	    	SeleniumUtils.delay(3000);
			
		}
		
		
		
		public void selectWorkAtHome(String strWorkAtHome)
		{
			selectWAH.click();
			Select objSelect = new Select(selectWAH);
	    	objSelect.selectByVisibleText(strWorkAtHome);
	    	SeleniumUtils.delay(3000);
	    	this.getScreenDetails("Select WorkAtHome");
		}
		
		
		public void selectAssignCategory(String strAssignCategory)
		{
			selectAssignCat.click();
			Select objSelect = new Select(selectAssignCat);
	    	objSelect.selectByVisibleText(strAssignCategory);
	    	SeleniumUtils.delay(3000);
	    	this.getScreenDetails("Select AssignCategory");
		}
		
		
		
		public void selectRegulerOrTemp(String strRegOrTemp)
		{
			selectRegOrTemp.click();
			Select objSelect = new Select(selectRegOrTemp);
	    	objSelect.selectByVisibleText(strRegOrTemp);
	    	SeleniumUtils.delay(3000);
	    	this.getScreenDetails("Select Reguler Or Temporary");
		}
		
		public void selectManagerName(String strManagerName)
		{	
			rowcount=(List<WebElement>) tableManagerNames.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=1;row<rownum;row++)
			{	
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':ManagerNameId_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				
				if(actualText.equalsIgnoreCase(strManagerName))
				{
					report.log(LogStatus.INFO, "Selected Manager Name is "+strManagerName);
					cellNametext.click();
					SeleniumUtils.delay(5000);
					this.getScreenDetails("Select Manager");
					break;
				}
			}
		}		
		
		
		public void selectActionName(String strActionName)
		{	
			rowcount=(List<WebElement>) selectSalAction.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=1;row<rownum;row++)
			{	
				WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:0:AP1:idNewAction::dropdownPopup::dropDownContent::db']/table/tbody/tr["+row+"]/td"));
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				
				if(actualText.equalsIgnoreCase(strActionName))
				{
					report.log(LogStatus.INFO, "Selected Action Name is "+strActionName);
					cellNametext.click();
					SeleniumUtils.delay(5000);
					this.getScreenDetails("Select Action");
					break;
				}
			}
		}		
		
		
		public void selectPositionName(String strPositionName)
		{	
			rowcount=(List<WebElement>) tablePositionNames.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			for (int row=1;row<rownum;row++)
			{	
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':positionId_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				
				if(actualText.equalsIgnoreCase(strPositionName))
				{
					report.log(LogStatus.INFO, "Selected Manager Name is "+strPositionName);
					cellNametext.click();
					SeleniumUtils.delay(5000);
					this.getScreenDetails("Selection of Position");
					break;
				}
			}
		}		
		
		
		public void selectLegEmployer(String strLegEmployer)
		{	
			rowcount=(List<WebElement>) tableLegalEmployer.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			int found=0;
			for (int row=1;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:legalEnt_afrLovInternalTableId::db']/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
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
		
		
		public void selectBusinessUnit(String strBusinessUnit)
		{	
			rowcount=(List<WebElement>) tableBusinessUnit.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			int found=0;
			for (int row=1;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':businessUnitId_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td"));
				//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:pt1:r1:2:pt2:SP1:AddWo1:0:AddWo1:0:businessUnitId_afrLovInternalTableId::db']/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td
				String actualText=cellNametext.getText();
				System.out.println("actual text is "+actualText);
				//if(actualText.contains(strLegEmployer))
				if(actualText.equalsIgnoreCase(strBusinessUnit))
				{
					
					report.log(LogStatus.INFO, "Selected Legal Employer Name is "+strBusinessUnit);
					cellNametext.click();
					SeleniumUtils.delay(5000);
					found=1;
					this.getScreenDetails("AfterSelection Of BU");
					break;
				}
			}
			if (found==0)
			{
				report.log(LogStatus.FAIL, "Selected Legal Employer Name is "+strBusinessUnit+" is not listed in the search list");
			}
		}
		
		
		
		 public void clickSearchFromDestLegEmpList()
		 {
			 driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:legalEnt::dropdownPopup::popupsearch']")).click();
			//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:0:AP1:legalEnt::dropdownPopup::popupsearch"]
			 wdwait.until(ExpectedConditions.visibilityOf(txtLegalEmployer));
			 this.getScreenDetails("Search");
		 }
		 
		 
		 public void clickAddManagerDetailsButton()
		 {
			 buttonAdd.click();
			SeleniumUtils.delay(2000);
		 }
		 
		 
		 public void checkIncludeTerminateWorkRelationship()
		 {
			chkIncludeTerminateWorkRelationship.click();
			SeleniumUtils.delay(2000);
			this.getScreenDetails("ChekboxCheck");
		 }
		 
		 public void clickCloseTabButton()
		 {
			btnCloseTab.click();
			SeleniumUtils.delay(2000);
			this.getScreenDetails("After Close Tab click");
		 }
		 
		 
		 public void clickHomeButton()
		 {
			btnHome.click();
			SeleniumUtils.delay(2000);
			this.getScreenDetails("Home Screen");
		 }
		 
		 
		 public void clickAssignmentLink()
		 {
			 linkAssignment.click();
			 SeleniumUtils.delay(8000);
			 //wdwait.until(ExpectedConditions.visibilityOf(listLocation));
			 this.getScreenDetails("Assignment Screen");
		 }
		 
		 
		 public void clickSearchPositionsList()
		 {
			 listSearchPosition.click();
			 SeleniumUtils.delay(3000);
			 
			 this.getScreenDetails("Positions Screen");
		 }
		 
		 public void clickSearchFromPositionList()
		 {
			 driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt1:0:pt1:Manag1:1:r:JobDe1:0:positionId::dropdownPopup::popupsearch']")).click();
			 wdwait.until(ExpectedConditions.visibilityOf(txtLegalEmployer));
			 this.getScreenDetails("Search");
		 }
		
		 
			 
		 public void clicDoneButton()
		 {
			 	buttonDone.click();
				SeleniumUtils.delay(10000);
				this.getScreenDetails("After clicking on Done button");
		 }
		 
		 public void clickSearchLink()
		 {
			 lnkSearch.click();
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("SearchLink Screen");
		 }
		 
		 
		 public void clickBusinessUnitLink()
		 {
			 linkBusinessUnit.click();
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("SelectBU screen");
		 }
		 
		 public void clickNextButton()
		 {
			 	buttonNext.click();
				SeleniumUtils.delay(10000);
				this.getScreenDetails("Review Page");
		 }
		 
		 public void clickDestLegEmpButton()
		 {
			 listDestLegEmp.click();
				SeleniumUtils.delay(5000);
		 }
		 
		 
		 
		 public void selectBusinessUnit()
		 {
			 linkBusinessUnit.click();
			 SeleniumUtils.delay(3000);
			 
		 }
		 
		 public void clicYesButton()
		 {
			 	buttonYes.click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails("After Yes button click");
		 }
		
		public void clicSubmitButton()
		 {
			 buttonSubmit.click();
			 SeleniumUtils.delay(10000);
			 this.getScreenDetails("After Submit Button Click");
		 }
		
		
		public void clickReviewSubmitButton()
		 {
			buttonReviewSubmit.click();
			 SeleniumUtils.delay(10000);
			 this.getScreenDetails("Review Page");
		 }
		
		
		public void clickLocationSubmitButton()
		 {
			buttonLocationSubmit.click();
			//SeleniumUtils.delay(10000);
			 wdwait.until(ExpectedConditions.visibilityOf(buttonYes));
			 this.getScreenDetails("Submit Button clicked");
		 }
		
		
		public void clickContinueSubmitButton()
		 {
			btnContinueSubmit.click();
			//SeleniumUtils.delay(10000);
			 wdwait.until(ExpectedConditions.visibilityOf(buttonYes));
			 this.getScreenDetails("Submit Button clicked");
		 }
		
		public void clickEditButton()
		 {
			 buttonEdit.click();
			 SeleniumUtils.delay(3000);
			 this.getScreenDetails("Edit Button Screen");
		 }
		
		
		public void clickMTPEditButton()
		 {
			btnMTPEdit.click();
			 wdwait.until(ExpectedConditions.visibilityOf(selAddContentMenu));
			 this.getScreenDetails("Edit Button clicked");
		 }
		
		public void clickUpdateList()
		 {
			 listUpdate.click();
			 //SeleniumUtils.delay(3000);
			 wdwait.until(ExpectedConditions.visibilityOf(selectAction));
			 this.getScreenDetails("Selected Update from Action List");
		 }
		
		public void selectCorrectFromEditList()
		 {
			listCorrect.click();
			 //SeleniumUtils.delay(3000);
			 wdwait.until(ExpectedConditions.visibilityOf(selectCorrectAction));
			 this.getScreenDetails("Selected Correct from Action List");
		 }
		
		public void clickLocationList()
		 {
			 listLocation.click();
			 SeleniumUtils.delay(5000);
			 //wdwait.until(ExpectedConditions.visibilityOf(selectAction));
			 this.getScreenDetails("Locations Screen");
		 }
		
		public void clickNameList()
		 {
			 linkName.click();
			 SeleniumUtils.delay(3000);
			 //wdwait.until(ExpectedConditions.visibilityOf(selectAction));
			 this.getScreenDetails("Expand Name List");
		 }
		
		 public void enterStartDate(String strStartDate)
		 {
			 txtStartDate.sendKeys(strStartDate);
			 SeleniumUtils.delay(5000);
		 }
		 
		 
		 public void enterSelectDate(String strSelectDate)
		 {
			 txtSelectDate.click();
			 txtSelectDate.sendKeys(strSelectDate);
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("After Select Date entered");
			 
		 }
		 
		 
		 public void enterSalaryBasis(String strSalaryBasis)
		 {
			 txtSalaryBasis.clear();
			 txtSalaryBasis.sendKeys(strSalaryBasis);
			 txtSalaryBasis.sendKeys(Keys.ENTER);
			 SeleniumUtils.delay(5000);
		 }
		 
		 
		 public void enterSalaryAmount(String strSalaryAmount)
		 {
			 txtSalaryAmount.click();
			 txtSalaryAmount.clear();
			 txtSalaryAmount.sendKeys(strSalaryAmount);
			 SeleniumUtils.delay(2000);
		 }
		 
		 public void clickNotificationDatePicker()
		 {
			 txtNotificationDate.click();
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("NotifacationDate click");
		 }
		 
		 public void selectNotifacationsDayFromDate(String noOfDays)
		 {
				WebElement dateWidget = driver.findElement(By.xpath("//table[contains(@id,':r1:0:pt1:ap1:Termi1:0:NotificationDate::pop::cd::cg')]"));
																	 //table[contains(@id,'management:0:MAt2:1:r1:0:r1:0:pt1:ap1:Termi1:0:NotificationDate::pop::cd::cg')]
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
		 
		 public void enterStartTime(String strStartime)
		 {
			 txtStartTime.click();
			 txtStartTime.clear();
			 txtStartTime.sendKeys(strStartime);
			 SeleniumUtils.delay(5000);
		 }
		 
		 
		 public void enterWorkingHours(String strWorkinghrs)
		 {
			 txtWorkingHrs.clear();
			 txtWorkingHrs.sendKeys(strWorkinghrs);
			 SeleniumUtils.delay(5000);
		 }
		 
		 public void enterLocationName(String strLocationName)
		 {
			 txtLocationName.clear();
			 txtLocationName.sendKeys(strLocationName);
			 SeleniumUtils.delay(2000);
		 }
		 
		 public void enterEffectiveStartDate(String strStartDate)
		 {
			 txtEffectiveStartDate.clear();
			 txtEffectiveStartDate.sendKeys(strStartDate);
			 txtEffectiveStartDate.sendKeys(Keys.ENTER);
			 SeleniumUtils.delay(5000);
			 
		 }
		 
		 public void enterBusinessUnit(String strBusinessUnit)
		 {
			 txtBusinessUnit.sendKeys(strBusinessUnit);
			 SeleniumUtils.delay(3000);
		 }
		 
		 public void enterLegalEmployer(String strLegEmp)
		 {
			 txtLegalEmployer.sendKeys(strLegEmp);
			 SeleniumUtils.delay(2000);
		 }
		 
		 public void enterComments(String strComments)
		 {
			 txtAreaComments.sendKeys(strComments);
			 SeleniumUtils.delay(3000);
		 }
		
		 public void checkSingleDay()
		 {
			 	checkSingleDay.click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails("After checking SingleDay");
			    report.log(LogStatus.PASS, "Checked Single Day option");
		 }
		
		 public void selectType(String strType)
		 {
			 	report.log(LogStatus.PASS, "Select any leave type from Type dropdown");
			 	this.getScreenDetails("LeaveTypeList");
		    	Select objSelect = new Select(selectType);
		    	objSelect.selectByVisibleText(strType);
		    	SeleniumUtils.delay(5000);
		 }
		 
		 
		 public void selectAddContentMenu(String strAddContent)
		 {
			 	selAddContentMenu.click();
			 	SeleniumUtils.delay(2000);
			 	
		    	/*Select objSelect = new Select(selAddContentMenu)
		    	objSelect.selectByVisibleText(strAddContent);
		    	SeleniumUtils.delay(2000);*/
			 	
			 	WebElement addContentList = driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt3:0:SP1:menu4::ScrollContent']"));
				List<WebElement> rows=addContentList.findElements(By.tagName("tr")); 
			 	List<WebElement> columns=addContentList.findElements(By.tagName("td"));

			 	for (WebElement cell:columns)
			 	{
			 		if (cell.getText().equals(strAddContent))
			 		{
			 			cell.click();
			 			SeleniumUtils.delay(3000);
			 			break;
			 		}
			 	} 
		    	
		    	this.getScreenDetails("Add Content Item selected");
		 }
		 
		 public void selectName(String strName)
		 {
			 	selName.click();
			 	SeleniumUtils.delay(2000);
		    	driver.findElement(By.xpath("//span[contains(.,'"+strName+"')]")).click();
		    	SeleniumUtils.delay(2000);
		    	this.getScreenDetails("Name value selected");
		 }
		 
		 public void selectProficiency(String strProficiency)
		 {
			 	selProficiency.click();
			 	SeleniumUtils.delay(2000);
		    	Select objSelect = new Select(selProficiency);
		    	objSelect.selectByVisibleText(strProficiency);
		    	SeleniumUtils.delay(2000);
		    	this.getScreenDetails("Proficiency value selected");
		 }
		 
		 
		 public void selectEvaluationType(String strEvaluationType)
		 {
			 	selEvaluationType.click();
			 	SeleniumUtils.delay(2000);
		    	Select objSelect = new Select(selEvaluationType);
		    	objSelect.selectByVisibleText(strEvaluationType);
		    	SeleniumUtils.delay(2000);
		    	this.getScreenDetails("EvaluationType value selected");
		 }
	
		public void clickConfirmatioDialog(String strYesOrNO)
		{
			this.getScreenDetails("Confiramtion Screen");
			if(strYesOrNO.equalsIgnoreCase("Yes"))
			{
				driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
			}
			else
			{
				driver.findElement(By.xpath("//button[contains(.,'No')]")).click();	
			}
			
			 wdwait.until(ExpectedConditions.visibilityOf(buttonOK));
				
		}
		
		
		public void clickContinueButton()
		{
			btnContinue.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("After Continue button click");
			
		}	

		 public boolean isMyDetailsPageDisplayed()
		 {
			 return txtPersonManagement.isDisplayed();
		 }
		 
		 
		 public boolean isManageTalentProfileLinkClicked()
		 {
			 return txtManageTalentProfile.isDisplayed();
		 }
		 
		 public boolean isEditReviewPageDisplayed()
		 {
			 SeleniumUtils.scroll(driver, 0, 200);
			 this.getScreenDetails("Job Details");
			 return txtEditEmpReview.isDisplayed();
			 
		 }
		 
		 public boolean isGlobalTransferReviewPageDisplayed()
		 {
			 return txtGTReview.isDisplayed();
		 }
		 
		 public boolean isReviewDetailsDisplayed()
		 {
			 return txtReview.isDisplayed();
		 }
		 
		 
		 public void selectAction(String strAction)
		 {
			 	selectAction.click();
			 	report.log(LogStatus.PASS, "Select any Action from Action dropdown");
		    	Select objSelect = new Select(selectAction);
		    	objSelect.selectByVisibleText(strAction);
		    	SeleniumUtils.delay(6000);
		    	this.getScreenDetails("Selected given Action");
		 }
		 
		 
		 public void clickSalAction()
		 {
			 	linkSalAction.click();
			 	SeleniumUtils.delay(5000);
			 	/*report.log(LogStatus.PASS, "Select any Action from Action dropdown");
		    	Select objSelect = new Select(selectSalAction);
		    	objSelect.selectByVisibleText(strAction);
		    	SeleniumUtils.delay(3000);*/
		 }
		 
		 public void selectTerminateAction(String strAction)
		 {
			 	selectTerminateAction.click();
			 	report.log(LogStatus.PASS, "Select any Action from Action dropdown");
		    	Select objSelect = new Select(selectTerminateAction);
		    	objSelect.selectByVisibleText(strAction);
		    	SeleniumUtils.delay(6000);
		 }
		 
		 
		 public void selectActionReason(String strActionReason)
		 {
		    	report.log(LogStatus.PASS, "Select any Reason from Action Reason dropdown");
		    	selectActionReason.click();
		    	Select objSelect = new Select(selectActionReason);
		    	objSelect.selectByVisibleText(strActionReason);
		    	SeleniumUtils.delay(5000);
		 }
		 
		 public void selectCorrectActionType(String strAction)
		 {
		    	report.log(LogStatus.PASS, "Select any Action from Action dropdown");
		    	Select objSelect = new Select(selectCorrectAction);
		    	objSelect.selectByVisibleText(strAction);
		    	SeleniumUtils.delay(4000);
		 }
		 
		 public void selectActionList(String strAction)
		 {
			 listAction.click();	
			 report.log(LogStatus.PASS, "Select any Action from Action dropdown");
		     Select objSelect = new Select(listAction);
		     objSelect.selectByVisibleText(strAction);
		     SeleniumUtils.delay(2000);
		 }
	 
		public void enterName(String strName)
		{
			txtName.sendKeys(strName);
			SeleniumUtils.delay(2000);
		}
		
	 
		public void enterPersonNumber(String strPersonNumber)
		{
			System.out.println("person number is inside method "+strPersonNumber);
			txtPersonNumber.click();
			txtPersonNumber.sendKeys(strPersonNumber);
			SeleniumUtils.delay(2000);
			
		}
	
		 public void clickSearchButton() throws TestException
		 {
			btnSearch.click();
			SeleniumUtils.delay(5000);
			SeleniumUtils.scroll(driver, 0, 1000);
			this.getScreenDetails("Search Results Screen");
		    report.log(LogStatus.PASS, "Clicked on Search button");
		 }
		 
		 public void clickAddButton() throws TestException
		 {
			btnAdd.click();
			SeleniumUtils.delay(5000);
			this.getScreenDetails("After clicking Add Button");
		    report.log(LogStatus.PASS, "Clicked on Add button");
		 }
		 
		 public void clickOKButton() throws TestException
		 {
			this.getScreenDetails("After Confirmation"); 
			buttonOK.click();
			SeleniumUtils.delay(8000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("After Clicking Ok button");
		    
		 }
		 
		 
		 public void clickLegEmpOKButton() throws TestException
		 {
			buttonLegEmpOK.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("AfterClickOkButton");
		    
		 }
		 
		 public void clickBUOKButton() throws TestException
		 {
			 buttonBUOK.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("After clicking OK");
		    
		 }
		 
		 public void clickUpdateOKButton() throws TestException
		 {
			buttonGenOK.click();
			SeleniumUtils.delay(10000);
			//wdwait.until(ExpectedConditions.visibilityOf(buttonStatusOK));
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("AfterClickOkButton");
		 }
		 
		 public void clickASOKButton() throws TestException
		 {
			buttonStatusOK.click();
			SeleniumUtils.delay(8000);
			report.log(LogStatus.PASS, "Clicked on OK button");
			this.getScreenDetails("AfterClickOkButton");
		    
		 }
		 
		 public void clickDoneButton() throws TestException
		 {
			buttonDone.click();
			SeleniumUtils.delay(5000);
			//wdwait.until(ExpectedConditions.visibilityOf(buttonYes));
			this.getScreenDetails("After clicking Done button");
		    report.log(LogStatus.PASS, "Clicked on Done button");
		 }
		 
		 public void clickSubmitButton() throws TestException
		 {
			this.getScreenDetails();
			buttonSubmit.click();
			SeleniumUtils.delay(5000);
			report.log(LogStatus.PASS, "Clicked on Submit button");
			this.getScreenDetails();
		 }
		 
		 
		 public void clickReviewButton() throws TestException
		 {
			buttonReview.click();
			SeleniumUtils.delay(8000);
			this.getScreenDetails();
		    report.log(LogStatus.PASS, "Clicked on Review button");
		 }
		 
		 
		 
		 public void clickLocationReviewButton() throws TestException
		 {
			locationReviewButton.click();
			//SeleniumUtils.delay(10000);
			wdwait.until(ExpectedConditions.elementToBeClickable(buttonLocationSubmit));
			this.getScreenDetails("Review Screen");
		    report.log(LogStatus.PASS, "Clicked on Review button");
		 }
	 
		 public void clickManageWorkRelationshipLink() throws TestException
		 {
			 	linkManageWorkRelationship.click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails();
			    report.log(LogStatus.PASS, "Clicked on ManageWorkRelationship link");
		 }
		 
		 
		 public void clickManageEmployementLink() throws TestException
		 {
			 	lnkManageEmp.click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails("Clikced Manage Employement link");
			    report.log(LogStatus.PASS, "Clicked on Manage Employement link");
		 }
		 
		 
		 
		 public void clickManageSalaryLink() throws TestException
		 {
			 	lnkManageSal.click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails("Clikced Manage Salary link");
			    report.log(LogStatus.PASS, "Clicked on Manage Salary link");
		 }
		 
		 
		 public void clickManageTalentProfileLink() throws TestException
		 {
			 	lnkManageTalentProfile.click();
				wdwait.until(ExpectedConditions.visibilityOf(txtManageTalentProfile));
				this.getScreenDetails("Clikced Manage Talent Profile link");
			    report.log(LogStatus.PASS, "Clicked on Manage Talent Profile link");
		 }
		 
		 public void clickManageAbsenceRecordLink() throws TestException
		 {
			 	linkManageAbsenceRecord.click();
//				SeleniumUtils.delay(10000);
			 	wdwait.until(ExpectedConditions.visibilityOf(btnAdd));
				this.getScreenDetails("ManageAbsenceRecord Screen");
			    report.log(LogStatus.PASS, "Clicked on Manage Absence Records link");
		 }
	 
	 
		 public void clickTasksButton() throws TestException
		 {
				imgTasks.click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails("Tasks Screen");
			    report.log(LogStatus.PASS, "Clicked on Tasks button");
		 }
	 
		 public void scrollTasksTab() throws TestException
		 {
			// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",tabTasks);
			 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",btnAdd);
				SeleniumUtils.delay(2000);
				SeleniumUtils.scroll(driver, 0, 300);
				SeleniumUtils.delay(2000);
			    report.log(LogStatus.PASS, "Scrolled Tasks button");
		 }
	 
		 public void clickActionsList(String strActionType)
		 {
			 buttonActions.click();
			 SeleniumUtils.delay(3000);
			 if(strActionType.equalsIgnoreCase("Edit"))
			 {
				 driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:pt1:r1:0:pt1:SP1:edtBtn']/td[2]")).click();
			 }
			 else  if(strActionType.equalsIgnoreCase("Terminate"))
			 {
				 //driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:pt1:r1:0:pt1:SP1:tBtn']/td[2]")).click();
				 driver.findElement(By.xpath("//*[contains(@id,':pt1:r1:0:pt1:SP1:tBtn') or contains(@id,':pt1:r1:0:pt1:SP1:vtBtn')]/td[2]")).click();
				 							 	
			 }
			 else  if(strActionType.equalsIgnoreCase("Cancel Work Relationship"))
			 {
				 driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:pt1:r1:0:pt1:SP1:cnlBtn']/td[2]")).click();
			 }
			 else
			 {
				 report.log(LogStatus.FAIL, "Invalid Choice Please select the proper Action Type");
			 }
			 SeleniumUtils.delay(5000);
			 this.getScreenDetails("ActionList Screen");
				 
		 }
		 
		 
		 
		 public void clickProposeNewSalButton() throws TestException
		 {
			 	btnProposeNewSal.click();
				SeleniumUtils.delay(5000);
				this.getScreenDetails("After ProposeNewSal button click");
			    report.log(LogStatus.PASS, "Clicked on Tasks button");
		 }
		 
			
		 public void selectRevokeUserAccess(String strAccessType)
		 {
			//input[contains(@id,'_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:r1:0:r1:0:pt1:ap1:r3:0:sor1:_1')]
			//input[contains(@id,'_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAt2:1:r1:0:r1:0:pt1:ap1:r3:0:sor1:_0')]
				
			if(strAccessType.equalsIgnoreCase("After termination"))
			 {
				 driver.findElement(By.xpath("//input[contains(@id,':r1:0:r1:0:pt1:ap1:r3:0:sor1:_0')]")).click();
			 }
			 else  if(strAccessType.equalsIgnoreCase("Immediately"))
			 {
				 driver.findElement(By.xpath("//input[contains(@id,':r1:0:r1:0:pt1:ap1:r3:0:sor1:_1')]")).click();
				 							 	
			 }
			 else
			 {
				 report.log(LogStatus.FAIL, "Invalid Choice Please select the proper Access Type");
			 }
		 
		 }
		 
		 public MyDetailsContactsPage clickImageContacts() throws TestException
		 {
			imgContacts.click();
		    report.log(LogStatus.PASS, "Clicked on Contacts image");
		    return new MyDetailsContactsPage(driver,report);
		 }
		 
	
		 public boolean isDisplayed()
		 {
	    	 report.log(LogStatus.PASS, "Person Management Page is Loaded Successfully");
	    	 return SeleniumUtils.isDisplayed(driver, txtPersonManagement, context.getFindTimeout());
		 }
		 
		 public String getActionType()
		 {
			 System.out.println(txtActionType.getText().trim());
			 this.getScreenDetails("VerifyActionTypeAndReason");
			 return txtActionType.getText().trim();
		 }
		 
		 public String getActionText()
		 {
			 return txtAction.getText();
		 }
		 
		 public String getActionReason()
		 {
			 System.out.println(txtActionReason.getText().trim());
			 return txtActionReason.getText().trim();
		 }
		 
		 		 
		 public String getLegalEmpoyerText()
		 {
			 return txtLegalEmpl.getText();
		 }
		 
		 public String getBusinessUnitText()
		 {
			 return txtBusUnit.getText();
		 }
		 
		 
		  public Item getScreenDetails()
		  {
		    	String xyz = Screenshot.takeScreenshotX(driver, "Person Management", context);
		    	report.addScreenCapture(xyz);
		    	String projectPath = System.getProperty("user.dir");   	
		    	String sShotPath = projectPath+"/report/"+xyz;
		    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Person Management Page</span></a>");
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
